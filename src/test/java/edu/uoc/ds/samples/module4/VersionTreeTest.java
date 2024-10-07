package edu.uoc.ds.samples.module4;

import edu.uoc.ds.adt.helpers.Position;
import org.junit.Assert;
import org.junit.Test;

public class VersionTreeTest {


    public static void populateTree(VersionTree tree) {
        Position<String> v10 = tree.add(null, "1.0");
        Position<String> v11 = tree.addLeftChild(v10, "1.1");
        tree.addLeftChild(v11, "1.2");
        Position<String> v20 = tree.addRightChild(v10, "2.0");
        Position<String> v21 = tree.addLeftChild(v20, "2.1");
        tree.addRightChild(v20, "3.0");
        tree.addRightChild(v21, "4.0");
    }


    @Test
    public void test() {
        VersionTree tree = new VersionTree();
        populateTree(tree);
        Assert.assertEquals("{1.0 {1.1 {1.2 {,},},2.0 {2.1 {,4.0 {,}},3.0 {,}}}}", tree.toString());

        String incompatibleVersion = tree.incompatibleVersion();
        Assert.assertEquals("XX", incompatibleVersion);
    }

}
