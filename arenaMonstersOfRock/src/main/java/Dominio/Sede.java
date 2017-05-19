package Dominio;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.uqbar.commons.utils.Observable;

@Observable
public abstract class Sede {

	private int capacidad;
	private Ciudad ciudad;
	private Set<Evento> eventos = new HashSet<Evento>();
	private String nombre;
	
	/**
	 * 
	 * @param ciudad 
	 * @param capacidad
	 */
	public Sede(Ciudad ciudad, int capacidad){
		this.setCapacidad(capacidad);
		this.ciudad = ciudad;
		this.getCiudad().getPais().agregarSede(this);
	}
	
	public Sede(String nombre, Ciudad ciudad, int capacidad) {
		this.setCapacidad(capacidad);
		this.ciudad = ciudad;
		this.getCiudad().getPais().agregarSede(this);	
		this.setNombre(nombre);
	}

	public abstract double costoPorEvento(Evento e);
	
	//3
	public Collection<Banda> bandasQueActuan(){
		return this.getEventos().stream()
				.flatMap(e -> e.getBandas().stream())
				.collect(Collectors.toSet());
	}
	
	public void agregarEvento(Evento e){
		this.getEventos().add(e);
	}
	
	public Set<Evento> getEventos(){
		return this.eventos;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public boolean sePuedeHacerFestival() {
		return false;
	}
	public boolean sePuedeHacerRecital() {
		return true;
	}
	public boolean sePuedeHacerCenaShow() {
		return false;
	}

	public Ciudad getCiudad(){
		return this.ciudad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	//agregado por ARENA
	public void setEventos(Set<Evento> eventos){
		this.eventos = eventos;
	}
}
