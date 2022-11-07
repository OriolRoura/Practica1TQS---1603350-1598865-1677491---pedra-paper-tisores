package Modelo;



import java.util.ArrayList;
import testOfTests;


public class MockPartidaBaseDades implements PartidaBaseDades {

	@Override
	public void guardarPartida(Partida p) {

		System.out.println("s'ha guardat tot correctament");
		
		
	}

	@Override
	public Partida carregarPartida() {
		testOfTests t =new testOfTests();
		Partida p = new Partida();
		p.setIdPartida("carregaT");
		p.setAlMejorDe(11);
		p.setJugador1(new Jugador("susan",TiposJugador.PERSONA));
		p.setJugador2(new Jugador("manolo",TiposJugador.PERSONA));
		p.setTipo(TiposPartida.JvJ);
		ServicioPartida sp = new ServicioPartida();
		ServicioRonda sr = new ServicioRonda();
		ArrayList<Ronda> Rondas = new ArrayList();
		int[] p1 = {0,0,1,1,2,3,3,3,4,4,4,5,5,5,6,7,7,8,8,8,8,9,9,10,10,11}; 
		int[] p2 = {0,1,1,2,2,2,2,3,3,4,5,5,5,6,6,6,7,7,7,8,9,9,10,10,10,10};
		int count = 0;
		for(int i=0;i<5;i++) {
			for(int n = 0;n<(5);n++) {
				Ronda r = new Ronda(count);
				Jugada j1 = new Jugada();
				j1.setJugador(p.getJugador1());
				j1.setJugada_Seleccionada(t.selectPar(i));
				Jugada j2 = new Jugada();
				j2.setJugador(p.getJugador2());
				j2.setJugada_Seleccionada(t.selectPar(n));
				r.setJugada_Jugador2(j2);
				r.setJugada_Jugador1(j1);
				p.agregarRonda(r);
				sr.evaluarGanador(r);
				Partida g = sp.evaluarGanador(p);
				count++;
				
			}
		}
		Ronda r = new Ronda();
		r.setNumeroRonda(count);
		Jugada j1 = new Jugada(p.getJugador1(),OpcionesJugada.ROCK);
		Jugada j2 = new Jugada();
		j2.setJugador(p.getJugador2());
		j2.setJugada_Seleccionada(OpcionesJugada.SCISSORS);

		r.setJugada_Jugador2(j2);
		r.setJugada_Jugador1(j1);
		p.agregarRonda(r);
		sr.evaluarGanador(r);
		assert r.getGanadorRonda() == p.getJugador1() ;
		Partida g = sp.evaluarGanador(p);
		assert g.getGanador() == p.getJugador2() : "No ha gaunyat el jugador correcte";
		
	}

}



