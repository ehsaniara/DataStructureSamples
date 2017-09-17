package com.ehsaniara.dataStructureSample;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Ehsaniara (Jay.Ara) on 9/12/17.
 * From https://www.ehsaniara.com
 * <h1>Median of two sorted arrays</h1>
 * Question: There are 2 sorted arrays A and B of size n each. Write an algorithm to find the median of the array obtained after merging the above 2 arrays(i.e. array of length 2n). The complexity should be O(log(n))
 * <p>
 * Median: In probability theory and statistics, a median is described as the number separating the higher half of a sample, a population, or a probability distribution, from the lower half.
 * The median of a finite list of numbers can be found by arranging all the numbers from lowest value to highest value and picking the middle one.
 * <p>
 * For getting the median of input array { 12, 11, 15, 10, 20 }, first sort the array. We get { 10, 11, 12, 15, 20 } after sorting. Median is the middle element of the sorted array which is 12.
 * <p>
 * There are different conventions to take median of an array with even number of elements, one can take the mean of the two middle values, or first middle value, or second middle value.
 * <p>
 * Let us see different methods to get the median of two sorted arrays of size n each. Since size of the set for which we are looking for median is even (2n), we take average of middle two numbers in all below solutions and return floor of the average.
 */
public class MergeTowArrayAndGetMedian {


    int medianCalculator(int[] arr) {
        int medIndex = 0;
        if (arr.length == 0)
            return -1;
        //should be sorted
        Arrays.sort(arr);
        show(arr);
        //Since size of the set for which we are looking for median is even (2n), we take average of middle two numbers in all below solutions and return floor of the average.

        medIndex = arr.length / 2;
        if (arr.length % 2 == 0) {
            return (arr[medIndex] + arr[medIndex - 1]) / 2;
        } else {
            return arr[medIndex];
        }
    }

    int[] mergeArrays(int[] a, int[] b) {
        Set<Integer> res = new HashSet<>();
        for (int i : a) {
            res.add(i);
        }
        for (int i : b) {
            res.add(i);
        }
        //Java 1.8 or later
        return res.stream().mapToInt(Number::intValue).toArray();
    }

    public void show(int arr[]) {
        for (int anArr : arr)
            System.out.print(anArr + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr1 = {12, 11, 15, 10, 20, 9};
        int[] arr2 = {10, 30, 21, 29, 13, 12};

        MergeTowArrayAndGetMedian mtaagm = new MergeTowArrayAndGetMedian();

        int[] merged = mtaagm.mergeArrays(arr1, arr2);
        System.out.println("Median is " + mtaagm.medianCalculator(merged));
    }

}
