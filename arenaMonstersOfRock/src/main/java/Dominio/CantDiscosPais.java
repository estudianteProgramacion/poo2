package Dominio;

import org.uqbar.commons.utils.Observable;

@Observable
public class CantDiscosPais {

	private int cantDiscosVendidos;
	private Pais pais;

	public CantDiscosPais(Pais p,int discosV){
		this.setCantDiscosVendidos(discosV);
		this.setPais(p);
	}
	
	//Setter y Getters
	
	@Override
	public boolean equals(Object a){
		return this.getPais().equals(((CantDiscosPais) a).getPais());
	}
	
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

	public void addCantDiscosVendidos(int cantDiscosVendidos2) {
		this.setCantDiscosVendidos(this.getCantDiscosVendidos() + cantDiscosVendidos2);
	}
}
