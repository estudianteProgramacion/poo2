package ui;

import java.util.List;

import org.uqbar.commons.model.ObservableUtils;
import org.uqbar.commons.utils.Observable;

import Dominio.Banda;
import Dominio.Disco;
import Dominio.Presentacion;
import Dominio.StoreBandas;

@Observable
public class ControlerPresentacion {

	private Presentacion presentacion;
	private Banda banda = StoreBandas.getInstance().getBandas().get(0);
	

	public ControlerPresentacion(Presentacion p){
		super();
		this.setPresentacion(p);
	}

	public List<Disco> getDiscosBandaActual(){
		return this.getBanda().getDiscos();
	}
	
	public Banda getBanda() {
		return banda;
	}

	public void setBanda(Banda banda) {
		this.banda = banda;
		ObservableUtils.firePropertyChanged(this, "discosBandaActual");
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
		return this.presentacion.getDisco();
	}

	public void setDisco(Disco disco) {
		this.presentacion.setDisco(disco);
	}

}
