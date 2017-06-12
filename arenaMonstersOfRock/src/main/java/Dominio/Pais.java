package Dominio;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.uqbar.commons.utils.Observable;

@Observable
public class Pais {

	private String name;
	private Set<Sede> sedesEnPais = new HashSet<Sede>();
	
	//constructores
	
	public Pais(String name){
		this.setName(name);
	}
	
	//methods
	
	@Override
	public boolean equals(Object p){
		return this.getName().equals(((Pais) p).getName());
	}
	
	public Set<Banda> bandasExtranjerasQueTocan(){
		return this.getSedesEnPais().stream()
				.flatMap(s -> s.getEventos().stream())
				.flatMap(e -> e.getBandas().stream())
				.filter(b -> !b.getPais().equals(this))
				.collect(Collectors.toSet());
	}
	
	//setters y getters
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Set<Sede> getSedesEnPais() {
		return sedesEnPais;
	}

	public void agregarSede(Sede s){
		this.getSedesEnPais().add(s);
	}
	
	//Agregado por ARENA
	public void setSedesEnPais(Set<Sede> s){
		this.sedesEnPais = s;
	}

}
