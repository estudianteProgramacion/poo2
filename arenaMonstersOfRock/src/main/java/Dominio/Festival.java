package Dominio;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Festival extends Evento {

	private Collection<String> generosAdmitidos = new HashSet<String>();
	private static final int tiempoMax = 720;
	private Set<Auspicio> auspicios = new HashSet<Auspicio>();
	
	public Festival(Organizador orga, double mdfi,double pEntrada) {
		super(orga, mdfi, pEntrada);
	}
	public Festival(String nombre,Organizador orga, double mdfi,double pEntrada) {
		super(nombre,orga, mdfi, pEntrada);
	}
	
	@Override
	public boolean sePuedeHacerEnSede(Sede s) {
		return s.sePuedeHacerFestival();
	}
	
	public void agregarGeneroAdmitido(String genero){
		this.generosAdmitidos.add(genero);
	}
	
	
	@Override
	public boolean sePuedeAgregar(Presentacion p)  {
		return this.getOrganizador().puedeHacerPresentacionEnEvento(p)
				&& this.estaEnGenerosAdmitidos(p)
				&& this.noSupueraTiempo(p)
				&& this.tieneMenosDiscosQuePrincipal(p);
	}

	private boolean tieneMenosDiscosQuePrincipal(Presentacion p){
		if (!this.hayPresentaciones() || (p.getBanda().copiasVendidas() < this.bandaPrincipal().copiasVendidas())){
		return true;} else {
			throw new RuntimeException("Esta Banda tiene mas discos que la principal, tiene que tener " ); //+ this.bandaPrincipal().copiasVendidas()
		}
	}

	private boolean estaEnGenerosAdmitidos(Presentacion p) {
		if (this.getGenerosAdmitidos().contains( p.getBanda().getGeneroMusical() )){
		return true;} else {
			throw new RuntimeException("El genero " + p.getBanda().getGeneroMusical() + " no esta en los generos admitidos ");
		}
	}

	private boolean noSupueraTiempo(Presentacion p){
		if ((this.getTiempoTotalPresentaciones() + p.getMinutos()) <= tiempoMax){
		return true;} else {
			throw new RuntimeException("Agregando esta presentacion superaria el tiempo Maximo ");
		}
	}

	@Override
	public Banda bandaPrincipal() {
		return this.bandaConMasCopias();
	}
	
	@Override 
	public boolean incluyeGenero(String genero){
		return this.bandaPrincipal().getGeneroMusical().equals(genero)
				|| this.tresBandasDelMismoGenero(genero);
	}

	private boolean tresBandasDelMismoGenero(String genero) {
		return this.getBandas().stream()
				.filter(b -> !b.equals(this.bandaPrincipal()))
				.filter(b -> b.getGeneroMusical().equals(genero))
				.count() >= 3;
	}
	
	@Override
	public double getGastos() {
		return this.getBandas().stream()
				.mapToDouble(b -> b.getCachet() *0.5)
				.sum() 
				+ this.bandaPrincipal().getCachet() * 0.5;
	}

	@Override
	public double aporteEspecial() {
		return this.getAuspicios().stream()
				.mapToDouble(a -> a.getMonto())
				.sum();
	}
	//Setter y Getters
	
	public Collection<String> getGenerosAdmitidos() {
		return generosAdmitidos;
	}

	public void setGenerosAdmitidos(Collection<String> generosAdmitidos) {
		this.generosAdmitidos = generosAdmitidos;
	}

	public Set<Auspicio> getAuspicios() {
		return auspicios;
	}

	public void agregarAuspicio(Auspicio auspicio) {
		this.auspicios.add(auspicio);
	}

	


}
