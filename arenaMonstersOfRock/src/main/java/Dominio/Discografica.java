package Dominio;

import java.util.Collection;
import java.util.HashSet;

import org.uqbar.commons.utils.Observable;

@Observable
public class Discografica implements Organizador {

	private Collection<Disco> discosProducidos= new HashSet<Disco>();
	private String name;
	
	//Constructores
	
	public Discografica(String name){
		this.setName(name);
	}

	public boolean equals(Object o){
		return this.getName().equals(((Discografica) o).getName());
	}
	
	//methods
		@Override
	public boolean puedeHacerPresentacionEnEvento( Presentacion p)  {
		if (p.getBanda().ultimoDisco().getProductor().equals(this)
				|| p.getDisco().getProductor().equals(this)){ return true;} else {
					throw new RuntimeException("El Organizador Discografica no permite agregar la Presentacion a evento ");
				}
	}
	
	public Collection<Disco> getDiscosProducidos() {
		return discosProducidos;
	}

	@Override
	public boolean puedeHacerEventoEnSede(Sede s) {
		return true;
	}
	
	//setters y getters
	
	public void setDiscosProducidos(Collection<Disco> discosProducidos) {
		this.discosProducidos = discosProducidos;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



}
