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
public class Categoria {
    
    //Constantes
    private final String COD_CAT      = "COD_CAT";
    private final String DESCRIPCION  = "DESCRIPCION";
    private final String URL          = "URL";
    private final String FORMATOFECHA = "FORMATOFECHA";
    private final String COMODIN      = "COMODIN";
    private final String EXTENSION    = "EXTENSION";
    
    //Atributos
    private String codCategoria;
    private String descripcion;
    private String urlDatosFichero;
    private String formFechaFichero;
    private String comodinFichero;
    private String extensionFichero;
    
    public Categoria(java.sql.ResultSet rs){
        try{
            this.codCategoria     = rs.getString(COD_CAT);
            this.descripcion      = rs.getString(DESCRIPCION);
            this.urlDatosFichero  = rs.getString(URL);
            this.formFechaFichero = rs.getString(FORMATOFECHA);
            this.comodinFichero   = rs.getString(COMODIN);
            this.extensionFichero = rs.getString(EXTENSION);
        }catch(java.sql.SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public Categoria(String codCategoria, String descripcion, String urlDatosFichero, String formFechaFichero, String comodinFichero, String extensionFichero){
        this.codCategoria     = codCategoria;
        this.descripcion      = descripcion;
        this.urlDatosFichero  = urlDatosFichero;
        this.formFechaFichero = formFechaFichero;
        this.comodinFichero   = comodinFichero;
        this.extensionFichero = extensionFichero;
    }
    
    @Override
    public String toString(){
        return COD_CAT + ": " + this.getCodCategoria() + ", " + DESCRIPCION + ": " + this.getDescripcion() + ", " + URL + ": " + this.getUrlDatosFichero() + ", " + FORMATOFECHA + ": " + this.getFormFechaFichero() + ", " + COMODIN + ": " + this.getComodinFichero() + ", " + EXTENSION + ": " + this.getExtensionFichero();
    }    

    /**
     * @return the codCategoria
     */
    public String getCodCategoria() {
        return codCategoria;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @return the urlDatosFichero
     */
    public String getUrlDatosFichero() {
        return urlDatosFichero;
    }

    /**
     * @return the formFechaFichero
     */
    public String getFormFechaFichero() {
        return formFechaFichero;
    }

    /**
     * @return the comodinFichero
     */
    public String getComodinFichero() {
        return comodinFichero;
    }

    /**
     * @return the extensionFichero
     */
    public String getExtensionFichero() {
        return extensionFichero;
    }
}
