package com.ehsaniara.dataStructureSample.BubbleSort;

/**
 * Created by Jason Ara (Jay.Ara) on 9/13/17.
 * From https://www.exapot.com
 */
public class BubbleSort {

    public void sort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++)
            for (int j = 0; j < arr.length - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
    }

    public void show(int arr[]) {
        for (int anArr : arr)
            System.out.print(anArr + " ");
        System.out.println();
    }


    public static void main(String args[]) {
        BubbleSort ob = new BubbleSort();
        int arr[] = {64, 34, 25, 12, 22, 11, 90};
        ob.sort(arr);
        ob.show(arr);
    }
}
