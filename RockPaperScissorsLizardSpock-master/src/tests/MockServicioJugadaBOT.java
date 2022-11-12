package tests;

import Modelo.Jugada;
import Modelo.OpcionesJugada;
import Modelo.ServicioJugadaBOT;

public class MockServicioJugadaBOT implements ServicioJugadaBOT{

	@Override
	public Jugada jugar(Jugada j) {
		j.setJugada_Seleccionada(OpcionesJugada.PAPER);
		return j;
	}

}
