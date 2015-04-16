/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Ignacio
 */
public class PatronDatosEntrada {
    
    //Constantes
    private final String QUERY_PATRON_DATOS = "SELECT COD_CAMPO, ORDEN, TIPO_DATO FROM PATRON_DATOS ORDER BY ORDEN ASC";
            
    //Atributos
    private ArrayList<PatronCampo> listaCampos = new ArrayList();

    public void recuperarPatronesBD(Connection con){
        
        try{
            Statement cmd = con.createStatement();
            ResultSet rs = cmd.executeQuery(QUERY_PATRON_DATOS);
            
            //Recorremos todos los Datos de Entrada
            while(rs.next()){
                //Nuevo Campo de Patron
                PatronCampo nuevoPatron = new PatronCampo(rs);
                
                //Añadimos nuevo campo a la lista
                getListaCampos().add(nuevoPatron);                
                System.out.println(nuevoPatron.toString());
            }            
        }catch(Exception ex){
            System.out.println("Error Recuperando Datos de los Patrones");
        }
    }

    /**
     * @return the listaCampos
     */
    public ArrayList<PatronCampo> getListaCampos() {
        return listaCampos;
    }
}
