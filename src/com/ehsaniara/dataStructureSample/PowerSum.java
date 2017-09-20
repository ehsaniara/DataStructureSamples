package com.ehsaniara.dataStructureSample;

/**
 * Created by Ehsaniara (Jay.Ara) on 9/12/17.
 * From https://www.ehsaniara.com
 * Find the number of ways that a given integer, , can be expressed as the sum of the  power of unique, natural numbers.
 * <p>
 * Input Format
 * <p>
 * The first line contains an integer .
 * The second line contains an integer .
 * Constraints
 * <p>
 * <h4>Output Format</h4>
 * <p>
 * Output a single integer, the answer to the problem explained above.
 * <h4>Sample Input 0</h4>
 * <p>
 * 10
 * 2
 * <h4>Sample Output 0</h4>
 * <p>
 * 1
 */
public class PowerSum {
    public static void main(String[] args) {

        System.out.println(new PowerSum().calculate(100, 2, 1, 0));
    }

    int calculate(int x, int n, int currNum, int curSum) {
        // Initialize number of ways to express
        // x as n-th powers of different natural
        // numbers
        int results = 0;

        // Calling power of 'i' raised to 'n'
        int p = (int) Math.pow(currNum, n);
        while (p + curSum < x) {
            // Recursively check all greater values of i
            results += calculate(x, n, currNum + 1, p + curSum);
            currNum++;
            p = (int) Math.pow(currNum, n);
        }

        // If sum of powers is equal to x
        // then increase the value of result.
        if (p + curSum == x)
            results++;

        // Return the final result
        return results;
    }
}
