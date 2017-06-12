package ui;

import org.uqbar.arena.bindings.ObservableProperty;
import org.uqbar.arena.bindings.PropertyAdapter;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.List;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

import Dominio.CantDiscosPais;
import Dominio.Pais;
import Dominio.StorePaises;
import uiProp.ButtonC;
import uiProp.LabelH3;
import uiProp.NumericFieldMonsters;
import uiProp.PropMonsters;

public class selectionWindow extends Dialog<CantDiscosPais> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8253642979364521528L;
	
	public selectionWindow(WindowOwner owner, CantDiscosPais model) {
		super(owner, model);
	}
	
	@Override
	protected void createFormPanel(Panel mainPanel) {
		this.setTitle("Cantidad y Pais");
			
		new LabelH3(mainPanel, PropMonsters.color1).setText("Seleccione un Pais");
		

		List<Pais> selectorDePais = new List<Pais>(mainPanel);
		selectorDePais
			.bindItems(new ObservableProperty<>(StorePaises.getInstance(), "paises"))
			.setAdapter(new PropertyAdapter(Pais.class, "name"));
		selectorDePais.bindValueToProperty("pais");
		selectorDePais.setWidth(220);
		selectorDePais.setHeight(80);
			
		new LabelH3(mainPanel, PropMonsters.color1).setText("Seleccione cantidad");
		 
		new NumericFieldMonsters(mainPanel).bindValueToProperty("cantDiscosVendidos"); 
		
		Button acceptButton = new ButtonC(mainPanel);
		acceptButton.setCaption("Aceptar");
		acceptButton.onClick(() -> this.accept());

		Button cancelButton = new ButtonC(mainPanel);
		cancelButton.setCaption("Cancelar");
		cancelButton.onClick(() -> this.cancel());
		
	}

}
