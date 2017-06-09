package ui;

import java.awt.Color;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.NumericField;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.style.Style;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.MainWindow;
import org.uqbar.commons.model.ObservableUtils;

import Dominio.Banda;
import Dominio.Disco;
import Dominio.Evento;
import Dominio.Presentacion;
import Dominio.StoreBandas;
import Dominio.StorePaises;
import uiProp.ButtonC;
import uiProp.Espaciado;
import uiProp.LabelH1;
import uiProp.LabelH2;
import uiProp.LabelH3;
import uiProp.NumericFieldMonsters;
import uiProp.PropMonsters;

public class EventoVentanaSimple extends MainWindow<Evento> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3255843475929212341L;

	public EventoVentanaSimple(Evento model) {
		super(model);
	}

	@Override
	public void createContents(Panel mainPanel) {
		this.setTitle("Evento");
		
		//this.setIconImage("icon");
		
		Panel descEvento = new Panel(mainPanel);
		descEvento.setLayout(new ColumnLayout(2));
		
		
		new LabelH2(descEvento,PropMonsters.color1).setText("Nombre: ");
		new LabelH1(descEvento,PropMonsters.color2).bindValueToProperty("nombre");
		
		new LabelH3(descEvento,PropMonsters.color1).setText("Pais: ");
		new LabelH3(descEvento,PropMonsters.color2).bindValueToProperty("paisDeEvento.name");
		
		new LabelH3(descEvento,PropMonsters.color1).setText("Ingreso Asegurado: ");
		new LabelH3(descEvento,PropMonsters.color2).bindValueToProperty("ingresoAsegurado");
		
		new LabelH3(descEvento,PropMonsters.color1).setText("Gastos basicos: ");
		new LabelH3(descEvento,PropMonsters.color2).bindValueToProperty("gastos");
		
		new LabelH3(descEvento,PropMonsters.color1).setText("Duracion: ");
		new LabelH3(descEvento,PropMonsters.color2).bindValueToProperty("tiempoTotalPresentaciones");
		
		new Espaciado(mainPanel);
		
		Table<Presentacion> bandas = new Table<>(mainPanel, Presentacion.class);
		bandas.bindItemsToProperty("presentaciones");
		bandas.setNumberVisibleRows(4);
		
		new Column<>(bandas).setFont(12).setForeground(Color.BLUE).setBackground(Color.cyan)
			.setTitle("Banda")
			.bindContentsToProperty("banda.nombre");
		
		new Column<>(bandas)
			.setTitle("Disco")
			.bindContentsToProperty("disco.nombre");
		
		new Column<>(bandas)
			.setTitle("Duracion")
			.bindContentsToProperty("minutos");
		
		new Espaciado(mainPanel);
		
		this.construirBarraDeAcciones(mainPanel);
		

	}

	private void construirBarraDeAcciones(Panel mainPanel) {
		
		ControlerBandasEvento controlerBandas = new ControlerBandasEvento(this.getModelObject());
		
		//Un panelsito para visor para que quede arriba del Numeric Field
		Panel visor = new Panel(mainPanel, controlerBandas);
		visor.setLayout(new ColumnLayout(2));
		
		Label visorText = new LabelH3(visor,PropMonsters.color3);
		visorText.bindValueToProperty("text");
		
		new LabelH3(visor,PropMonsters.color1).setText("Opciones para Bandas");
		
		Panel botones = new Panel(mainPanel,controlerBandas);
		
			
		botones.setLayout(new HorizontalLayout());
		
		
		new LabelH3(botones, PropMonsters.color1).setText("  Nro. Fila \n Banda  ");

		NumericField nroPres = new NumericFieldMonsters(botones);
		nroPres.bindValueToProperty("nroBandaActual");
		
		new ButtonC(botones)			
			.setCaption("ver")
			.onClick(() -> {
				if (controlerBandas.esNumeroValido()){
					controlerBandas.textoPorDefecto();
					new BandaVentanaSimplePopUp(this, controlerBandas.getBandaActual()).open();
				} else {
					controlerBandas.setText(
							"elija valores entre 1 y " 
							+ this.getModelObject().getBandas().size()		
					);
				}
			});
		
		new Espaciado(botones);
		new Espaciado(botones);
		
		new ButtonC(botones)
			.setCaption("agregar")
			.onClick( () -> {
					 this.agregarBandaSelectionWindow();
					}
			);
		
		new ButtonC(botones)
		.setCaption("editar")
		.onClick( () -> {
				 this.editarBandaSelectionWindow(controlerBandas.getBandaActual());
				}
		);
		
		new ButtonC(botones)
		.setCaption("borrar")
		.onClick( () -> {
				 this.getModelObject().quitarBanda(controlerBandas.getBandaActual());
				}
		);
		

	}
	


	private void editarBandaSelectionWindow(Banda bandaActual) {
		Presentacion actualP = this.getModelObject().presentacionDeBanda(bandaActual);
		Presentacion editPClone = new Presentacion(actualP.getMinutos(),actualP.getDisco());
		BandaSelectionWindow windowB = new BandaSelectionWindow(this, editPClone);
		windowB.onAccept(() -> {
			this.getModelObject().reemplazarPresentacion(editPClone, actualP);
			this.actualizarDescripcion();
		});
		windowB.open();
		
	}

	
	private void agregarBandaSelectionWindow() {
		Presentacion nuevaP = new Presentacion(); 
		BandaSelectionWindow windowB = new BandaSelectionWindow(this, nuevaP);
		windowB.onAccept(() -> {
			try {
				this.getModelObject().agregarPresentacion(nuevaP);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				//e.printStackTrace();
				new VentanaDeError(this,e).open();
			}
			this.actualizarDescripcion();
		});
		windowB.open();
	}

	private void actualizarDescripcion() {
		ObservableUtils.firePropertyChanged(this.getModelObject(), "presentaciones");
		ObservableUtils.firePropertyChanged(this.getModelObject(), "tiempoTotalPresentaciones");
		ObservableUtils.firePropertyChanged(this.getModelObject(), "gastos");
		ObservableUtils.firePropertyChanged(this.getModelObject(), "ingresoAsegurado");		
	}
}
