/**
 * 
 */
package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

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
		String data = "1\n";
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		assert (v.inTipo() == TiposPartida.JvJ); 
		data = "2\n";
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		assert (v.inTipo() ==  TiposPartida.JvB);
		data = "3\n";
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		assert (v.inTipo() == TiposPartida.BvB);
		data = "4\n";
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		assert (v.inTipo() == TiposPartida.C);
	}

	/**
	 * Test method for {@link MVC.Vista.DefaultValidacion#inInt()}.
	 */
	@Test
	void testInInt() {
		String data = "1 2 3\n";
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		assertEquals( v.inInt(),3);
		
	}

	/**
	 * Test method for {@link MVC.Vista.DefaultValidacion#inNombre()}.
	 */
	@Test
	void testInNombre() {
		String data = "Antonio";
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		String an = "Antonio";
		assert (v.inNombre().equals(an) );
		
	}

	/**
	 * Test method for {@link MVC.Vista.DefaultValidacion#inJugada()}.
	 */
	@Test
	void testInJugada() {
		String data = "R \n ";
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		
		assert ( v.inJugada() == OpcionesJugada.ROCK);

		data = "P \n ";
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		assert ( v.inJugada() == OpcionesJugada.PAPER);
		
		data = "S \n ";
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		assert ( v.inJugada() == OpcionesJugada.SCISSORS);
		
		data = "L \n ";
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		assert ( v.inJugada() == OpcionesJugada.LIZARD);
		
		data = "V \n ";
		System.setIn(new ByteArrayInputStream(data.getBytes()));
		assert ( v.inJugada() == OpcionesJugada.SPOCK);
	}

	@AfterEach
	void tearDown() {
		v = null;
	}
	
}
