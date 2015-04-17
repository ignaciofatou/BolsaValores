/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases.Tablas;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Ignacio
 */
public class Valores {
    //Constantes
    private final String QUERY_VALORES = "SELECT COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION FROM VALORES ORDER BY COD_VALOR ASC";
            
    //Atributos
    private ArrayList<Valor> valores = new ArrayList();

    public Valores(Connection con){
        
        try{
            Statement cmd = con.createStatement();
            ResultSet rs = cmd.executeQuery(QUERY_VALORES);
            
            //Recorremos todos los Datos de Entrada
            while(rs.next()){
                //Nuevo Campo de Categoria
                Valor nuevoValor = new Valor(rs);
                
                //Añadimos nuevo campo a la lista
                valores.add(nuevoValor);
                
                //Traza
                System.out.println(nuevoValor.toString());
            }            
        }catch(Exception ex){
            System.out.println("Error Recuperando Datos de los Valores");
        }
    }

    /**
     * @return the valores
     */
    public ArrayList<Valor> getValores() {
        return valores;
    }
}
