/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases.DatosMegaBolsa;

import clases.Tablas.DatoValor;
import clases.Tablas.PatronesCampos;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 *
 * @author Ignacio
  * http://www.megabolsa.com/cierres/150410.txt
 */
public class MegaBolsa {
    
    private PatronesCampos patronesCampos;
    private String         direccionWEB;
    private String         extensionWEB;    
    
    public MegaBolsa(PatronesCampos patronesCampos, String direccionWEB, String extensionWEB){
        this.patronesCampos = patronesCampos;
        this.direccionWEB   = direccionWEB;
        this.extensionWEB   = extensionWEB;
    }
    
    public DatoDiaValores getDatos(String fecha){
        //Retorna los Datos de los Valores Para un Dia
        DatoDiaValores datoDiaValores = new DatoDiaValores();
        DatoValor      datoValor;
        
        //URL desde la que vamos a Obtener la Informacion
        String direccionInformacion = direccionWEB + fecha + extensionWEB;
        System.out.println("Tratamos de Acceder a: "+direccionInformacion);

        //Variables Para leer la URL
        FileReader r = null;
        BufferedReader buffer;
        String lineaLeida;

        try
        {
            r = new FileReader(direccionInformacion);
            buffer = new BufferedReader(r);

            //Despreciamos la Primera Linea de Cabecera
            buffer.readLine();

            //Recorremos el Fichero hasta el Final o hasta el Tope de Rango
            while ((lineaLeida = buffer.readLine()) != null){
                //Por Cada Linea Creamos un Nuevo Dato Valor
                datoValor = new DatoValor(patronesCampos, lineaLeida);                
                
                //Añadimos el Nuevo Valor al ArrayList
                datoDiaValores.setNuevoValor(datoValor);
            }
            System.out.println("Fin de: "+direccionInformacion);

        }catch (Exception e){
            System.out.println("Error al Acceder al Fichero: " + e.getMessage());
        }finally{
            try{
                if (r != null)
                    r.close();
            }catch (Exception e2){
                System.out.println("Error al Cerrar el Fichero: " + e2.getMessage());
            }
        }
        //Retornamos los Datos de los Valores para ese Dia
        return datoDiaValores;
    }
}
