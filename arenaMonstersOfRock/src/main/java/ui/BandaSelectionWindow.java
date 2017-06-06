package ui;

import org.uqbar.arena.bindings.ObservableProperty;
import org.uqbar.arena.bindings.PropertyAdapter;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.List;
import org.uqbar.arena.widgets.NumericField;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.commons.model.ObservableUtils;
import org.uqbar.commons.utils.Observable;

import Dominio.Banda;
import Dominio.Disco;
import Dominio.Pais;
import Dominio.Presentacion;
import Dominio.StoreBandas;
import Dominio.StorePaises;

public class BandaSelectionWindow extends Dialog<Presentacion> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 209079005935234338L;

	public BandaSelectionWindow(WindowOwner owner, Presentacion model) {
		super(owner, model);
	}
	
	@Override
	protected void createFormPanel(Panel mainPane) {
		
		this.setTitle("Presentacion");
		
		
		ControlerPresentacion controlPresentacion = new ControlerPresentacion(this.getModelObject());
		
		
		Panel mainPanel = new Panel(mainPane, controlPresentacion);
		
		new Label(mainPanel).setText("Seleccione una Banda");
		
		List<Pais> selectorDeBanda = new List<Pais>(mainPanel);
			selectorDeBanda
				.bindItems(new ObservableProperty<>(StoreBandas.getInstance(), "bandas"))
				.setAdapter(new PropertyAdapter(Banda.class, "nombre"));
		selectorDeBanda.bindValueToProperty("banda");
		//solo para ver que ande
		selectorDeBanda.onSelection(()-> { 
			System.out.println("banda actual " + controlPresentacion.getBanda().getNombre());});

		
		new Label(mainPanel).setText("seleccione Disco");
		
		
		List<Disco> selectorDeDiscos = new List<Disco>(mainPanel);
		selectorDeDiscos
				.bindItems(new ObservableProperty<>(controlPresentacion.getBanda(), "discos"))
				.setAdapter(new PropertyAdapter(Disco.class, "nombre"));
		selectorDeDiscos.bindValueToProperty("disco");

		
		new Label(mainPanel).setText("Tiempo de presentacion").setFontSize(12);
		 
		new NumericField(mainPanel).bindValueToProperty("minutos"); 
		
		Button acceptButton = new Button(mainPanel);
		acceptButton.setCaption("Aceptar");
		acceptButton.onClick(() ->  this.accept());

		Button cancelButton = new Button(mainPanel);
		cancelButton.setCaption("Cancelar");
		cancelButton.onClick(() -> this.cancel());
		
	}

}
