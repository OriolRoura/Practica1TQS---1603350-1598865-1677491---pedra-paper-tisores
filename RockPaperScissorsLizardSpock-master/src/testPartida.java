import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import Modelo.Partida;
import Modelo.Ronda;
import Modelo.Jugador;
import Modelo.TiposJugador;
import Modelo.TiposPartida;

class testPartida {

	@Test
	void PartidaTest() {
		
		Partida p1 = new Partida();
		
		assert (p1.existeGanador()) == (false) : "no deberia existir ganador";
		
		Jugador j1 = new Jugador("Ramon",TiposJugador.PERSONA);
		p1.setGanador(j1);
		
		
		p1.setTipo(TiposPartida.JvJ);
		

		p1.setIdPartida("Id1");
		p1.getIdPartida();
		
		
		Ronda r1 = new Ronda();
		ArrayList<Ronda> Rondas = new ArrayList();
		Rondas.add(r1);
		p1.setRondas(Rondas);
		
		
		
		assert (p1.existeGanador()) == (true) : "deberia existir ganador";
		assert (p1.getTipo()) == (TiposPartida.JvJ) : "no es del tipos correcte";
		assert (p1.getIdPartida()) == ("Id1") : "Id no es correcto";
		assert (p1.getNroRonda()) == (2) : "No devuelve numero de rondas correctamente";
		
	}

}
