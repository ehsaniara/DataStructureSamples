package com.ehsaniara.dataStructureSample.Test;


import java.util.*;

/**
 * Created by Ehsaniara (Jay.Ara) on 9/19/17.
 * From http://www.ehsaniara.com
 */
public class Test_3 {


    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        String inStr = null;
        while (inStr == null || inStr.length() < 1) {
            inStr = in.nextLine();
            inStr = inStr.trim();
        }


        List<Long> arr = new ArrayList<>();
        for (String element : inStr.split(" ")) {
            long i = Long.parseLong(element);
            arr.add(i);
        }

        Collections.sort(arr);


        for (Long element : arr) {
            System.out.print(element + " ");
        }

        in.close();
    }
}
