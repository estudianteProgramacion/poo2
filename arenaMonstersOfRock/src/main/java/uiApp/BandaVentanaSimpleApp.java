package uiApp;

import Dominio.Banda;
import Dominio.CantDiscosPais;
import Dominio.Disco;
import Dominio.Discografica;
import Dominio.Pais;
import ui.BandaVentanaSimple;

public class BandaVentanaSimpleApp {

	public static void main(String[] args) {
		Discografica elf = new Discografica("elf");
		
		Pais eeuu = new Pais("eeuu");
		
		Banda stones = new Banda(10000.0, "rock", eeuu);
		stones.setNombre("stones");
		
		Disco flashpoint = new Disco(1991, stones, elf);
		flashpoint.setNombre("Flashpoint");
		Disco angie = new Disco(1970, stones, elf);
		angie.setNombre("Angie");
		
		CantDiscosPais eeuuFlashPoint = new CantDiscosPais(eeuu, 2000);
		CantDiscosPais eeuuAngie = new CantDiscosPais(eeuu, 5500);


		flashpoint.agregarPais(eeuuFlashPoint);
		stones.agregarDisco(flashpoint);
		angie.agregarPais(eeuuAngie);
		stones.agregarDisco(angie);
		
		BandaVentanaSimple window = new BandaVentanaSimple(stones);
		window.startApplication();
	}
}
