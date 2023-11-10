/*
 * Clase Empleado
 */
package modelo;

import controlador.Funciones;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

/**
 *
 * @author Di Qi
 */
public class Empleado implements Serializable, Comparable<Empleado> {

    protected static final long serialVersionUID = 1L;
    
    protected int numero;
    protected transient String nombre;
    protected double sueldo, sueldoMaximo;
    protected GregorianCalendar fechaAlta;

    public Empleado(
            int numero, 
            String nombre, 
            double sueldo, 
            double sueldoMaximo,
            GregorianCalendar fechaAlta
    ) throws SueldoException {
        if (sueldo > sueldoMaximo) {
            throw new SueldoException("El sueldo no puede ser mayor al sueldo máximo.");
        } else {
            this.numero = numero;
            this.nombre = nombre;
            this.fechaAlta = fechaAlta;
            this.sueldo = sueldo;
            this.sueldoMaximo = sueldoMaximo;
        }
    }

    public Empleado(int numero) throws SueldoException {
        this(numero, "**Anónimo**", 0, 0, Funciones.generarFechaAleatoria());
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) throws SueldoException {
        if (sueldo > this.sueldoMaximo) {
            throw new SueldoException("El sueldo no puede superar el sueldo máximo.");
        } else {
            this.sueldo = sueldo;
        }
    }

    public double getSueldoMaximo() {
        return sueldoMaximo;
    }

    public void setSueldoMaximo(double sueldoMaximo) {
        this.sueldoMaximo = sueldoMaximo;
    }

    public GregorianCalendar getFechaAlta() {
        return fechaAlta;
    }
    
    public String getFechaAltaStr() {
        SimpleDateFormat dateTimeFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        dateTimeFormat.setCalendar(this.fechaAlta);
        return dateTimeFormat.format(this.fechaAlta.getTime());
    }

    public void setFechaAlta(GregorianCalendar fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    @Override
    public String toString() {
        return "Empleado{" + "numero=" + numero + ", nombre=" + nombre + '}';
    }

    @Override
    public int compareTo(Empleado o) {
        return Integer.compare(this.numero, o.numero);
    }

}
