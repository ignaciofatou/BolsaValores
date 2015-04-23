/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases.Tablas;

import clases.DatosMegaBolsa.CampoLinea;
import clases.DatosMegaBolsa.CamposLinea;
import clases.Fecha;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;

/**
 *
 * @author Ignacio
 */
public class DatoValor {
    
    //Constantes
    private final String COD_VALOR = "COD_VALOR";
    private final String FECHA     = "FECHA";
    private final String APERTURA  = "APERTURA";
    private final String MAXIMO    = "MAXIMO";
    private final String MINIMO    = "MINIMO";
    private final String CIERRE    = "CIERRE";
    private final String VOLUMEN   = "VOLUMEN";
    
    //Constante para SQL
    private final String QUERY_INSERT_DATOS = "INSERT INTO DATOS_VALORES (COD_VALOR, FECHA, APERTURA, MAXIMO, MINIMO, CIERRE, VOLUMEN) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private final String QUERY_SELECT_DATOS = "SELECT COUNT(1) FROM DATOS_VALORES WHERE COD_VALOR = ? AND FECHA = ?";
    
    //Atributos Iniciales
    private String codValor;
    private String fecha;
    private double apertura;
    private double maximo;
    private double minimo;
    private double cierre;
    private long   volumen;
    
    //Atributos Calculados
    private double pivotPoint;
    private double r1;
    private double s1;
    private double r2;
    private double s2;
    
    //Cargamos los Datos de BBDD
    public DatoValor(java.sql.ResultSet rs){
        try{
            this.codValor = rs.getString(COD_VALOR);
            this.fecha    = rs.getString(FECHA);
            this.apertura = rs.getDouble(APERTURA);            
            this.maximo   = rs.getDouble(MAXIMO);
            this.minimo   = rs.getDouble(MINIMO);
            this.cierre   = rs.getDouble(CIERRE);
            this.volumen  = rs.getLong(VOLUMEN);
            
            //Calculamos el Resto de Valores
            calculaRestoValores();

        }catch(java.sql.SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    //Cargamos los Datos Manualmente con los datos basicos
    public DatoValor(String codValor, String fecha, double apertura, double maximo, double minimo, double cierre, long volumen){
        this.codValor = codValor;
        this.fecha    = fecha;
        this.apertura = apertura;        
        this.maximo   = maximo;
        this.minimo   = minimo;
        this.cierre   = cierre;
        this.volumen  = volumen;
        
        //Calculamos el Resto de Valores
        calculaRestoValores();
    }
    
    //Cargamos los Datos Manualmente con todos los datos
    public DatoValor(String codValor, String fecha, double apertura, double maximo, double minimo, double cierre, long volumen, double pivotPoint, double r1, double s1, double r2, double s2){
        this.codValor   = codValor;
        this.fecha      = fecha;
        this.apertura   = apertura;        
        this.maximo     = maximo;
        this.minimo     = minimo;
        this.cierre     = cierre;
        this.volumen    = volumen;
        this.pivotPoint = pivotPoint;
        this.r1         = r1;
        this.s1         = s1;
        this.r2         = r2;
        this.s2         = s2;
    }
    
    //Construye a Partir de una Linea y del Patron
    public DatoValor(PatronesCampos patronesCampos, String linea)
    {
        //A partir de la Linea guardamos los Datos en un ArrayList de Campos
        CamposLinea camposLinea = new CamposLinea(linea, patronesCampos.getSeparador());

        //Recorremos el ArrayList de Patrones
        for(PatronCampo patronCampo:patronesCampos.getPatronesCampos()){
            
            //Recuperamos el Campo especificado en la Posicion del Patron
            int posicion = patronCampo.getOrden();
            CampoLinea campoLinea = camposLinea.getCamposLinea().get(posicion - 1);
            String contenido = campoLinea.getContenido();
            
            switch(patronCampo.getCodValor()){
                case "COD_VALOR":
                    this.codValor = contenido;
                    break;
                case "FECHA":
                    this.fecha = contenido;
                    break;
                case "APERTURA":
                    this.apertura = Double.valueOf(contenido);
                    break;
                case "MAXIMO":
                    this.maximo = Double.valueOf(contenido);
                    break;
                case "MINIMO":
                    this.minimo = Double.valueOf(contenido);
                    break;
                case "CIERRE":
                    this.cierre = Double.valueOf(contenido);
                    break;
                case "VOLUMEN":
                    this.volumen = Long.valueOf(contenido);
                    break;
            }
        }
    }
    
    public void insertaDatoValorBBDD(Connection con){
        try{
            PreparedStatement cmd = con.prepareStatement(QUERY_INSERT_DATOS);
            cmd.setString(1, this.codValor);
            cmd.setDate(1, Fecha.getFechaDate(this.fecha));
            cmd.setDouble(3, this.apertura);
            cmd.setDouble(4, this.maximo);
            cmd.setDouble(5, this.minimo);
            cmd.setDouble(6, this.cierre);
            cmd.setLong(7, this.volumen);
            cmd.executeUpdate();

        }catch(Exception ex){
            System.out.println("Error Recuperando Datos de los Patrones");
        }
    }
    
    public Date getFecha(String fecha){
        Date auxFecha = new Date();
        
        return auxFecha;
    }
    
    private double Redondear(Double PE_Numero, int Decimales)
    {
        double Factor = Math.pow(10, Decimales);
        return (Math.round(PE_Numero * Factor) / Factor);
    }
    
    
    //Calcula el Resto de Campos
    private void calculaRestoValores()
    {        
        this.pivotPoint = (getCierre() + getMaximo() + getMinimo()) / 3;
        this.r1         = (getPivotPoint() * 2) - getMinimo();
        this.s1         = (getPivotPoint() * 2) - getMaximo();
        this.r2         = (getPivotPoint() - getS1()) + getR1();
        this.s2         = (getPivotPoint() - getR1()) + getS1();
    }
    
    @Override
    public String toString(){
        return COD_VALOR + ": " + this.codValor + ", " + FECHA + ": " + this.fecha + ", " + APERTURA + ": " + this.apertura + ", " + MAXIMO + ": " + this.maximo + ", " + MINIMO + ": " + this.minimo + ", " + CIERRE + ": " + this.cierre  + ", " + VOLUMEN + ": " + this.volumen;
    }

    /**
     * @return the codValor
     */
    public String getCodValor() {
        return codValor;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @return the apertura
     */
    public double getApertura() {
        return apertura;
    }

    /**
     * @return the maximo
     */
    public double getMaximo() {
        return maximo;
    }

    /**
     * @return the minimo
     */
    public double getMinimo() {
        return minimo;
    }

    /**
     * @return the cierre
     */
    public double getCierre() {
        return cierre;
    }

    /**
     * @return the volumen
     */
    public long getVolumen() {
        return volumen;
    }

    /**
     * @return the pivotPoint
     */
    public double getPivotPoint() {
        return pivotPoint;
    }

    /**
     * @return the r1
     */
    public double getR1() {
        return r1;
    }

    /**
     * @return the s1
     */
    public double getS1() {
        return s1;
    }

    /**
     * @return the r2
     */
    public double getR2() {
        return r2;
    }

    /**
     * @return the s2
     */
    public double getS2() {
        return s2;
    }
}
