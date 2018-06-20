package com.hackerrank.monosoul.crackingthecodinginterview.ctcilonelyinteger;

import java.util.*;

/**
 * https://www.hackerrank.com/challenges/ctci-lonely-integer/problem
 */
public class Solution {

    private static final Scanner SCANNER = new Scanner(System.in);

    static int findLonely(final int... a) {
        int value = 0;

        for (final int item : a) {
            value ^= item;
        }

        return value;
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

        SCANNER.close();

        System.out.println(findLonely(a));
    }
}

