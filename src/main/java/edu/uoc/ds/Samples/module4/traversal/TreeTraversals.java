package edu.uoc.ds.samples.module4.traversal;


import edu.uoc.ds.adt.helpers.Position;
import edu.uoc.ds.adt.nonlinear.Tree;
import edu.uoc.ds.adt.sequential.Queue;
import edu.uoc.ds.adt.sequential.QueueArrayImpl;
import edu.uoc.ds.traversal.Traversal;

/**
 * This class recursively defines the basic traversals over
 * the general trees. Provides a default treatment consisting of
 * to display the tree elements on standard output.<p>
 * In derived classes you can define the method treatPosition with the objective
 * to define the treatment applied to the tree.
 *
 * @param <E>
 * @author Jordi Alvarez
 * @author Esteve Marine
 * Universitat Oberta de Catalunya (UOC)
 */

public abstract class TreeTraversals<E> {
    StringBuilder out;

    public TreeTraversals() {
        super();
        out = new StringBuilder();
    }


    public void preOrder(Tree<E> tree) {
        initTraversal();
        if (!tree.isEmpty())
            preOrder(tree, tree.root());
        endTraversal();
    }


    public void postOrder(Tree<E> tree) {
        initTraversal();
        if (!tree.isEmpty())
            postOrder(tree, tree.root());
        endTraversal();
    }


    public void levels(Tree<E> tree) {
        initTraversal();
        Queue<Position<E>> positions = new QueueArrayImpl<>(tree.size());
        if (!tree.isEmpty())
            positions.add(tree.root());
        while (!positions.isEmpty()) {
            Position<E> p = positions.poll();
            processPosition(p);
            Traversal<E> children = tree.children(p);
            while (children.hasNext())
                positions.add(children.next());
        }
        endTraversal();
    }


    protected void preOrder(Tree<E> tree, Position<E> p) {
        processPosition(p);
        Traversal<E> children = tree.children(p);
        while (children.hasNext()) {
            Position<E> child = children.next();
            preOrder(tree, child);
        }
    }


    protected void postOrder(Tree<E> tree, Position<E> p) {
        Traversal<E> children = tree.children(p);
        while (children.hasNext()) {
            Position<E> child = children.next();
            postOrder(tree, child);
        }
        processPosition(p);
    }


    protected void processPosition(Position<E> position) {
        out.append(position.getElem() + " ");
    }


    protected void initTraversal() {
    }


    protected void endTraversal() {
    }

    public String getOutput() {
        return out.toString();
    }


}
