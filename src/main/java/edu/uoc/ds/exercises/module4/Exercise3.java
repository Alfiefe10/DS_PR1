package edu.uoc.ds.exercises.module4;


import edu.uoc.ds.adt.helpers.Position;
import edu.uoc.ds.adt.nonlinear.Tree;
import edu.uoc.ds.samples.module4.traversal.TreeTraversals;
import edu.uoc.ds.traversal.Traversal;

public class Exercise3<E> extends TreeTraversals<E> {

    public void inOrder(Tree<E> tree) {
        if (!tree.isEmpty())
            inOrder(tree, tree.root());
    }


    public void inOrder(Tree<E> tree, Position<E> p) {
        Traversal<E> children = tree.children(p);
        if (children.hasNext())
            inOrder(tree, children.next());
        processPosition(p);
        while (children.hasNext()) {
            Position<E> child
                    = children.next();
            inOrder(tree, child);
        }
    }




}
