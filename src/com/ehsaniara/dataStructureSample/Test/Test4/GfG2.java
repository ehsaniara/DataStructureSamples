package com.ehsaniara.dataStructureSample.Test.Test4;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jason Ara (Jay.Ara) on 9/16/17.
 * From https://www.exapot.com
 */
public class GfG2 {
    public static void main(String[] args) {
        String str = "sample string";
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (char c : str.toCharArray()) {
            map.put(c, map.get(c) == null ? 1 : map.get(c) + 1);
            int counter = map.get(c);
            if (counter > max) {
                max = counter;
            }
        }

        System.out.println("Max occurring character:" + max);

    }
}
