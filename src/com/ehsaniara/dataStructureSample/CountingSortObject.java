package com.ehsaniara.dataStructureSample;

import java.util.Scanner;

/**
 * Created by Ehsaniara (Jay.Ara) on 9/12/17.
 * From https://www.ehsaniara.com
 * <p>
 * In this challenge you need to print the data that accompanies each integer in a list. In addition, if two strings have the same integers, you need to print the strings in their original order. Hence, your sorting algorithm should be stable, i.e. the original order should be maintained for equal elements.
 * <p>
 * Insertion Sort and the simple version of Quicksort were stable, but the faster in-place version of Quicksort was not (since it scrambled around elements while sorting).
 * <p>
 * In cases where you care about the original order, it is important to use a stable sorting algorithm. In this challenge, you will use counting sort to sort a list while keeping the order of the strings (with the accompanying integer) preserved.
 * <p>
 * Challenge
 * In the previous challenge, you created a "helper array" that contains information about the starting position of each element in a sorted array. Can you use this array to help you create a sorted array of the original list?
 * <p>
 * Hint: You can go through the original array to access the strings. You can then use your helper array to help determine where to place those strings in the sorted array. Be careful about being one off.
 * <p>
 * Details and a Twist
 * You will be given a list that contains both integers and strings. Can you print the strings in order of their accompanying integers? If the integers for two strings are equal, ensure that they are print in the order they appeared in the original list.
 * <p>
 * The Twist - Your clients just called with an update. They don't want you to print the first half of the original array. Instead, they want you to print a dash for any element from the first half.
 * <p>
 * Sample Input
 * <p>
 * <br/>20
 * <br/>0 ab
 * <br/>6 cd
 * <br/>0 ef
 * <br/>6 gh
 * <br/>4 ij
 * <br/>0 ab
 * <br/>6 cd
 * <br/>0 ef
 * <br/>6 gh
 * <br/>0 ij
 * <br/>4 that
 * <br/>3 be
 * <br/>0 to
 * <br/>1 be
 * <br/>5 question
 * <br/>1 or
 * <br/>2 not
 * <br/>4 is
 * <br/>2 to
 * <br/>4 the
 * <h4>Sample Output</h4>
 * <p>
 * <br/>- - - - - to be or not to be - that is the question - - - -
 * Explanation
 * Below is the list in the correct order. The strings of each number were printed above for the second half of the array. Elements from the first half of the original array were replaced with dashes.
 * <p>
 * <br/>0 ab
 * <br/>0 ef
 * <br/>0 ab
 * <br/>0 ef
 * <br/>0 ij
 * <br/>0 to
 * <br/>1 be
 * <br/>1 or
 * <br/>2 not
 * <br/>2 to
 * <br/>3 be
 * <br/>4 ij
 * <br/>4 that
 * <br/>4 is
 * <br/>4 the
 * <br/>5 question
 * <br/>6 cd
 * <br/>6 gh
 * <br/>6 cd
 * <br/>6 gh
 */
public class CountingSortObject {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int size = Integer.parseInt(scan.nextLine());
        StringBuffer[] st = new StringBuffer[100];

        for (int i = 0; i < 100; i++) {
            st[i] = new StringBuffer();
        }

        for (int i = 0; i < size; i++) {
            String sts = scan.nextLine();
            String[] str = sts.split("[\\s]+");
            int k = Integer.parseInt(str[0]);
            String s;
            if (i < size / 2)
                s = "- ";
            else
                s = str[1] + " ";
            st[k] = st[k].append(s);
        }

        for (int i = 0; i < 100; i++) {
            System.out.print(st[i]);
        }
    }
}
