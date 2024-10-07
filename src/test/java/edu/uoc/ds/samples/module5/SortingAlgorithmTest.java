package edu.uoc.ds.samples.module5;

import edu.uoc.ds.algorithms.HeapSort;
import edu.uoc.ds.algorithms.MergeSort;
import edu.uoc.ds.algorithms.SortingAlgorithm;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;


public class SortingAlgorithmTest {

    @Test
    public void test() {
        SortingAlgorithm<Integer> mergeSort = new MergeSort<>();
        SortingAlgorithm<Integer> heapSortQueue = new HeapSort<>();
        SortingAlgorithm<Integer> heapSort = new HeapSortWithoutQueue<>();
        Integer[] vector1 = {40, 7, 18, 45, 24, 87, 90, 23, 41, 8, 9, 65, 23, 56, 70};
        Integer[] vector2 = {40, 7, 18, 45, 24, 87, 90, 23, 41, 8, 9, 65, 23, 56, 70};
        Integer[] vector3 = {40, 7, 18, 45, 24, 87, 90, 23, 41, 8, 9, 65, 23, 56, 70};

        Assert.assertArrayEquals(new Integer[]{40, 7, 18, 45, 24, 87, 90, 23, 41, 8, 9, 65, 23, 56, 70}, vector1);
        Assert.assertArrayEquals(new Integer[]{40, 7, 18, 45, 24, 87, 90, 23, 41, 8, 9, 65, 23, 56, 70}, vector2);
        Assert.assertArrayEquals(new Integer[]{40, 7, 18, 45, 24, 87, 90, 23, 41, 8, 9, 65, 23, 56, 70}, vector3);

        mergeSort.sort(vector1, 15);
        heapSortQueue.sort(vector2, 15);
        heapSort.sort(vector3, 15);

        // MergeSort
        Assert.assertArrayEquals(new Integer[]{7, 8, 9, 18, 23, 23, 24, 40, 41, 45, 56, 65, 70, 87, 90}, vector1);
        // HeapSort & Queue
        Assert.assertArrayEquals(new Integer[]{7, 8, 9, 18, 23, 23, 24, 40, 41, 45, 56, 65, 70, 87, 90}, vector2);
        // HeapSort & !Queue
        Assert.assertArrayEquals(new Integer[]{7, 8, 9, 18, 23, 23, 24, 40, 41, 45, 56, 65, 70, 87, 90}, vector3);

    }

}
