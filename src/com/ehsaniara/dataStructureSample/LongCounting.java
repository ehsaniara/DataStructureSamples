package com.ehsaniara.dataStructureSample;

import java.util.*;

/**
 * Created by Ehsaniara (Jay.Ara) on 9/12/17.
 * From https://www.ehsaniara.com
 * Challenge
 * Given a list of integers, can you count and output the number of times each value appears?
 * <p>
 * Hint: There is no need to sort the data, you just need to count it.
 * <p>
 * Input Format
 * There will be two lines of input:
 * <p>
 * - the size of the list
 * -  space-separated numbers that make up the list
 * Output Format
 * Output the number of times every number from 0 to 99 (inclusive) appears on the list.
 * <p>
 * Sample Input
 * <p>
 * 100
 * 63 25 73 1 98 73 56 84 86 57 16 83 8 25 81 56 9 53 98 67 99 12 83 89 80 91 39 86 76 85 74 39 25 90 59 10 94 32 44 3 89 30 27 79 46 96 27 32 18 21 92 69 81 40 40 34 68 78 24 87 42 69 23 41 78 22 6 90 99 89 50 30 20 1 43 3 70 95 33 46 44 9 69 48 33 60 65 16 82 67 61 32 21 79 75 75 13 87 70 33
 * Sample Output
 * <p>
 * 0 2 0 2 0 0 1 0 1 2 1 0 1 1 0 0 2 0 1 0 1 2 1 1 1 3 0 2 0 0 2 0 3 3 1 0 0 0 0 2 2 1 1 1 2 0 2 0 1 0 1 0 0 1 0 0 2 1 0 1 1 1 0 1 0 1 0 2 1 3 2 0 0 2 1 2 1 0 2 2 1 2 1 2 1 1 2 2 0 3 2 1 1 0 1 1 1 0 2 2
 * Explanation
 * <p>
 * The output states that 0 appears 0 times, 1 appears 2 times, 2 appears 0 times, and so on in the given input array.
 */
public class LongCounting {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        String inStr = null;
        while (inStr == null || inStr.length() < 1) {
            inStr = in.nextLine();
            inStr = inStr.trim();
        }

        long max = 0;

        List<Long> arr = new ArrayList<>();
        for (String element : inStr.split(" ")) {
            long i = Long.parseLong(element);
            arr.add(i);
            if (i > max)
                max = i;
        }

        Map<Long, Long> map = new TreeMap<>();

        for (Long element : arr) {
            Long res = map.get(element);
            if (res == null) {
                map.put(element, 1L);
            } else {
                map.put(element, res + 1);
            }
        }

        long i = 0;
        while (i <= max) {
            Long res = map.get(i);
            //System.out.print(i + ":");
            System.out.print((res == null ? 0 : res) + " ");
            i++;
        }

        in.close();
    }

}
