package Dominio;

public class Auspicio {
	
	private double monto;
	private String empresa;
	
	public Auspicio(String e,double m){
		this.monto=m;
		this.empresa=e;
	}
	
	public double getMonto(){
		return monto;
	}
	
	public String getNombreEmpresa(){
		return empresa;
	}
	
}
