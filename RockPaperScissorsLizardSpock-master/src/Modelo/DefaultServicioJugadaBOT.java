package Modelo;


public class DefaultServicioJugadaBOT implements ServicioJugadaBOT{
    public Jugada jugar(Jugada j){
        int indiceRandom=(int)( Math.random()*(OpcionesJugada.values().length-1) );
        j.setJugada_Seleccionada(OpcionesJugada.values()[indiceRandom]);
        
        return j;
    }
}
