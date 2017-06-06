package Dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.uqbar.commons.utils.Observable;

@Observable
public class StoreBandas {

	private List<Banda> bandas = new ArrayList<>();
	private static StoreBandas instance;
	
	private StoreBandas() {
		super();
			try {
				this.ponerBandas();
			} catch (Exception e) {
				e.printStackTrace();
			}
			this.configurarBandas();
	}
	

	private void configurarBandas() {
		Discografica elf = new Discografica("elf");
		Discografica vamp = new Discografica("vamp");
				
		Disco flashpoint = new Disco(1991, this.getBanda("stones"), elf);
		Disco noche = new Disco(2002, this.getBanda("bandana"), vamp);
//		Disco theEnd = new Disco(2017, stones, vamp);
//		Disco angelitos = new Disco(2000, angels, elf);
		
		this.getBanda("stones").agregarDisco(flashpoint);
		this.getBanda("bandana").agregarDisco(noche);
	}


	public void ponerBandas() throws Exception {
		
		Pais eeuu = StorePaises.getInstance().getPais("eeuu");
		Pais argentina = StorePaises.getInstance().getPais("argentina");
		Pais uruguay = StorePaises.getInstance().getPais("uruguay");
			

		this.getBandas().add( new Banda("stones",10000.0, "rock", eeuu));
		this.getBandas().add( new Banda("bandana",1000.0, "rock", argentina));
		this.getBandas().add( new Banda("angels",500.0, "pop", eeuu));
		this.getBandas().add( new Banda("noTeVaAGustar",5000.0, "pop", uruguay));
		
	}


	private Banda getBanda(String string) {
		return this.getBandas().stream()
							.filter(b -> b.getNombre().equals(string))
							.collect(Collectors.toList())
							.get(0);
	}


	public static StoreBandas getInstance()  {
		return (instance == null) ? instance = new StoreBandas() : instance;
	}


	public List<Banda> getBandas() {
		return bandas;
	}


	public void setBandas(List<Banda> bandas) {
		this.bandas = bandas;
	}
}
