package com.ehsaniara.dataStructureSample.Test;

import java.util.Scanner;
import java.util.stream.Stream;

/**
 * Created by Jason Ara (Jay.Ara) on 9/17/17.
 * From https://www.exapot.com
 */
public class Test {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        /*int[][] arr = {
                {1, 1, 1, 0, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0},
                {0, 0, 2, 4, 4, 0},
                {0, 0, 0, 2, 0, 0},
                {0, 0, 1, 2, 4, 0}
        };*/
        int[][] arr = new int[6][6];

        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 6; i++) {
            String inStr = sc.nextLine();
            if (inStr != null)
                inStr = inStr.trim();
            int[] tmp = Stream.of(inStr.split(" ")).mapToInt(Integer::parseInt).toArray();
            arr[i] = tmp;
        }


        Test test = new Test();
        int max = test.getHourglassSum(arr, 0, 0), sum;
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++) {
                sum = test.getHourglassSum(arr, i, j);
                if (sum > max) {
                    max = sum;
                }
            }


        System.out.println(max);
    }

    int getHourglassSum(int[][] arr, int x, int y) {

        return arr[x][y] + arr[x][y + 1] + arr[x][y + 2]
                + arr[x + 1][y + 1]
                + arr[x + 2][y] + arr[x + 2][y + 1] + arr[x + 2][y + 2];
    }

}
