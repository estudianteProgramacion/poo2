package ui;

import org.uqbar.arena.bindings.ObservableProperty;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.HorizontalLayout;
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
		this.setTitle("Evento_Simple");
		//mainPanel.setWidth(400);
		
		Panel descEvento = new Panel(mainPanel);
		
		descEvento.setLayout(new ColumnLayout(2));
		
		new Label(descEvento).setText("Nombre:");
		new Label(descEvento).bindValueToProperty("nombre");
		
		new Label(descEvento).setText("Pais:");
		new Label(descEvento).bindValueToProperty("paisDeEvento.name");
		
		new Label(descEvento).setText("Ingreso Asegurado:");
		new Label(descEvento).bindValueToProperty("ingresoAsegurado");
		
		new Label(descEvento).setText("Gastos basicos:");
		new Label(descEvento).bindValueToProperty("gastos");
			//setText(Double.toString(this.getModelObject().getGastos()));
		
		new Label(descEvento).setText("Duracion:");
		new Label(descEvento).bindValueToProperty("tiempoTotalPresentaciones");
			//setText(Double.toString(this.getModelObject().getTiempoTotalPresentaciones()));
		
		
		Table<Presentacion> bandas = new Table<>(mainPanel, Presentacion.class);
		bandas.bindItemsToProperty("presentaciones");
		
		new Column<>(bandas)
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
		
		new Label(botones).setText("Nro. Banda");

		NumericField nroPres = new NumericField(botones);
		nroPres.bindValueToProperty("nroBandaActual");
		
	}

}
