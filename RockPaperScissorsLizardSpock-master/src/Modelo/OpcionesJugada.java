package Modelo;
		//TODO falta test
public enum OpcionesJugada {
    ROCK('R'),
    PAPER('P'),
    SCISSORS('S'),
    LIZARD('L'),
    SPOCK('V');
    private char caracter;
    //TODO testejar
    OpcionesJugada(char c){
        this.caracter=c;
    }

    public char getCaracter() {
        return caracter;
    }
    
}
