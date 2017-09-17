package com.ehsaniara.dataStructureSample.Test.Test7;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Ehsaniara (Jay.Ara) on 9/12/17.
 * From https://www.ehsaniara.com
 */
public class GFG {
    public static void main(String[] args) {
        //code
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int size = sc.nextInt();
            int arr[] = new int[size];
            for (int index = 0; index < size; index++) {
                arr[index] = sc.nextInt();
            }
            System.out.println(new GFG().medianCalculator(arr));
        }
    }

    int medianCalculator(int[] arr) {
        int medIndex = 0;
        if (arr.length == 0)
            return -1;
        //should be sorted
        Arrays.sort(arr);

        medIndex = arr.length / 2;
        if (arr.length % 2 == 0) {

            return (arr[medIndex] + arr[medIndex - 1]) / 2;

        } else {
            return arr[medIndex];
        }
    }
}
