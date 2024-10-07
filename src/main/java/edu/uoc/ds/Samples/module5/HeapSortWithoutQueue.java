package edu.uoc.ds.samples.module5;

import edu.uoc.ds.algorithms.SortingAlgorithm;

public class HeapSortWithoutQueue<E> implements SortingAlgorithm<E> {


    public void sort(E[] vector, int n) {
        newHeap(vector, n);
        consumeHeap(vector, n);
    }


    private void newHeap(E[] vector, int n) {
        for (int i = n / 2; i >= 0; i--)
            shiftDown(vector, i, n);
    }


    private void consumeHeap(E[] vector, int n) {
        for (int i = n - 1; i >= 0; i--) {
            swap(vector, 0, i);
            shiftDown(vector, 0, i);
        }
    }


    final private void shiftDown(E[] vector, int i, int n) {
        if (i * 2 + 1 < n) {
            int child = selectChildToSwap(vector, i, n);
            if (compare(vector, i, child) < 0) {
                swap(vector, i, child);
                shiftDown(vector, child, n);
            }
        }
    }


    final private int selectChildToSwap(E[] vector, int i, int n) {
        int hi = i * 2 + 1;
        int hd = i * 2 + 2;
        if (hd >= n) return hi;
        return compare(vector, hi, hd) > 0 ? hi : hd;
    }


    final private int compare(E[] vector, int i, int j) {
        return ((Comparable<E>) vector[i]).compareTo(vector[j]);
    }


    final private int compare(E a, E b) {
        return ((Comparable<E>) a).compareTo(b);
    }


    final private void swap(E[] vector, int i, int j) {
        E aux = vector[i];
        vector[i] = vector[j];
        vector[j] = aux;
    }


}
