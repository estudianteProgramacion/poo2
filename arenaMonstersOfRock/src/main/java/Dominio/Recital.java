package Dominio;

public class Recital extends Evento {

	private double costoPublicidad;
	
	public Recital(Organizador orga, double mdfi,double pEntrada, double cPublicidad) {
		super(orga, mdfi, pEntrada);
		this.setCostoPublicidad(cPublicidad);
	}

	public Recital(String nombre,Organizador orga, double mdfi,double pEntrada, double cPublicidad) {
		super(nombre,orga, mdfi, pEntrada);
		this.setCostoPublicidad(cPublicidad);
	}

	@Override
	public boolean sePuedeHacerEnSede(Sede s) {
		return s.sePuedeHacerRecital();
	}

	@Override
	public boolean sePuedeAgregar(Presentacion p){
		return this.BandaTieneUnTercioDeLaPrincipal(p)
				&& this.noSuperaLimiteDeBandas()
				&& this.getOrganizador().puedeHacerPresentacionEnEvento(p)
				;
	}

	//le tube que poner el no adelante por el tema de negar la exception
	private boolean noSuperaLimiteDeBandas() {
		if (this.getBandas().size() <= 4){
		return true;} else {
			throw new RuntimeException("No se puede agregar supera e limite de bandas");
		}
	}

	private boolean BandaTieneUnTercioDeLaPrincipal(Presentacion p) {
		if(!this.hayPresentaciones() 
				|| ((p.getBanda().copiasVendidas() < this.bandaPrincipal().copiasVendidas() * 3)
				&& p.getBanda().getGeneroMusical().equals(this.bandaPrincipal().getGeneroMusical()))){
			return true;} else {
				throw new RuntimeException("La Banda tiene mas de un tercio de copias vendeidas que la banda principal");
			}
	}

	@Override
	public double getGastos() {
		return 	this.bandaPrincipal().getCachet()
				+ this.getSede().costoPorEvento(this) * 0.5
				+ this.getCostoPublicidad();
	}

	@Override
	public double aporteEspecial() {
		return 250000.0;
	}

	public double getCostoPublicidad() {
		return costoPublicidad;
	}

	public void setCostoPublicidad(double costoPublicidad) {
		this.costoPublicidad = costoPublicidad;
	}

}
