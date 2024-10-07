package edu.uoc.ds.samples.module4.traversal;


import edu.uoc.ds.adt.helpers.Position;
import edu.uoc.ds.adt.nonlinear.BinaryTree;

/**
 * This class extends the Tree Traversals class with the basic
 * tree traversals available only for binary trees.
 *
 * @param <E>
 * @author Jordi Alvarez
 * @author Esteve Marine
 * Universitat Oberta de Catalunya (UOC)
 * *
 */

public abstract class BinaryTreeTraversal<E> extends TreeTraversals<E> {


    public void preOrder(BinaryTree<E> tree) {
        if (!tree.isEmpty())
            this.preOrder(tree, tree.root());
    }


    public void inOrder(BinaryTree<E> tree) {
        if (!tree.isEmpty())
            inOrder(tree, tree.root());
    }


    public void postOrder(BinaryTree<E> tree) {
        if (!tree.isEmpty())
            postOrder(tree, tree.root());
    }


    public void preOrder(BinaryTree<E> tree, Position<E> p) {
        Position<E> rightChild = tree.rightChild(p);
        Position<E> leftChild = tree.leftChild(p);
        processPosition(p);
        if (leftChild != null) preOrder(tree, leftChild);
        if (rightChild != null) preOrder(tree, rightChild);
    }


    public void inOrder(BinaryTree<E> tree, Position<E> p) {
        Position<E> rightChild = tree.rightChild(p);
        Position<E> leftChild = tree.leftChild(p);
        if (leftChild != null) inOrder(tree, leftChild);
        processPosition(p);
        if (rightChild != null) inOrder(tree, rightChild);
    }


    public void postOrder(BinaryTree<E> tree, Position<E> p) {
        Position<E> rightChild = tree.rightChild(p);
        Position<E> leftChild = tree.leftChild(p);
        if (leftChild != null) postOrder(tree, leftChild);
        if (rightChild != null) postOrder(tree, rightChild);
        processPosition(p);
    }

}
