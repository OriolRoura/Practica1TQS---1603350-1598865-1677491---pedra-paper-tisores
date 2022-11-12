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
import org.junit.After;
import org.junit.Before;


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
		Jugador game = new Jugador();
		Jugada j = new Jugada(game, OpcionesJugada.ROCK);
		Jugada g = new Jugada();
		g.setJugada_Seleccionada(OpcionesJugada.ROCK);
		g.setJugador(game);
		assert j.getJugador() == g.getJugador() && j.getJugada_Seleccionada() == g.getJugada_Seleccionada();
	}
	

}
