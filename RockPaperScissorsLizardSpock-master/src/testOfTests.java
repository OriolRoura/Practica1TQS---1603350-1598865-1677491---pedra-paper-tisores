import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class testOfTests {

	@Test
	void test() {
		testSumarPunts t1 = new testSumarPunts();
		testJugador t2 = new testJugador();
		t1.testEvaluarGanador();
		t2.test();
		LogicaTest lT = new LogicaTest();
		lT.testLogica();
	}

}




