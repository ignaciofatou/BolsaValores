/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases.Tablas;

import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author Ignacio
 */
public class DatosValores {
            
    //Atributos
    private ArrayList<DatosValor> datosValores = new ArrayList();
    Valores valores;

    public DatosValores(Connection con){
        valores = new Valores(con);
            
        for(Valor valor:valores.getValores()){
            //Nuevo Campo de Datos Valor
            DatosValor nuevoDatosValor = new DatosValor(con, valor);
            
            //Añadimos nuevo campo a la lista
            datosValores.add(nuevoDatosValor);
            System.out.println(nuevoDatosValor.toString());
        }
    }

    /**
     * @return the datosValores
     */
    public ArrayList<DatosValor> getDatosValores() {
        return datosValores;
    } 
}
