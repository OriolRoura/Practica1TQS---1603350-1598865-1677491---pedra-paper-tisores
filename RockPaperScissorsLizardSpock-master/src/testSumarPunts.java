

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.Test;

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
		testOfTests t =new testOfTests();
		Partida p = new Partida();
		p.setIdPartida("test");
		p.setAlMejorDe(11);
		p.setJugador1(new Jugador("susan",TiposJugador.PERSONA));
		p.setJugador2(new Jugador("manolo",TiposJugador.PERSONA));
		p.setTipo(TiposPartida.JvJ);
		ServicioPartida sp = new ServicioPartida();
		ServicioRonda sr = new ServicioRonda();
		ArrayList<Ronda> Rondas = new ArrayList();
		int[] p1 = {0,0,1,1,2,3,3,3,4,4,4,5,5,5,6,7,7,8,8,8,8,9,9,10,10,10}; 
		int[] p2 = {0,1,1,2,2,2,2,3,3,4,5,5,5,6,6,6,7,7,7,8,9,9,10,10,10,11};
		int count = 0;
		for(int i=0;i<5;i++) {
			for(int n = 0;n<(5);n++) {
				Ronda r = new Ronda(count);
				Jugada j1 = new Jugada();
				j1.setJugador(p.getJugador1());
				j1.setJugada_Seleccionada(t.selectPar(i));
				Jugada j2 = new Jugada();
				j2.setJugador(p.getJugador2());
				j2.setJugada_Seleccionada(t.selectPar(n));
				r.setJugada_Jugador2(j2);
				r.setJugada_Jugador1(j1);
				p.agregarRonda(r);
				sr.evaluarGanador(r);
				Partida g = sp.evaluarGanador(p);
				assert r.getNumeroRonda() == count;
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
		assert r.getGanadorRonda() == p.getJugador2() ;
		Partida g = sp.evaluarGanador(p);
		assert g.getGanador() == p.getJugador2() : "No ha gaunyat el jugador correcte";
		
	}

	
}
