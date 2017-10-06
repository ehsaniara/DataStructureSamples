package com.ehsaniara.dataStructureSample;

import java.util.Vector;

/**
 * Created by Ehsaniara (Jay.Ara) on 9/17/17.
 * From http://www.ehsaniara.com
 */
public class Divisors {
    /**
     * For example if n = 100, then the various pairs of divisors are: (1,100), (2,50), (4,25), (5,20), (10,10)
     * <p>
     * Using this fact we could speed up our program significantly.
     * We, however have to careful if there are two equal divisors as in case of (10, 10). In such case we’d print only one of them.
     */
    void printDivisors(int n) {
        // Vector to store half of the divisors
        Vector<Integer> v = new Vector<>();
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                if (n / i == i) // check if divisors are equal
                    System.out.printf("%d ", i);
                else {
                    System.out.printf("%d ", i);

                    // push the second divisor in the vector
                    v.add(n / i);
                }
            }
        }

        // The vector will be printed in reverse
        for (int i = v.size() - 1; i >= 0; i--)
            System.out.printf("%d ", v.get(i));
    }

    public static void main(String[] args) {
        new Divisors().printDivisors(20);
    }
}
