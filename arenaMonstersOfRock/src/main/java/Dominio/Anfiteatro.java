package Dominio;

import java.util.HashSet;
import java.util.Set;

public class Anfiteatro extends Sede {

	private Set<String> generosEnPromocion = new HashSet<String>();
	private double costoBasePorEvento;
	
	public Anfiteatro(Ciudad ciudad, int capacidad, double costoBaseE) {
		super(ciudad, capacidad);
		this.setCostoBasePorEvento(costoBaseE);
	}

	public Anfiteatro(String nombre, Ciudad ciudad, int capacidad, double costoBaseE) {
		super(nombre,ciudad, capacidad);
		this.setCostoBasePorEvento(costoBaseE);
		
	}

	@Override 
	public boolean sePuedeHacerCenaShow(){
		return true;
	}

	@Override
	public double costoPorEvento(Evento e) {
		return  this.getCostoBasePorEvento() - this.descuento(e);
	}

	private double descuento(Evento e) {
		 double desc = 0.0;
		 if (this.aplicaDescuento(e)){
			 desc = this.getCostoBasePorEvento() * 0.2;
		 }
		 return desc;
	}
	
	private boolean aplicaDescuento(Evento e) {
		return  this.getGenerosEnPromocion().stream()
				.anyMatch(g -> e.incluyeGenero(g));
	}

	public void agregarGeneroEnPromocion(String g){
		this.getGenerosEnPromocion().add(g);
	}
	
	public Set<String> getGenerosEnPromocion() {
		return generosEnPromocion;
	}

	public void setGenerosEnPromocion(Set<String> generosEnPromocion) {
		this.generosEnPromocion = generosEnPromocion;
	}

	public double getCostoBasePorEvento() {
		return costoBasePorEvento;
	}

	public void setCostoBasePorEvento(double costoPorEvento) {
		this.costoBasePorEvento = costoPorEvento;
	}
}
