package MVC.Vista;

import java.util.Scanner;

import Modelo.OpcionesJugada;
import Modelo.TiposPartida;

public interface Validacion {
    public TiposPartida inTipo();
    public int inInt();
    public String inNombre();
    
    public OpcionesJugada inJugada();
   
    private void mostrarError(String formato){
        System.out.println("Error de Formato.. "+ "Ingrese un valor con formato: " + formato + "\n" );
    }
}
