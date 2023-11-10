/*
 * Clase Funciones
 */
package controlador;

import java.util.Calendar;
import java.util.GregorianCalendar;
import modelo.*;

/**
 *
 * @author Di Qi
 */
public class Funciones {
    
    private static final String[] NOMBRES = {
        "Antonio",
        "Bruno",
        "Carmen",
        "Diego",
        "Elena",
        "Fernando",
        "Gerónimo",
        "Humberto",
        "Irene",
        "Jesse",
        "Kenia",
        "Laura",
        "Mario",
        "Noelia",
        "Olivia",
        "Pablo",
        "Quique",
        "Rosa",
        "Silvia",
        "Tomás",
        "Úrsula",
        "Valentín",
        "Walter",
        "Xavier",
        "Yolanda",
        "Zoraida"
    };
    
    private static final String[] PROYECTOS = {
        "Videojuego",
        "Aplicación móvil",
        "Aplicación web",
        "Aplicación escritorio",
        "Testing",
        "Inteligencia artificial"
    };
    
    /**
     * Número entero aleatorio entre min y max, ambos inclusive
     * @param min valor mínimo
     * @param max valor máximo
     * @return número random
     */
    public static int numeroRandom(int min, int max) {
        return (int)(Math.floor(Math.random() * (max - min + 1) + min));
    }
    
    /**
     * Genera un empleado aleatoriamente
     * @param numero número de empleado
     * @return Empleado creado
     * @throws SueldoException Controla que el sueldo sea correcto
     */
    public static Empleado generarEmpleadoAleatorio(int numero) throws SueldoException {
        int analistaOProgramador = numeroRandom(0, 1);  // 0 = Programador, 1 = Analista
        String nombre = NOMBRES[numeroRandom(0, NOMBRES.length - 1)];
        GregorianCalendar fechaAlta = generarFechaAleatoria();
        Empleado res;
        
        if (analistaOProgramador == 0) {
            int anyoExp = numeroRandom(0, 10);
            double sueldo = numeroRandom(1200, 5000);
            double sueldoMax = numeroRandom(5000, 6000);
            double sueldoExtraMensual = numeroRandom(200, 500);
            res = new Programador(sueldoExtraMensual, anyoExp, numero, nombre, sueldo, sueldoMax, fechaAlta);
        } else {
            String proyecto = PROYECTOS[numeroRandom(0, PROYECTOS.length - 1)];
            double sueldo = numeroRandom(3000, 7000);
            double sueldoMax = numeroRandom(7000, 8000);
            double plusAnual = numeroRandom(5, 20);
            res = new Analista(plusAnual, proyecto, numero, nombre, sueldo, sueldoMax, fechaAlta);
        }
        
        return res;
    }
    
    /**
     * Genera una fecha aleatoria
     * @return fecha aleatoria
     */
    public static GregorianCalendar generarFechaAleatoria() {
        GregorianCalendar actual = new GregorianCalendar();
        
        int anyo = numeroRandom(1970, actual.get(Calendar.YEAR) - 1);
        int mes = numeroRandom(0, 11);
        int dia = numeroRandom(1, maxDiaMes(anyo, mes));

        return new GregorianCalendar(anyo, mes, dia);
    }

    /**
     * Calcula el máximo de dias que tiene un mes en un determinado año
     * @param anyo año
     * @param mes mes
     * @return número de días máximo
     */
    private static int maxDiaMes(int anyo, int mes) {
        int[] diasMeses = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (mes == 1 
                && ((anyo % 4 == 0 && anyo % 100 != 0) || (anyo % 400 == 0))) {
            return 29;
        }
        return diasMeses[mes];
    }
    
}
