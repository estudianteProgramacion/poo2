package Dominio;

public class Estadio extends Sede {

	private double costoPorHora;
	public Estadio(Ciudad ciudad, int capacidad, double cph) {
		super(ciudad, capacidad);
		this.setCostoPorHora(cph);
	}
	public Estadio(String nombre,Ciudad ciudad, int capacidad, double cph) {
		super(nombre,ciudad, capacidad);
		this.setCostoPorHora(cph);
	}
	
	@Override
	public boolean sePuedeHacerFestival(){
		return true;
	}

	@Override
	public double costoPorEvento(Evento e) {
		return (e.getTiempoTotalPresentaciones() / 60) * this.getCostoPorHora();
	}
	
	public double getCostoPorHora(){
		return this.costoPorHora;
	}
	private void setCostoPorHora(double cph) {
		this.costoPorHora=cph;
	}
}
