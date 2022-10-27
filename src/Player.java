import java.util.Scanner;

public class Player {
	String nom;
	int tornsVictoria;
	Tirada tirada;
	
	
	Player(String n) {
		nom = n;
		tornsVictoria = 0;
		tirada = null;
	}
	String getNom() {
		return null;
	}
	int getTornsVictoria() {
		return 0;
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
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();
		int num = Integer.parseInt(line);
		tirada.setMov(num);
	}
	
}
