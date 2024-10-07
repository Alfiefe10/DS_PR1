package edu.uoc.ds.samples.module1;

public class NatbImpl implements Nat {

    /**
     * This class represents the natural by
     * a table of booleans. The representation of a natural
     * N corresponds to a table where the first N
     * table positions have the value true and position
     * N+1 has the value false.
     */
    private boolean[] nat;

    /**
     * Creates an instance of natural with value 0.
     *
     * @post nat!=null && nat[0]==false
     */
    public NatbImpl() {
        nat = new boolean[10];
    }

    public void succ() {
        int i = searchLastPosition();
        setPosition(i + 1, true);
    }

    public void pred() {
        int i = searchLastPosition();
        setPosition(i, false);
    }

    public void addAmount(Nat y) {
        int i = searchLastPosition();
        int j = y.get();
        while (j-- > 0)
            setPosition(++i, true);
    }

    /**
     * @pre true
     * @post nat == initial(nat) &&
     * $all(nat,0,$return-1,index,nat[index] == true) &&
     * (nat.length<$return || nat[$return]==false)
     */
    public int get() {
        return searchLastPosition() + 1;
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


    /**
     * @pre true
     * @post nat == initial(nat) &&
     * $all(nat,0,$return,i,nat[i]) &&
     * (nat.length<$return+1 || nat[$return+1]==false)
     */
    private int searchLastPosition() {
        int i = 0;
        while (i < nat.length && nat[i])
            i++;
        return i - 1;
    }

    /**
     * @pre true
     * @post $all(nat, j, j = = i | | nat[j] = = $old ( nat[j])) && nat[i]==value
     */
    private void setPosition(int i, boolean valor) {
        if (i >= nat.length)
            cloneArray();
        nat[i] = valor;
    }

    /**
     * @pre true
     * @post $all(nat, i,
     *i < $old ( nat.length) && nat[i]==$old(nat[i]) ||
     * i>=$old(nat.length) && !nat[i])
     */
    private void cloneArray() {
        boolean[] newBoolean = new boolean[nat.length * 2];
        System.arraycopy(nat, 0, newBoolean, 0, nat.length);
        nat = newBoolean;
    }

}
