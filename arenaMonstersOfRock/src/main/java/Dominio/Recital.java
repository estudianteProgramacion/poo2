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
	public boolean sePuedeAgregar(Presentacion p) {
		return this.BandaTieneUnTercioDeLaPrincipal(p)
				&& !this.superaLimiteDeBandas()
				&& this.getOrganizador().puedeHacerPresentacionEnEvento(p)
				;
	}

	private boolean superaLimiteDeBandas() {
		return this.getBandas().size() > 4;
	}

	private boolean BandaTieneUnTercioDeLaPrincipal(Presentacion p) {
		return !this.hayPresentaciones() 
				|| ((p.getBanda().copiasVendidas() < this.bandaPrincipal().copiasVendidas() * 3)
				&& p.getBanda().getGeneroMusical().equals(this.bandaPrincipal().getGeneroMusical()));
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
