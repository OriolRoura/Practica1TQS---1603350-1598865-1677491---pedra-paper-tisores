import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Modelo.Jugador;
import Modelo.TiposJugador;

class testJugador {

	@Test
	void test() {
		Jugador play =new Jugador();
		play.setNombreJugador("susan");
		play.setTipo(TiposJugador.BOT);
		
		assert play.getTipo() == (TiposJugador.BOT) : "no es del tipos correcte";
		assert (play.getNombreJugador()) == ("susan") : "el nom no es correcte";
	}

}
