package p1tqs;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class pedra_guanya_tisora {

	@Test
	void test() {
		Game g = new Game();
		g.addplayer();
		g.addplayer();
		g.getplayer(0).setMove(2);
		g.getplayer(1).setMove(3);
		g.CalculateRound();
		assertTrue(g.calculateRound != 1);
		
	}

}
