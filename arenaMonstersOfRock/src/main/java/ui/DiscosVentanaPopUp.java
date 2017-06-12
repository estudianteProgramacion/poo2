package ui;

import java.awt.Color;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.Window;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.commons.model.ObservableUtils;

import Dominio.CantDiscosPais;
import Dominio.Disco;
import Dominio.StorePaises;
import uiProp.ButtonC;
import uiProp.Espaciado;
import uiProp.LabelH1;
import uiProp.LabelH2;
import uiProp.LabelH3;
import uiProp.NumericFieldMonsters;
import uiProp.PropMonsters;

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
		
		new LabelH2(desc, PropMonsters.color1).setText("Nombre:");
		new LabelH1(desc, PropMonsters.color2).bindValueToProperty("nombre");
		
		new LabelH3(desc, PropMonsters.color1).setText("Año:");
		new LabelH3(desc, PropMonsters.color2).bindValueToProperty("anioDePublicacion");
		
		new LabelH3(desc, PropMonsters.color1).setText("Discografica:");
		new LabelH3(desc, PropMonsters.color2).bindValueToProperty("productor.name");
		
		Table<CantDiscosPais> copiasVendidas = new Table<>(mainPanel, CantDiscosPais.class);
		copiasVendidas.bindItemsToProperty("cantDiscosyPaises");
		
		new Column<>(copiasVendidas).setFont(12).setForeground(Color.BLUE).setBackground(Color.cyan)
		.setTitle("Pais")
		.bindContentsToProperty("pais.name");
		
		new Column<>(copiasVendidas)
		.setTitle("Copias")
		.bindContentsToProperty("cantDiscosVendidos");
	
		new Espaciado(mainPanel);
		
		this.hacerNav(mainPanel);
		
	}

	protected void hacerNav(Panel mainPanel){
		
		ControlerDisco controlerDisco = new ControlerDisco(this.getModelObject());
		
		Panel navCompleto = new Panel(mainPanel,controlerDisco);
		navCompleto.setLayout(new HorizontalLayout());
		
		Panel selector = new Panel(navCompleto);
		
		new LabelH3(selector, PropMonsters.color1).setText("Fila");
		new NumericFieldMonsters(selector).bindValueToProperty("filaActual");
		
		
		Panel navBotones = new Panel(navCompleto);
		navBotones.setLayout(new HorizontalLayout());
		
		
		Button agregar = new ButtonC(navBotones);
		agregar.setCaption("agregar");
		agregar.onClick( () -> {
				this.agregarSelectionWindow();
			}	
		);
		
		Button editar = new ButtonC(navBotones);
		editar.setCaption("editar");
		editar.onClick( () -> {
				this.editarSelectionWindow(controlerDisco.getVentas());
			}	
		);
		
		
		Button eliminar= new ButtonC(navBotones);
		eliminar.setCaption("eliminar");
		eliminar.onClick(() -> {
			controlerDisco.eliminar();
		});
		
		new LabelH3(navCompleto, PropMonsters.color3).bindValueToProperty("visor");
	
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
