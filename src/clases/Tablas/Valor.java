/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases.Tablas;

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

    //Constructor Simple
    public Valor(String codValor, String codCategoria, int numDecimales, String descripcion) {
        this.codValor     = codValor;
        this.codCategoria = codCategoria;
        this.numDecimales = numDecimales;
        this.descripcion  = descripcion;
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
