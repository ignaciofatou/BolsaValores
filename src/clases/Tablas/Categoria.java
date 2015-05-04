/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases.Tablas;

import clases.Secundarias.Valores;
import clases.DatosMegaBolsa.MegaBolsa;
import java.sql.Connection;
import java.util.List;

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

    //Se guardan los Valores de dicha Categoria
    private List<Valor> valores;

    //Se guardan los Datos de los Valores de dicha Categoria
    private MegaBolsa datosValores;

    //Atributo para guardar la Conexion
    private Connection con;


    //Constructor desde BBDD
    public Categoria(Connection con, java.sql.ResultSet rs){
        //Guardamos la Conexion
        this.con = con;
        
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

        //Cargamos los Valores de Dicha Categoria
        cargaTablaValores();
    }

    //Cargamos los Valores de Dicha Categoria
    private void cargaTablaValores(){
        Valores auxValores = new Valores(con, this.codCategoria);
        valores = auxValores.getValores();
    }

    //Actualiza los Datos de los Valores de la Web MegaBolsa
    public void actualizaDatosMegaBolsa(){

        //Obtenemos los Datos de los Valores de la Web de MegaBolsa
        datosValores = new MegaBolsa(con, urlDatosFichero, comodinFichero, extensionFichero, codCategoria);

        //Actualizamos los Datos de los Valores de la Web de MegaBolsa (Tarea en Paralelo)
        getDatosValores().start();
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

    /**
     * @return the datosValores
     */
    public MegaBolsa getDatosValores() {
        return datosValores;
    }

    /**
     * @return the valores
     */
    public List<Valor> getValores() {
        return valores;
    }
}
