package uiApp;

import Dominio.Anfiteatro;
import Dominio.Banda;
import Dominio.CantDiscosPais;
import Dominio.CenaShow;
import Dominio.Ciudad;
import Dominio.Disco;
import Dominio.Discografica;
import Dominio.Estadio;
import Dominio.Evento;
import Dominio.Festival;
import Dominio.Pais;
import Dominio.Presentacion;
import Dominio.Recital;
import Dominio.Sede;
import ui.EventoVentanaSimple;

public class EventoVentanaSimpleApp {

	public static void main(String[] args) {
		Discografica elf = new Discografica("elf");
		Discografica vamp = new Discografica("vamp");
		
		Pais argentina = new Pais("argentina");
		Pais uruguay = new Pais("uruguay");
		Pais eeuu = new Pais("eeuu");
		
		
		Banda stones = new Banda("Stones",10000.0, "rock", eeuu);
		Banda bandana = new Banda("Bandana",1000.0, "rock", argentina);
		Banda angels = new Banda("Angels",500.0, "pop", eeuu);
		
		Disco flashpoint = new Disco("FalshPoint",1991, stones, elf);
		Disco noche = new Disco("Noche",2002, bandana, vamp);
		Disco theEnd = new Disco("The End",2017, stones, vamp);
		Disco angelitos = new Disco("Angelitos",2000, angels, elf);
		
		CantDiscosPais argFlashPoint = new CantDiscosPais(argentina, 2000);
		CantDiscosPais argNoche = new CantDiscosPais(argentina, 150);
		CantDiscosPais uruFlashPoint = new CantDiscosPais(uruguay , 1000);
		CantDiscosPais uruNoche = new CantDiscosPais(uruguay, 200);
		CantDiscosPais eeuuAngelitos = new CantDiscosPais(eeuu, 5000);
		
		Presentacion presBandanaNoche = new Presentacion(60,noche);
		Presentacion presStonesFalshpoint = new Presentacion(120,flashpoint);
		Presentacion presStonesTheEnd = new Presentacion(240, theEnd);
		Presentacion presAngelsAngelitos = new Presentacion(60, angelitos);
		
		Ciudad belgrano = new Ciudad("Belgrano",argentina);
		Ciudad buenosAires = new Ciudad("Buenos Aires",argentina);
		Ciudad newYork = new Ciudad("New York",eeuu);
		
		Anfiteatro morada = new Anfiteatro("Morada",belgrano,180, 1000.0);
		Sede luna = new Estadio("Luna Park",buenosAires,2000, 2000.0);
		Sede pp = new Estadio ("Park Pick",newYork, 1000, 1200.0);
		
		Evento e1 = new CenaShow("NocheTanqui", belgrano, 80000.0, 50.0);
		Evento e2 = new Recital("VamosTodos",vamp,20000.0, 100, 20000.0);
		Festival e3 = new Festival("Festi Loco",elf, 5000.0,200.0 );
		Evento e4 = new CenaShow("Noche Loca",elf, 80000.0, 50.0);
		
			noche.agregarPais(argNoche);
			noche.agregarPais(uruNoche);
			flashpoint.agregarPais(argFlashPoint);
			flashpoint.agregarPais(uruFlashPoint);
			angelitos.agregarPais(eeuuAngelitos);
			
			stones.agregarDisco(flashpoint);
			bandana.agregarDisco(noche);
			angels.agregarDisco(angelitos);
			
			e1.agregarSede(morada);
			e2.agregarSede(luna);
			e3.agregarSede(pp);
			e3.agregarGeneroAdmitido("pop");
			e3.agregarGeneroAdmitido("rock");
			
		e1.agregarPresentacion(presBandanaNoche);	
		e2.agregarPresentacion(presBandanaNoche);
		
		e3.agregarPresentacion(presAngelsAngelitos);
		e3.agregarPresentacion(presStonesFalshpoint);
		
		
		EventoVentanaSimple window = new EventoVentanaSimple(e3);
		window.startApplication();
	}

}
