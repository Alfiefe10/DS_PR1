package edu.uoc.ds.adt;

public class PeriodicFunction {
    /**
     * Calcula el valor de la función periódica f(x) = (x mod 4)^2
     *
     * @param x El valor de entrada.
     * @return El valor de la función periódica.
     */
    public static int f(int x) {
        return (x % 4) * (x % 4);  // f(x) = (x mod 4)^2
    }
}
