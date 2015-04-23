package clases;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Fecha {
    
    private static final String YYYYMMDD = "YMd";
    private static final String HH24MISS = "Hmmss";
    private static final String YYMMDD   = "yyMMdd";
    
    //Retorna la Fecha y Hora Actual YYYYMMDD_HH24MISS -> 2015320_215625
    public static String getFechaHora(){
        //Obtener la fecha y hora actual
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat formatoFechaPersonal;
        formatoFechaPersonal = new SimpleDateFormat(YYYYMMDD + "_" + HH24MISS);
        return formatoFechaPersonal.format(cal.getTime());
    }
    //Retorna la Fecha Actual YYYYMMDD -> 2015320
    public static String getFecha(){
        //Obtener la fecha y hora actual
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat formatoFechaPersonal;
        formatoFechaPersonal = new SimpleDateFormat(YYYYMMDD);
        return formatoFechaPersonal.format(cal.getTime());
    }
    //Retorna la Hora Actual HH24MISS -> 215625
    public static String getHora(){
        //Obtener la fecha y hora actual
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat formatoFechaPersonal;
        formatoFechaPersonal = new SimpleDateFormat(HH24MISS);
        return formatoFechaPersonal.format(cal.getTime());
    }
    //Retorna la Fecha/Hora en el Formato Especificado
    public static String getFechaHora(String formato){
        //Obtener la fecha y hora actual
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat formatoFechaPersonal;
        formatoFechaPersonal = new SimpleDateFormat(formato);
        return formatoFechaPersonal.format(cal.getTime());
    }
    //Retorna la Fecha de String a Date
    public static Date getFechaDate(String strFecha){
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat(YYMMDD);
        Date fecha = null;

        try {
            //Realizamos la Conversion
            fecha = formatoDelTexto.parse(strFecha);

        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        //Retornamos
        return fecha;
    }
}
