/**
 * 
 */
package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.After;
import org.junit.Before;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
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
class TestServicioRonda {
	Partida p;
	ServicioPartida sp;
	ServicioRonda sr; 
	
	
	void Run() {
		SetUp();
		testEvaluarGanador();
		tearDown();
	}
	
	/**
	 * Test method for {@link Modelo.ServicioRonda#evaluarGanador(Modelo.Ronda)}.
	 */
	@BeforeEach

	void SetUp() {
		p = new Partida();
		p.setIdPartida("test");
		p.setAlMejorDe(11);
		p.setJugador1(new Jugador("susan",TiposJugador.PERSONA));
		p.setJugador2(new Jugador("manolo",TiposJugador.PERSONA));
		p.setTipo(TiposPartida.JvJ);
		sp = new ServicioPartida();
		sr = new ServicioRonda();
		ArrayList<Ronda> rondas = new ArrayList();
		p.setRondas(rondas);

		int count = 0;
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
				count++;
			}
		}
		Ronda r = new Ronda();
		r.setNumeroRonda(count);
		Jugada j1 = new Jugada(p.getJugador1(),OpcionesJugada.ROCK);
		Jugada j2 = new Jugada();
		j2.setJugador(p.getJugador2());
		j2.setJugada_Seleccionada(OpcionesJugada.SCISSORS);
		
		r.setJugada_Jugador2(j2);
		r.setJugada_Jugador1(j1);
		p.agregarRonda(r);
		sr.evaluarGanador(r);
		sr.evaluarGanador(r);
		count = 0;
	}
	@Test
	void testEvaluarGanador() {
		Jugador jug1 = p.getJugador1();
		Jugador jug2 = p.getJugador2();
		Jugador[] victory = {null,jug2,jug1,jug2,jug1,jug1,null,jug2,jug1,jug2,jug2,jug1,null,jug2,jug1,jug1,jug2,jug1,null,jug2,jug2,jug1,jug2,jug1,null,jug1};
		
		ArrayList<Ronda> rondas = p.getRondas();
		for(int i=0;i< victory.length;i++) {
			assert rondas.get(i).getGanadorRonda() == victory[i] : String.format("no ha guanyate el que havia de guanyar en la ronda [%i]", i);
		}
	}
	@AfterEach
	void tearDown() {
		 p = null;
		 sp = null;
		 sr = null; 
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
