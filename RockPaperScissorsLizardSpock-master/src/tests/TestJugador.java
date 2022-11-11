/**
 * 
 */
package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Modelo.Jugador;
import Modelo.TiposJugador;

/**
 * @author Oriol
 *
 */
class TestJugador {

	/**
	 * Test method for {@link Modelo.Jugador#Jugador(java.lang.String, Modelo.TiposJugador)}.
	 */
	@Test
	void testJugadorStringTiposJugador() {
		Jugador j = new Jugador("..dadw",TiposJugador.PERSONA);
		assert j != null && j.getNombreJugador() == "..dadw" && j.getTipo() == TiposJugador.PERSONA : "nom o tipo no  creat correctament"; 
	}

	/**
	 * Test method for {@link Modelo.Jugador#Jugador()}.
	 */
	@Test
	void testJugador() {
		Jugador j = new Jugador();
		assert j != null && j == new Jugador() : "el jugador buit s'ha creat incorrectament";
	}

	/**
	 * Test method for {@link Modelo.Jugador#getNombreJugador()}.
	 */
	@Test
	void testGetNombreJugador() {
		Jugador j = new Jugador("..dadw",TiposJugador.PERSONA);
		assert j.getNombreJugador() == "..dadw": "nom mostrat no es el correcte"; 
	
	}

	/**
	 * Test method for {@link Modelo.Jugador#setNombreJugador(java.lang.String)}.
	 */
	@Test
	void testSetNombreJugador() {
		Jugador j = new Jugador("..dadw",TiposJugador.PERSONA);
		j.setNombreJugador("+++werfd33");
		assert j.getNombreJugador() != "..dadw" : "ha mostrat el nom antic";
		assert j.getNombreJugador() == "+++werfd33": "nom no ha canviat correctament"; 
		

		

	}

	/**
	 * Test method for {@link Modelo.Jugador#getTipo()}.
	 */
	@Test
	void testGetTipo() {
		Jugador j = new Jugador("..dadw",TiposJugador.PERSONA);
		assert j.getTipo() == TiposJugador.PERSONA: "tipus mostrat no es el correcte"; 
	
	}

	/**
	 * Test method for {@link Modelo.Jugador#setTipo(Modelo.TiposJugador)}.
	 */
	@Test
	void testSetTipo() {
		Jugador j = new Jugador("..dadw",TiposJugador.PERSONA);
		j.setTipo(TiposJugador.BOT);
		assert j.getTipo() != TiposJugador.PERSONA : "ha mostrat el tipus antic";
		assert j.getTipo() == TiposJugador.BOT: "tipus no ha canviat correctament"; 

	}

	/**
	 * Test method for {@link Modelo.Jugador#toString()}.
	 */
	@Test
	void testToString() {
		//TODO no se com es fa
		fail("Not yet implemented");
	}

}
