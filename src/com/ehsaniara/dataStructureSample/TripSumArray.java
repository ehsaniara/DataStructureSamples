package com.ehsaniara.dataStructureSample;

import java.util.Arrays;

/**
 * Created by Ehsaniara (Jay.Ara) on 9/29/17.
 * From http://www.ehsaniara.com
 */
public class TripSumArray {


    public static void main(String[] args) {
        int array[] = {-1, 0, 1, 2, -1, -4};
        Arrays.sort(array);

        for (int i = 0; i < array.length - 2; i++) {
            if (i == 0 || array[i] > array[i - 1]) {
                int j = i + 1;
                int k = array.length - 1;

                while (j < k) {
                    if (array[i] + array[j] + array[k] == 0) {

                        System.out.println(" Numbers are:" + array[i] + " " + array[j] + " " + array[k]);

                        j++;
                        k--;

                        //handle duplicate here
                        while (j < k && array[j] == array[j - 1])
                            j++;
                        while (j < k && array[k] == array[k + 1])
                            k--;

                    } else if (array[i] + array[j] + array[k] < 0) {
                        j++;
                    } else {
                        k--;
                    }
                }
            }

        }

    }
}
