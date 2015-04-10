/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bolsa;

/**
 *
 * @author Ignacio
 */
public class DatoValor {
    //Atributos Iniciales
    private String fecha;
    private double apertura;
    private double cierre;
    private double maximo;
    private double minimo;
    private double variacion;
    private double porVariacion;
    private long   volumen;
    
    //Atributos Calculados
    private double pivotPoint;
    private double r1;
    private double s1;
    private double r2;
    private double s2;
    
    public DatoValor(String fecha, double apertura, double cierre, double maximo, double minimo){
        this.fecha    = fecha;
        this.apertura = apertura;
        this.cierre   = cierre;
        this.maximo   = maximo;
        this.minimo   = minimo;
        
        //Calculamos el Resto de Valores
        calculaRestoValores();
    }
    
    public DatoValor(String fecha, double apertura, double cierre, double maximo, double minimo, double variacion, double porVariacion, long volumen){
        this.fecha        = fecha;
        this.apertura     = apertura;
        this.cierre       = cierre;
        this.maximo       = maximo;
        this.minimo       = minimo;
        this.variacion    = variacion;
        this.porVariacion = porVariacion;
        this.volumen      = volumen;
        
        //Calculamos el Resto de Valores
        calculaRestoValores();
    }

    public DatoValor(String fecha, double apertura, double cierre, double maximo, double minimo, double variacion, double porVariacion, long volumen, double pivotPoint, double r1, double s1, double r2, double s2){
        this.fecha        = fecha;
        this.apertura     = apertura;
        this.cierre       = cierre;
        this.maximo       = maximo;
        this.minimo       = minimo;
        this.variacion    = variacion;
        this.porVariacion = porVariacion;
        this.volumen      = volumen;
        this.pivotPoint   = pivotPoint;
        this.r1           = r1;
        this.s1           = s1;
        this.r2           = r2;
        this.s2           = s2;
    }
    
    //Calcula el Resto de Campos
    private void calculaRestoValores()
    {        
        this.pivotPoint = (getCierre() + getMaximo() + getMinimo()) / 3;
        this.r1         = (getPivotPoint() * 2) - getMinimo();
        this.s1         = (getPivotPoint() * 2) - getMaximo();
        this.r2         = (getPivotPoint() - getS1()) + getR1();
        this.s1         = (getPivotPoint() - getR1()) + getS1();
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
     * @return the cierre
     */
    public double getCierre() {
        return cierre;
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
     * @return the variacion
     */
    public double getVariacion() {
        return variacion;
    }

    /**
     * @return the porVariacion
     */
    public double getPorVariacion() {
        return porVariacion;
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
