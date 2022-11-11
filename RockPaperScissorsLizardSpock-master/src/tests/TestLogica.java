/**
 * 
 */
package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Modelo.Jugada;
import Modelo.Logica;
import Modelo.OpcionesJugada;

/**
 * @author Oriol
 *
 */
class TestLogica {
	
	Logica lt;
	Jugada isRock; 
	Jugada  isPaper; 
	Jugada isScissors;
	Jugada isLizard;
	Jugada isSpock;
	
	
	void Run() {
		SetUp();
		testAnalizar();
		tearDown();
	}
	
	void SetUp() {
		lt = new Logica();
		isRock = new Jugada(); 		isRock.setJugada_Seleccionada(OpcionesJugada.ROCK);
		isPaper = new Jugada();		isPaper.setJugada_Seleccionada(OpcionesJugada.PAPER);
		isScissors = new Jugada(); 	isScissors.setJugada_Seleccionada(OpcionesJugada.SCISSORS);
		isLizard = new Jugada();		isLizard.setJugada_Seleccionada(OpcionesJugada.LIZARD);
		isSpock = new Jugada(); 		isSpock.setJugada_Seleccionada(OpcionesJugada.SPOCK);
	}
	
	/**
	 * Test method for {@link Modelo.Logica#analizar(Modelo.Jugada, Modelo.Jugada)}.
	 */
	@Test
	void testAnalizar() {
		
		//OPCIONS TREIENT PEDRA
		Jugada rockWinsScissors = lt.analizar(isRock,isScissors);
		assertEquals(rockWinsScissors, isRock);
		Jugada rockWinsLizard = lt.analizar(isRock,isLizard);
		assertEquals(rockWinsLizard, isRock);
		Jugada rockLosePaper = lt.analizar(isRock,isPaper);
		assertEquals(rockLosePaper, isPaper);
		Jugada rockLoseSpock = lt.analizar(isRock,isSpock);
		assertEquals(rockLoseSpock, isSpock);
		Jugada rockvsRock = lt.analizar(isRock,isRock);
		assertEquals(rockvsRock, null);
		
		//OPCIONS TREIENT PAPER
		Jugada PaperLoseScissors = lt.analizar(isPaper,isScissors);
		assertEquals(PaperLoseScissors, isScissors);
		Jugada paperLoseLizard = lt.analizar(isPaper,isLizard);
		assertEquals(paperLoseLizard, isLizard);
		Jugada paperWinsRock = lt.analizar(isPaper,isRock);
		assertEquals(paperWinsRock, isPaper);
		Jugada paperWinsSpock = lt.analizar(isPaper,isSpock);
		assertEquals(paperWinsSpock, isPaper);
		Jugada paperVsPaper = lt.analizar(isPaper,isPaper);
		assertEquals(paperVsPaper, null);
		
		//OPCIONS TREIENT TISORES
		Jugada scissorsLoseRock = lt.analizar(isScissors,isRock);
		assertEquals(scissorsLoseRock, isRock);
		Jugada scissorsLoseSpock = lt.analizar(isScissors,isSpock);
		assertEquals(scissorsLoseSpock, isSpock);
		Jugada scissorsWinsPaper = lt.analizar(isScissors,isPaper);
		assertEquals(scissorsWinsPaper, isScissors);
		Jugada scissorsWinsLizard = lt.analizar(isScissors,isLizard);
		assertEquals(scissorsWinsLizard, isScissors);
		Jugada scissorsVsScissors = lt.analizar(isScissors, isScissors);
		assertEquals(scissorsVsScissors, null);
		
		//OPCIONS TREIENT SPOCK
		Jugada spockWinsScissors = lt.analizar(isSpock,isScissors);
		assertEquals(spockWinsScissors, isSpock);
		Jugada spockWinsRock = lt.analizar(isSpock,isRock);
		assertEquals(spockWinsRock, isSpock);
		Jugada spockLosePaper = lt.analizar(isSpock,isPaper);
		assertEquals(spockLosePaper, isPaper);
		Jugada spockLoseLizard = lt.analizar(isSpock,isLizard);
		assertEquals(spockLoseLizard, isLizard);
		Jugada spockVsSpock = lt.analizar(isSpock, isSpock);
		assertEquals(spockVsSpock, null);
		
		//OPCIONS TREIENT LIZARD
		Jugada lizardWinsSpock = lt.analizar(isLizard,isSpock);
		assertEquals(lizardWinsSpock, isLizard);
		Jugada lizardWinsPaper = lt.analizar(isLizard,isPaper);
		assertEquals(lizardWinsPaper, isLizard);
		Jugada lizardLoseRock = lt.analizar(isLizard,isRock);
		assertEquals(lizardLoseRock, isRock);
		Jugada LizardLoseScissors = lt.analizar(isLizard,isScissors);
		assertEquals(LizardLoseScissors, isScissors);
		Jugada lizardvsLizard = lt.analizar(isLizard, isLizard);
		assertEquals(lizardvsLizard, null);
	}

	void tearDown() {
		isRock = null; 
		isPaper = null; 
		isScissors = null;
		isLizard = null;
		isSpock = null;
		lt =null;	
	}
	
}
