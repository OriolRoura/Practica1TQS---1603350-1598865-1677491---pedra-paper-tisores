/**
 * 
 */
package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Modelo.Jugador;
import Modelo.Partida;
import Modelo.Ronda;
import Modelo.TiposJugador;
import org.junit.After;
import org.junit.Before;


/**
 * @author Oriol
 *
 */
class TestPartida {
	Partida p;

	void run() {
		setUp();
		testAgregarRonda();
		testExisteGanador();
		testToString();
		testgetIdPartida();
		tearDown();
		
	}
	
	
	@BeforeEach
	void setUp() {
		p = new Partida();
		p.setIdPartida("id");
	}
	
	
	/**
	 * Test method for {@link Modelo.Partida#agregarRonda(Modelo.Ronda)}.
	 */
	
	@Test
	void testAgregarRonda() {
		for (int i = 0; i< 10;i++) {
			p.agregarRonda(new Ronda(i));
		}
		assert p.getNroRonda() == 10 : "el nombre de rondes no coincideix en la sonda	";
	}

	/**
	 * Test method for {@link Modelo.Partida#existeGanador()}.
	 */
	@Test
	void testExisteGanador() {
		assert p.existeGanador() == false : "no hauria d'existir guanyador" ; 
		p.setGanador(new Jugador("pedro", TiposJugador.PERSONA));
		assert p.existeGanador() == true : "hauria d'existir guanyador" ; 
	}

	/**
	 * Test method for {@link Modelo.Partida#toString()}.
	 */
	@Test

	void testToString() {
		p.toString();
	}
	
	@Test
	void testgetIdPartida() {
		assert p.getIdPartida().equals("id");
	}
	
	@AfterEach
	void tearDown() {
		p = null;
		System.gc();
	}

}
