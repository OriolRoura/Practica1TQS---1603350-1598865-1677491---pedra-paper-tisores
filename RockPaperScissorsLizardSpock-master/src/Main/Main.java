/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import MVC.Controlador.Controlador;
import Modelo.Partida;

/**
 *
 * @author eddyf
 */
public class Main {
    public static void main(String[] args) {

        Controlador controlador = new Controlador();
        controlador.controlar();
    
    }
}