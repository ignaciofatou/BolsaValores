/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases.Secundarias;

import clases.Tablas.DatoValor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ignacio
 */
public class DatosValor {
    //Constantes
    private final String QUERY_DATOS_VALOR_DATOS = "SELECT COD_VALOR, FECHA, APERTURA, MAXIMO, MINIMO, CIERRE, VOLUMEN FROM DATOS_VALORES WHERE COD_VALOR = ? ORDER BY FECHA DESC";
    private final String COD_VALOR               = "COD_VALOR";
            
    //Atributos
    private List<DatoValor> datosValor = new ArrayList();
    private String codValor;
    
    //Atributos de BBDD
    Connection conexion;

    public DatosValor(Connection con, String codValor){
        
        //Hacemos copia de la Conexion
        conexion = con;
        
        //Inicializamos el Atributo Codigo Valor
        this.codValor = codValor;
        
        try{
            //Ejecutamos la Query Filtando por Codigo de Valor
            PreparedStatement cmd = conexion.prepareStatement(QUERY_DATOS_VALOR_DATOS);
            cmd.setString(1, codValor);
            ResultSet rs = cmd.executeQuery();
            
            //Recorremos todos los Datos de Entrada
            while(rs.next()){
                //Nuevo Campo de Dato Valor
                DatoValor nuevoDatoValor = new DatoValor(rs);
                
                //Añadimos nuevo campo a la lista
                datosValor.add(nuevoDatoValor);
                
                //Traza
                //System.out.println(nuevoDatoValor.toString());
            }            
        }catch(Exception ex){
            System.out.println("Error Recuperando los Datos del Valor: " + this.codValor);
        }
    }

    @Override
    public String toString(){
        return COD_VALOR + ": " + this.codValor + ", NUM_REG: " + this.datosValor.size();
    }

    /**
     * @return the datosValor
     */
    public List<DatoValor> getDatosValor() {
        return datosValor;
    }

    /**
     * @return the codValor
     */
    public String getCodValor() {
        return codValor;
    }
}
