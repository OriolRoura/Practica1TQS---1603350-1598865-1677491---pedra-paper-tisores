package Modelo;

public class Logica {

    public Jugada analizar(Jugada jugada_Jugador1, Jugada jugada_Jugador2) {
        switch (jugada_Jugador1.getJugada_Seleccionada()) {
            case ROCK:
                switch (jugada_Jugador2.getJugada_Seleccionada()) {
                    case ROCK:
                        return null;
                    case PAPER:
                        return jugada_Jugador2;
                    case SCISSORS:
                        return jugada_Jugador1;
                    case LIZARD:
                        return jugada_Jugador1; 
                    case SPOCK:
                        return jugada_Jugador2; 
                }

            case PAPER:
                switch (jugada_Jugador2.getJugada_Seleccionada()) {
                    case ROCK:
                        return jugada_Jugador1;
                    case PAPER:
                        return null;
                    case SCISSORS:
                        return jugada_Jugador2;
                    case LIZARD:
                        return jugada_Jugador2; 
                    case SPOCK:
                        return jugada_Jugador1;
                        	
                }


            case SCISSORS:
                switch (jugada_Jugador2.getJugada_Seleccionada()) {
                    case ROCK:
                        return jugada_Jugador2;
                    case PAPER:
                        return jugada_Jugador1;
                    case SCISSORS:
                        return null;
                    case LIZARD:
                        return jugada_Jugador1; 
                    case SPOCK:
                        return jugada_Jugador2;
                }
            

            
            case LIZARD:
                switch (jugada_Jugador2.getJugada_Seleccionada()) {
                    case ROCK:
                        return jugada_Jugador2;
                    case PAPER:
                        return jugada_Jugador1;
                    case SCISSORS:
                        return jugada_Jugador2;
                    case LIZARD:
                        return null; 
                    case SPOCK:
                        return jugada_Jugador1;
                }
            
            case SPOCK:
                switch (jugada_Jugador2.getJugada_Seleccionada()) {
                    case ROCK:
                        return jugada_Jugador1;
                    case PAPER:
                        return jugada_Jugador2;
                    case SCISSORS:
                        return jugada_Jugador1;
                    case LIZARD:
                        return jugada_Jugador2; 
                    case SPOCK:
                        return null;
                    	
                }

                
        }
        System.out.println("ESTO NO TIENE QUE PASAR - REVISA LOGICA.ANALIZAR()");
        return null;
    };
    
}
