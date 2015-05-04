/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases.Secundarias;

import clases.Tablas.Valor;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ignacio
 */
public class DatosValores {
            
    //Atributos
    private List<DatosValor> datosValores = new ArrayList();
    private Valores valores;
    private String  categoria;

    public DatosValores(Connection con, String categoria){
        //Inicializamos el Atributo Categoria
        this.categoria = categoria;

        valores = new Valores(con, categoria);

        for(Valor valor:valores.getValores()){
            //Nuevo Campo de Datos Valor
            DatosValor nuevoDatosValor = new DatosValor(con, valor.getCodValor());

            //Añadimos nuevo campo a la lista
            datosValores.add(nuevoDatosValor);

            //Traza
            //System.out.println(nuevoDatosValor.toString());
        }
    }

    /**
     * @return the datosValores
     */
    public List<DatosValor> getDatosValores() {
        return datosValores;
    }

    /**
     * @return the categoria
     */
    public String getCategoria() {
        return categoria;
    }
}
