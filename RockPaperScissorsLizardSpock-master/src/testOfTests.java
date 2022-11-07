import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Modelo.OpcionesJugada;

class testOfTests {

	@Test
	void test() {
		testSumarPunts t1 = new testSumarPunts();
		testJugador t2 = new testJugador();
		t1.testEvaluarGanador();
		t2.test();
		LogicaTest lT = new LogicaTest();
		lT.testLogica();
		testPartida t3 = new testPartida();
		t3.PartidaTest();
		testServicioJugadaBOT t4 = new testServicioJugadaBOT();
		t4.ServicioJugadaBOTtest();
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




