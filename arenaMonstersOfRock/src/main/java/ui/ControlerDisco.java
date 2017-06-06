package ui;

import org.uqbar.commons.utils.Observable;

import Dominio.CantDiscosPais;
import Dominio.Disco;

@Observable
public class ControlerDisco {

	private Disco disco;
	private int filaActual = 1;
	private String visor = "";
	
	public ControlerDisco(Disco disco) {
		this.setDisco(disco);
	}

	public void eliminar() {
		if (this.existeFilaActual()){
			this.resetVisor();
			this.eliminarActual();
		} else {
			this.setVisor( "valores entre 1 y " + this.getDisco().getCantDiscosyPaises().size() );
		}
	}
	
	protected void eliminarActual() {
		this.getDisco().getCantDiscosyPaises().remove(this.getFilaActual() - 1);
	}

	public CantDiscosPais getVentas(){
		return this.getDisco().getCantDiscosyPaises().get(this.getFilaActual() - 1);
	}
	
	public boolean existeFilaActual() {
		return this.getFilaActual() > 0 && this.getDisco().getCantDiscosyPaises().size() >= this.getFilaActual();
	}
	
	public Disco getDisco() {
		return disco;
	}


	public void setDisco(Disco disco) {
		this.disco = disco;
	}


	public int getFilaActual() {
		return filaActual;
	}


	public void setFilaActual(int filaActual) {
		this.filaActual = filaActual;
	}

	//visor
	public void resetVisor() {
		this.setVisor("");
	}
	
	public String getVisor() {
		return visor;
	}
	
	public void setVisor(String visor) {
		this.visor = visor;
	}

}
