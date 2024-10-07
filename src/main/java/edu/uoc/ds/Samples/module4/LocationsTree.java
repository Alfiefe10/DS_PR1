package edu.uoc.ds.samples.module4;

import java.util.StringTokenizer;

import edu.uoc.ds.adt.helpers.Position;
import edu.uoc.ds.adt.nonlinear.GeneralTreeDelImpl;
import edu.uoc.ds.adt.sequential.Stack;
import edu.uoc.ds.adt.sequential.StackArrayImpl;

public class LocationsTree extends GeneralTreeDelImpl<String> {


    public LocationsTree() {
        super();
    }


    public LocationsTree(String textTree) {
        super();
        read(textTree);
    }


    protected void read(String treeFromText) {
        Stack<Position<String>> predecessors = new StackArrayImpl<>();
        StringTokenizer tokenizer = new StringTokenizer(treeFromText);
        // we take the number of the root and create the root node
        String name = tokenizer.nextToken();
        Position<String> currentPosition = add(null, name);
        while (tokenizer.hasMoreTokens()) {
            name = tokenizer.nextToken();
            if (name.equals("SUB"))
                predecessors.push(currentPosition);
            else if (name.equals("FSUB"))
                predecessors.pop();
            else {
                Position<String> parent = predecessors.peek();
                currentPosition = add(parent, name);
            }
        }
    }

}
