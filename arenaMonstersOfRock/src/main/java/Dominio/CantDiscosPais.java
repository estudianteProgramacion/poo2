package Dominio;

public class CantDiscosPais {

	private int cantDiscosVendidos;
	private Pais pais;

	public CantDiscosPais(Pais p,int discosV){
		this.setCantDiscosVendidos(discosV);
		this.setPais(p);
	}
	
	//Setter y Getters
	
	public int getCantDiscosVendidos() {
		return cantDiscosVendidos;
	}
	public void setCantDiscosVendidos(int cantDiscosVendidos) {
		this.cantDiscosVendidos = cantDiscosVendidos;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}
}
