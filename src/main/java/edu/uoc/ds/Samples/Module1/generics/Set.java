package edu.uoc.ds.samples.module1.generics;

import edu.uoc.ds.adt.sequential.Container;

public interface Set<E> extends Container<E> {
    void add(E e);
    boolean contains(E e);
    E delete(E e);
}
