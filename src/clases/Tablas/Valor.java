/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases.Tablas;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Ignacio
 */
public class Valor {

    //Constantes
    private final String COD_VALOR   = "COD_VALOR";
    private final String COD_CAT     = "COD_CAT";
    private final String DECIMALES   = "DECIMALES";
    private final String DESCRIPCION = "DESCRIPCION";
    private final int    DECIMAL_DEF = 3;
    
    //Constante para SQL
    private static final String QUERY_INSERT_VALOR   = "INSERT INTO VALORES (COD_VALOR, COD_CAT, DECIMALES, DESCRIPCION) VALUES (?, ?, ?, ?)";
    private static final String QUERY_SELECT_VALORES = "SELECT COUNT(1) FROM VALORES WHERE COD_VALOR = ?";

    //Atributos
    private String codValor;
    private String codCategoria;
    private int    numDecimales;
    private String descripcion;

    //Constructor que a partir del Result asigna el valor a los Atributos
    public Valor(java.sql.ResultSet rs){
        try{
            this.codValor     = rs.getString(COD_VALOR);
            this.codCategoria = rs.getString(COD_CAT);
            this.numDecimales = rs.getInt(DECIMALES);
            this.descripcion  = rs.getString(DESCRIPCION);
        }catch(java.sql.SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

    //Constructor Normal
    public Valor(String codValor, String codCategoria, int numDecimales, String descripcion) {
        this.codValor     = codValor;
        this.codCategoria = codCategoria;
        this.numDecimales = numDecimales;
        this.descripcion  = descripcion;
    }
    
    //Constructor Simplificado
    public Valor(String codValor, String codCategoria) {
        this.codValor     = codValor;
        this.codCategoria = codCategoria;
        this.numDecimales = DECIMAL_DEF;
        this.descripcion  = codValor;
    }
    
    //Inserccion en la Tabla de VALORES
    public boolean insertValorBBDD(java.sql.Connection con){
        
        //Si el Valor No Existe en BBDD -> Es Valido para Insertar
        if (!isValores(con, this.codValor)){
            try{
                PreparedStatement cmd = con.prepareStatement(QUERY_INSERT_VALOR);
                cmd.setString(1, this.codValor);
                cmd.setString(2, this.codCategoria);
                cmd.setInt(3, this.numDecimales);
                cmd.setString(4, this.descripcion);
                cmd.executeUpdate();

            }catch(Exception ex){
                System.out.println("Error al Insertar el Valor: " + this.codValor + " en la Tabla de VALORES");
                ex.printStackTrace();
                return false;
            }
            System.out.println("Insertado el Valor: " + this.codValor + " en la Tabla de VALORES");
        }        
        return true;
    }    

    //Comprueba que el Codigo de Valor Exista en la Tabla VALORES
    public static boolean isValores(java.sql.Connection con, String codValor){        
        try{
            PreparedStatement cmd = con.prepareStatement(QUERY_SELECT_VALORES);
            cmd.setString(1, codValor);
            java.sql.ResultSet rs = cmd.executeQuery();
            
            if (rs.next())
                return (rs.getInt(1) == 1);
            else
                return false;            

        }catch(Exception ex){
            return false;
        }
    }
    
    @Override
    public String toString(){
        return COD_VALOR + ": " + this.getCodValor() + ", " + COD_CAT + ": " + this.getCodCategoria() + ", " + DECIMALES + ": " + this.getNumDecimales() + ", " + DESCRIPCION + ": " + this.getDescripcion();
    }   

    /**
     * @return the codValor
     */
    public String getCodValor() {
        return codValor;
    }

    /**
     * @return the codCategoria
     */
    public String getCodCategoria() {
        return codCategoria;
    }

    /**
     * @return the numDecimales
     */
    public int getNumDecimales() {
        return numDecimales;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }    
}
