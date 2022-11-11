/**
 * 
 */
package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Modelo.Jugada;
import Modelo.Jugador;
import Modelo.OpcionesJugada;
import Modelo.Ronda;
import Modelo.TiposJugador;

/**
 * @author Oriol
 *
 */
class TestRonda {

	/**
	 * Test method for {@link Modelo.Ronda#Ronda(int)}.
	 */
	@Test
	void testRondaInt() {
		for (int i = 0; i< 10; i++) {
			Ronda r = new Ronda(i);
			Ronda r2 = new Ronda();
			r2.setNumeroRonda(i);
			assert r == r2 : "les rondes no coincideixen";
		}
		
	}

	/**
	 * Test method for {@link Modelo.Ronda#Ronda()}.
	 */
	@Test
	void testRonda() {
		Ronda r = new Ronda();
		assert r == new Ronda();
	}

	/**
	 * Test method for {@link Modelo.Ronda#getNumeroRonda()}.
	 */
	@Test
	void testGetNumeroRonda() {
		for (int i = 0; i< 10; i++) {
			Ronda r = new Ronda(i);
			assert r.getNumeroRonda() == i : "les rondes no coincideixen";
		}
	}

	/**
	 * Test method for {@link Modelo.Ronda#setNumeroRonda(int)}.
	 */
	@Test
	void testSetNumeroRonda() {
		Ronda r = new Ronda(0);
		for (int i = 0; i< 10; i++) {
			 r.setNumeroRonda(i);
			assert r.getNumeroRonda() == i : "les rondes no coincideixen";
		}
	}

	/**
	 * Test method for {@link Modelo.Ronda#getJugada_Jugador1()}.
	 */
	@Test
	void testGetJugada_Jugador1() {
		Ronda r = new Ronda();
		Jugada j = new Jugada();
		j.setJugada_Seleccionada(OpcionesJugada.PAPER);
		r.setJugada_Jugador1(j);
		assert r.getJugada_Jugador1() == j : "la Jugada no és correcta";
	}

	/**
	 * Test method for {@link Modelo.Ronda#setJugada_Jugador1(Modelo.Jugada)}.
	 */
	@Test
	void testSetJugada_Jugador1() {
		//TODO revisar(els set i get són iguals)
		Ronda r = new Ronda();
		Jugada j = new Jugada();
		j.setJugada_Seleccionada(OpcionesJugada.PAPER);
		r.setJugada_Jugador1(j);
		assert r.getJugada_Jugador1() == j : "la Jugada no és correcta";
	}

	/**
	 * Test method for {@link Modelo.Ronda#getJugada_Jugador2()}.
	 */
	@Test
	void testGetJugada_Jugador2() {
		Ronda r = new Ronda();
		Jugada j = new Jugada();
		j.setJugada_Seleccionada(OpcionesJugada.PAPER);
		r.setJugada_Jugador2(j);
		assert r.getJugada_Jugador2() == j : "la Jugada no és correcta";
	}

	/**
	 * Test method for {@link Modelo.Ronda#setJugada_Jugador2(Modelo.Jugada)}.
	 */
	@Test
	void testSetJugada_Jugador2() {
		//TODO revisar(els set i get són iguals)
		Ronda r = new Ronda();
		Jugada j = new Jugada();
		j.setJugada_Seleccionada(OpcionesJugada.PAPER);
		r.setJugada_Jugador2(j);
		assert r.getJugada_Jugador2() == j : "la Jugada no és correcta";
	}

	/**
	 * Test method for {@link Modelo.Ronda#getGanadorRonda()}.
	 */
	@Test
	void testGetGanadorRonda() {
		Ronda r = new Ronda();
		Jugador j = new Jugador("susan",TiposJugador.PERSONA);
		r.setGanadorRonda(j);
		assert r.getGanadorRonda() == j;
	}

	/**
	 * Test method for {@link Modelo.Ronda#setGanadorRonda(Modelo.Jugador)}.
	 */
	@Test
	void testSetGanadorRonda() {
		//TODO revisar(els set i get són iguals)
		Ronda r = new Ronda();
		Jugador j = new Jugador("susan",TiposJugador.PERSONA);
		r.setGanadorRonda(j);
		assert r.getGanadorRonda() == j;
	}

	/**
	 * Test method for {@link Modelo.Ronda#toString()}.
	 */
	@Test
	void testToString() {
		//TODO He de mirar com fer-ho
	}


}
