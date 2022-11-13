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
	
	Controlador con;
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
		
		asignarJugadores();
		iniciarJuego();
		
	}
	

	void SetUp(){
		con = new Controlador();
		PartidaBaseDades bd = new MockPartidaBaseDades();
		p1 = new Partida();
		p2 = new Partida();
		p3 = new Partida();
		p4 = new Partida();
		p1.setIdPartida("test1");
		p2.setIdPartida("test2");
		p3.setIdPartida("test3");
		p4.setIdPartida("test3");
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
		
	}
<<<<<<< Updated upstream
	

=======
	 @Test
>>>>>>> Stashed changes
    public void asignarJugadores(){  
    	p1.setTipo(TiposPartida.JvJ);  
        //case JvJ:
        jvj.registrarJugador(1);
        jvj.registrarJugador(2);
        assert p1.getJugador1() != null && p1.getJugador2() != null : "s'haurien d'assignar be";
            
    	p1.setTipo(TiposPartida.JvB);  
        //case JvJ:
        jvj.registrarJugador(1);
        p1.setJugador2( new Jugador("BuenardoBOT",TiposJugador.BOT));
    	assert p1.getJugador1() != null && p1.getJugador2() != null : "s'haurien d'assignar be";
    	p1.setTipo(TiposPartida.BvB);  
        //case JvJ:
        p1.setJugador1( new Jugador("BuenardoBOT1",TiposJugador.BOT));
        p1.setJugador2( new Jugador("BuenardoBOT2",TiposJugador.BOT));
    	assert p1.getJugador1() != null && p1.getJugador2() != null : "s'haurien d'assignar be";
    }
    
    
    public void iniciarJuego(){
    	con.setVista(jvj);
    	con.iniciarJuego();
    	
    	con.setVista(jvb);
    	con.iniciarJuego();
    	
    	con.setVista(bvb);
    	con.iniciarJuego();
    }
    
    /*public void iniciarJuego2(){
    	PartidaBaseDades partidaBaseDades = new MockPartidaBaseDades();
        ServicioPartida sp = new ServicioPartida();
        ServicioRonda sr = new ServicioRonda();
        boolean guardar = false;
        int i=0;
        do{
            System.out.println("Partida al mejor de :"+partida.getAlMejorDe());
            realizarRonda(i);
            sr.evaluarGanador(partida.getRondas().get(i));
            guardar = vista.mostrarGanadorRonda(i);
            sp.evaluarGanador(partida);
            i++;
            if(guardar) {
            	partidaBaseDades.guardarPartida(partida);	
            }
        }while(partida.getGanador()==null);
        	
        vista.mostrarGanadorPartida();
    }}/**/



}
