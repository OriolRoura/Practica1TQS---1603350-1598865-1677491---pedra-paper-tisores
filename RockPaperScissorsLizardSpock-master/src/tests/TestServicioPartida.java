/**
 * 
 */
package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import Modelo.Jugada;
import Modelo.Jugador;
import Modelo.OpcionesJugada;
import Modelo.Partida;
import Modelo.Ronda;
import Modelo.ServicioPartida;
import Modelo.ServicioRonda;
import Modelo.TiposJugador;
import Modelo.TiposPartida;

/**
 * @author Oriol
 *
 */
class TestServicioPartida {

	
	Partida p;
	ServicioPartida sp;
	ServicioRonda sr; 
	int[] p1 = {0,0,1,1,2,3,3,3,4,4,4,5,5,5,6,7,7,8,8,8,8,9,9,10,10,10}; 
	int[] p2 = {0,1,1,2,2,2,2,3,3,4,5,5,5,6,6,6,7,7,7,8,9,9,10,10,10,11};
	int count;
	
	void Run() {
		SetUp();
		testEvaluarGanador();
		tearDown();
	}
	
	void SetUp(){
		Partida p = new Partida();
		p.setIdPartida("test");
		p.setAlMejorDe(11);
		p.setJugador1(new Jugador("susan",TiposJugador.PERSONA));
		p.setJugador2(new Jugador("manolo",TiposJugador.PERSONA));
		p.setTipo(TiposPartida.JvJ);
		ServicioPartida sp = new ServicioPartida();
		ServicioRonda sr = new ServicioRonda();
		ArrayList<Ronda> Rondas = new ArrayList();
		count = 0;
	}
	/**
	 * Test method for {@link Modelo.ServicioPartida#evaluarGanador(Modelo.Partida)}.
	 */

	@Test
	void testEvaluarGanador() {	
		
		for(int i=0;i<5;i++) {
			for(int n = 0;n<(5);n++) {
				Ronda r = new Ronda(count);
				Jugada j1 = new Jugada();
				j1.setJugador(p.getJugador1());
				j1.setJugada_Seleccionada(selectPar(i));
				Jugada j2 = new Jugada();
				j2.setJugador(p.getJugador2());
				j2.setJugada_Seleccionada(selectPar(n));
				r.setJugada_Jugador2(j2);
				r.setJugada_Jugador1(j1);
				p.agregarRonda(r);
				sr.evaluarGanador(r);
				Partida g = sp.evaluarGanador(p);
				assert g.getScorej1() == p1[count] : String.format("j1 treu el valor [%i] que o es el valor [%i]. Cilce [%i]", g.getScorej1(),p1[count],count);
				assert g.getScorej2() == p2[count] : String.format("j2 treu el valor [%i] que o es el valor [%i]. Cicle [%i]", g.getScorej2(),p2[count],count);
				count++;
				
			}
		}
		Ronda r = new Ronda();
		r.setNumeroRonda(count);
		Jugada j1 = new Jugada(p.getJugador1(),OpcionesJugada.SCISSORS);
		Jugada j2 = new Jugada();
		j2.setJugador(p.getJugador2());
		j2.setJugada_Seleccionada(OpcionesJugada.ROCK);
		
		r.setJugada_Jugador2(j2);
		r.setJugada_Jugador1(j1);
		p.agregarRonda(r);
		sr.evaluarGanador(r);
		Partida g = sp.evaluarGanador(p);
		assert g.getGanador() == p.getJugador2() : "No ha gaunyat el jugador correcte";
		
	}
	void tearDown() {
		p = null;
		sp = null;
		sr = null; 
		p1 = null; 
		p2 = null;
		count = 0;
		System.gc();
	}
	
	
	public OpcionesJugada selectPar(int i){
		switch(i){
		case 0:
			return OpcionesJugada.ROCK;
		case 1:
			return OpcionesJugada.PAPER;
		case 2:
			return OpcionesJugada.SCISSORS;
		case 3:
			return OpcionesJugada.SPOCK;
		case 4:
			return OpcionesJugada.LIZARD;
		}
		
		return null;
	}


}
