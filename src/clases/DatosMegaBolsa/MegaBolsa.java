/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases.DatosMegaBolsa;

import clases.Tablas.DatoValor;
import clases.Tablas.PatronesCampos;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

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
    //Recupera los Datos de la Web megabolsa.com y los Inserta en la Base de Datos
    public void setDatosToBBDD(java.sql.Connection con, String fecha){
        //Retorna los Datos de los Valores Para un Dia
        DatoDiaValores datoDiaValores = new DatoDiaValores();
        DatoValor      datoValor;
        
        //URL desde la que vamos a Obtener la Informacion
        String direccionInformacion = direccionWEB + fecha + extensionWEB;
        System.out.println("Tratamos de Acceder a: "+direccionInformacion);
        
        //Variables Para leer la URL
        URL accesoURL;
        String lineaLeida;

        try
        {
            //Accedemos a la URL
            accesoURL = new URL(direccionInformacion);
            BufferedReader buffer = new BufferedReader(new InputStreamReader(accesoURL.openStream())); 

            //Recorremos el Fichero de la URL hasta el Final
            while ((lineaLeida = buffer.readLine()) != null){
                //Por Cada Linea Creamos un Nuevo Dato Valor
                datoValor = new DatoValor(patronesCampos, lineaLeida);                
                
                //Añadimos el Nuevo Dato del Valor al ArrayList
                datoDiaValores.setNuevoValor(datoValor);
            }
            //Cerramos el Buffer
            buffer.close();
            System.out.println("Fin de: "+direccionInformacion);

        }catch (Exception e){
            System.out.println("Error al Acceder al Fichero: " + e.getMessage());
        }
        //Insertamos los Datos de los Valores en BBDD
        datoDiaValores.insertaDatoValoresBBDD(con);
    }
}
