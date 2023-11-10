/*
 * Interfaz Fecha
 */
package modelo;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Di Qi
 */
public interface Fecha {
    
    public final int DIA = Calendar.DAY_OF_MONTH;
    public final int MES = Calendar.MONTH;
    public final int ANYO = Calendar.YEAR;
    
    public boolean cumpleMes();
    public boolean cumpleAnyo();
}
