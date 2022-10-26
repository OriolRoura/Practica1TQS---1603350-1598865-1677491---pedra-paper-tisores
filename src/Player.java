

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
		//esperar tirada
		tirada.setMov(/*resultat de la tirada*/);
	}
	
}
