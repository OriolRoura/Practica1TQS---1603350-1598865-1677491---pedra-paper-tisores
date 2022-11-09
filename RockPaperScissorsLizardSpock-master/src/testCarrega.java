import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import Modelo.MockPartidaBaseDades;
import Modelo.Partida;
import Modelo.PartidaBaseDades;
import Modelo.Ronda;
import Modelo.ServicioPartida;
import Modelo.ServicioRonda;

class testCarrega {

	@Test
	void test() {
		int[] p1 = {0,1}; 
		int[] p2 = {1,1};
		ServicioPartida sp = new ServicioPartida();
		ServicioRonda sr = new ServicioRonda();
		PartidaBaseDades bd = new MockPartidaBaseDades();
		Partida p = bd.carregarPartida();
		ArrayList<Ronda> rondas = p.getRondas();
		assert rondas.get(0).getGanadorRonda() == p.getJugador2() : "els jugadors no coincidaixen(1)";
		assert rondas.get(0).getGanadorRonda() == p.getJugador1() : "els jugadors no coincidaixen(2)";	
	}

}
