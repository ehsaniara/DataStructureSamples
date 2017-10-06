package com.ehsaniara.dataStructureSample;

/**
 * Created by Ehsaniara (Jay.Ara) on 10/3/17.
 * From http://www.ehsaniara.com
 */
public class IntersectionTwoSortedArray {
    static void printIntersection(int arr1[], int arr2[]) {
        int i = 0, j = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j])
                i++;
            else if (arr2[j] < arr1[i])
                j++;
            else {
                System.out.print(arr2[j++] + " ");
                i++;
            }
        }
    }

    public static void main(String args[]) {
        int arr1[] = {1, 2, 4, 5, 6};
        int arr2[] = {2, 3, 5, 7};
        new IntersectionTwoSortedArray().printIntersection(arr1, arr2);
    }
}
