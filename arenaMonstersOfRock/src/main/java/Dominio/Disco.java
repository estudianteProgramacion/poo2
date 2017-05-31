package Dominio;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.uqbar.commons.utils.Observable;

@Observable
public class Disco {

	private int anioDePublicacion;
	private Discografica productor;
	private List<CantDiscosPais> cantDiscosyPaises= new ArrayList<CantDiscosPais>();
	private Banda banda;
	private String nombre;
	
	//Constructores

	public Disco(int anioP, Banda banda, Discografica discografica){
		this.setAnioDePublicacion(anioP);
		this.setBanda(banda);
		this.setProductor(discografica);
	}
	public Disco(String nombre,int anioP, Banda banda, Discografica discografica){
		this.setAnioDePublicacion(anioP);
		this.setBanda(banda);
		this.setProductor(discografica);
		this.setNombre(nombre);
	}
	
	//Methods
	
	public int getCopiasVendidas(){
		return this.getCantDiscosyPaises().stream()
				.mapToInt(cdp -> cdp.getCantDiscosVendidos())
				.sum();
	}

	public int copiasVendidasPais(Pais p) {
		return this.getCantDiscosyPaises().stream()
				.filter(cdp -> cdp.getPais().equals(p))
				.mapToInt(cdp -> cdp.getCantDiscosVendidos())
				.sum();
	}
	
	public void agregarPais(CantDiscosPais p){
		if (! this.estaPaisAgregado(p)){
			this.getCantDiscosyPaises().add(p);
		} else {
			this.agregarDiscosANombrePais(p);
		}
		;
	}
	
	private void agregarDiscosANombrePais(CantDiscosPais p) {
		this.getCantDiscosyPaises().get(this.getPosicionDePais(p.getPais()))
								    	.addCantDiscosVendidos(p.getCantDiscosVendidos());;
	}
	private int getPosicionDePais(Pais pais) {
		return this.getCantDiscosyPaises().stream()
				.map(cdp -> cdp.getPais())
				.collect(Collectors.toList())
				.indexOf(pais);
	}
	private boolean estaPaisAgregado(CantDiscosPais p) {
		return this.getCantDiscosyPaises().stream().anyMatch( cdp -> cdp.getPais().equals(p.getPais()) );
	}
	
	//Setters y Getters
	
	
	public int getAnioDePublicacion() {
		return anioDePublicacion;
	}

	public void setAnioDePublicacion(int anioDePublicacion) {
		this.anioDePublicacion = anioDePublicacion;
	}

	public Discografica getProductor() {
		return productor;
	}

	public void setProductor(Discografica productor) {
		this.productor = productor;
	}

	public List<CantDiscosPais> getCantDiscosyPaises() {
		return cantDiscosyPaises;
	}

	public void setCantDiscosyPaises(List<CantDiscosPais> cantDiscosyPaises) {
		this.cantDiscosyPaises = cantDiscosyPaises;
	}

	public Banda getBanda() {
		return this.banda;
	}

	public void setBanda(Banda banda) {
		this.banda = banda;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	
}
