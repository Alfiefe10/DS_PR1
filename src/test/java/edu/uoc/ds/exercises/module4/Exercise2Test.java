package edu.uoc.ds.exercises.module4;

import edu.uoc.ds.samples.module4.traversal.inorder.Task;
import edu.uoc.ds.samples.module4.traversal.inorder.TaskTreeTest;
import edu.uoc.ds.samples.module4.traversal.inorder.TasksTree;
import org.junit.Assert;
import org.junit.Test;

public class Exercise2Test {

    @Test
    public void test() {
        Exercise2<Task> exercise2 = new Exercise2<Task>();
        // We use the task tree defined for the example as an example tree
        // of the traversal in preorder
        TasksTree tree = new TasksTree();
        TaskTreeTest.populateTree(tree);
        /*
         *                       [PAINT]
         *                    /          \
         *                 PLASTER          CLEAN
         *                  /       \
         *        Electrical Inst  COVER HOLES
         *
         */
        Assert.assertEquals(3, exercise2.numberOfLeafs(tree));
    }
}
