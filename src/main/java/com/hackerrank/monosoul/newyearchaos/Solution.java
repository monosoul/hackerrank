package com.hackerrank.monosoul.newyearchaos;

import java.util.*;

/**
 * https://www.hackerrank.com/challenges/new-year-chaos/problem
 */
public class Solution {

    private static final Scanner SCANNER = new Scanner(System.in);

    // Complete the minimumBribes function below.
    static int minimumBribes(final int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] - i - 1 > 2) return -1;
        }

        return bubbleSortAndCountSwaps(a);
    }

    static int bubbleSortAndCountSwaps(final int[] a) {
        int swaps = 0;

        while (true) {
            int iterSwaps = 0;

            for (int i = 0; i < a.length - 1; i++) {
                if (a[i] > a[i+1]) {
                    final int temp = a[i];
                    a[i] = a[i+1];
                    a[i+1] = temp;
                    iterSwaps++;
                }
            }
            swaps += iterSwaps;

            if (iterSwaps == 0) break;
        }

        return swaps;
    }

    static String printResult(final int result) {
        if (result < 0) {
            return "Too chaotic";
        }

        return Integer.toString(result);
    }

    public static void main(String[] args) {
        int t = SCANNER.nextInt();
        SCANNER.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = SCANNER.nextInt();
            SCANNER.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = SCANNER.nextLine().split(" ");
            SCANNER.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            System.out.println(
                    printResult(
                            minimumBribes(q)
                    )
            );
        }

        SCANNER.close();
    }
}

