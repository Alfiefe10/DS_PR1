package edu.uoc.ds.samples.module7;


import edu.uoc.ds.traversal.Iterator;

public interface Pager<K, V> {
    void put (K key, V value);
    Iterator<V> pager(K start, K end);
}
