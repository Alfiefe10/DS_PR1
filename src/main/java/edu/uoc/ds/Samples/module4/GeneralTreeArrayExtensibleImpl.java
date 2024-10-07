package edu.uoc.ds.samples.module4;

import edu.uoc.ds.adt.helpers.Position;
import edu.uoc.ds.adt.nonlinear.AbstractTree;
import edu.uoc.ds.traversal.Traversal;
import edu.uoc.ds.traversal.TraversalArrrayImpl;


public class GeneralTreeArrayExtensibleImpl<E> extends AbstractTree<E> {


    private Node<E> root;
    private int size;


    public GeneralTreeArrayExtensibleImpl() {
        super();
        root = null;
        size = 0;
    }


    public Position<E> root() {
        return root;
    }


    public Traversal<E> children(Position<E> parent) {
        return ((Node<E>) parent).children();
    }


    public Position<E> add(Position<E> parent, E elem) {
        Node<E> child = new Node<E>(elem);
        if (parent == null)
            root = child;
        else
            ((Node<E>) parent).addChild(child);
        size++;
        return child;
    }


    public E update(Position<E> pos, E elem) {
        E previousElem = pos.getElem();
        Node<E> node = (Node<E>) pos;
        node.setElem(elem);
        return previousElem;
    }


    /**
     * The positions remain unchanged; only their values are swapped.
     */
    public void swap(Position<E> pos1, Position<E> pos2) {
        Node<E> node1 = (Node<E>) pos1;
        Node<E> node2 = (Node<E>) pos2;
        E aux = node1.getElem();
        node1.setElem(node2.getElem());
        node2.setElem(aux);
    }


    public void delete(Position<E> parent, Position<E> child) {
        if (parent == null)
            root = null;
        else
            ((Node<E>) parent).deleteChild((Node<E>) child);
        size -= numChildren(child);
    }


    public int size() {
        return size;
    }


    protected static class Node<E> implements Position<E> {

        private E elems;
        int nChildren;
        private Node<E>[] children;


        public Node(E element) {
            this.elems = element;
            children = null;
            nChildren = 0;
        }


        public E getElem() {
            return elems;
        }

        public void setElem(E elem) {
            this.elems = elem;
        }

        public int nChildren() {
            return nChildren;
        }


        public Traversal<E> children() {
            return new TraversalArrrayImpl<>(children, nChildren, 0);
        }


        public void addChild(Node<E> child) {
            if (children == null || nChildren == children.length)
                extendChildrenArray();
            children[nChildren] = child;
            nChildren++;
        }


        public void deleteChild(Node<E> child) {
            int index = 0;
            while (children[index] != child)
                index++;
            while (index < nChildren - 1)
                children[index] = children[index + 1];
            children[index] = null;
        }


        private void extendChildrenArray() {
            if (children == null) children = (Node<E>[]) new Node[1];
            else {
                Node<E>[] aux = (Node<E>[]) new Node[children.length * 2];
                System.arraycopy(children, 0, aux, 0, children.length);
                children = aux;
            }
        }

        public String toString() {
            return elems.toString();
        }

    }

}
