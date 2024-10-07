package edu.uoc.ds.samples.module7;

import edu.uoc.ds.adt.helpers.KeyValue;
import edu.uoc.ds.adt.nonlinear.DictionaryAVLImpl;
import edu.uoc.ds.traversal.Iterator;
import edu.uoc.ds.traversal.IteratorTraversalValuesImpl;
import edu.uoc.ds.traversal.Traversal;

public class ExtendedDictionary<K, V> extends DictionaryAVLImpl<K, V> {

    public Iterator<V> values(K start, K end) {
        Traversal<KeyValue<K, V>> range = new RangeTraversal(avl.inOrderTraversal(), start, end);

        return new IteratorTraversalValuesImpl<K, V>(range);
    }
}
