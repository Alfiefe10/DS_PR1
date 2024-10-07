
package edu.uoc.ds.samples.module3.list;

import edu.uoc.ds.adt.helpers.Position;
import edu.uoc.ds.adt.sequential.AbstractSet;
import edu.uoc.ds.adt.sequential.LinkedList;
import edu.uoc.ds.adt.sequential.List;
import edu.uoc.ds.adt.sequential.Set;
import edu.uoc.ds.traversal.Iterator;
import edu.uoc.ds.traversal.Traversal;

import java.io.IOException;


/**
 * Implementation of the ADT Set that uses a linked list as a representation to
 * save items. This implementation has the restriction that you have to
 * specify at array creation time the maximum number of elements that
 * will be saved in the set.
 */
public class SetLinkedListImpl<E> extends AbstractSet<E> implements Set<E> {

    /**
     * List that we use to represent the elements
     * of the Set.
     */
    private final List<E> theList;


    public SetLinkedListImpl() {
        theList = new LinkedList<>();
    }


    public void add(E elem) {
        if (!contains(elem))
            theList.insertEnd(elem);
    }


    public boolean contains(E elem) {
        boolean found = false;
        Iterator<E> it = theList.values();
        while (!found && it.hasNext())
            found = elem.equals(it.next());
        return found;
    }


    public E delete(E elem) {
        E deletedElem = null;
        boolean found = false;
        Traversal<E> traversal = theList.positions();
        Position<E> prev = null, current = null;
        while (!found && traversal.hasNext()) {
            prev = current;
            current = traversal.next();
            found = current != null && elem.equals(current.getElem());
        }
        if (found)
            deletedElem = theList.deleteNext(prev);
        return deletedElem;
    }


    public boolean isEmpty() {
        return theList.isEmpty();
    }

    @Override
    public int size() {
        return theList.size();
    }

    @Override
    public Iterator<E> values() {
        return theList.values();
    }

}
