package ui;

import org.uqbar.arena.bindings.ObservableProperty;
import org.uqbar.arena.bindings.PropertyAdapter;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.List;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

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
	protected void createFormPanel(Panel mainPanel) {
		this.setTitle("Presentacion");
		
		new Label(mainPanel).setText("Seleccione una Banda");
		
		List<Pais> selectorDeBanda = new List<Pais>(mainPanel);
		selectorDeBanda
			.bindItems(new ObservableProperty<>(StoreBandas.getInstance(), "bandas"))
			.setAdapter(new PropertyAdapter(Banda.class, "nombre"));
		selectorDeBanda.bindValueToProperty("banda");
		selectorDeBanda.setWidth(220);
		selectorDeBanda.setHeight(80);
	
		//TODO que se esconde
//		Panel panelDiscos = new Panel(mainPanel);
//		panelDiscos.
		
		new Label(mainPanel).setText("seleccione Disco");
		
		List<Disco> selectorDeDiscos = new List<Disco>(mainPanel);
		selectorDeDiscos
			.bindItems(new ObservableProperty<>(StoreBandas.getInstance(), "bandas"))
			.setAdapter(new PropertyAdapter(Banda.class, "nombre"));
		selectorDeDiscos.bindValueToProperty("banda");
		selectorDeDiscos.setWidth(220);
		selectorDeDiscos.setHeight(80);
			
		
		
	}

}
