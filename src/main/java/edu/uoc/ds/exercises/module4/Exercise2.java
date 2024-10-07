package edu.uoc.ds.exercises.module4;

import edu.uoc.ds.adt.helpers.Position;
import edu.uoc.ds.adt.nonlinear.BinaryTree;
import edu.uoc.ds.adt.nonlinear.Tree;
import edu.uoc.ds.traversal.Traversal;

public class Exercise2<E> {

    protected int numberOfLeafs(Tree<E> tree, Position<E> position) {
        int nLeafs = 0;
        if (tree.isLeaf(position))
            nLeafs = 1;
        else {
            Traversal<E> children = tree.children(position);
            while (children.hasNext()) {
                Position<E> child = children.next();
                nLeafs += this.numberOfLeafs(tree, child);
            }
        }
        return nLeafs;
    }


    public int numberOfLeafs(BinaryTree<E> tree) {
        return numberOfLeafs(tree, tree.root());
    }


    protected int numberOfLeafs(BinaryTree<E> tree, Position<E> position) {
        int nLeafs = 0;
        if (position != null) {
            nLeafs += numberOfLeafs(tree, tree.leftChild(position));
            nLeafs += numberOfLeafs(tree, tree.rightChild(position));
            if (nLeafs == 0)
                nLeafs = 1;
        }
        return nLeafs;
    }

}
