package edu.uoc.ds.samples.module3.reference;

public class PrimeNumber {

    /**
     * @param n
     * @return Returns true if n is prime and false if
     * * contrary.
     */
    public static boolean isPrime(long n) {
        boolean found = false;
        int i = 2;
        while ((long) i * i <= n && !found) {
            found = (n % i) == 0;
            i++;
        }
        return !found;
    }
}
