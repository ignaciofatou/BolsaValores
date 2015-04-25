/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases.Tablas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Ignacio
 */
public class Valores {
    //Constantes
    private final String QUERY_VALORES = "SELECT COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION FROM VALORES WHERE COD_CAT = ? ORDER BY COD_VALOR ASC";

    //Atributos
    private ArrayList<Valor> valores = new ArrayList();
    private String categoria;

    public Valores(Connection con, String categoria){
        //Inicializamos el Atributo Categoria
        this.categoria = categoria;

        try{
            //Ejecutamos la Query Filtando por Codigo de Categoria
            PreparedStatement cmd = con.prepareStatement(QUERY_VALORES);
            cmd.setString(1, categoria);
            ResultSet rs = cmd.executeQuery();

            //Recorremos todos los Datos de Entrada
            while(rs.next()){
                //Nuevo Campo de Valor
                Valor nuevoValor = new Valor(rs);
                
                //Añadimos nuevo campo a la lista
                valores.add(nuevoValor);
                
                //Traza
                System.out.println(nuevoValor.toString());
            }            
        }catch(Exception ex){
            System.out.println("Error Recuperando los Valores");
        }
    }

    /**
     * @return the valores
     */
    public ArrayList<Valor> getValores() {
        return valores;
    }

    /**
     * @return the categoria
     */
    public String getCategoria() {
        return categoria;
    }
}
