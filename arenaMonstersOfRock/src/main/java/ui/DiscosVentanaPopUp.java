package ui;

import java.awt.Color;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;

import Dominio.CantDiscosPais;
import Dominio.Disco;
import Dominio.Presentacion;

public class DiscosVentanaPopUp extends Window<Disco> {


	/**
	 * 
	 */
	private static final long serialVersionUID = -8635612666624450440L;

	public DiscosVentanaPopUp(WindowOwner owner, Disco model) {
		super(owner, model);
	}

	@Override
	public void createContents(Panel mainPanel) {

		this.setTitle("Disco");
		
		Panel desc = new Panel(mainPanel);
		desc.setLayout(new ColumnLayout(2));
		
		new Label(desc).setText("Nombre:");
		
		new Label(desc).bindValueToProperty("nombre");
		
		new Label(desc).setText("Año:");
		
		new Label(desc).bindValueToProperty("anioDePublicacion");
		
		new Label(desc).setText("Discografica:");
		
		new Label(desc).bindValueToProperty("productor.name");
		
		Table<CantDiscosPais> copiasVendidas = new Table<>(mainPanel, CantDiscosPais.class);
		copiasVendidas.bindItemsToProperty("cantDiscosyPaises");
		
		new Column<>(copiasVendidas)
		.setForeground(Color.darkGray)
		.setTitle("Pais")
		.bindContentsToProperty("pais.name");
		
		new Column<>(copiasVendidas)
		.setForeground(Color.darkGray)
		.setTitle("Copias")
		.bindContentsToProperty("cantDiscosVendidos");
	
		
	}

}
