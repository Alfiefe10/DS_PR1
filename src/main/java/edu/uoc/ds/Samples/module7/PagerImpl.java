package edu.uoc.ds.samples.module7;


import edu.uoc.ds.traversal.Iterator;

public class PagerImpl<K, V> implements Pager<K, V> {
    private final ExtendedDictionary<K, V> pagesDictionary;

    public PagerImpl() {
        pagesDictionary = new ExtendedDictionary<>();
    }

    @Override
    public void put(K key, V value) {
        pagesDictionary.put(key, value);
    }

    @Override
    public Iterator<V> pager(K start, K end) {
        return pagesDictionary.values(start, end);
    }
}
