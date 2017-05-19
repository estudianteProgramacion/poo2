package Dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.uqbar.commons.utils.Observable;

@Observable
public abstract class Evento {

	private Organizador organizador;
	private Sede sede;
	private double precioEntrada;
	private double montoDeFinanciamientoInicial;
	private List<Presentacion> presentaciones = new ArrayList<Presentacion>();
	private String nombre;
	
	
	public Evento(Organizador orga,double mdfi,double pEntrada){
		this.organizador = orga;
		this.setMontoDeFinanciamientoInicial(mdfi);
		this.setPrecioEntrada(pEntrada);
	}
	
	public Evento(String nombre,Organizador orga,double mdfi,double pEntrada){
		this.organizador = orga;
		this.setMontoDeFinanciamientoInicial(mdfi);
		this.setPrecioEntrada(pEntrada);
		this.setNombre(nombre);
	}
	
	public double indiceDeExitoPotencial(){
		return this.copiasVendidasDeBandasEnPaisDeEvento() 
				* (1 + (this.cantBandasDePais(this.getPaisDeEvento()) * 0.05 ));
	}
	
	private double cantBandasDePais(Pais paisDeEvento) {
		return this.getBandas().stream()
				.filter(b -> b.getPais().equals(paisDeEvento))
				.count();
	}

	private int copiasVendidasDeBandasEnPaisDeEvento() {
		return this.getBandas().stream()
				.mapToInt(b -> b.copiasVendidasPais(this.getPaisDeEvento()))
				.sum();
	}

	public Pais getPaisDeEvento() {
		return this.getSede().getCiudad().getPais();
	}

	public boolean incluyeGenero(String genero){
		return this.bandaPrincipal().getGeneroMusical().equals(genero);
	}
	
	public abstract boolean sePuedeAgregar(Presentacion p);
	
	public abstract boolean sePuedeHacerEnSede(Sede s);
	
	public void agregarSede(Sede s){
		if (this.sePuedeHacerEnSede(s)){
			this.setSede(s);
			s.agregarEvento(this);
		} else {
			System.out.println("No se puede agregar esta sede");
		}
	}
	
	public void agregarPresentacion(Presentacion p){
		if ( this.sePuedeAgregar(p)){
			this.getPresentaciones().add(p);
		} else {
			System.out.println("No se puede agregar esta presentacion al evento");
		}
	}
	
	public boolean esEconomicamenteFactible(){
		return (this.getIngresoAsegurado() - this.getGastos()) > 0;
	}

	public double getIngresoAsegurado() {
		return this.getMontoDeFinanciamientoInicial() + this.aporteEspecial();
	}
	
	public abstract double getGastos();
	public abstract double aporteEspecial();

	public int getTiempoTotalPresentaciones(){
		return this.getPresentaciones().stream()
				.mapToInt(p -> p.getMinutos())
				.sum();
	}
	
	public Banda bandaPrincipal() {
		return  this.getPresentaciones().get(0).getBanda();
	}
	
	public Banda bandaConMasCopias() {
		return this.getBandas().stream()
				.max( (x,y) -> Integer.compare(x.copiasVendidas() ,y.copiasVendidas()))
				.get();
	}

	//setters y getters
	public Organizador getOrganizador(){
		return this.organizador;
	}

	public List<Presentacion> getPresentaciones() {
		return presentaciones;
	}
	public Set<Banda> getBandas(){
		return this.getPresentaciones().stream()
			   .map(p -> p.getBanda())
			   .collect(Collectors.toSet());
	}

	protected boolean hayPresentaciones() {
		return !this.getPresentaciones().isEmpty();
	}

	public double getMontoDeFinanciamientoInicial() {
		return montoDeFinanciamientoInicial;
	}

	public void setMontoDeFinanciamientoInicial(double montoDeFinanciamientoInicial) {
		this.montoDeFinanciamientoInicial = montoDeFinanciamientoInicial;
	}

	public double getPrecioEntrada() {
		return precioEntrada;
	}

	public void setPrecioEntrada(double precioEntrada) {
		this.precioEntrada = precioEntrada;
	}

	public Sede getSede() {
		return sede;
	}

	public void setSede(Sede sede) {
		this.sede = sede;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	//NO USAR SOLO POR QUE ME SALIO EN ARENA
	public void setPresentaciones(List<Presentacion> listP){
		this.presentaciones = listP;
	}

}
