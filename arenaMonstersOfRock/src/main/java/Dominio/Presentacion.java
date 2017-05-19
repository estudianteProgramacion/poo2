package Dominio;

import org.uqbar.commons.utils.Observable;

@Observable
public class Presentacion {

	private int minutos;
	private Disco disco;
	
	public Presentacion(int minutos, Disco disco){
		this.setMinutos(minutos);
		this.disco = disco;
	}
	
	public int getMinutos() {
		return minutos;
	}
	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}

	public Banda getBanda() {
		return disco.getBanda();
	}

	public Disco getDisco() {
		return this.disco;
	}
}
