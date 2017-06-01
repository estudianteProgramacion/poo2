package ui;

import java.util.ArrayList;
import java.util.List;

import org.uqbar.commons.utils.Observable;

import Dominio.Pais;

@Observable
public class StorePaises {

	private List<Pais> paises = new ArrayList<>();
	private static StorePaises instance;
	
	private StorePaises(){
		super();
		this.ponerPaises();
	}
	
	private void ponerPaises() {
		this.agregarPais(new Pais("argentina"));
		this.agregarPais(new Pais("uruguay"));
		this.agregarPais(new Pais("eeuu"));
	}
	
	private void agregarPais(Pais pais) {
		this.getPaises().add(pais);
	}

	public static StorePaises getInstance(){
		if(instance==null){
			instance= new StorePaises();
		}
		return instance;
	}
	
	public List<Pais> getPaises() {
		return paises;
	}

	public void setPaises(List<Pais> paises) {
		this.paises = paises;
	}

	public Pais getFirst() {
		return this.getPaises().get(0);
	}
	
}
