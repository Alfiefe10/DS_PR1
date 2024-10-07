package edu.uoc.ds.samples.module6;

import edu.uoc.ds.adt.nonlinear.HashTable;
import edu.uoc.ds.adt.sequential.Stack;

class SymbolHashTable extends HashTable<String, Stack<SymbolProperties>> {

    private static final int SIZE = 1023;

    public SymbolHashTable() {
        super(SIZE);
    }

    protected int calculateIndex(String key) {
        int hash = 0;
        for (int i = 0; i < key.length(); i++)
            hash += ordinal(key.charAt(i));
        hash %= SIZE;
        return hash;
    }


    private int ordinal(char c) {
        if (c == '_') return 0;
        if (Character.isDigit(c)) return 1 + c - '0';
        return 11 + c - 'a';
    }

}
