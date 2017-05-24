package ui;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.MainWindow;
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
		mainPanel.setWidth(200);
		this.setTitle("Banda");
		
		Panel detalles = new Panel(mainPanel);
		
		detalles.setLayout(new ColumnLayout(2));
		
		new Label(detalles).setText("Nombre");
		new Label(detalles).bindValueToProperty("nombre");
	
		new Label(detalles).setText("País");
		new Label(detalles).bindValueToProperty("pais.name");
		
		new Label(detalles).setText("Género");
		new Label(detalles).bindValueToProperty("generoMusical");
	
		
		Table<Disco> discos = new Table<>(mainPanel, Disco.class);
		discos.bindItemsToProperty("discos");
		
		new Column<>(discos)
			.setTitle("Nombre")
			.bindContentsToProperty("nombre");
		
		new Column<>(discos)
			.setTitle("CopiasTotales")
			.bindContentsToProperty("copiasVendidas");
	}

	
}
