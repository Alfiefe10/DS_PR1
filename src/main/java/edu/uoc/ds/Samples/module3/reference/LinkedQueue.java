package edu.uoc.ds.samples.module3.reference;


import edu.uoc.ds.adt.helpers.Position;
import edu.uoc.ds.adt.sequential.Queue;
import edu.uoc.ds.traversal.Iterator;

/**
 * Chained implementation of the Queue ADT
 */
public class LinkedQueue<E> implements Queue<E> {

    private static final long serialVersionUID = 1;

    /**
     * Number of items currently in the container.
     */
    protected int n;

    /**
     * First element of the queue.
     */
    private Node<E> first;

    /**
     * �ltimo elemento de la cola.
     */
    private Node<E> ultimo;

    public LinkedQueue() {
        first = null;
        ultimo = null;
    }


    /**
     * Method that provides the number of items in the container.
     * @return number of elements currently contained
     */
    public int size() {
        return n;
    }


    /**
     * Method to check if the container is empty.
     *
     * @return true or false, depending on whether it is empty or not
     */
    public boolean isEmpty() {
        return (n == 0);
    }


    /**
     * A�ade un elemento a la cola, si cabe.
     *
     * @param elem elemento que se quiere a�adir a la cola
     */
    public void add(E elem) {
        Node<E> newElem = new Node<E>(elem);
        if (first == null)
            first = newElem;
        else
            ultimo.setNext(newElem);
        ultimo = newElem;
        n++;
    }


    /**
     * Deletes the first item in the queue, if there is one.
     *
     * @return first element inserted into queue
     * @pre first!=null
     */
    public E poll() {
        Node<E> aux = first;
        first = first.getNext();
        if (first == null)
            ultimo = null;
        n--;
        return aux.getElem();
    }

    /**
     * Method that provides the first element added to the queue, if any.
     *
     * @return first item in queue
     * @pre first!=null
     */
    public E first() {
        return first.getElem();
    }

    /**
     * the elements in the container.
     *
     * @return enumeration of the container elements
     */
    public Iterator<E> values() {
        return new QueueIterator<E>(this);
    }

    @Override
    public E peek() {
        return first();
    }

    /**
     * Class that implements a node with a chaining to node, which joins a
     * node with the next in a single chained data structure.
     */
    protected static class Node<E> implements Position<E> {

        private static final long serialVersionUID = 1;


        /**
         * Element contained in the node.
         */
        private final E elem;

        /**
         * link to the next node.
         */
        private Node<E> next;

        public Node(E elem) {
            this.elem = elem;
            next = null;
        }

        public E getElem() {
            return elem;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> node) {
            next = node;
        }

    }


    /**
     * A class that provides a traversal of the queue positions.
     */
    protected static class QueueIterator<E> implements Iterator<E> {

        private static final long serialVersionUID = 1;

        /**
         * Next node
         */
        protected Node<E> currentNode;

        public QueueIterator(LinkedQueue<E> cola) {
            currentNode = cola.first;
        }

        /**
         * Check if there are any positions left to visit.
         *
         * @return true if positions remain, false otherwise.
         */
        public boolean hasNext() {
            return currentNode != null;
        }

        /**
         * Returns the next node to visit and moves on.
         *
         * @return next position.
         * @pre hasNext(), new InvalidPositionException("There is no next")
         */
        public E next() {
            Node<E> aux = currentNode;
            currentNode = currentNode.getNext();
            return aux.getElem();
        }
    }

}
