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
import org.uqbar.commons.model.ObservableUtils;

import Dominio.CantDiscosPais;
import Dominio.Disco;

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
		
		//TODO IMAGENES VER
//		 Label imageLabel = new Label(mainPanel);
//				 imageLabel.bindImageToProperty(", null
//				     
//				    );
		
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
	
		
		
		this.hacerNav(mainPanel);
	}

	protected void hacerNav(Panel mainPanel){
		
		ControlerDisco controlerDisco = new ControlerDisco(this.getModelObject());
		
		Panel navCompleto = new Panel(mainPanel,controlerDisco);
		
		
		Panel selector = new Panel(navCompleto);
		
		new Label(selector).setText("Fila");
		
		new NumericField(selector).bindValueToProperty("filaActual");
		
		
		Panel navBotones = new Panel(navCompleto);
		navBotones.setLayout(new HorizontalLayout());
		
		
		Button agregar = new Button(navBotones);
		agregar.setCaption("agregar");
		agregar.onClick( () -> {
				this.agregarSelectionWindow();
			}	
		);
		
		Button editar = new Button(navBotones);
		editar.setCaption("editar");
		editar.onClick( () -> {
				this.editarSelectionWindow(controlerDisco.getVentas());
			}	
		);
		
		
		Button eliminar= new Button(navBotones);
		eliminar.setCaption("eliminar");
		eliminar.onClick(() -> {
			controlerDisco.eliminar();
		});
		
		new Label(navCompleto).bindValueToProperty("visor");
	
	}

	private void editarSelectionWindow(CantDiscosPais edit) {
		CantDiscosPais editClone = new CantDiscosPais(edit.getPais(), edit.getCantDiscosVendidos());
		selectionWindow ventana = new selectionWindow(this, editClone);
		ventana.onAccept(() -> {
					this.getModelObject().remplazarCDP(editClone,edit);
					ObservableUtils.firePropertyChanged(this.getModelObject(), "copiasVendidas");
					}
				);
		ventana.open();
	}

	private void agregarSelectionWindow() {
		CantDiscosPais nuevo = new CantDiscosPais(StorePaises.getInstance().getFirst(), 0);
		selectionWindow ventana = new selectionWindow(this, nuevo);
		ventana.onAccept(() -> {
					this.getModelObject().agregarPais(nuevo);
					ObservableUtils.firePropertyChanged(this.getModelObject(), "copiasVendidas");
					}
				);
		ventana.open();
	}
}
