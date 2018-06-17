package com.hackerrank.monosoul.crackingthecodinginterview.ctcibubblesort;

import java.util.*;

/**
 * https://www.hackerrank.com/challenges/ctci-bubble-sort/problem
 */
public class Solution {

    private static final Scanner SCANNER = new Scanner(System.in);

    // Complete the countSwaps function below.
    static void countSwaps(int[] a) {
        final int swaps = bubbleSortCountingSwaps(a);
        System.out.printf("Array is sorted in %d swaps.\n", swaps);
        System.out.printf("First Element: %d\n", a[0]);
        System.out.printf("Last Element: %d\n", a[a.length-1]);
    }

    static int bubbleSortCountingSwaps(final int[] a) {
        final int n = a.length;
        int count = 0;
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n - 1; j++) {
                // Swap adjacent elements if they are in decreasing order
                if (a[j] > a[j + 1]) {
                    swap(a, j, j+1);
                    count++;
                }
            }

        }

        return count;
    }

    private static void swap(final int[] arr, final int index1, final int index2) {
        final int val = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = val;
    }

    public static void main(String[] args) {
        int n = SCANNER.nextInt();
        SCANNER.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] a = new int[n];

        String[] aItems = SCANNER.nextLine().split(" ");
        SCANNER.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        countSwaps(a);

        SCANNER.close();
    }
}

