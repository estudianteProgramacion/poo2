package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import Dominio.Anfiteatro;
import Dominio.Auspicio;
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

//public class testPunto1 {
//	
//	Discografica elf = new Discografica("elf");
//	Discografica vamp = new Discografica("vamp");
//	
//	Pais argentina = new Pais("argentina");
//	Pais uruguay = new Pais("uruguay");
//	Pais eeuu = new Pais("eeuu");
//	
//	
//	Banda stones = new Banda(10000.0, "rock", eeuu);
//	Banda bandana = new Banda(1000.0, "rock", argentina);
//	Banda angels = new Banda(500.0, "pop", eeuu);
//	
//	Disco flashpoint = new Disco(1991, stones, elf);
//	Disco noche = new Disco(2002, bandana, vamp);
//	Disco theEnd = new Disco(2017, stones, vamp);
//	Disco angelitos = new Disco(2000, angels, elf);
//	
//	CantDiscosPais argFlashPoint = new CantDiscosPais(argentina, 2000);
//	CantDiscosPais argNoche = new CantDiscosPais(argentina, 150);
//	CantDiscosPais uruFlashPoint = new CantDiscosPais(uruguay , 1000);
//	CantDiscosPais uruNoche = new CantDiscosPais(uruguay, 200);
//	CantDiscosPais eeuuAngelitos = new CantDiscosPais(eeuu, 5000);
//	
//	Presentacion presBandanaNoche = new Presentacion(60,noche);
//	Presentacion presStonesFalshpoint = new Presentacion(120,flashpoint);
//	Presentacion presStonesTheEnd = new Presentacion(240, theEnd);
//	Presentacion presAngelsAngelitos = new Presentacion(60, angelitos);
//	
//	Ciudad belgrano = new Ciudad(argentina);
//	Ciudad buenosAires = new Ciudad(argentina);
//	Ciudad newYork = new Ciudad(eeuu);
//	
//	Anfiteatro morada = new Anfiteatro(belgrano,180, 1000.0);
//	Sede luna = new Estadio(buenosAires,2000, 2000.0);
//	Sede pp = new Estadio (newYork, 1000, 1200.0);
//	
//	Evento e1 = new CenaShow(belgrano, 80000.0, 50.0);
//	Evento e2 = new Recital(vamp,20000.0, 100, 20000.0);
//	Festival e3 = new Festival(elf, 5000.0,200.0 );
//	Evento e4 = new CenaShow(elf, 80000.0, 50.0);
//	
//	@Before
//	public void init(){
//		noche.agregarPais(argNoche);
//		noche.agregarPais(uruNoche);
//		flashpoint.agregarPais(argFlashPoint);
//		flashpoint.agregarPais(uruFlashPoint);
//		angelitos.agregarPais(eeuuAngelitos);
//		
//		stones.agregarDisco(flashpoint);
//		bandana.agregarDisco(noche);
//		angels.agregarDisco(angelitos);
//		
//		e2.agregarSede(luna);
//		e3.agregarSede(pp);
//		e3.agregarGeneroAdmitido("pop");
//		e3.agregarGeneroAdmitido("rock");
//	}
//	
//	@Test
//	public void testDiscosVendidos() {
//
//		assertEquals(3000 , stones.copiasVendidas());
//
//		assertEquals(350, bandana.copiasVendidas());
//		
//	}
//	
//	@Test
//	public void testUltimoDisco(){
//		
//		assertEquals(noche, bandana.ultimoDisco());
//		
//		Disco night = new Disco(2003, bandana,vamp);
//		
//		Disco oscura = new Disco(2004, bandana,vamp);
//		
//		bandana.agregarDisco(night);
//		assertEquals(night, bandana.ultimoDisco());
//		bandana.agregarDisco(oscura);
//		assertEquals(oscura, bandana.ultimoDisco());
//
//	}
//	
//	@Test
//	public void testConjuntoDeBandasEventos(){
//		
//		//anfiTeatro
//		e1.agregarSede(morada);
//		e1.agregarPresentacion(presBandanaNoche);
//		
//		Set<Banda> anfiBTest = new HashSet<Banda>();
//		anfiBTest.add(bandana);
//		
//		assertEquals(anfiBTest, morada.bandasQueActuan());
//		
//		//estadio
//		e2.agregarSede(luna);
//		e2.agregarPresentacion(presStonesTheEnd);
//		e2.agregarPresentacion(presBandanaNoche);
//
//		Set<Banda> estadioBandasTest = new HashSet<Banda>();
//		estadioBandasTest.add(bandana);
//		estadioBandasTest.add(stones);
//		
//		assertEquals(estadioBandasTest, luna.bandasQueActuan());
//		
//	}
//	
//	@Test
//	public void puedeAgregaseBandaAEvento(){
//
//		assertEquals(true, e1.sePuedeAgregar(presBandanaNoche));
//		assertEquals(false, e2.sePuedeAgregar(presStonesFalshpoint));
//		assertEquals(false, e1.sePuedeAgregar(presStonesTheEnd));
//		assertEquals(true, e2.sePuedeAgregar(presStonesTheEnd));
//		
//	}
//	
//	@Test
//	public void agregarBandaAEvento(){
//
//		//lanza Por consola que no se puede
//		System.out.println("error AgregarBandaAEvento StonesFalshpoint:");
//		e2.agregarPresentacion(presStonesFalshpoint);
//		
//		e1.agregarPresentacion(presBandanaNoche);
//	}
//	
//	@Test 
//	public void eventoIncluyeGenero(){
//		e2.agregarSede(luna);
//		e2.agregarPresentacion(presStonesTheEnd);
//		e2.agregarPresentacion(presBandanaNoche);
//		
//		System.out.println("error eventoIncluyeGenero agregarAngels:");
//		e2.agregarPresentacion(presAngelsAngelitos);
//		
//		assertTrue(e2.incluyeGenero("rock"));
//		assertFalse(e2.incluyeGenero("pop"));
//		
//		e3.agregarPresentacion(presAngelsAngelitos);
//		e3.agregarPresentacion(presStonesFalshpoint);
//		
//		assertTrue(e3.incluyeGenero("pop"));
//		assertFalse(e3.incluyeGenero("rock")); //por que tienen que ser 3 bandas
//		assertFalse(e3.incluyeGenero("cumbia"));
//		
////		e1.incluyeGenero("pop"); ERROR
//		
//	}
//	
//	@Test
//	public void costoDeAlquilerSede(){
//		
//		//Anfiteatro
//		e1.agregarSede(morada);
//		e1.agregarPresentacion(presBandanaNoche);
//		
//		int d = Double.compare(1000.0, morada.costoPorEvento(e1));
//		assertEquals(0, d);
//		
//		morada.agregarGeneroEnPromocion("rock");
//		
//		int d1 = Double.compare(800.0, morada.costoPorEvento(e1));
//		assertEquals(0, d1);
//		
//		//Estadio
//		
//		e2.agregarPresentacion(presStonesTheEnd);
//		
//		int d2 = Double.compare(4*2000.0, luna.costoPorEvento(e2));
//		assertEquals(0, d2);
//	}
//	
//
//	@Test
//	public void economicamenteFactible(){
//		
//		//Festival
//		e3.agregarPresentacion(presAngelsAngelitos);
//		e3.agregarPresentacion(presStonesTheEnd);
//		
//		assertFalse( e3.esEconomicamenteFactible());
//		
//		Auspicio a1 = new Auspicio("coca-cola", 50000.0);
//		e3.agregarAuspicio(a1);
//		
//		assertTrue(e3.esEconomicamenteFactible());
//		
//		//Recital
//		e2.agregarPresentacion(presBandanaNoche);
//		
//		assertTrue(e2.esEconomicamenteFactible());
//		
//		bandana.setCachet(250000.0);
//		
//		assertFalse(e2.esEconomicamenteFactible());
//		
//		//cenaShow
//		e1.agregarSede(morada);
//		e1.agregarPresentacion(presBandanaNoche);
//				
//		assertFalse(e1.esEconomicamenteFactible());
//		
//		morada.setCapacidad(10000);
//		assertTrue (e1.esEconomicamenteFactible());
//	}
//
//	@Test
//	public void bandasExtranjerasQueParticipanEnPais(){
//		e2.agregarSede(luna);
//		e2.agregarPresentacion(presStonesTheEnd);
//		e2.agregarPresentacion(presBandanaNoche);
//
//		e4.agregarSede(morada);
//		e4.agregarPresentacion(presAngelsAngelitos);
//		
//		Set<Banda> argBandasExtranjeras = new HashSet<Banda>();
//		argBandasExtranjeras.add(stones);
//		argBandasExtranjeras.add(angels);
//		assertTrue(argBandasExtranjeras.containsAll(argentina.bandasExtranjerasQueTocan()));
//		
//	}
//}
