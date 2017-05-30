package ui;

import org.uqbar.commons.utils.Observable;

import Dominio.Banda;
import Dominio.Disco;

@Observable
public class ControlerDiscosBanda {
	
	//Variables
	private Banda banda;
	private int filaActual = 1;
	
	//Constructores
	public ControlerDiscosBanda(Banda banda) {
		super();
		this.setBanda(banda);
	};
	
	//Methods

	public Disco getDiscoActual() {
		return this.getBanda().getDiscos().get(this.getFilaActual() - 1);
	}
	
	//Setters y getters
	public int getFilaActual() {
		return filaActual;
	}

	public void setFilaActual(int filaActual) {
		this.filaActual = filaActual;
	}

	public Banda getBanda() {
		return banda;
	}

	public void setBanda(Banda banda) {
		this.banda = banda;
	}

}