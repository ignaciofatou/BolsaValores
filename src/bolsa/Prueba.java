/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bolsa;

import clases.BaseDeDatos;
import clases.PatronDatosEntrada;

/**
 *
 * @author Ignacio
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BaseDeDatos bd = new BaseDeDatos();
        PatronDatosEntrada patrones = new PatronDatosEntrada();
        patrones.recuperarPatronesBD(bd.getConexion());
        bd.cerrar();
    }
    
}
