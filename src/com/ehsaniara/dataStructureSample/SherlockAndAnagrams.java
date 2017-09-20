package com.ehsaniara.dataStructureSample;

import java.util.*;

/**
 * Created by Jason Ara (Jay.Ara) on 9/19/17.
 * From https://www.exapot.com
 * <h1>Sherlock and Anagrams</h1>
 * <p>
 * Given a string <b>S</b>, find the number of "unordered anagrammatic pairs" of substrings. In other words, find the number of unordered pairs of substrings of <b>S</b> that are anagrams of each other.
 * <p>
 * Two strings are anagrams of each other if the letters of one string can be rearranged to form the other string.
 * <p>
 * Input Format
 * First line contains , the number of testcases. Each testcase consists of string  in one line.
 * <p>
 * Constraints
 * <p>
 * <p>
 * String  contains only the lowercase letters of the English alphabet.
 * <p>
 * Output Format
 * For each testcase, print the required answer in one line.
 * <p>
 * Sample Input 0
 * <p>
 * 2
 * abba
 * abcd
 * Sample Output 0
 * <p>
 * 4
 * 0
 */

public class SherlockAndAnagrams {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        for (int k = 0; k < x; k++) {

            System.out.println(new SherlockAndAnagrams().sherlockAndAnagrams(sc.next()));
        }
    }

    int sherlockAndAnagrams(String s) {
        Map<Integer, ArrayList<String>> sub = getSub(s);
        int counter = 0;
        for (int t = 1; t <= s.length(); t++) {
            List<String> subList = sub.get(t);
            for (int i = 0; i < subList.size() - 1; i++) {
                for (int j = i + 1; j < subList.size(); j++) {
                    if (isAnagram(subList.get(j), subList.get(i))) {
                        counter++;
                    }
                }
            }
        }
        return counter;
    }


    public Map<Integer, ArrayList<String>> getSub(String s) {
        Map<Integer, ArrayList<String>> ret = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (!ret.containsKey(s.substring(i, j + 1).length())) {
                    ArrayList<String> x = new ArrayList<>();
                    x.add(s.substring(i, j + 1));
                    ret.put(s.substring(i, j + 1).length(), x);
                } else
                    ret.get(s.substring(i, j + 1).length()).add(s.substring(i, j + 1));
            }
        }
        return ret;
    }

    public boolean isAnagram(String a1, String a2) {
        int count1[] = new int[26];
        int count2[] = new int[26];
        if (a1.length() != a2.length())
            return false;
        for (int i = 0; i < a1.length(); i++) {
            count1[(int) a1.charAt(i) - 97]++;
            count2[(int) a2.charAt(i) - 97]++;
        }
        for (int i = 0; i < 26; i++) {
            if (count1[i] != count2[i])
                return false;
        }
        return true;
    }
}
