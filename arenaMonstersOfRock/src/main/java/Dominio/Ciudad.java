package Dominio;

public class Ciudad implements Organizador {
	
	private Pais pais;
	private String nombre;
	
	public Ciudad(Pais p){
		this.pais=p;
	}
	public Ciudad(String nombre,Pais p){
		this.pais=p;
		this.setNombre(nombre);
	}
	

	@Override
	public boolean puedeHacerPresentacionEnEvento(Presentacion p) {
		return p.getBanda().getPais().equals(this.getPais());
	}
	
	@Override
	public boolean puedeHacerEventoEnSede(Sede s) {
		return s.getCiudad().getPais().equals(this.getPais());
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
}
