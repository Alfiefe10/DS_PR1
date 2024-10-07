package edu.uoc.ds.samples.module1;

public class Fibonacci {

    protected static Nat createNat() {
        return new NatiImpl(); // or new NatbImpl();
    }

    public static int[] showNumbers(int n) {
        int[] f = new int[n];

        Nat fibN = createNat();    // f[0] = 0
        f[0] = fibN.get();

        Nat fibN2 = createNat();    // f[1] = 1
        fibN2.succ();
        f[1] = fibN2.get();

        Nat fibN3 = createNat();
        fibN3.addAmount(fibN);
        fibN3.addAmount(fibN2);     // f[2] = 2
        f[2] = fibN3.get();
        int i = 0;
        while (i < n-3) {
            fibN = fibN2;
            fibN2 = fibN3;
            fibN3 = createNat();
            fibN3.addAmount(fibN);
            fibN3.addAmount(fibN2);
            f[i+3]=fibN3.get();
            i++;
        }
        return f;
    }
}
