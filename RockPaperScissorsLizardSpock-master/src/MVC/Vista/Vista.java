package MVC.Vista;

import Modelo.Jugada;
import Modelo.Jugador;
import Modelo.OpcionesJugada;
import Modelo.Partida;
import Modelo.ServicioJugadaBOT;
import Modelo.TiposJugador;
	//TODO segurament caldra un mock

public interface Vista {
    public Partida partida;
    public Vista(Partida partida){
        this.partida=partida;
    }
    
    public void mostrarIngreso();
    public void registrarJugador(int j);
    public void establecerPuntos();
    public Jugada realizarJugada(int j);
    public void mostrarJugadas(int r);
    public boolean mostrarGanadorRonda(int i);
    public void mostrarGanadorPartida();
    private void mostrarIngresoJugada(){
        System.out.println("[R] Piedra");
        System.out.println("[P] Papel");
        System.out.println("[S] Tijera");
        System.out.println("[L] Lagarto");
        System.out.println("[V] Spock");
    }
    private String formatoJugada(OpcionesJugada opcion);
}
