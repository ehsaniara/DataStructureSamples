package com.ehsaniara.dataStructureSample.Test;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Jason Ara (Jay.Ara) on 9/20/17.
 * From https://www.exapot.com
 */
public class Test_4 {
    public static void main(String[] args) {

        Map<Integer, Integer> map = new TreeMap<>();
        System.out.println(map.put(1, 0));
        System.out.println(map.put(1, 1));
        System.out.println(map.put(1, 3));
        System.out.println(map.put(2, 0));
        System.out.println(map.put(1, 5));
        System.out.println(map.put(1, 5));
    }
}
