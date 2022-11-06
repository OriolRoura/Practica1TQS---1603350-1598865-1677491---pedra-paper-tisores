import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import Modelo.Jugada;
import Modelo.Jugador;
import Modelo.OpcionesJugada;
import Modelo.Partida;
import Modelo.Ronda;
import Modelo.TiposJugador;
import Modelo.TiposPartida;
import Modelo.ServicioPartida;
import Modelo.ServicioRonda;

class testSumarPunts {

	@Test
	void testEvaluarGanador() {
		Partida p = new Partida();
		p.setIdPartida("test");
		p.setAlMejorDe(7);
		p.setJugador1(new Jugador("susan",TiposJugador.PERSONA));
		p.setJugador2(new Jugador("manolo",TiposJugador.PERSONA));
		p.setTipo(TiposPartida.JvJ);
		ServicioPartida sp = new ServicioPartida();
		ServicioRonda sr = new ServicioRonda();
		ArrayList<Ronda> Rondas = new ArrayList();
		int[] p1 = {0,0,1,1,2,2,2,3,3,3,3,4,4,4,4,4}; 
		int[] p2 = {0,1,1,2,2,2,3,3,4,4,5,5,5,6,6,7};
		int count = 0;
		for(int i=0;i<5;i++) {
			for(int n = 0;n<(5-i);n++) {
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
				assertTrue(g.getScorej1() != p1[count] || g.getScorej2() != p2[count]);
				count++;
			}
		}
		Ronda r = new Ronda(count);
		Jugada j1 = new Jugada();
		j1.setJugada_Seleccionada(OpcionesJugada.ROCK);
		Jugada j2 = new Jugada();
		j2.setJugada_Seleccionada(OpcionesJugada.PAPER);
		r.setJugada_Jugador2(j2);
		r.setJugada_Jugador1(j1);
		p.agregarRonda(r);
		sr.evaluarGanador(r);
		Partida g = sp.evaluarGanador(p);
		assertTrue(g.getGanador() != p.getJugador2());
	}
	OpcionesJugada selectPar(int i){
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
