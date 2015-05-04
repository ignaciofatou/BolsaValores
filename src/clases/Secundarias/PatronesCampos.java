/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases.Secundarias;

import clases.Tablas.PatronCampo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ignacio
 */
public class PatronesCampos {
    
    //Constantes
    private final String QUERY_PATRONES_DATOS = "SELECT COD_CAMPO, ORDEN, TIPO_DATO FROM PATRON_DATOS ORDER BY ORDEN ASC";
    private final String SEPARADOR            = ",";
    
    //Atributos
    private List<PatronCampo> patronesCampo = new ArrayList();

    public PatronesCampos(Connection con){
        
        try{
            Statement cmd = con.createStatement();
            ResultSet rs = cmd.executeQuery(QUERY_PATRONES_DATOS);

            //Recorremos todos los Datos de Entrada
            while(rs.next()){
                //Nuevo Campo de Patron
                PatronCampo nuevoPatron = new PatronCampo(rs);

                //Añadimos nuevo campo a la lista
                patronesCampo.add(nuevoPatron);

                //Traza
                //System.out.println(nuevoPatron.toString());
            }            
        }catch(Exception ex){
            System.out.println("Error Recuperando Datos de los Patrones");
        }
    }
    
    public String getSeparador(){
        return SEPARADOR;
    }

    /**
     * @return the listaCampos
     */
    public List<PatronCampo> getPatronesCampos() {
        return patronesCampo;
    }
}
