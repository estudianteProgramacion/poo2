package ui;

import org.uqbar.commons.utils.Observable;

import Dominio.Banda;
import Dominio.Disco;
import Dominio.Presentacion;

@Observable
public class ControlerPresentacion {

	private Presentacion presentacion;
	private Banda banda;
	private Disco disco;
	private boolean visible = false;
	
	public ControlerPresentacion(Presentacion p){
		super();
		this.setPresentacion(p);
	}

	public Banda getBanda() {
		return banda;
				//(this.getPresentacion().getBanda() == null)?banda:this.getPresentacion().getBanda();
	}

	public void setBanda(Banda banda) {
		this.banda = banda;
	}

	public Presentacion getPresentacion() {
		return presentacion;
	}

	public void setPresentacion(Presentacion presentacion) {
		this.presentacion = presentacion;
	}

	public int getMinutos() {
		return this.getPresentacion().getMinutos();
	}

	public void setMinutos(int minutos) {
		this.getPresentacion().setMinutos(minutos);
	}

	public Disco getDisco() {
		return this.disco;
	}

	public void setDisco(Disco disco) {
		this.disco = disco;
		this.presentacion.setDisco(disco);
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	
}
