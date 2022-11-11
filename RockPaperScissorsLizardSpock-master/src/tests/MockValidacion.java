package tests;

import MVC.Vista.*;
import Modelo.OpcionesJugada;
import Modelo.PartidaBaseDades;
import Modelo.TiposPartida;
import java.util.Scanner;
public class MockValidacion implements Validacion{
    private Scanner in = new Scanner(System.in); 
    int contadorIn=0;
    int contadorInt = 3;
    int contadorString =4;
    int contadorJugada=0;
    public TiposPartida inTipo(){
        TiposPartida tipo=null;                
        int entrada = 0;
        boolean valido = false;
        do {
            entrada = contadorIn;
            valido = true;               
            if(entrada<5 && entrada>0){                   
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
            contadorIn++;
            if(contadorIn == 5) {
            	contadorIn ++;
            }else if(contadorIn==7) {
            		contadorIn = 0;
            }
                
        }while (!valido);       
        return tipo;
    }
    
    public int inInt(){

        return contadorInt;
    }

    
    public String inNombre(){
    	contadorString++;
    	if(contadorString == 5) {
    		contadorString=0;
    	}
    	switch(contadorString){
        case 0:
        	return (String)"Carmen";
        case 1:
        	return (String)"Martina";
        case 2:
        	return (String)"Jose";
        case 3:
        	return (String)"Pere";
        default:
        	return (String)"Montoya";
        	
    	}
    	
    }
    
    public OpcionesJugada inJugada(){
        OpcionesJugada opcion =null;

		switch(contadorJugada){
            case 1:
                opcion=OpcionesJugada.ROCK;
                break;
            case 2:
                opcion=OpcionesJugada.PAPER;
                break;
            case 3:
                opcion=OpcionesJugada.SCISSORS;
                break;  
            case 4:
                opcion=OpcionesJugada.LIZARD;
                break;  
            case 5:
                opcion=OpcionesJugada.SPOCK;
                break;    
        }
		contadorJugada++;
		if(contadorJugada ==6) {
			contadorJugada = 0;
		}
        return opcion;
    }
    
    private void mostrarError(String formato){
        System.out.println("Error de Formato.. "+ "Ingrese un valor con formato: " + formato + "\n" );
    }
}