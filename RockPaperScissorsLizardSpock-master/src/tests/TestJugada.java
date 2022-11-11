/**
 * 
 */
package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Modelo.Jugada;
import Modelo.Jugador;
import Modelo.OpcionesJugada;
import Modelo.TiposJugador;

/**
 * @author Oriol
 *
 */
class TestJugada {

	/**
	 * Test method for {@link Modelo.Jugada#Jugada(Modelo.Jugador, Modelo.OpcionesJugada)}.
	 */
	@Test
	void testJugadaJugadorOpcionesJugada() {
		Jugada j = new Jugada(new Jugador(),OpcionesJugada.ROCK);
		Jugada g = new Jugada();
		g.setJugada_Seleccionada(OpcionesJugada.ROCK);
		g.setJugador(new Jugador());
		assert j != null && j == g;
	}

}
