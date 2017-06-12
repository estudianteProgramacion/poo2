package uiApp;

import Dominio.Anfiteatro;
import Dominio.CenaShow;
import Dominio.Ciudad;
import Dominio.Discografica;
import Dominio.Estadio;
import Dominio.Evento;
import Dominio.Festival;
import Dominio.Pais;
import Dominio.Recital;
import Dominio.Sede;
import Dominio.StorePaises;
import ui.EventoVentanaSimple;

public class EventoVentanaSimpleApp {

	public static void main(String[] args) throws Exception {
		Discografica elf = new Discografica("elf");
		Discografica vamp = new Discografica("vamp");
		
		Pais argentina = StorePaises.getInstance().getPais("argentina");
		Pais eeuu = StorePaises.getInstance().getPais("eeuu");
		
		
		Ciudad belgrano = new Ciudad("Belgrano",argentina);
		Ciudad buenosAires = new Ciudad("Buenos Aires",argentina);
		Ciudad newYork = new Ciudad("New York",eeuu);
		
		Anfiteatro morada = new Anfiteatro("Morada",belgrano,180, 1000.0);
		Sede luna = new Estadio("Luna Park",buenosAires,2000, 2000.0);
		Sede pp = new Estadio ("Park Pick",newYork, 1000, 1200.0);
		
		Evento e1 = new CenaShow("NocheTanqui", belgrano, 80000.0, 50.0);
		Evento e2 = new Recital("VamosTodos",vamp,20000.0, 100, 20000.0);
		Festival e3 = new Festival("Festi Loco",elf, 5000.0,200.0 );
	
			e1.agregarSede(morada);
			e2.agregarSede(luna);
			e3.agregarSede(pp);
			e3.agregarGeneroAdmitido("pop");
			e3.agregarGeneroAdmitido("rock");
			e3.agregarGeneroAdmitido("reagge");
			

			//Aca se cambia entre los 3 eventos
		EventoVentanaSimple window = new EventoVentanaSimple(e1);
		window.startApplication();
	}

}
