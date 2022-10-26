package p1tqs;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class test_IA {

	@Test
	void test() {
		Game g = new Game();
		g.setIA();
		while ( g.getTorns()<10000)
		{
			assertTrue(ia.getcontador() >= 4);	
		}
		
	}

}
