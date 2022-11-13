/**
 * 
 */
package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Rule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import MVC.Vista.DefaultValidacion;
import MVC.Vista.Validacion;
import Modelo.OpcionesJugada;
import Modelo.TiposPartida;

import static org.junit.Assert.*;


/**
 * @author Oriol
 *
 */
class TestValidacion {
	Validacion v;
	
	
	@Rule
	public final TextFromStandardInputStream systemInMock
	  = TextFromStandardInputStream.emptyStandardInputStream();
	
	
	void run() {
		startUp();
		
		testInTipo();
		testInInt();
		testInNombre();
		testInJugada();
		
		tearDown();
	}
	
	@BeforeEach
	void startUp(){
		 v = new DefaultValidacion();
	}
	
	/**
	 * Test method for {@link MVC.Vista.DefaultValidacion#inTipo()}.
	 */
	@Test
	void testInTipo() {

		systemInMock.provideLines("1","2","3","4");

		
		assert (v.inTipo() == TiposPartida.JvJ); 
		
		assert (v.inTipo() ==  TiposPartida.JvJ);
	
		assert (v.inTipo() == TiposPartida.JvJ);
		
		assert (v.inTipo() == TiposPartida.JvJ);
	}

	/**
	 * Test method for {@link MVC.Vista.DefaultValidacion#inInt()}.
	 */
	@Test
	void testInInt() {
		systemInMock.provideLines("2", "4");
		assertEquals( v.inInt(),4);
		
	}

	/**
	 * Test method for {@link MVC.Vista.DefaultValidacion#inNombre()}.
	 */
	@Test
	void testInNombre() {
		systemInMock.provideLines("","Antonio");
		assert (v.inNombre() == "Antonio");
		
	}

	/**
	 * Test method for {@link MVC.Vista.DefaultValidacion#inJugada()}.
	 */
	@Test
	void testInJugada() {
		systemInMock.provideLines("R","P","S","L","V");
		
		assert ( v.inJugada() == OpcionesJugada.ROCK);
		assert ( v.inJugada() == OpcionesJugada.PAPER);
		assert ( v.inJugada() == OpcionesJugada.SCISSORS);
		assert ( v.inJugada() == OpcionesJugada.LIZARD);
		assert ( v.inJugada() == OpcionesJugada.SPOCK);
	}

	@AfterEach
	void tearDown() {
		v = null;
	}
	
}
