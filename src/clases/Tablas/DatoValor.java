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
public class DatoValor {
    
    //Constantes
    private final String COD_VALOR = "COD_VALOR";
    private final String FECHA     = "FECHA";
    private final String APERTURA  = "APERTURA";
    private final String MAXIMO    = "MAXIMO";
    private final String MINIMO    = "MINIMO";
    private final String CIERRE    = "CIERRE";
    private final String VOLUMEN   = "VOLUMEN";
    
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
            this.cierre   = rs.getDouble(MAXIMO);
            this.maximo   = rs.getDouble(MINIMO);
            this.minimo   = rs.getDouble(CIERRE);
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
        this.cierre   = cierre;
        this.maximo   = maximo;
        this.minimo   = minimo;
        this.volumen  = volumen;
        
        //Calculamos el Resto de Valores
        calculaRestoValores();
    }
    
    //Cargamos los Datos Manualmente con todos los datos
    public DatoValor(String codValor, String fecha, double apertura, double maximo, double minimo, double cierre, long volumen, double pivotPoint, double r1, double s1, double r2, double s2){
        this.codValor   = codValor;
        this.fecha      = fecha;
        this.apertura   = apertura;
        this.cierre     = cierre;
        this.maximo     = maximo;
        this.minimo     = minimo;
        this.volumen    = volumen;
        this.pivotPoint = pivotPoint;
        this.r1         = r1;
        this.s1         = s1;
        this.r2         = r2;
        this.s2         = s2;
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
