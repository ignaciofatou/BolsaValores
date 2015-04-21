/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bolsa;

import clases.BaseDeDatos;
import clases.DatosMegaBolsa.MegaBolsa;
import clases.Tablas.Categoria;
import clases.Tablas.Categorias;
import clases.Tablas.DatosValores;
import clases.Tablas.PatronesCampos;
import clases.Tablas.Valores;

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
        MegaBolsa megaBolsa = new MegaBolsa(patrones, categoria1.getUrlDatosFichero(), categoria1.getExtensionFichero());
        megaBolsa.getDatos("150410");
        
        //Cerramos la Base de Datos
        bd.cerrar();
    }
    
}
