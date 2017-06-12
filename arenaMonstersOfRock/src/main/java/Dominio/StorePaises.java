package Dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.uqbar.commons.utils.Observable;

@Observable
public class StorePaises {

	private List<Pais> paises = new ArrayList<>();
	private static StorePaises instance;
	
	private StorePaises(){
		super();
		this.ponerPaises();
	}
	
	public static StorePaises getInstance(){
		if(instance==null){
			instance= new StorePaises();
		}
		return instance;
	}
		
	private void ponerPaises() {
		this.agregarPais(new Pais("argentina"));
		this.agregarPais(new Pais("uruguay"));
		this.agregarPais(new Pais("eeuu"));
	}
	
	private void agregarPais(Pais pais) {
		this.getPaises().add(pais);
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

	public Pais getPais(String nPais) {
		int indexPais = this.getPaises().stream()
						.map(p -> p.getName())
						.collect(Collectors.toList())
						.indexOf(nPais);
		return this.getPaises().get(indexPais);
	}
	
}
