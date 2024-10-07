package edu.uoc.ds.samples.module4.traversal.levels;

import edu.uoc.ds.adt.helpers.Position;
import edu.uoc.ds.adt.sequential.LinkedList;
import edu.uoc.ds.adt.sequential.List;
import edu.uoc.ds.traversal.Iterator;
import edu.uoc.ds.traversal.Traversal;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DepartmentTest {

    Department tree;

    @Before
    public void setUp() {
        tree = new Department();
        populateTree(tree);
    }

    /**
     *
     *                   matt
     *                  /   \
     *                Ned    Apu
     *                     /      \
     *                  Homer    Winnie
     *                          /   |    \
     *                        Bart  Lisa  Maggie
     */
    public static void populateTree(Department tree) {
        Position<Employee> matt = tree.add(null, new Employee("Matt"));
        tree.add(matt, new Employee("Ned"));
        Position<Employee> apu = tree.add(matt, new Employee("Apu"));
        Position<Employee> homer = tree.add(apu, new Employee("Homer"));
        Position<Employee> winnie = tree.add(apu, new Employee("Winnie"));
        tree.add(winnie, new Employee("Bart"));
        tree.add(winnie, new Employee("Lisa"));
        tree.add(winnie, new Employee("Maggie"));
    }


    @Test
    public void test() {
        List<String> positions = new LinkedList<>();
        positions.insertEnd("Parking A");
        positions.insertEnd("Parking B");
        positions.insertEnd("Parking C");
        positions.insertEnd("Parking D");
        positions.insertEnd("Parking E");
        positions.insertEnd("Parking F");
        positions.insertEnd("Parking G");
        positions.insertEnd("Parking H");

        tree.distributeParkingAreas(positions);

        Employee currentEmployee = null;
        Traversal<Employee> traversal = tree.levelOrderTraversal();

        currentEmployee = traversal.next().getElem();
        Assert.assertEquals("Matt", currentEmployee.getName());
        Assert.assertEquals("Parking A", currentEmployee.getParkingArea());

        currentEmployee = traversal.next().getElem();
        Assert.assertEquals("Ned", currentEmployee.getName());
        Assert.assertEquals("Parking B", currentEmployee.getParkingArea());

        currentEmployee = traversal.next().getElem();
        Assert.assertEquals("Apu", currentEmployee.getName());
        Assert.assertEquals("Parking C", currentEmployee.getParkingArea());

        currentEmployee = traversal.next().getElem();
        Assert.assertEquals("Homer", currentEmployee.getName());
        Assert.assertEquals("Parking D", currentEmployee.getParkingArea());

        currentEmployee = traversal.next().getElem();
        Assert.assertEquals("Winnie", currentEmployee.getName());
        Assert.assertEquals("Parking E", currentEmployee.getParkingArea());

        currentEmployee = traversal.next().getElem();
        Assert.assertEquals("Bart", currentEmployee.getName());
        Assert.assertEquals("Parking F", currentEmployee.getParkingArea());

        currentEmployee = traversal.next().getElem();
        Assert.assertEquals("Lisa", currentEmployee.getName());
        Assert.assertEquals("Parking G", currentEmployee.getParkingArea());

        currentEmployee = traversal.next().getElem();
        Assert.assertEquals("Maggie", currentEmployee.getName());
        Assert.assertEquals("Parking H", currentEmployee.getParkingArea());

        Assert.assertFalse(traversal.hasNext());
    }

}
