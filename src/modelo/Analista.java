/*
 * Clase Analista
 */
package modelo;

import controlador.Funciones;
import java.util.GregorianCalendar;

/**
 *
 * @author Di Qi
 */
public class Analista extends Empleado implements Fecha {
    private double plusAnual;
    private String proyectoActual;

    public Analista(
            double plusAnual, 
            String proyectoActual,
            int numero, String nombre,
            double sueldo, 
            double sueldoMaximo,
            GregorianCalendar fechaAlta
    ) throws SueldoException {
        super(numero, nombre, sueldo, sueldoMaximo, fechaAlta);
        this.plusAnual = plusAnual;
        this.proyectoActual = proyectoActual;
    }
    
    public Analista(int numero) throws SueldoException {
        this(0, "", numero, "", 0, 0, Funciones.generarFechaAleatoria());
    }

    public double getPlusAnual() {
        return plusAnual;
    }

    public void setPlusAnual(double plusAnual) {
        this.plusAnual = plusAnual;
    }

    public String getProyectoActual() {
        return proyectoActual;
    }

    public void setProyectoActual(String proyectoActual) {
        this.proyectoActual = proyectoActual;
    }

    @Override
    public boolean cumpleMes() {
        GregorianCalendar actual = new GregorianCalendar();
        return fechaAlta.get(DIA) == actual.get(DIA);
    }

    @Override
    public boolean cumpleAnyo() {
        GregorianCalendar actual = new GregorianCalendar();
        return fechaAlta.get(DIA) == actual.get(DIA)
                && fechaAlta.get(MES) == actual.get(MES);
    }

    @Override
    public String toString() {
        return numero + " - " + nombre + " (Analista)";
    }
}
