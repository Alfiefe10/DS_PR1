package edu.uoc.ds.samples.module4.traversal.inorder;

import edu.uoc.ds.adt.helpers.Position;
import edu.uoc.ds.traversal.Iterator;
import edu.uoc.ds.util.DateUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

public class TaskTreeTest {

    TasksTree tree;

    @Before
    public void setUp() {
        tree = new TasksTree();
        populateTree(tree);
    }

    public static void populateTree(TasksTree tree) {
        Position<Task> paint = tree.add(null, new Task("Paint", 20));
        Position<Task> plaster = tree.add(paint, new Task("Plaster", 30));
        tree.add(paint, new Task("Clean", 7));
        tree.add(plaster, new Task("Electrical installation", 80));
        tree.add(plaster, new Task("Cover holes", 15));
    }

    @Test
    public void test() {
        Date start = DateUtils.createDate("10-04-2023 09:00:00");
        tree.planningTasks(start);

        System.out.println("The tree after planning the tasks is: " + tree);
        Assert.assertEquals("{[Paint,20,Mon Apr 10 11:05:00 CEST 2023] {[Plaster,30,Mon Apr 10 10:20:00 CEST 2023] {[Electrical installation,80,Mon Apr 10 09:00:00 CEST 2023] {,},[Cover holes,15,Mon Apr 10 10:50:00 CEST 2023] {,}},[Clean,7,Mon Apr 10 11:25:00 CEST 2023] {,}}}", tree.toString());
        // Assert

        Task currentTask;

        Iterator<Task> it = tree.values();

        currentTask = it.next();
        Assert.assertEquals("Electrical installation", currentTask.getName());
        Assert.assertEquals(DateUtils.createDate("10-04-2023 09:00:00"), currentTask.getStart());
        Assert.assertEquals(80, currentTask.getMinDuration());

        currentTask = it.next();
        Assert.assertEquals("Plaster", currentTask.getName());
        Assert.assertEquals(DateUtils.createDate("10-04-2023 10:20:00"), currentTask.getStart());
        Assert.assertEquals(30, currentTask.getMinDuration());

        currentTask = it.next();
        Assert.assertEquals("Cover holes", currentTask.getName());
        Assert.assertEquals(DateUtils.createDate("10-04-2023 10:50:00"), currentTask.getStart());
        Assert.assertEquals(15, currentTask.getMinDuration());

        currentTask = it.next();
        Assert.assertEquals("Paint", currentTask.getName());
        Assert.assertEquals(DateUtils.createDate("10-04-2023 11:05:00"), currentTask.getStart());
        Assert.assertEquals(20, currentTask.getMinDuration());

        currentTask = it.next();
        Assert.assertEquals("Clean", currentTask.getName());
        Assert.assertEquals(DateUtils.createDate("10-04-2023 11:25:00"), currentTask.getStart());
        Assert.assertEquals(7, currentTask.getMinDuration());

    }

}
