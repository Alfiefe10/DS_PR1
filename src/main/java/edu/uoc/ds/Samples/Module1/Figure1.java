package edu.uoc.ds.samples.module1;

public class Figure1 {

    /**
     * Create an instance of some Nat implementation.
     * At the time when figure 1 appears in the text
     * no Nat implementation seen yet. Here
     * NatiImpl is used.
     *
     * @return An instance of Nat
     */
    protected static Nat buildNat() {
        return new NatiImpl();
    }


}
