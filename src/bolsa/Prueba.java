/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bolsa;

import clases.BaseDeDatos;
import clases.Tablas.Categorias;
import clases.Tablas.DatosValores;
import clases.Tablas.PatronesCampos;

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
        PatronesCampos patrones     = new PatronesCampos(bd.getConexion());
        Categorias     categorias   = new Categorias(bd.getConexion());        
        DatosValores   datosValores = new DatosValores(bd.getConexion(), "ifc");
        
        //Cerramos la Base de Datos
        bd.cerrar();
    }
    
}
