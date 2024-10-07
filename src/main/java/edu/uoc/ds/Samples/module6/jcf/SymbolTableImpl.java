package edu.uoc.ds.samples.module6.jcf;

import java.util.*;

import edu.uoc.ds.samples.module6.SymbolProperties;
import edu.uoc.ds.samples.module6.SymbolTable;

public class SymbolTableImpl implements SymbolTable {

    private int numNestedBlocks;
    private final Map<String, Stack<SymbolProperties>> table;

    public SymbolTableImpl() {
        numNestedBlocks = 0;
        table = new SymbolHashtable();
    }


    public void getIn() {
        numNestedBlocks++;
    }


    public void goOut() {
        Collection<String> ids2Delete = new ArrayList<String>();
        Iterator<String> ids = table.keySet().iterator();
        while (ids.hasNext()) {
            String id = ids.next();
            Stack<SymbolProperties> stack = table.get(id);
            SymbolProperties props = stack.peek();
            if (props.getBlock() == numNestedBlocks) {
                stack.pop();
                if (stack.empty())
                    ids2Delete.add(id);
            }
        }
        ids = ids2Delete.iterator();
        while (ids.hasNext()) {
            String id = ids.next();
            table.remove(id);
        }
    }


    public void register(String id, SymbolProperties.Category category, SymbolProperties.Type type, int size) {
        id = id.toLowerCase();
        SymbolProperties props = new SymbolProperties(numNestedBlocks, category, type, size);
        Stack<SymbolProperties> pila = table.get(id);
        if (pila == null) {
            pila = new Stack<SymbolProperties>();
            table.put(id, pila);
        }
        pila.push(props);
    }

    public SymbolProperties get(String id) {
        id = id.toLowerCase();
        Stack<SymbolProperties> pila = table.get(id);
        if (pila == null)
            return null;
        return pila.peek();
    }

}
