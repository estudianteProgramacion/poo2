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

import Dominio.Banda;
import Dominio.Disco;
import Dominio.Pais;
import Dominio.Presentacion;
import Dominio.StoreBandas;
import uiProp.ButtonC;
import uiProp.LabelH3;
import uiProp.NumericFieldMonsters;
import uiProp.PropMonsters;

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
		
		new LabelH3(mainPanel, PropMonsters.color1).setText("Seleccione una Banda");
		
		List<Pais> selectorDeBanda = new List<Pais>(mainPanel);
			selectorDeBanda
				.bindItems(new ObservableProperty<>(StoreBandas.getInstance(), "bandas"))
				.setAdapter(new PropertyAdapter(Banda.class, "nombre"));
		selectorDeBanda.bindValueToProperty("banda");
		
		new LabelH3(mainPanel, PropMonsters.color1).setText("seleccione Disco");
				
		List<Disco> selectorDeDiscos = new List<Disco>(mainPanel);
		selectorDeDiscos
				.bindItems(new ObservableProperty<>(controlPresentacion, "discosBandaActual"))
				.setAdapter(new PropertyAdapter(Disco.class, "nombre"));
		selectorDeDiscos.bindValueToProperty("disco");
		selectorDeDiscos.bindVisibleToProperty("visible");
		
		
		new LabelH3(mainPanel, PropMonsters.color1).setText("Tiempo de presentacion").setFontSize(12);
		 
		new NumericFieldMonsters(mainPanel).bindValueToProperty("minutos"); 
		
		Button acceptButton = new ButtonC(mainPanel);
		acceptButton.setCaption("Aceptar");
		acceptButton.onClick(() ->  this.accept());

		Button cancelButton = new ButtonC(mainPanel);
		cancelButton.setCaption("Cancelar");
		cancelButton.onClick(() -> this.cancel());
		
	}

}
