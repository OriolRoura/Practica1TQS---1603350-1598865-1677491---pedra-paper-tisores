package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Modelo.DefaultServicioJugadaBOT;
import Modelo.Jugada;
import Modelo.OpcionesJugada;
import Modelo.ServicioJugadaBOT;
import org.junit.After;
import org.junit.Before;


class TestServicioJugadaBOT {
	ServicioJugadaBOT s1 ;
	
	
	void run() {
		startUp();
		testJugar();
		tearDown();
	}
	
	
	@BeforeEach
	void startUp() {
		s1 = new DefaultServicioJugadaBOT();
	}
	
	@Test
	void testJugar() {
		
		for(int i = 0;i< 50; i++) {
			Jugada j1 = new Jugada();
			j1 = s1.jugar(j1);
			assert ((j1.getJugada_Seleccionada()) == (OpcionesJugada.ROCK)|| (j1.getJugada_Seleccionada()) == (OpcionesJugada.PAPER)||(j1.getJugada_Seleccionada()) == (OpcionesJugada.SCISSORS)||(j1.getJugada_Seleccionada()) == (OpcionesJugada.LIZARD)||(j1.getJugada_Seleccionada()) == (OpcionesJugada.SPOCK)) : "no es del tipos correcte";
		}
	}
	
	@AfterEach
	void tearDown() {
		s1 = null;
		System.gc();
	}
}
