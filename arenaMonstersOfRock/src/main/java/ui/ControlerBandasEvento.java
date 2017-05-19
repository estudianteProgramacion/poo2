package ui;

import Dominio.Banda;
import Dominio.Evento;

public class ControlerBandasEvento {

	//Variables
	private Evento evento;
	private int nroBandaActual = 0;
	
	//Constructores
	public ControlerBandasEvento (Evento e){
		super();
		this.setEvento(e);
	}

	//Methods
	
	
	//Setters y getters
	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public int getNroBandaActual() {
		return nroBandaActual;
	}

	public void setNroBandaActual(int nroBandaActual) {
		this.nroBandaActual = nroBandaActual;
	}

	public Banda getBandaActual() {
		return this.getEvento().getBandas().get(this.getNroBandaActual());
	}


}
