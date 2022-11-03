import java.util.Scanner;

public class Player {
	String nom;
	int tornsVictoria;
	Tirada tirada;
	
	
	Player(String n, int rang ) {
		nom = n;
		tornsVictoria = 0;
		tirada = new Tirada(rang, this);
	}
	Player(String n) {
		nom = n;
		tornsVictoria = 0;
		tirada = new Tirada(3,this);
	}
	String getNom() {
		return nom;
	}
	int getTornsVictoria() {
		return tornsVictoria;
	}
	Tirada getTirada() {
		return null;
	}
	void setNom() {
		
	}
	void tornsVictoriaMes() {
		tornsVictoria++;
	}
	
	void jugada() {
		Scanner scanner = new Scanner(System.in); //no recordo que es
		String line = scanner.nextLine();
		int num = Integer.parseInt(line);
		tirada.setMov(num);
	}
	boolean haveWon(int perVic) {
		if(tornsVictoria == perVic) {
			return true;
		}else {
			return false;
		}
	}
	
}
