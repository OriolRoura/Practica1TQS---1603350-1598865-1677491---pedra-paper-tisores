/**
 * 
 */
package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Modelo.Jugador;
import Modelo.Partida;
import Modelo.Ronda;
import Modelo.TiposJugador;

/**
 * @author Oriol
 *
 */
class TestPartida {


	/**
	 * Test method for {@link Modelo.Partida#agregarRonda(Modelo.Ronda)}.
	 */
	@Test
	void testAgregarRonda() {
		Partida p = new Partida();
		for (int i = 0; i< 10;i++) {
			p.agregarRonda(new Ronda(i));
		}
		assert p.getNroRonda() == 10 : "el nombre de rondes no coincideix";
	}

	/**
	 * Test method for {@link Modelo.Partida#existeGanador()}.
	 */
	@Test
	void testExisteGanador() {
		Partida p = new Partida();
		assert p.existeGanador() == false : "no hauria d'existir guanyador" ; 
		p.setGanador(new Jugador("pedro", TiposJugador.PERSONA));
		assert p.existeGanador() == true : "hauria d'existir guanyador" ; 
	}

	/**
	 * Test method for {@link Modelo.Partida#toString()}.
	 */
	@Test
	//TODO no se com fer el test
	void testToString() {
		fail("Not yet implemented");
	}

}
