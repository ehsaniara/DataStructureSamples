package com.ehsaniara.dataStructureSample;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Ehsaniara (Jay.Ara) on 10/3/17.
 * From http://www.ehsaniara.com
 */
public class IntersectionTwoArray {
    public static void main(String[] args) {

        String s1 = "31745";
        String s2 = "6548";

        Set<Character> h1 = new HashSet<>(), h2 = new HashSet<>();
        for (int i = 0; i < s1.length(); i++) {
            h1.add(s1.charAt(i));
        }
        for (int i = 0; i < s2.length(); i++) {
            h2.add(s2.charAt(i));
        }
        h1.retainAll(h2);
        Character[] res = h1.toArray(new Character[0]);
        System.out.println(Arrays.toString(res));

    }
}
