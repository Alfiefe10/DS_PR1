
package edu.uoc.ds.samples.module1.generics;

import edu.uoc.ds.adt.sequential.AbstractSet;
import edu.uoc.ds.adt.sequential.FiniteContainer;
import edu.uoc.ds.adt.sequential.Set;
import edu.uoc.ds.traversal.Iterator;
import edu.uoc.ds.traversal.IteratorArrayImpl;

/**
 * Implementation of the ADT Set that uses an array as a representation to
 * store items. This implementation has the restriction that you have to
 * specify at array creation time the maximum number of elements that
 * will be saved in the set.
 */
public class SetArrayImpl<E> extends AbstractSet<E> implements FiniteSet<E> {

    /**
     * array that stores the elements of the set
     */
    private final E[] elems;


    /**
     * The number of elements that the array currently contains.
     */
    private int numElems;


    /**
     * Creates a set with a maximum number of elements.
     *
     * @param n Maximum number of elements in the set.
     * @pre n>=0
     * @post elems.length==n && numElems==0
     */
    public SetArrayImpl(int n) {
        elems = (E[]) new Object[n];
        numElems = 0;
    }


    /**
     * @pre elem!=null && (numElems<elems.length || contains(elem))
     * @post this.contains(elem) &&
     * ($old(this).contains(elem) && $old(numElems)==numElems ||
     * !$old(this).contains(elem) && $old(numElems)+1==numElems) &&
     * $all(i:elems,i>=$old(numElems) || $old(elems[i])==elems[i])
     */
    @Override
    public void add(E elem) {
        if (!contains(elem)) {
            elems[numElems] = elem;
            numElems++;
        }
    }


    /**
     * @pre elem!=null
     * @post $old(this)==this &&
     * $return == $exists(i:elems,i<numElems && elems[i].equals(elem))
     */
    @Override
    public boolean contains(E elem) {
        return searchPositionElem(elem) != -1;
    }


    /**
     * @pre elem!=null
     * @post !contains(elem) &&
     * ($old(this).contains(elem) && $old(numElems)==numElems+1 ||
     * !$old(this).contains(elem) && $old(numElems)==numElems) &&
     * $all(i:elems,i>=$old(numElems) ||
     * $old(elems[i])==elem ||
     * this.contains($old(elems[i])))
     */
    public E delete(E elem) {
        E deletedElem = null;
        int position = searchPositionElem(elem);
        if (position != -1) {
            deletedElem = elems[position];
            numElems--;
            if (position < numElems)
                elems[position] = elems[numElems];
        }
        return deletedElem;
    }


    /**
     * @post $return == (numElems==0)
     */

    public boolean isEmpty() {
        return numElems == 0;
    }

    @Override
    public int size() {
        return numElems;
    }

    @Override
    public Iterator<E> values() {
        return new IteratorArrayImpl<>(elems, numElems, 0);
    }


    /**
     * @post $return == (numElems==elems.length)
     */

    public boolean isFull() {
        return numElems == elems.length;
    }


    /**
     * Private method that finds the position of an element
     * inside the table where all the elements are stored
     * that have been added to the set.
     *
     * @param elem
     * @return
     * @pre elem!=null
     * @post $old(this)==this &&
     * ($return == -1 && !contains(elem) ||
     * elems[$return].equals(elem))
     */
    protected int searchPositionElem(E elem) {
        boolean found = false;
        int i = 0;
        while (i < numElems && !found) {
            found = elems[i].equals(elem);
            if (!found) i++;
        }
        return found ? i : -1;
    }
}
