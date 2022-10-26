package p1tqs;


import static org.junit.Assert.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class empat {

	@Test
	void test() {
		 Game g = new Game()
		 g.addPlayer("pepo");
		 g.addPlayer("joana");
		 g.getPlayer(0).setMove(1);
		 g.getPlayer(1).setMove(1);
		 assertTrue(g.calculateRound != -1);
		 
		 
	}

}
