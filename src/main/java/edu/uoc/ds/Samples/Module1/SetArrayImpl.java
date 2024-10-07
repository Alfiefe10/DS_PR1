package edu.uoc.ds.samples.module1;

import edu.uoc.ds.adt.sequential.AbstractSet;
import edu.uoc.ds.adt.sequential.FiniteContainer;
import edu.uoc.ds.adt.sequential.Set;
import edu.uoc.ds.samples.module1.generics.FiniteSet;
import edu.uoc.ds.traversal.Iterator;
import edu.uoc.ds.traversal.IteratorArrayImpl;

/**
 * Implementation of the ADT that will serve a table with personal representation
 * to save the elements. This implements the restriction that you have to specify,
 * at set creation time, the maximum number of elements to store in the set.
 *
 * @author Jordi Àlvarez Canal
 * @author Esteve Mariné Gallisà.
 * Universitat Oberta de Catalunya (UOC)
 * @version 2.0.0
 * @since 1.5
 */

public class
SetArrayImpl extends AbstractSet implements FiniteSet {

    /**
     * array that stores the elements of the set.
     */

    private final Object[] elements;


    /**
     * Number of elements
     */

    private int num;


    /**
     * Creates a set with a maximum number of elements.
     *
     * @param n Maximum name of elements of the set.
     * @pre n>=0
     * @post elements.length==n && num==0
     */

    public SetArrayImpl(int n) {
        elements = new Object[n];
        num = 0;
    }


    /**
     * @pre elem!=null && (!isFull() || contains(elem))
     * @post this.contains(elem) &&
     * ($old(this).contains(elem) && $old(num)==num ||
     * !$old(this).contains(elem) && $old(num)+1==num) &&
     * $all(i:elements,i>=$old(num) || $old(elements[i])==elements[i])
     */

    public void add(Object elem) {
        if (!contains(elem)) {
            elements[num] = elem;
            num++;
        }
    }


    /**
     * @pre elem!=null
     * @post $old(this)==this &&
     * $return == $exists(i:elements,i<num && elements[i].equals(elem))
     */

    public boolean contains(Object elem) {
        return searchPosition(elem) != -1;
    }


    /**
     * @pre elem!=null
     * @post !contains(elem) &&
     * ($old(this).contains(elem) && $old(num)==num+1 ||
     * !$old(this).contains(elem) && $old(num)==num) &&
     * $all(i:elements,i>=$old(num) ||
     * $old(elements[i])==elem ||
     * this.contains($old(elements[i])))
     */

    public Object delete(Object elem) {
        Object elem2Delete = null;
        int position = searchPosition(elem);
        if (position != -1) {
            elem2Delete = elements[position];
            num--;
            if (position < num)
                elements[position] = elements[num];
            // for garbage collector
            elements[num] = null;
        }
        return elem2Delete;
    }

    /**
     * @post $return == (num==0)
     */

    public boolean isEmpty() {
        return num == 0;
    }

    @Override
    public int size() {
        return num;
    }

    @Override
    public Iterator values() {
        return new IteratorArrayImpl(elements, num, 0);
    }


    /**
     * @post $return == (num==elements.length)
     */

    public boolean isFull() {
        return num == elements.length;
    }


    /**
     * seek the position of an element
     *
     * @param elem
     * @return
     * @pre elem!=null
     * @post $old(this)==this &&
     * ($return == -1 && !contains(elem) ||
     * elements[$return].equals(elem))
     */

    protected int searchPosition(Object elem) {
        boolean found = false;
        int i = 0;
        while (i < num && !found) {
            found = elements[i].equals(elem);
            if (!found) i++;
        }
        return found ? i : -1;
    }
}
