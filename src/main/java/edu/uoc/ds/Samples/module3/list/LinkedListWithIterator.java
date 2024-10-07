package edu.uoc.ds.samples.module3.list;

import edu.uoc.ds.adt.sequential.LinkedList;
import edu.uoc.ds.exceptions.InvalidPositionException;
import edu.uoc.ds.traversal.Iterator;

import java.io.IOException;

public class LinkedListWithIterator<E> extends LinkedList<E> {

    private static final long serialVersionUID = 1;


    public Iterator<E> values() {
        return new ListIterator<E>(this);
    }


    public String toString() {
        StringBuffer sb = new StringBuffer();
        Iterator<E> iter = values();
        while (iter.hasNext()) {
            sb.append(iter.next());
            if (iter.hasNext())
                sb.append(", ");
        }
        return sb.toString();
    }


    protected static class ListIterator<E> implements Iterator<E> {

        private static final long serialVersionUID = 1;

        private final LinkedNode<E> last;
        private LinkedNode<E> next;

        ListIterator(LinkedListWithIterator<E> ll) {
            this.last = ll.last;
            if (last != null)
                next = last.getNext();
        }

        public boolean hasNext() {
            return next != null;
        }

        public E next() throws InvalidPositionException {
            LinkedNode<E> aux = next;
            next = next == last ? null : next.getNext();
            return aux.getElem();
        }
    }
}
