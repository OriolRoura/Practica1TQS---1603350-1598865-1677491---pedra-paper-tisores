/**
 * 
 */
package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.After;
import org.junit.Before;

import org.junit.jupiter.api.Test;

import Modelo.Jugador;
import Modelo.TiposJugador;

/**
 * @author Oriol
 *
 */
class TestJugador {
	Jugador j ;
	
void run() {
	setUp();
	
	testJugadorStringTiposJugador();
	testJugador();
	testGetNombreJugador();
	testSetNombreJugador();
	testGetTipo();
	testSetTipo();
	testToString();
	
	tearDown();
}
	@Before
	void setUp() {
		j = new Jugador("..dadw",TiposJugador.PERSONA);
	}
	/**
	 * Test method for {@link Modelo.Jugador#Jugador(java.lang.String, Modelo.TiposJugador)}.
	 */
	
	
	@Test
	void testJugadorStringTiposJugador() {
		assert j != null && j.getNombreJugador() == "..dadw" && j.getTipo() == TiposJugador.PERSONA : "nom o tipo no  creat correctament"; 
	}

	/**
	 * Test method for {@link Modelo.Jugador#Jugador()}.
	 */
	@Test
	void testJugador() {
		Jugador j = new Jugador();
		assert j != null : "el jugador buit s'ha creat incorrectament";
	}

	/**
	 * Test method for {@link Modelo.Jugador#getNombreJugador()}.
	 */
	@Test
	void testGetNombreJugador() {
		assert j.getNombreJugador() == "..dadw": "nom mostrat no es el correcte"; 
	
	}

	/**
	 * Test method for {@link Modelo.Jugador#setNombreJugador(java.lang.String)}.
	 */
	@Test
	void testSetNombreJugador() {
		j.setNombreJugador("+++werfd33");
		assert j.getNombreJugador() != "..dadw" : "ha mostrat el nom antic";
		assert j.getNombreJugador() == "+++werfd33": "nom no ha canviat correctament"; 
		

		

	}

	/**
	 * Test method for {@link Modelo.Jugador#getTipo()}.
	 */
	@Test
	void testGetTipo() {
		assert j.getTipo() == TiposJugador.PERSONA: "tipus mostrat no es el correcte"; 
	
	}

	/**
	 * Test method for {@link Modelo.Jugador#setTipo(Modelo.TiposJugador)}.
	 */
	@Test
	void testSetTipo() {
		j.setTipo(TiposJugador.BOT);
		assert j.getTipo() != TiposJugador.PERSONA : "ha mostrat el tipus antic";
		assert j.getTipo() == TiposJugador.BOT: "tipus no ha canviat correctament"; 

	}

	/**
	 * Test method for {@link Modelo.Jugador#toString()}.
	 */
	@Test
	void testToString() { 
		j.toString();
	}
	
	@After
	void tearDown() {
		j = null;
		System.gc();
	}
}
