package p1tqs;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class victoria_total {

	@Test
	void test() {
		Game g = new Game();
		g.addPlayer("Marc");
		g.addPlayer("Oriol");
		g.settornsvictoria();
		assertTrue(g.getjugadors(0).getvictories() > g.gettornsvictoria());
		assertTrue(g.getjugadors(1).getvictories() > g.gettornsvictoria());
	}

}
