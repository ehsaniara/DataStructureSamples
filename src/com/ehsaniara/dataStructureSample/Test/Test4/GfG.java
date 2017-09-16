package com.ehsaniara.dataStructureSample.Test.Test4;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Jason Ara (Jay.Ara) on 9/16/17.
 * From https://www.exapot.com
 */
public class GfG {

    public static void main(String[] args) {
        String str = "nice string sample";
        Map<Character, Integer> map = new HashMap<>(); // may be there is more than 1 char occurring
        int max = 0;
        for (char c : str.toCharArray()) {
            map.put(c, map.get(c) == null ? 1 : map.get(c) + 1);
            int counter = map.get(c);
            if (counter > max) {
                max = counter;
            }
        }

        final int finalMax = max;
        System.out.println("Max occurring character:" + map.entrySet()
                .stream()
                .filter(entry -> entry.getValue().equals(finalMax))
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet()) + " " + max + " times");

    }
}
