package edu.uoc.ds.samples.module7;

import edu.uoc.ds.adt.helpers.KeyValue;
import edu.uoc.ds.adt.helpers.Position;
import edu.uoc.ds.exceptions.InvalidPositionException;
import edu.uoc.ds.traversal.Traversal;



public class RangeTraversal<K, V> implements Traversal<KeyValue<K, V>> {
    private final Traversal<KeyValue<K, V>> globalTraversal;
    private final K start;
    private final K end;
    private Position<KeyValue<K, V>> next;

    public RangeTraversal(Traversal traversal, K start, K end) {
        this.globalTraversal = traversal;
        this.start = start;
        this.end = end;
    }


    @Override
    public boolean hasNext() {
        if (next!=null) {
            return true;
        }

        while (globalTraversal.hasNext() && next==null) {
            Position<KeyValue<K, V>> aux = globalTraversal.next();
            if (isKey(aux.getElem().getKey())) {
                next = aux;
            }
        }
        return (next != null);
    }

    @Override
    public Position<KeyValue<K, V>> next() throws InvalidPositionException {
        Position<KeyValue<K, V>> aux = next;
        next = null;
        return aux;
    }

    private boolean isKey(K key) {
        return ((Comparable<K>)start).compareTo(key)<=0 && ((Comparable<K>)key).compareTo(end)<=0;
    }
}
