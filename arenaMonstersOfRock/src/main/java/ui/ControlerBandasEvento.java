package ui;

import org.uqbar.commons.utils.Observable;

import Dominio.Banda;
import Dominio.Evento;

@Observable
public class ControlerBandasEvento {

	//Variables
	private Evento evento;
	private int nroBandaActual = 1;
	private String text;
	
	//Constructores
	public ControlerBandasEvento (Evento e){
		super();
		this.setEvento(e);
	}

	//Methods
	
	public boolean esNumeroValido() {
		return this.getNroBandaActual() > 0 
				&& this.getEvento().getBandas().size() >= this.getNroBandaActual();
	}

	public Banda getBandaActual() {
		return this.getEvento().getBandas().get(this.getNroBandaActual() - 1);
	}
	
	public void textoPorDefecto() {
		this.setText("");
	}
	
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

	public void setText(String text ) {
		this.text = text;
	}
	public String getText(){
		return this.text;
	}

}
