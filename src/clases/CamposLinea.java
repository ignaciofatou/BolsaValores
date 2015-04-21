/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.ArrayList;

/**
 *
 * @author Ignacio
 */
public class CamposLinea {
    //Atributos
    private ArrayList <CampoLinea> camposLinea;
    
    public CamposLinea(String linea, String separador){
        
        //Creamos el ArrayList de Campos para Almacenar cada Campo de la Linea
        camposLinea = new ArrayList();
        CampoLinea campoLinea;
        
        //Variables para Recorrer la Cadena
        int    posIndice   = 0;
        int    contCampos  = 0;
        int    posBusqueda = 0;
        String campo;
        
        //Recorre la Linea hasta el Final
        while ((posBusqueda + 1) < linea.length()){
            //Buscamos el Fin de la Posicion del Campo
            posBusqueda = linea.indexOf(separador, posIndice);

            //Recuperamos el Campo de la Linea
            campo = linea.substring(posIndice, posBusqueda);

            //Creamos un Nuevo Campo
            campoLinea = new CampoLinea(campo, ++contCampos);

            //Incluimos el Nuevo Campo en el ArrayList
            camposLinea.add(campoLinea);
            
            //Actualizamos la Posicion del Indice
            posIndice = posBusqueda;
        }
    }

    /**
     * @return the camposLinea
     */
    public ArrayList <CampoLinea> getCamposLinea() {
        return camposLinea;
    }
}
