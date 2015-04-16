/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.ArrayList;

/**
 *
 * @author Ignacio
 */
public class Valor {
    
    private String nombreValor;
    private String categoria;
    private DatoValor valorActual;            
    private ArrayList<DatoValor> historicos = new ArrayList();
    
    public Valor(String nombre){
        this.nombreValor = nombre;
    }
    public Valor(String nombre, String categoria){
        this.nombreValor = nombre;
        this.categoria   = categoria;
    }
}
