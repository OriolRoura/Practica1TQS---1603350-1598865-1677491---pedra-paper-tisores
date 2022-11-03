import java.util.*;


public class Tirada {
	List<Integer> moviment = new ArrayList<>();
	int rang;
	Player jugador;
	Tirada(int ra,Player jug){
		rang = ra;
		jugador =jug;
		
	}
	void setMov(int i) {
		if(i<= rang) {
			moviment.add(i);
		}
		else {
			System.out.println("tria una jugada bàlid");
			jugador.jugada();
		}
	}
	int getMov(int i) {
		return moviment.get(i);
	}
	int getLast() {
		return moviment.lastIndexOf(moviment);
	}
}
