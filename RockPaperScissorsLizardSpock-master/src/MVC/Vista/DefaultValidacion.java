package MVC.Vista;
import Modelo.OpcionesJugada;
import Modelo.TiposPartida;
import java.util.Scanner;


public class DefaultValidacion implements Validacion {
    private Scanner in = new Scanner(System.in); 
    public TiposPartida inTipo(){
        TiposPartida tipo=null;                
        int entrada = 0;
        boolean valido = false;
        in = new Scanner(System.in); 
        do {
                entrada = in.nextInt();
              
                if(entrada<5 && entrada>0){   
                    valido = true; 
                    switch(entrada){
                        case 1:
                            tipo=TiposPartida.JvJ;
                            break;
                        case 2:
                            tipo=TiposPartida.JvB;
                            break;
                        case 3:
                            tipo=TiposPartida.BvB;
                            break;
                        case 4:
                            tipo=TiposPartida.C;
                            break;
                        case 5:
                            System.exit(0);
                    }                  
                }
                else{
                    System.out.println("Valor de entrada fuera de rango.");
                    System.out.println("Ingrese uno nuevo:");
                }
        }while (!valido);       
        return tipo;
    }
    
    public int inInt(){
        int entero= 0;
        boolean valido = false;
        in = new Scanner(System.in); 
        do {
            entero = in.nextInt();
            if(entero > 2) {
                valido = true;
            }else {
               this.mostrarError("Entero mayor o igual a 3.");
            }
        }while (!valido);
        return entero;
    }
    
    public String inNombre(){
        String entrada = "";
        boolean valido = false;
        in = new Scanner(System.in); 
        do {
            
            String input = in.next();
            if (entrada.equals(input)){
                this.mostrarError("No nulo.");
            }else{
                entrada = input;
                valido = true;
            }
        }while (!valido);
        return entrada;
    }
    
    public OpcionesJugada inJugada(){
        OpcionesJugada opcion =null;
        char caracter = ' ';
        boolean valido = false;
        in = new Scanner(System.in);
        do {
            
            String entrada = in.next();
            if (entrada.length() != 1) {
                this.mostrarError("caracter");
            }           
            else if (entrada.charAt(0) != 'R' && entrada.charAt(0)!= 'P' && entrada.charAt(0) != 'S' && entrada.charAt(0) != 'L' && entrada.charAt(0) != 'V'){
                this.mostrarError("R o P o S o L o V");
            }           
            else {
                caracter = entrada.charAt(0);
                valido = true;
                switch(caracter){
                    case 'R':
                        opcion=OpcionesJugada.ROCK;
                        break;
                    case 'P':
                        opcion=OpcionesJugada.PAPER;
                        break;
                    case 'S':
                        opcion=OpcionesJugada.SCISSORS;
                        break;  
                    case 'L':
                        opcion=OpcionesJugada.LIZARD;
                        break;  
                    case 'V':
                        opcion=OpcionesJugada.SPOCK;
                        break;    
                }
            }                      
        } while (!valido);
        return opcion;
    }
    
    private void mostrarError(String formato){
        System.out.println("Error de Formato.. "+ "Ingrese un valor con formato: " + formato + "\n" );
    }
}
