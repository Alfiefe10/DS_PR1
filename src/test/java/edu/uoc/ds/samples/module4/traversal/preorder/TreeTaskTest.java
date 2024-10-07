package edu.uoc.ds.samples.module4.traversal.preorder;

import edu.uoc.ds.adt.helpers.Position;
import edu.uoc.ds.traversal.Iterator;
import edu.uoc.ds.traversal.Traversal;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TreeTaskTest {

    TaskTree tree;

    @Before
    public void setUp() {
        tree = new TaskTree();
        populateTree(tree);
    }

    /**
     *                           Reform (100)
     *                       /              \           \
     *                 Walls (35)           Floor (50)   Lights (15)
     *               /             \
     *      Cover holes (30)   Paint (70)
     */
    public static void populateTree(TaskTree tree) {
        Position<Task> reform = tree.add(null, new Task("Reform", 100));
        Position<Task> walls = tree.add(reform, new Task("Walls", 35));
        tree.add(reform, new Task("Floor", 50));
        tree.add(reform, new Task("Lights", 15));
        tree.add(walls, new Task("Cover holes", 30));
        tree.add(walls, new Task("Paint", 70));
    }


    @Test
    public void test() {
        double absoluteResources = 5;

        tree.root().getElem().setAbsoluteResources(absoluteResources);
        tree.distributeTasks();

        Assert.assertEquals("{[Reform,P:100.0,A:5.0] {[Walls,P:35.0,A:1.75] {[Cover holes,P:30.0,A:0.525] ,[Paint,P:70.0,A:1.225] },[Floor,P:50.0,A:2.5] ,[Lights,P:15.0,A:0.75] }}", tree.toString());
    }

}
