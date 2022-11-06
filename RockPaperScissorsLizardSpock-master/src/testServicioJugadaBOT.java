import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Modelo.ServicioJugadaBOT;
import Modelo.Jugada;
import Modelo.OpcionesJugada;

class testServicioJugadaBOT {

	@Test
	void ServicioJugadaBOTtest() {
		ServicioJugadaBOT s1 = new ServicioJugadaBOT();
		Jugada j1 = new Jugada();
		j1 = s1.jugar(j1);
		
		assert (j1.getJugada_Seleccionada()) == (OpcionesJugada.ROCK) : "no es del tipos correcte";
	}
		

}
