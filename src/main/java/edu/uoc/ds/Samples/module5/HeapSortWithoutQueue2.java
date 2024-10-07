package edu.uoc.ds.samples.module5;

import edu.uoc.ds.algorithms.SortingAlgorithm;

public class HeapSortWithoutQueue2<E> implements SortingAlgorithm<E> {


    private int selectChildToSwap(E[] vector, int i, int n) {
        int hi = i * 2 + 1;
        int hd = i * 2 + 2;
        if (hd >= n) return hi;
        return compare(vector, hi, hd) > 0 ? hi : hd;
    }


    private int compare(E[] vector, int i, int j) {
        return ((Comparable<E>) vector[i]).compareTo(vector[j]);
    }


    private int compare(E a, E b) {
        return ((Comparable<E>) a).compareTo(b);
    }


    private void siftDown(E[] vector, int i, int n) {
        E temp = vector[i];
        boolean end = false;
        while (i * 2 + 1 <= n && !end) {
            int child = selectChildToSwap(vector, i, n);
            if (compare(temp, vector[child]) < 0) {
                vector[i] = vector[child];
                i = child;
            } else
                end = true;
        }
        vector[i] = temp;
    }


    private void add(E[] vector, int i, int n) {
        E tmp = vector[i];
        boolean end = false;
        while (i > 0 && !end) {
            int parent = (i - 1) / 2;
            if (compare(vector[parent], tmp) < 0) {
                vector[i] = vector[parent];
                i = parent;
            } else
                end = true;
        }
        vector[i] = tmp;
    }


    public void sort(E[] vector, int n) {
        for (int i = 1; i < n; i++)
            add(vector, i, n);
        for (int i = n - 1; i >= 1; i--) {
            E temp = vector[0];
            vector[0] = vector[i];
            vector[i] = temp;
            siftDown(vector, 0, i - 1);
        }
    }

}
