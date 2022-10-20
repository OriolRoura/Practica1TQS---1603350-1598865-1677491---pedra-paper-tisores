package p1tqs;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class empat {

	@Test
	void test() {
		Game g = new Game();
		g.addplayer();
		g.addplayer();
		g.getplayer(0).setMove(1);
		g.getplayer(1).setMove(1);
		g.CalculateRound();
		assertTrue(g.calculateRound != -1);
		
	}

}
