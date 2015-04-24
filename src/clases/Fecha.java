package clases;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Fecha {
    
    //public static final String YYYYMMDD = "YMd";
    public static final String YYYYMMDD = "yyyyMMdd";
    public static final String HH24MISS = "Hmmss";
    public static final String YYMMDD   = "yyMMdd";    
    
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
    //Retorna la Fecha de String a Date (java.util.Date)
    public static java.util.Date getFechaDate(String strFecha){
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat(YYMMDD);
        java.util.Date fecha = null;

        try {
            //Realizamos la Conversion
            fecha = formatoDelTexto.parse(strFecha);

        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        //Retornamos
        return fecha;
    }
    //Retorna la Fecha de String a Date (java.util.Date)
    public static java.util.Date getFechaDate(String strFecha, String strFormato){
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat(strFormato);
        java.util.Date fecha = null;

        try {
            //Realizamos la Conversion
            fecha = formatoDelTexto.parse(strFecha);

        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        //Retornamos
        return fecha;
    }
    
    //Retorna la Fecha de String a Date (java.sql.Date)
    public static java.sql.Date getFechaSqlDate(String strFecha, String strFormato){
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat(strFormato);
        java.sql.Date sqlDate = null;

        try {
            //Realizamos la Conversion a Milisegundos
            long fecha = formatoDelTexto.parse(strFecha).getTime();
            //Convertimos Milisegundos a Fecha
            sqlDate = new java.sql.Date(fecha);

        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        //Retornamos
        return sqlDate;
    }
    
}
