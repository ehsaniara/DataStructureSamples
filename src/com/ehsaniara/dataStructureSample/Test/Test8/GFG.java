package com.ehsaniara.dataStructureSample.Test.Test8;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Ehsaniara (Jay.Ara) on 9/12/17.
 * From https://www.ehsaniara.com
 * <h2>Length of the longest substring without repeating characters</h2>
 * Given a string, find the length of the longest substring without repeating characters.
 * For example, the longest substrings without repeating characters for “ABDEFGABEF” are “BDEFGA” and “DEFGAB”, with length 6.
 * For “BBBB” the longest substring is “B”, with length 1. For “GEEKSFORGEEKS”, there are two longest substrings shown in the below diagrams, with length 7.
 */
public class GFG {
    public static void main(String[] args) {
        //code
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            String inStr = sc.next();
            new GFG().subString(inStr);
        }
    }

    void subString(String str) {
        int max = 0;
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                String tmp = str.substring(i, j);

                Set<Character> set = new HashSet<>();
                StringBuilder sb = new StringBuilder();
                for (int k = 0; k < tmp.length(); k++)
                    if (set.add(tmp.charAt(k))) // to remove the duplicates, if char exist return false
                        sb.append(tmp.charAt(k));


                if (str.contains(sb.toString()))
                    if (sb.toString().length() > max)
                        max = sb.toString().length();

            }
        }


        System.out.println(max);

    }
}
