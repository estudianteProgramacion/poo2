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
		
		this.setTitle("Evento_Simple");
		//this.setIconImage("icon");
		
		//espacio arriba de la ventana // Padding
		new Label(mainPanel).setText("").setHeight(20);
		
		Panel descEvento = new Panel(mainPanel);
		
		descEvento.setLayout(new ColumnLayout(2));
		
		Color colorTexto1 = new Color(0,76,156);
		Color colorTexto2 = new Color(153,153,0);
		
		new Label(descEvento).setText("Nombre:").setFontSize(12).setForeground(colorTexto1);
		new Label(descEvento).setFontSize(13).setForeground(colorTexto2).bindValueToProperty("nombre");
		
		new Label(descEvento).setText("Pais:").setFontSize(12).setForeground(colorTexto1);
		new Label(descEvento).setFontSize(12).setForeground(colorTexto2).bindValueToProperty("paisDeEvento.name");
		
		new Label(descEvento).setText("Ingreso Asegurado:").setFontSize(12).setForeground(colorTexto1);
		new Label(descEvento).setFontSize(12).setForeground(colorTexto2).bindValueToProperty("ingresoAsegurado");
		
		new Label(descEvento).setText("Gastos basicos:").setFontSize(12).setForeground(colorTexto1);
		new Label(descEvento).setFontSize(12).setForeground(colorTexto2).bindValueToProperty("gastos");
		
		new Label(descEvento).setText("Duracion:").setFontSize(12).setForeground(colorTexto1);
		new Label(descEvento).setFontSize(13).setForeground(colorTexto2).bindValueToProperty("tiempoTotalPresentaciones");
		
		//espacio entre tabla y desc
		new Label(mainPanel).setText("").setHeight(15);
		
		Table<Presentacion> bandas = new Table<>(mainPanel, Presentacion.class);
		bandas.bindItemsToProperty("presentaciones");
		
		bandas.setNumberVisibleRows(5);
		
		new Column<>(bandas)
			.setForeground(Color.darkGray)
			.setTitle("Banda")
			.bindContentsToProperty("banda.nombre");
		
		new Column<>(bandas)
			.setTitle("Disco")
			.bindContentsToProperty("disco.nombre");
		
		new Column<>(bandas)
			.setTitle("Duracion")
			.bindContentsToProperty("minutos");
		
		//espacio entre tabla y barra de acciones
		new Label(mainPanel).setText("").setHeight(20);
		
		this.construirBarraDeAcciones(mainPanel);
		
		// Padding
		new Label(mainPanel).setText("").setHeight(20);
	}

	private void construirBarraDeAcciones(Panel mainPanel) {
		
		ControlerBandasEvento controlerBandas = new ControlerBandasEvento(this.getModelObject());

		Panel botones = new Panel(mainPanel,controlerBandas);
		botones.setLayout(new HorizontalLayout());
		
		new Label(botones).setText("Nro. Fila Banda");

		NumericField nroPres = new NumericField(botones);
		nroPres.bindValueToProperty("nroBandaActual");
		
		new Button(botones)
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
		
		//espacio entre boton
		new Label(botones).setWidth(15);
		
		new Button(botones)
			.setCaption("agregar")
			.onClick( () -> {
					 this.agregarBandaSelectionWindow();
					}
			);
		
		new Button(botones)
		.setCaption("borrar")
		.onClick( () -> {
				 this.getModelObject().quitarBanda(controlerBandas.getBandaActual());
				}
		);
		
		Label visor = new Label(botones);
		visor.bindValueToProperty("text");
	}
	


	private void agregarBandaSelectionWindow() {
		Presentacion nuevaP = new Presentacion(); 
		BandaSelectionWindow windowB = new BandaSelectionWindow(this, nuevaP);
		windowB.onAccept(() -> {
			this.getModelObject().agregarPresentacion(nuevaP);
			ObservableUtils.firePropertyChanged(this.getModelObject(), "presentaciones");
			ObservableUtils.firePropertyChanged(this.getModelObject(), "tiempoTotalPresentaciones");
			ObservableUtils.firePropertyChanged(this.getModelObject(), "gastos");
			ObservableUtils.firePropertyChanged(this.getModelObject(), "ingresoAsegurado");
		});
		windowB.open();
	}

}
