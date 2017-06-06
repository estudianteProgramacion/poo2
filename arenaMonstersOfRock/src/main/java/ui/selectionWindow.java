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

import Dominio.CantDiscosPais;
import Dominio.Pais;
import Dominio.StorePaises;

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
		this.setTitle("agregue Cantidad y Pais");
			
		new Label(mainPanel).setText("Seleccione un Pais").setFontSize(12);
		

		List<Pais> selectorDePais = new List<Pais>(mainPanel);
		selectorDePais
			.bindItems(new ObservableProperty<>(StorePaises.getInstance(), "paises"))
			.setAdapter(new PropertyAdapter(Pais.class, "name"));
		selectorDePais.bindValueToProperty("pais");
		selectorDePais.setWidth(220);
		selectorDePais.setHeight(80);
			
		new Label(mainPanel).setText("Seleccione cantidad").setFontSize(12);
		 
		new NumericField(mainPanel).bindValueToProperty("cantDiscosVendidos"); 
		
		Button acceptButton = new Button(mainPanel);
		acceptButton.setCaption("Aceptar");
		acceptButton.onClick(() -> this.accept());

		Button cancelButton = new Button(mainPanel);
		cancelButton.setCaption("Cancelar");
		cancelButton.onClick(() -> this.cancel());
		
	}

}
