/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bolsa;

import clases.BaseDeDatos;
import clases.DatosMegaBolsa.MegaBolsa;
import clases.Fecha;
import clases.Tablas.Categoria;
import clases.Tablas.Categorias;
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
        //DatosValores   datosValores = new DatosValores(bd.getConexion());
        //Valores        valores      = new Valores(bd.getConexion());
        
        //PatronesCampos patronesCampos, String direccionWEB, String extensionWEB){
        Categoria categoria1 = categorias.getCategorias().get(0);
        Categoria categoria2 = categorias.getCategorias().get(1);

        MegaBolsa megaBolsa1 = new MegaBolsa(patrones, categoria1);
        MegaBolsa megaBolsa2 = new MegaBolsa(patrones, categoria2);
        
        System.out.println("Fecha: " + Fecha.getFechaHora("yyMMdd"));
        
        
        //megaBolsa.setDatosToBBDD(bd.getConexion(), "150410");
        megaBolsa1.updateDatosBBDD(bd.getConexion(), 300);
        megaBolsa2.updateDatosBBDD(bd.getConexion(), 300);
        
        //Cerramos la Base de Datos
        bd.cerrar();
    }
    
}
