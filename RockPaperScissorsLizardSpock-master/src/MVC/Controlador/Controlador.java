package MVC.Controlador;
import tests.MockPartidaBaseDades;
import MVC.Vista.*;
import Modelo.*;

public class Controlador {
    private Vista vista;
    private Partida partida;
  
    
    public Controlador(){
        partida = new Partida();
        Validacion validacion = new DefaultValidacion();
        ServicioJugadaBOT sb = new DefaultServicioJugadaBOT();
        vista = new DefaultVista(partida, validacion, sb);       
    }

    public void setVista(Vista v) {
    	vista = v;
    }
    public void setPartida(Partida p) {
    	partida = p;
    }
    public Partida getPartida() {
    	return partida;
    }
    public Vista getVista() {
    	return vista;
    }
    
    public void controlar(){
        vista.mostrarIngreso();
        asignarJugadores();
        vista.establecerPuntos(); 
        iniciarJuego();
    }
    
    public void asignarJugadores(){        
        switch (partida.getTipo()) { //fer un mock per a testegar
            case JvJ:
                vista.registrarJugador(1); //també aqui
                vista.registrarJugador(2); //i aqui
                break;
            case JvB:
                vista.registrarJugador(1);
                partida.setJugador2( new Jugador("BuenardoBOT",TiposJugador.BOT));
                break;   
            case BvB:
                partida.setJugador1( new Jugador("DayanBOT",TiposJugador.BOT));
                partida.setJugador2( new Jugador("BuenardoBOT",TiposJugador.BOT));    
                break;
            case C: 
                PartidaBaseDades partidaBaseDades = new MockPartidaBaseDades();
                Partida p = partidaBaseDades.carregarPartida();
                partida = p;
        }
    }
    
    public void iniciarJuego(){
    	PartidaBaseDades partidaBaseDades = new MockPartidaBaseDades();
        ServicioPartida sp = new ServicioPartida();
        ServicioRonda sr = new ServicioRonda();
        boolean guardar = false;
        int i=0;
        do{
        	guardar = false;
            System.out.println("Partida al mejor de :"+partida.getAlMejorDe());
            realizarRonda(i);
            sr.evaluarGanador(partida.getRondas().get(i));
            guardar = vista.mostrarGanadorRonda(i); // TODO automatocament decidir si guardar o no(s'ha de fer els 2)
            sp.evaluarGanador(partida);
            i++;
            if(guardar) {
            	partidaBaseDades.guardarPartida(partida);	
            }
        }while(partida.getGanador()==null);
        	
        vista.mostrarGanadorPartida();
    }
    
    private void realizarRonda(int r){
        Ronda ronda = new Ronda(r+1);
        System.out.println("Ronda N°"+(r+1)+":");
        ronda.setJugada_Jugador1(vista.realizarJugada(1));   // En el MockVista estem indicant una jugada ja manualment com a MOCK         
        ronda.setJugada_Jugador2(vista.realizarJugada(2));   // Igual
        partida.agregarRonda(ronda);
        vista.mostrarJugadas(r);
    }
    
}