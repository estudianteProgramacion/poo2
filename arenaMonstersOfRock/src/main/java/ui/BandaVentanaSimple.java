package ui;

import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.MainWindow;

import Dominio.Banda;

public class BandaVentanaSimple extends MainWindow<Banda> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4643536097378190337L;

	public BandaVentanaSimple(Banda model) {
		super(model);
	}

	@Override
	public void createContents(Panel mainPanel) {
		this.setTitle("Banda");
		new PanelBandaSimple(mainPanel);
	}
}
