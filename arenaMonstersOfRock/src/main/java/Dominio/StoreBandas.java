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
		Discografica uruDisc = new Discografica("uruDisc");
				
		Disco flashpoint = new Disco("flashPoint",1991, this.getBanda("stones"), elf);
		Disco noche = new Disco("noche",2002, this.getBanda("bandana"), elf);
		Disco mierdas = new Disco("mierdas", 2001, this.getBanda("bandana"), vamp);
		Disco publico = new Disco("publico",2012, this.getBanda("noTeVaAGustar"), uruDisc);
		Disco porLoMenos = new Disco("porLoMenos",2010, this.getBanda("noTeVaAGustar"), elf);
		Disco genero = new Disco("genero", 2015, this.getBanda("generacion"), elf);
		Disco angelitos = new Disco("angelitos",2000, this.getBanda("angels"), elf);

		
		CantDiscosPais argFlashPoint = new CantDiscosPais(StorePaises.getInstance().getPais("argentina"), 10000);
		CantDiscosPais argNoche = new CantDiscosPais(StorePaises.getInstance().getPais("argentina"), 150);
		CantDiscosPais uruFlashPoint = new CantDiscosPais(StorePaises.getInstance().getPais("uruguay") , 1000);
		CantDiscosPais uruNoche = new CantDiscosPais(StorePaises.getInstance().getPais("uruguay"), 200);
		CantDiscosPais eeuuMierdas = new CantDiscosPais(StorePaises.getInstance().getPais("eeuu"), 50);
		CantDiscosPais uruPublico = new CantDiscosPais(StorePaises.getInstance().getPais("uruguay"), 2000);
		CantDiscosPais eeuuAngelitos = new CantDiscosPais(StorePaises.getInstance().getPais("eeuu"), 5000);

		
		flashpoint.agregarPais(argFlashPoint);
		flashpoint.agregarPais(uruFlashPoint);
		noche.agregarPais(uruNoche);
		noche.agregarPais(argNoche);
		mierdas.agregarPais(eeuuMierdas);
		porLoMenos.agregarPais(uruPublico);
		angelitos.agregarPais(eeuuAngelitos);
		
		this.getBanda("angels").agregarDisco(angelitos);
		this.getBanda("noTeVaAGustar").agregarDisco(porLoMenos);
		this.getBanda("stones").agregarDisco(flashpoint);
		this.getBanda("bandana").agregarDisco(noche);
		this.getBanda("bandana").agregarDisco(mierdas);
		this.getBanda("noTeVaAGustar").agregarDisco(publico);
		this.getBanda("generacion").agregarDisco(genero);
	}


	public void ponerBandas(){
		
		Pais eeuu = StorePaises.getInstance().getPais("eeuu");
		Pais argentina = StorePaises.getInstance().getPais("argentina");
		Pais uruguay = StorePaises.getInstance().getPais("uruguay");
			

		this.getBandas().add( new Banda("stones",10000.0, "rock", eeuu));
		this.getBandas().add( new Banda("bandana",1000.0, "rock", argentina));
		this.getBandas().add( new Banda("angels",500.0, "pop", eeuu));
		this.getBandas().add( new Banda("noTeVaAGustar",5000.0, "reagge", uruguay));
		this.getBandas().add(new Banda("generacion", 7000.0, "punk", argentina));
		
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
