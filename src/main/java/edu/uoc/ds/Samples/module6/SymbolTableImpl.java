package edu.uoc.ds.samples.module6;

import edu.uoc.ds.adt.sequential.LinkedList;
import edu.uoc.ds.adt.sequential.List;
import edu.uoc.ds.adt.sequential.Stack;
import edu.uoc.ds.samples.module6.SymbolProperties.Category;
import edu.uoc.ds.samples.module6.SymbolProperties.Type;
import edu.uoc.ds.traversal.Iterator;

public class SymbolTableImpl implements SymbolTable {

    private int numNestedBlocks;
    private final SymbolHashTable table;

    public SymbolTableImpl() {
        numNestedBlocks = 0;
        table = new SymbolHashTable();
    }


    public void getIn() {
        numNestedBlocks++;
    }


    public void goOut() {
        List<String> ids2Delete = new LinkedList<String>();
        Iterator<String> ids = table.keys();
        while (ids.hasNext()) {
            String id = ids.next();
            Stack<SymbolProperties> stack = table.get(id);
            SymbolProperties props = stack.peek();
            if (props.getBlock() == numNestedBlocks) {
                stack.pop();
                if (stack.isEmpty())
                    ids2Delete.insertEnd(id);
            }
        }
        ids = ids2Delete.values();
        while (ids.hasNext()) {
            String id = ids.next();
            table.delete(id);
        }
    }


    public void register(String id, Category category, Type type, int size) {
        id = id.toLowerCase();
        SymbolProperties props = new SymbolProperties(numNestedBlocks, category, type, size);
        Stack<SymbolProperties> stack = table.get(id);
        if (stack == null) {
            stack = new LinkedStack<SymbolProperties>();
            table.put(id, stack);
        }
        stack.push(props);
    }

    public SymbolProperties get(String id) {
        id = id.toLowerCase();
        Stack<SymbolProperties> stack = table.get(id);
        if (stack == null)
            return null;
        return stack.peek();
    }

}
