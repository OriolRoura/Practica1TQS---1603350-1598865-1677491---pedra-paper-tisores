import java.lang.String;
import java.util.*;

public class Game {
	List<Player> jugadors; 
	int torns;
	int rondesPerVictoria;
	
	void setIa() {
		if(jugadors.size() < 2) {
			jugadors.add(new IA());
		}else {
			
		}
	}
	
	void setRondesPerVictoria(int rondes){
		rondesPerVictoria = rondes;
	}
	
	void addTorn() {
		torns++;
	}
	
	void addPlayer(String nom){
		if(jugadors.size() < 2) {
			if(jugadors.contains(new Player(nom)) || nom == "IA") {
				System.out.println("aquest nom ja ha estat elegit");
				System.out.printf("tria un altre");
				addPlayer(nom);
			}else {
				jugadors.add(new Player(nom));
			}
		}
	}
	
	int getTorns() {
		return torns;
	}
	
	int getRondesPerVictoria() {
		return rondesPerVictoria;
	}
	
	Player getJugador(int jug) {
		return jugadors.get(jug);
	}
	Player getJugador(String nom) {
		for(int i=0; i<=2;i++) {
			if(jugadors.get(i).getNom() == nom) {
				return jugadors.get(i);
			}
		}
		System.out.println("No hi ha jugadors amb aquest nom");
		return null;
	}
	
	Player setRoundWiner() {
		Player j1 = jugadors.get(0);
		int t1 = j1.tirada.getLast();
		Player j2 = jugadors.get(1);
		int t2 = j2.tirada.getLast();
		
		if(t2 == (t1+1) || t2 == (t1+3)) {
			j1.tornsVictoriaMes();
			System.out.println("la persona victoriosa en aquesta ronda és " + j1.getNom());
			return j1;
		}else{
			if(t2 == t1) {
				System.out.println("Hi ha hagut empat");
				return null;
			}else {
				j2.tornsVictoriaMes();
				System.out.println("la persona victoriosa en aquesta ronda és " + j1.getNom());
				return j2;
			}
		}
	}
	
	Player Win() {
		for ( Player p : jugadors) {
			if(p.haveWon(rondesPerVictoria)) {
				return p;
			}
		}
		return null;
	}
	void simpleGame() {
		//demanar jugador 1
		//preguntar per tipus de joc(contra IA o contra un altre jugador)
		//tirades
		//determinar victoria ronda
		//comprovar bictories totals
			//si no ha arribat repeti des de tirades
		//dir qui es el guanyador
		//fi
		//preguntar si bol registre
		//guardar a la BD (10 ultimes partides)
	}
	void bigGame() {
		
	}
	
}
