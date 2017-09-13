package com.ehsaniara.dataStructureSample;

/**
 * Created by Jason Ara (Jay.Ara) on 9/12/17.
 * From https://www.exapot.com
 */
public class Factorial {
    /**
     * this function returns the n!
     * domain: numbers are between 0 and n 20
     */
    public long factorial(long n) {
        if (n < 0) throw new RuntimeException("Underflow error in factorial");
        else if (n > 20) throw new RuntimeException("Overflow error in factorial");
        else if (n == 0) return 1;
        else return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(new Factorial().factorial(20));
    }
}
