import static org.junit.jupiter.api.Assertions.*;

import MVC.Vista.DefaultVista;
import org.junit.jupiter.api.Test;

import MVC.Controlador.Controlador;
import MVC.Vista.Vista;
import Modelo.Partida;
import tests.MockVista;

//TODO all
class testController {
	Controlador c;
	@Test
	void testControlador() {
		Controlador c = new Controlador();
		assert (c.getPartida() == new Partida() && c.getVista() == new DefaultVista(c.getPartida()) );
		
		c.setVista(new MockVista(p));
	}

	@Test
	void testControlar() {
		c.controlar();
	}

	@Test
	void testAsignarJugadores() {
		fail("Not yet implemented");
	}

	@Test
	void testIniciarJuego() {
		fail("Not yet implemented");
	}

	@Test
	void testRealizarRonda() {
		fail("Not yet implemented");
	}

}
