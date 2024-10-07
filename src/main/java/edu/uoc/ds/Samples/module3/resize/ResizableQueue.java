package edu.uoc.ds.samples.module3.resize;

import edu.uoc.ds.adt.sequential.Queue;
import edu.uoc.ds.traversal.Iterator;
import edu.uoc.ds.traversal.IteratorArrayImpl;

/**
 * Variation of the implementation of a Queue that resizes the vector where
 * Items are automatically saved when the item is full.
 * The implementation is pretty much the same as Queue except for that and the
 * fact that as a consequence the BoundedContainer interface is not implemented.
 *
 * @author Jordi Àlvarez Canal
 * @author Esteve Mariné Gallisà.
 * Universitat Oberta de Casrctalunya (UOC)
 * @version 2.0.0
 */
public class ResizableQueue<E> implements Queue<E> {

    private static final long serialVersionUID = 1;


    //-------------------------------------------------------
    // The following part of the implementation is identical
    // to the QueueVectorImpl.
    // We can't reuse it since we don't want it to
    // ResizableQueueImpl implement Finitecontainer.
    // (in order to reuse it, you would have to modify the
    // library  and create a class
    // parent common to both implementations that did not implement
    // BoundedContainer)
    //-------------------------------------------------------

    /**
     * Maximum capacity, by default, of the container.
     */
    public static final int INITIAL_SIZE = 10;

    /**
     * Table of elements of the container.
     */
    protected E[] elems;

    /**
     * Number of items currently in the container.
     */
    protected int n;

    /**
     * First element of the queue.
     */
    private int first;

    public ResizableQueue(int len) {
        elems = (E[]) new Object[len];
        n = 0;
        first = 0;
    }

    public ResizableQueue() {
        this(INITIAL_SIZE);
    }

    private int position(int position) {
        return position % elems.length;
    }

    private int next(int posicion) {
        return (posicion + 1) == elems.length ? 0 : posicion + 1;
    }

    private boolean isFull() {
        return (n == elems.length);
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return (n == 0);
    }

    public E first() {
        return elems[first];
    }


    public E peek() {
        E elem = poll(); //elems[first];
        elems[first] = null;
        first = next(first);
        n--;
        return elem;
    }

    public Iterator<E> values() {
        return new IteratorArrayImpl<>(elems, size(), first);
    }

    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("{QUEEU:");
        for (Iterator<E> it = values(); it.hasNext(); ) {
            buffer.append(it.next());
            if (it.hasNext()) buffer.append(',');
        }
        buffer.append("}");
        return buffer.toString();
    }


    //-------------------------------------------------------
    // modifications on the implementation: QueueArrayImpl
    //-------------------------------------------------------

    /**
     * The enqueue implementation checks if the array
     * is full, and * if so, resizes the array.
     */
    public void add(E elem) {
        if (isFull())
            resize();
        int ultimo = position(first + n);
        elems[ultimo] = elem;
        n++;
    }

    @Override
    public E poll() {
        E elem = elems[first];
        return elem;
    }


    /**
     * This method doubles the size of the vector where we store
     * The elements.
     */
    private void resize() {
        // creation of the new vector (with twice the capacity)
        E[] auxElems = (E[]) new Object[elems.length * 2];
        // copy elements from one to the other
        Iterator<E> it = values();
        int i = 0;
        while (it.hasNext()) {
            auxElems[i] = it.next();
            i++;
        }
        // replacement of the old full vector by the new one with more capacity
        first = 0;
        elems = auxElems;
    }

}
