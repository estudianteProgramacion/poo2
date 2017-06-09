package ui;

import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;

import uiProp.ButtonC;
import uiProp.Espaciado;
import uiProp.LabelH2;
import uiProp.PropMonsters;

public class VentanaDeError extends Dialog<Exception> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public VentanaDeError(WindowOwner owner, Exception model) {
		super(owner, model);
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		
		new Espaciado(mainPanel);
		
		new LabelH2(mainPanel, PropMonsters.color3).setText(this.getModelObject().getMessage());
		
		new Espaciado(mainPanel);
		
		new ButtonC(mainPanel).setCaption("Aceptar").onClick(() -> this.accept());

	}

}
