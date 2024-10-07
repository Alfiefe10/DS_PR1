package edu.uoc.ds.samples.module1;

public class NatiImpl implements Nat {

    /**
     * This class represents the natural by
     * an integer attribute.
     */
    private int nat;

    /**
     * Creates an instance of Nat with value 0.
     *
     * @post nat==0
     */
    public NatiImpl() {
        nat = 0;
    }

    public void succ() {
        nat++;
    }

    public void pred() {
        nat--;
    }

    public void addAmount(Nat y) {
        nat += y.get();
    }

    /**
     * @return nat
     * @pre true
     * @post nat==initial(nat)
     */
    public int get() {
        return nat;
    }

    /**
     * Returns a representation in text format of the
     * natural.
     *
     * @pre true
     * @post nat==initial(nat)
     */
    public String toString() {
        return Integer.toString(get());
    }

}
