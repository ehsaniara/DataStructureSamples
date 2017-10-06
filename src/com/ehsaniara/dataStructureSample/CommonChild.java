package com.ehsaniara.dataStructureSample;

import java.util.Scanner;

/**
 * Created by Ehsaniara (Jay.Ara) on 9/19/17.
 * From http://www.ehsaniara.com
 * <p>
 * <h1>Longest Common Child (or String)</h1>
 * Given two strings  and  of equal length, what's the longest string () that can be constructed such that it is a child of both?
 * <p>
 * A string  is said to be a child of a string  if  can be formed by deleting 0 or more characters from .
 * <p>
 * For example, ABCD and ABDC has two children with maximum length 3, ABC and ABD. Note that we will not consider ABCD as a common child because C doesn't occur before D in the second string.
 */
public class CommonChild {

    //this method takes to much resources
    int longestCommonChild(String s1, String s2, int m, int n) {
        if (m == 0 || n == 0)
            return 0;
        if (s1.charAt(m - 1) == s2.charAt(n - 1))
            return 1 + longestCommonChild(s1, s2, m - 1, n - 1);
        else
            return max(longestCommonChild(s1, s2, m, n - 1), longestCommonChild(s1, s2, m - 1, n));
    }

    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    /*Alternative solution: following is a partial recursion tree for input strings*/
    int lcs(char[] X, char[] Y, int m, int n) {
        int L[][] = new int[m + 1][n + 1];

    /* Following steps build L[m+1][n+1] in bottom up fashion. Note
         that L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1] */
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    L[i][j] = 0;
                else if (X[i - 1] == Y[j - 1])
                    L[i][j] = L[i - 1][j - 1] + 1;
                else
                    L[i][j] = max(L[i - 1][j], L[i][j - 1]);
            }
        }
        return L[m][n];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.next();
        String s2 = in.next();
        //int result = new CommonChild().longestCommonChild(s1, s2, s1.length(), s2.length());

        int result = new CommonChild().lcs(s1.toCharArray(), s2.toCharArray(), s1.length(), s2.length());
        System.out.println(result);
    }
}
