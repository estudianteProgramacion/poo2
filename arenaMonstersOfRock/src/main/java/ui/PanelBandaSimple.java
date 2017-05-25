package ui;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;

import Dominio.Disco;

public class PanelBandaSimple {

	protected Panel mainPanel;
	
	public PanelBandaSimple(Panel mainPanel) {
		super();
		this.setMainPanel(mainPanel);
		this.construir();
	}
		
	private void construir(){

	mainPanel.setWidth(200);
	
	Panel detalles = new Panel(getMainPanel());
	
	detalles.setLayout(new ColumnLayout(2));
	
	new Label(detalles).setText("Nombre");
	new Label(detalles).bindValueToProperty("nombre");

	new Label(detalles).setText("País");
	new Label(detalles).bindValueToProperty("pais.name");
	
	new Label(detalles).setText("Género");
	new Label(detalles).bindValueToProperty("generoMusical");

	
	Table<Disco> discos = new Table<>(getMainPanel(), Disco.class);
	discos.bindItemsToProperty("discos");
	
	new Column<>(discos)
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
