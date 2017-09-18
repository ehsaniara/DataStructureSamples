package com.ehsaniara.dataStructureSample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Ehsaniara (Jay.Ara) on 9/12/17.
 * From https://www.ehsaniara.com
 */
class Element {
    int number;
    int divisor;
    String name;

    Element(int number, int divisor, String name) {
        this.number = number;
        this.divisor = divisor;
        this.name = name;
    }

    @Override
    public String toString() {
        return "number:" + number + " divisor:" + divisor + " name:" + name;
    }
}

public class SortByObjectElement {

    public static void main(String[] args) {
        List<Element> list = new ArrayList<>();

        list.add(new Element(10, 2, "w"));
        list.add(new Element(6, 4, "r"));
        list.add(new Element(7, 12, "z"));
        list.add(new Element(5, 1, "b"));
        list.add(new Element(15, 3, "c"));

        //Sort By number
        Collections.sort(list, Comparator.comparingInt(o -> o.number));
        for (Element e : list) {
            System.out.println(e.toString());
        }

        System.out.println("-------------------------------");

        //Sort By name
        Collections.sort(list, Comparator.comparing(o -> o.name));
        for (Element e : list) {
            System.out.println(e.toString());
        }
    }
}
