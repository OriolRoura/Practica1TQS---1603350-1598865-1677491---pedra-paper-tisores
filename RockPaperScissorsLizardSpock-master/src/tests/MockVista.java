package tests;
import MVC.Vista.DefaultValidacion;
import MVC.Vista.Validacion;
import MVC.Vista.Vista;
import Modelo.Jugada;
import Modelo.Jugador;
import Modelo.OpcionesJugada;
import Modelo.Partida;
import Modelo.ServicioJugadaBOT;
import Modelo.TiposJugador;
//TODO segurament caldra un mock
public class MockVista implements Vista {
    private Partida partida;

    public Vista(Partida partida){
        this.partida=partida;
    }

    public void mostrarIngreso(){
        //TODO passar Validación al controlador per a fer un mock
        DefaultValidacion validacion = new DefaultValidacion();
        System.out.println("Ingrese Modo de Juego: ");
        System.out.println("[1] Jugador vs Jugador.");
        System.out.println("[2] Jugador vs BOT.");
        System.out.println("[3] BOT vs BOT.");
        System.out.println("[4] Cargarpartida.");
        System.out.println("[5] Salir.");
        partida.setTipo(validacion.inTipo());      //falta excepcio per valors
    }

    public void registrarJugador(int j){
        DefaultValidacion validacion = new DefaultValidacion();
        System.out.println("Ingrese el Nombre del Jugador N° 0"+j+":");
        switch(j){
            case 1:
                partida.setJugador1(new Jugador(validacion.inNombre(),TiposJugador.PERSONA));
                break;
            case 2:
                partida.setJugador2(new Jugador(validacion.inNombre(),TiposJugador.PERSONA));
                break;
        }
    }


    public void establecerPuntos(){
        DefaultValidacion validacion = new DefaultValidacion();
        System.out.println("Ingrese Puntos necesarios para ganar: ");
        partida.setAlMejorDe(validacion.inInt());
    }

    public Jugada realizarJugada(int j){
        Jugada jugada = new Jugada();
        DefaultValidacion validacion = new DefaultValidacion();
        switch (partida.getTipo()) {
            case JvJ:
                switch(j){
                    case 1:
                        System.out.println(partida.getJugador1().getNombreJugador()+" ,realice su jugada: ");
                        break;
                    case 2:
                        System.out.println(partida.getJugador2().getNombreJugador()+" ,realice su jugada: ");
                        break;
                }
                mostrarIngresoJugada();
                jugada.setJugada_Seleccionada(validacion.inJugada());
                break;
            case JvB:
                switch(j){
                    case 1:
                        System.out.println(partida.getJugador1().getNombreJugador()+" ,realice su jugada: ");
                        mostrarIngresoJugada();
                        jugada.setJugada_Seleccionada(validacion.inJugada());
                        break;
                    case 2:
                        ServicioJugadaBOT sb = new ServicioJugadaBOT();
                        System.out.println(partida.getJugador2().getNombreJugador()+" ,realizo su jugada: ");
                        jugada = sb.jugar(jugada);
                        break;
                }
                break;
            case BvB:
                switch(j){
                    case 1:
                        ServicioJugadaBOT sb = new ServicioJugadaBOT();
                        System.out.println(partida.getJugador1().getNombreJugador()+" ,realice su jugada: ");
                        jugada = sb.jugar(jugada);
                        break;

                    case 2:
                        ServicioJugadaBOT sb2 = new ServicioJugadaBOT();
                        System.out.println(partida.getJugador2().getNombreJugador()+" ,realizo su jugada: ");
                        jugada = sb2.jugar(jugada);
                        break;
                }
                break;
            default:
                throw new AssertionError();
        }

        switch(j){
            case 1:
                jugada.setJugador(partida.getJugador1());
                break;
            case 2:
                jugada.setJugador(partida.getJugador2());
                break;
        }

        return jugada;
    }


    public void mostrarJugadas(int r){
        System.out.println(partida.getJugador1().getNombreJugador()+" ha jugado "+formatoJugada(partida.getRondas().get(r).getJugada_Jugador1().getJugada_Seleccionada()));
        System.out.println(partida.getJugador2().getNombreJugador()+" ha jugado "+formatoJugada(partida.getRondas().get(r).getJugada_Jugador2().getJugada_Seleccionada()));
        //System.out.println(partida.getRondas().size());
    }

    public boolean mostrarGanadorRonda(int i){
        DefaultValidacion validacion = new DefaultValidacion();
        if(partida.getRondas().get(i).getGanadorRonda()!=null){
            System.out.println("El ganador de esta ronda es: "+partida.getRondas().get(i).getGanadorRonda().getNombreJugador());
        }
        else{
            System.out.println("Ronda empatada.");
        }
        System.out.println("voleu guardar partida? 1 per confirmar");
        if(validacion.inInt() == 1) {
            return true;
        }else {
            return false;
        }
    }

    public void mostrarGanadorPartida(){
        System.out.println("El ganador de la partida es: "+partida.getGanador().getNombreJugador());
    }

    private void mostrarIngresoJugada(){
        System.out.println("[R] Piedra");
        System.out.println("[P] Papel");
        System.out.println("[S] Tijera");
        System.out.println("[L] Lagarto");
        System.out.println("[V] Spock");
    }

    private String formatoJugada(OpcionesJugada opcion){
        String retorno="";
        switch(opcion){
            case ROCK:
                retorno="Piedra";
                break;
            case PAPER:
                retorno="Papel";
                break;
            case SCISSORS:
                retorno="Tijera";
                break;
            case LIZARD:
                retorno="Lagarto";
                break;
            case SPOCK:
                retorno="Spock";
                break;
        }
        return retorno;
    }
}

