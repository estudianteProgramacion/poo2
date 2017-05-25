package Dominio;

import java.util.ArrayList;
import java.util.List;

import org.uqbar.commons.utils.Observable;

@Observable
public class Banda {

	private Double cachet;
	private List<Disco> discos = new ArrayList<Disco>();
	private String generoMusical;
	private Pais pais;
	private String nombre;
	
	//Constructores
	
	public Banda(Double cachet, String generoM, Pais pais){
		super();
		this.setCachet(cachet);
		this.setGeneroMusical(generoM);
		this.setPais(pais);
	}
	
	public Banda(String nombre, double cachet, String generoM, Pais pais) {
		super();
		this.setCachet(cachet);
		this.setGeneroMusical(generoM);
		this.setPais(pais);
		this.setNombre(nombre);
	}
	
	//Methods
	
	

	public Disco ultimoDisco(){
		return this.getDiscos().stream()
				.max( (x,y) -> Integer.compare(x.getAnioDePublicacion(),y.getAnioDePublicacion()))
				.get(); // LAMBDA 
	}
	
	public int copiasVendidas(){
	 	return this.getDiscos().stream()
			.mapToInt(d -> d.getCopiasVendidas())
			.sum();
	}

	public int copiasVendidasPais(Pais p){
		return this.getDiscos().stream()
				.mapToInt(d -> d.copiasVendidasPais(p))
				.sum();
	}
	
	public void agregarDisco(Disco d){
		this.discos.add(d);
	}
	
	//Setter y Getters
	
	public Double getCachet() {
		return cachet;
	}
	public void setCachet(Double cachet) {
		this.cachet = cachet;
	}
	public String getGeneroMusical() {
		return generoMusical;
	}
	public void setGeneroMusical(String generoMusical) {
		this.generoMusical = generoMusical;
	}
	
	public List<Disco> getDiscos() {
		return discos;
	}
	public void setDiscos(List<Disco> discos) {
		this.discos = discos;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return this.nombre;
	}
}
