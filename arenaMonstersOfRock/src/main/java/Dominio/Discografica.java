package Dominio;

import java.util.Collection;
import java.util.HashSet;

public class Discografica implements Organizador {

	private Collection<Disco> discosProducidos= new HashSet<Disco>();
	private String name;
	
	//Constructores
	
	public Discografica(String name){
		this.setName(name);
	}

	//methods
		@Override
	public boolean puedeHacerPresentacionEnEvento( Presentacion p) {
		return p.getBanda().ultimoDisco().getProductor().equals(this)
				|| p.getDisco().getProductor().equals(this);
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
