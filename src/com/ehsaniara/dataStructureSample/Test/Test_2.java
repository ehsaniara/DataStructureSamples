package com.ehsaniara.dataStructureSample.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Ehsaniara (Jay.Ara) on 9/19/17.
 * From http://www.ehsaniara.com
 */
public class Test_2 {

    public static void main(String[] args) {

        SimpleDateFormat date12Format = new SimpleDateFormat("hh:mm:ssa");

        SimpleDateFormat date24Format = new SimpleDateFormat("HH:mm:ss");

        try {
            System.out.println(date24Format.format(date12Format.parse("07:05:45PM")));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Set<Integer> mm = new TreeSet<>();

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println(">" + mm.add(sc.nextInt()));
        }


    }
}
