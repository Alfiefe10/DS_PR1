package edu.uoc.ds.exercises.module9.exercise1;

import edu.uoc.ds.adt.helpers.Position;
import edu.uoc.ds.adt.nonlinear.PriorityQueue;
import edu.uoc.ds.adt.sequential.LinkedList;
import edu.uoc.ds.traversal.Iterator;
import edu.uoc.ds.traversal.Traversal;

/**
 * Extension of a queue with priority that allows to modify the values
 * saved to the queue and to update the queue so that it is again
 * ordered in logarithmic time.
 *
 * @author Jordi Alvarez
 * @author Esteve Marine
 * <p>
 * Universitat Oberta de Catalunya (UOC)
 */
public class PriorityQueueUpdatable<E> extends PriorityQueue<E> {


    private final LinkedList<PositionalContainerObserver<E>> observers;


    public PriorityQueueUpdatable() {
        super();
        observers = new LinkedList<PositionalContainerObserver<E>>();
    }

    public PriorityQueueUpdatable(int max) {
        super(max);
        observers = new LinkedList<PositionalContainerObserver<E>>();
    }

    public PriorityQueueUpdatable(java.util.Comparator<E> comparador) {
        super(comparador);
        observers = new LinkedList<PositionalContainerObserver<E>>();
    }

    public PriorityQueueUpdatable(int max, java.util.Comparator<E> comparator) {
        super(max, comparator);
        observers = new LinkedList<PositionalContainerObserver<E>>();
    }


    public void updatePosition(Position<E> position) {
        siftDown(position);
        siftUp(position);
    }


    public void addObserver(PositionalContainerObserver observador) {
        observers.insertEnd(observador);
    }


    public void deleteObserver(PositionalContainerObserver observador) {
        Traversal<PositionalContainerObserver<E>> r = observers.positions();
        boolean found = false;
        Position<PositionalContainerObserver<E>> p = null;
        while (r.hasNext() && !found) {
            p = r.next();
            found = p.getElem() == observador;
        }
        if (found)
            observers.delete(p);
    }


    public Position<E> nextLastPosition(E elem) {
        Position<E> position = super.nextLastPosition(elem);
        Iterator<PositionalContainerObserver<E>> iter = observers.values();
        while (iter.hasNext()) {
            iter.next().notifyNewPosition(position);
        }
        return position;
    }


    protected Position<E> deleteLastPosition() {
        Position<E> position = super.deleteLastPosition();
        Iterator<PositionalContainerObserver<E>> iter = observers.values();
        while (iter.hasNext()) {
            iter.next().notifyDeletedPosition(position);
        }
        return position;
    }
}
