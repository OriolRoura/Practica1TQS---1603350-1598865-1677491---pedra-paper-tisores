import java.util.Random;
public class IA extends Player{
	IA() {
		
		super("IA");
	}
	void jugada() {
		Random random = new Random();
        // generate random number from 0 to 3
        int number = random.nextInt(4);
		tirada.setMov(number);
	}

}
