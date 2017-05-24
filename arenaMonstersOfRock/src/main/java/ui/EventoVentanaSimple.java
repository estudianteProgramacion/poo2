package ui;

import java.awt.Color;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.NumericField;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.MainWindow;

import Dominio.Evento;
import Dominio.Presentacion;

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
		//mainPanel.setWidth(400);
		
		//this.setIconImage("icon");
		
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
		
		Table<Presentacion> bandas = new Table<>(mainPanel, Presentacion.class);
		bandas.bindItemsToProperty("presentaciones");
		
		bandas.setNumberVisibleRows(6);
		
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
		
		
		this.construirBarraDeAcciones(mainPanel);
		
		
	}

	private void construirBarraDeAcciones(Panel mainPanel) {
		// TODO Auto-generated method stub
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
		
		
		Label visor = new Label(botones);
		visor.bindValueToProperty("text");
	}

}
