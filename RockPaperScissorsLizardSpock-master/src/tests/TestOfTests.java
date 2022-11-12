package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestOfTests {

	@Test
	void test() {
		TestJugada t1 = new TestJugada();
		TestJugador t2 = new TestJugador();
		TestLogica t3 = new TestLogica();
		TestPartida t4 = new TestPartida();
		TestRonda t5 = new TestRonda();
		TestServicioJugadaBOT t6 = new TestServicioJugadaBOT();
		TestServicioPartida t7 = new TestServicioPartida();
		TestServicioRonda t8 = new TestServicioRonda();
		TestVista t9 = new TestVista();
		t1.testJugadaJugadorOpcionesJugada();
		t2.run();
		t3.Run();
		t4.run();
		t5.Run();
		t6.run();
		t7.Run();
		t8.Run();
		t9.testRun();
	}

}
