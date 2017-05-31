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
		this.construirBarra(mainPanel);
	
	}
	
	private void construirBarra(Panel mainPanel){
		
		Color colorTexto1 = new Color(0,76,156);
		Color colorTexto2 = new Color(153,153,0);
		
		ControlerDiscosBanda controladorDiscos = new ControlerDiscosBanda(this.getModelObject());
		
		Panel barrita = new Panel(mainPanel,controladorDiscos); 
		barrita.setLayout(new HorizontalLayout());
		
		NumericField numFila = new NumericField(barrita);
		numFila.bindValueToProperty("filaActual");
		
		Button mostrarDiscos = new Button(barrita);
		mostrarDiscos.setCaption("ver Disco");
		mostrarDiscos.onClick(
			() -> {
				if (controladorDiscos.esNumeroValido()){
					new DiscosVentanaPopUp(this,controladorDiscos.getDiscoActual()).open();
				} else {
					controladorDiscos.setVisor(
							"valor no valido"
					);
				}
			}
		);
		
		new Label(barrita).bindValueToProperty("visor");
	}

	
}

	
