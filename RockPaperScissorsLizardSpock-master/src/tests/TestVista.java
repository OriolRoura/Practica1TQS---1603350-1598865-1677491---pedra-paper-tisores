/**
 * 
 */
package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import MVC.Vista.Validacion;
import MVC.Vista.Vista;
import Modelo.*;

/**
 * @author Oriol
 *
 */
class TestVista {

	Vista jvj;
	Vista jvb;
	Vista bvb;
	Vista c;
	Partida p1;
	Partida p2;
	Partida p3;
    ServicioPartida sp;
    ServicioRonda sr;
	
	@Test
	void testRun() {
		SetUp();
		
		testMostrarIngreso();
		testRegistrarJugador();
		testEstablecerPuntos();
		testRealizarJugada();
		TestMostrarJugadas();
		mostrarGanadorRonda();
		mostrarGanadorPartida();
		
		tearDown();
	}
	
	void SetUp(){
		PartidaBaseDades bd = new MockPartidaBaseDades();
		p1 = new Partida();
		p2 = new Partida();
		p3 = new Partida();
		p1.setIdPartida("test1");
		p2.setIdPartida("test2");
		p3.setIdPartida("test3");
		p1.setRondas(new ArrayList());
		p1.setRondas(new ArrayList());
		p1.setRondas(new ArrayList());
		ServicioJugadaBOT sb = new MockServicioJugadaBOT();
		Validacion v = new MockValidacion();
		jvj = new Vista(p1,v, sb);
		jvb = new Vista(p2,v, sb);
		bvb = new Vista(p3,v, sb);
		c = new Vista(p1, v, sb);
		sp = new ServicioPartida();
		sr = new ServicioRonda();
	}

	/**
	 * Test method for {@link MVC.Vista.Vista#mostrarIngreso()}.
	 */
	
	void testMostrarIngreso() {
		c.mostrarIngreso();
		assert p1.getTipo() == TiposPartida.C : "el tipus hauria de ser C";
		jvj.mostrarIngreso();
		assert p1.getTipo() == TiposPartida.JvJ : "el tipus hauria de ser JvJ";
		jvb.mostrarIngreso();
		assert p2.getTipo() == TiposPartida.JvB : "el tipus hauria de ser JvB";
		bvb.mostrarIngreso();
		assert p3.getTipo() == TiposPartida.BvB : "el tipus hauria de ser BvB";
	}

	/**
	 * Test method for {@link MVC.Vista.Vista#registrarJugador(int)}.
	 */
	
	void testRegistrarJugador() {
		jvj.registrarJugador(0);
		assert p1.getJugador1() == null && p1.getJugador2() == null : "no s'hauria d'haver afegit cap jugador";
		jvj.registrarJugador(1);
		jvj.registrarJugador(2);
		assert p1.getJugador1().getNombreJugador() == (String)"Carmen"  : "no s'ha canviat el nom correctament(j1 en JvJ)";
		assert p1.getJugador2().getNombreJugador() == "Martina" && p1.getJugador1().getNombreJugador() == (String)"Carmen" : "no s'ha canviat el nom correctament(j2 en JvJ)";

		jvb.registrarJugador(1);
		jvb.registrarJugador(2);
		assert p2.getJugador1().getNombreJugador() == "Jose" : "no s'ha canviat el nom correctament(j1 en JvB)";
		assert p2.getJugador2() == null && p2.getJugador2() == null : "no s'hauria d'haver afegit cap jugador (j2 en JvB)";
		
		bvb.registrarJugador(1);
		bvb.registrarJugador(2);
		assert p3.getJugador1() == null && p3.getJugador2() == null : "no s'hauria d'haver afegit cap jugador (j1 en BvB)";
		assert p3.getJugador2() == null && p3.getJugador2() == null : "no s'hauria d'haver afegit cap jugador (j2 en BvB)";
		
		p2.setJugador2(new Jugador("Bot2",TiposJugador.BOT));
		p3.setJugador1(new Jugador("Bot1",TiposJugador.BOT));
		p3.setJugador2(new Jugador("Bot2",TiposJugador.BOT));
	}

	/**
	 * Test method for {@link MVC.Vista.Vista#establecerPuntos()}.
	 */
	
	void testEstablecerPuntos() {
		jvj.establecerPuntos();
		jvb.establecerPuntos();
		bvb.establecerPuntos();
		assert p1.getAlMejorDe() == 3 && p2.getAlMejorDe() == 4 && p3.getAlMejorDe() == 5 : "haurien de ser 3, 4 i 5 respectibament";
	}

	/**
	 * Test method for {@link MVC.Vista.Vista#realizarJugada(int)}.
	 */
	
	void testRealizarJugada() {
		Ronda r1 = new Ronda(0);
		r1.setJugada_Jugador1(jvj.realizarJugada(1));
		r1.setJugada_Jugador2(jvj.realizarJugada(2));
		assert r1.getJugada_Jugador1().getJugada_Seleccionada() == OpcionesJugada.ROCK : "no es la correcta";
		assert r1.getJugada_Jugador2().getJugada_Seleccionada() == OpcionesJugada.PAPER : "no es la correcta";
		p1.getRondas().add(r1);
		
		Ronda r2 = new Ronda(0);
		r2.setJugada_Jugador1(jvb.realizarJugada(1));
		r2.setJugada_Jugador2(jvb.realizarJugada(2));
		assert r2.getJugada_Jugador1().getJugada_Seleccionada() == OpcionesJugada.SCISSORS : "no es la correcta";
		assert r2.getJugada_Jugador2().getJugada_Seleccionada() == OpcionesJugada.PAPER: "no es la correcta";
		p2.getRondas().add(r2);
		
		Ronda r3 = new Ronda(0);
		r3.setJugada_Jugador1(bvb.realizarJugada(1));
		r3.setJugada_Jugador2(bvb.realizarJugada(2));
		assert r3.getJugada_Jugador1().getJugada_Seleccionada() == OpcionesJugada.PAPER: "no es la correcta";
		assert r3.getJugada_Jugador2().getJugada_Seleccionada() == OpcionesJugada.PAPER: "no es la correcta";
		p3.getRondas().add(r3);
		jvj.realizarJugada(3);
		jvb.realizarJugada(5);
		bvb.realizarJugada(-1);
	}

	void TestMostrarJugadas() {
		jvj.mostrarJugadas(1);
		jvb.mostrarJugadas(1);
		bvb.mostrarJugadas(1);
		
		jvj.mostrarJugadas(0);
		jvb.mostrarJugadas(0);
		bvb.mostrarJugadas(0);
		
		jvj.mostrarJugadas(-1);
		jvb.mostrarJugadas(-1);
		bvb.mostrarJugadas(-1);
		
	}
	void mostrarGanadorRonda() {
		p1.setAlMejorDe(1);
		p2.setAlMejorDe(1);
		p3.setAlMejorDe(1);
		sr.evaluarGanador(p1.getRondas().get(0));
		sr.evaluarGanador(p1.getRondas().get(0));
		sr.evaluarGanador(p1.getRondas().get(0));
		jvj.mostrarGanadorRonda(0);
		jvb.mostrarGanadorRonda(0);
		bvb.mostrarGanadorRonda(0);
	}
	void mostrarGanadorPartida() {
		sp.evaluarGanador(p1);
		sp.evaluarGanador(p1);
		sp.evaluarGanador(p1);
		jvj.mostrarGanadorPartida();
		jvb.mostrarGanadorPartida();
		bvb.mostrarGanadorPartida();
	}
	
	void tearDown() {
		jvj = null;
		jvb = null;
		bvb = null;
		c = null;
		p1 = null;
		p2 = null;
		p3 = null;
	}

}
