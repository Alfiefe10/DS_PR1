package edu.uoc.ds.samples.module4;


import edu.uoc.ds.adt.helpers.Position;
import edu.uoc.ds.adt.nonlinear.BinaryTreeLinkedImpl;

public class VersionTree extends BinaryTreeLinkedImpl<String> {


    public String incompatibleVersion() {
        String result = "XX";
        Position<String> p = root();
        Position<String> h = rightChild(p);
        while (h != null) {
            p = h;
            h = rightChild(p);
        }
        h = leftChild(p);
        if (h != null)
            result = h.getElem();
        return result;
    }



}



