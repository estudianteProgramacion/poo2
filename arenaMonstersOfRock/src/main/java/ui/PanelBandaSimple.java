package ui;

import java.awt.Color;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;

import Dominio.Disco;
import uiProp.LabelH1;
import uiProp.LabelH2;
import uiProp.LabelH3;
import uiProp.PropMonsters;

public class PanelBandaSimple {

	protected Panel mainPanel;
	
	public PanelBandaSimple(Panel mainPanel) {
		super();
		this.setMainPanel(mainPanel);
		this.construir();
	}
		
	private void construir(){
	
	Panel detalles = new Panel(getMainPanel());
	detalles.setLayout(new ColumnLayout(2));
	
	new LabelH2(detalles,PropMonsters.color1).setText("Nombre");
	new LabelH1(detalles,PropMonsters.color2).bindValueToProperty("nombre");

	new LabelH3(detalles,PropMonsters.color1).setText("País");
	new LabelH3(detalles,PropMonsters.color2).bindValueToProperty("pais.name");
	
	new LabelH3(detalles,PropMonsters.color1).setText("Género");
	new LabelH3(detalles,PropMonsters.color2).bindValueToProperty("generoMusical");

	
	Table<Disco> discos = new Table<>(getMainPanel(), Disco.class);
	discos.bindItemsToProperty("discos");
	
	new Column<>(discos).setFont(12).setForeground(Color.BLUE).setBackground(Color.cyan)
		.setTitle("Nombre")
		.bindContentsToProperty("nombre");
	
	new Column<>(discos)
		.setTitle("CopiasTotales")
		.bindContentsToProperty("copiasVendidas");

	}

	public Panel getMainPanel() {
		return mainPanel;
	}

	public void setMainPanel(Panel mainPanel) {
		this.mainPanel = mainPanel;
	}
}
