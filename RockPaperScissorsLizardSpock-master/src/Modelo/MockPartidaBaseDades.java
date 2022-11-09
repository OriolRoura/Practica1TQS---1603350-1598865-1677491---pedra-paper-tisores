package Modelo;



import java.util.ArrayList;


public class MockPartidaBaseDades implements PartidaBaseDades {

	@Override
	public void guardarPartida(Partida p) {

		System.out.println("s'ha guardat tot correctament");
		
		
	}

	@Override
	public Partida carregarPartida() {
		Partida p = new Partida();
		p.setIdPartida("carregaT");
		p.setAlMejorDe(3);
		p.setJugador1(new Jugador("susan",TiposJugador.PERSONA));
		p.setJugador2(new Jugador("manolo",TiposJugador.PERSONA));
		p.setTipo(TiposPartida.JvJ);
		ServicioPartida sp = new ServicioPartida();
		ServicioRonda sr = new ServicioRonda();
		Ronda r = new Ronda(0);
		Jugada j1 = new Jugada();
		j1.setJugador(p.getJugador1());
		j1.setJugada_Seleccionada(OpcionesJugada.PAPER);
		Jugada j2 = new Jugada();
		j2.setJugador(p.getJugador2());
		j2.setJugada_Seleccionada(OpcionesJugada.SCISSORS);
		r.setJugada_Jugador2(j2);
		r.setJugada_Jugador1(j1);
		p.agregarRonda(r);
		sr.evaluarGanador(r);
		sp.evaluarGanador(p);
				

		Ronda y = new Ronda();
		r.setNumeroRonda(2);
		Jugada j3 = new Jugada(p.getJugador1(),OpcionesJugada.ROCK);
		Jugada j4= new Jugada();
		j2.setJugador(p.getJugador2());
		j2.setJugada_Seleccionada(OpcionesJugada.SCISSORS);
		r.setJugada_Jugador2(j2);
		r.setJugada_Jugador1(j1);
		p.agregarRonda(r);
		sr.evaluarGanador(r);
	    sp.evaluarGanador(p);
		return p;
				
	}

}

