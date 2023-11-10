/*
 * Clase Programador
 */
package modelo;

import controlador.Funciones;
import java.util.GregorianCalendar;

/**
 *
 * @author Di Qi
 */
public class Programador extends Empleado implements Fecha {

    private double sueldoExtraMensual;
    private int anyiosExperiencia;

    public Programador(
            double sueldoExtraMensual,
            int anyiosExperiencia,
            int numero, String nombre,
            double sueldo,
            double sueldoMaximo,
            GregorianCalendar fechaAlta
    ) throws SueldoException {
        super(numero, nombre, sueldo, sueldoMaximo, fechaAlta);
        this.sueldoExtraMensual = sueldoExtraMensual;
        this.anyiosExperiencia = anyiosExperiencia;
    }

    public Programador(int numero) throws SueldoException {
        this(0, 0, numero, "", 0, 0, Funciones.generarFechaAleatoria());
    }

    public double getSueldoExtraMensual() {
        return sueldoExtraMensual;
    }

    public void setSueldoExtraMensual(double sueldoExtraMensual) {
        this.sueldoExtraMensual = sueldoExtraMensual;
    }

    public int getAnyiosExperiencia() {
        return anyiosExperiencia;
    }

    public void setAnyiosExperiencia(int anyiosExperiencia) {
        this.anyiosExperiencia = anyiosExperiencia;
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
        return numero + " - " + nombre + " (Programador)";
    }
}
