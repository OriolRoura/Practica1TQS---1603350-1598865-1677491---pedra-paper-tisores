package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.ModuleLayer.Controller;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import MVC.Controlador.Controlador;
import MVC.Vista.DefaultVista;
import MVC.Vista.Validacion;
import MVC.Vista.Vista;
import Modelo.Jugador;
import Modelo.Partida;
import Modelo.PartidaBaseDades;
import Modelo.ServicioJugadaBOT;
import Modelo.ServicioPartida;
import Modelo.ServicioRonda;
import Modelo.TiposJugador;
import Modelo.TiposPartida;

class TestController {
	
	Controlador con1;
	Controlador con2;
	Controlador con3;
	Controlador con4;
	Vista jvj;
	Vista jvb;
	Vista bvb;
	Vista c;
	Partida p1;
	Partida p2;
	Partida p3;
	Partida p4;
    ServicioPartida sp;
    ServicioRonda sr;
    ServicioJugadaBOT sb;
    Validacion v;
    
    
	@Test
	void testRun() {
		SetUp();
		
		testControlar();
		
	}
	

	void SetUp(){
		con1 = new Controlador();
		con2 = new Controlador();
		con3 = new Controlador();
		con4 = new Controlador();
		PartidaBaseDades bd = new MockPartidaBaseDades();
		p1 = new Partida();
		p2 = new Partida();
		p3 = new Partida();
		p4 = new Partida();
		p1.setIdPartida("test1");
		p2.setIdPartida("test2");
		p3.setIdPartida("test3");
		p4.setIdPartida("test4");
		p1.setAlMejorDe(2);
		p2.setAlMejorDe(2);
		p3.setAlMejorDe(2);
		p4.setAlMejorDe(2);
		p1.setRondas(new ArrayList());
		p2.setRondas(new ArrayList());
		p3.setRondas(new ArrayList());
		p4.setRondas(new ArrayList());
		sb = new MockServicioJugadaBOT();
		v = new MockValidacion();
		jvj = new MockVista(p1,v, sb);
		jvb = new MockVista(p2,v, sb);
		bvb = new MockVista(p3,v, sb);
		c = new MockVista(p4, v, sb);
		sp = new ServicioPartida();
		sr = new ServicioRonda();
    	con1.setPartida(p1);
    	con2.setPartida(p2);
    	con3.setPartida(p3);
    	con4.setPartida(p4);
    	p1.setTipo(TiposPartida.JvJ);  
    	p2.setTipo(TiposPartida.JvB);  
    	p3.setTipo(TiposPartida.BvB);  
    	p4.setTipo(TiposPartida.C); 
    	con1.setVista(jvj);
    	con2.setVista(jvb);
    	con3.setVista(bvb);
    	con4.setVista(c);
	}
	
	
    public void testControlar(){  

    	con1.controlar();
    	con2.controlar();
    	con3.controlar();
    	con4.controlar();;
    }
    

}
