package edu.uoc.ds.exercises.module4;

import edu.uoc.ds.samples.module4.traversal.levels.Department;
import edu.uoc.ds.samples.module4.traversal.levels.DepartmentTest;
import edu.uoc.ds.samples.module4.traversal.levels.Employee;
import org.junit.Assert;
import org.junit.Test;

public class Exercise3Test {

    @Test
    public  void test() {

        Exercise3<Employee> exercise3 = new Exercise3<>();

        // We use as an example the level traversal example tree
        Department tree = new Department();
        DepartmentTest.populateTree(tree);
        /*
         *                   matt
         *                  /   \
         *                Ned    Apu
         *                     /      \
         *                  Homer    Winnie
         *                          /   |    \
         *                        Bart  Lisa  Maggie
         */
        exercise3.inOrder(tree);
        Assert.assertEquals("[Ned,null] [Matt,null] [Homer,null] [Apu,null] [Bart,null] [Winnie,null] [Lisa,null] [Maggie,null] ",
                exercise3.getOutput());
    }
}
