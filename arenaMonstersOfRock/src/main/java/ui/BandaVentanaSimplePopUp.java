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
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;

import Dominio.Banda;
import Dominio.Disco;
import uiProp.ButtonC;
import uiProp.Espaciado;
import uiProp.LabelH3;
import uiProp.NumericFieldMonsters;
import uiProp.PropMonsters;

public class BandaVentanaSimplePopUp extends Window<Banda> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4643536097378190337L;

	public BandaVentanaSimplePopUp(WindowOwner owner, Banda model) {
		super(owner, model);
	}

	@Override
	public void createContents(Panel mainPanel) {
		
		this.setTitle("Banda");
		new PanelBandaSimple(mainPanel);
		new Espaciado(mainPanel);
		this.construirBarra(mainPanel);
	
	}
	
	private void construirBarra(Panel mainPanel){
		
		ControlerDiscosBanda controladorDiscos = new ControlerDiscosBanda(this.getModelObject());
		
		Panel barrita = new Panel(mainPanel,controladorDiscos); 
		barrita.setLayout(new HorizontalLayout());
		
		NumericField numFila = new NumericFieldMonsters(barrita);
		numFila.bindValueToProperty("filaActual");
		
		Button mostrarDiscos = new ButtonC(barrita);
		mostrarDiscos.setCaption("ver Disco");
		mostrarDiscos.onClick(
			() -> {
				if (controladorDiscos.esNumeroValido()){
					controladorDiscos.resetVisor();
					new DiscosVentanaPopUp(this,controladorDiscos.getDiscoActual()).open();
				} else {
					controladorDiscos.setVisor(
							"valor no valido"
					);
				}
			}
		);
		
		new LabelH3(barrita,PropMonsters.color3).bindValueToProperty("visor");
	}

	
}

	
