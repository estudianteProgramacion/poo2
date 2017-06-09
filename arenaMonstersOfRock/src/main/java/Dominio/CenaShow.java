package Dominio;

public class CenaShow extends Evento {

	public CenaShow(Organizador orga, double mdfi,double pEntrada) {
		super(orga, mdfi, pEntrada);
	}

	public CenaShow(String nombre, Organizador orga, double mdfi,double pEntrada) {
		super(nombre,orga, mdfi, pEntrada);

	}

	@Override
	public boolean sePuedeHacerEnSede(Sede s) {
		return s.sePuedeHacerCenaShow() && this.getOrganizador().puedeHacerEventoEnSede(s);
	}

	@Override
	public boolean sePuedeAgregar(Presentacion p)  {
		return this.getOrganizador().puedeHacerPresentacionEnEvento(p)
				&& !this.hayPresentaciones();
		//TODO exception cuando no hay prensentacion
	}

	@Override
	public double getGastos() {
		return 80000.0 + this.bandaPrincipal().getCachet() * 0.8;
	}

	@Override
	public double aporteEspecial() {
		return 0.5 * this.ingresoMaxPorEntradas();
	}

	private double ingresoMaxPorEntradas() {
		return this.getPrecioEntrada() * this.getSede().getCapacidad();
	}
}
