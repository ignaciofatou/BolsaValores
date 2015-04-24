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
public class Categorias {
    //Constantes
    private final String QUERY_CATEGORIAS_DATOS = "SELECT COD_CAT, DESCRIPCION, URL, FORMATOFECHA, COMODIN, EXTENSION FROM CATEGORIAS";
            
    //Atributos
    private ArrayList<Categoria> categorias = new ArrayList();

    public Categorias(Connection con){
        
        try{
            Statement cmd = con.createStatement();
            ResultSet rs = cmd.executeQuery(QUERY_CATEGORIAS_DATOS);
            
            //Recorremos todos los Datos de Entrada
            while(rs.next()){
                //Nuevo Campo de Categoria
                Categoria nuevaCategoria = new Categoria(rs);
                
                //Añadimos nuevo campo a la lista
                categorias.add(nuevaCategoria);
                
                //Traza
                //System.out.println(nuevaCategoria.toString());
            }            
        }catch(Exception ex){
            System.out.println("Error Recuperando Datos de los Patrones");
        }
    }

    /**
     * @return the listaCampos
     */
    public ArrayList<Categoria> getCategorias() {
        return categorias;
    }
   
}
