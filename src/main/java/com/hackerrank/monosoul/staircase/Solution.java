package com.hackerrank.monosoul.staircase;

import java.util.*;

import static java.util.stream.IntStream.rangeClosed;

/**
 * https://www.hackerrank.com/challenges/staircase/problem
 */
public class Solution {

    static void staircase(int n) {
        final StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            appendChar(sb, ' ', n - i);
            appendChar(sb, '#', i);
            sb.append('\n');
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        staircase(n);
        in.close();
    }

    private static void appendChar(final StringBuilder sb, char c, int amount) {
        rangeClosed(1, amount).forEach(_num -> sb.append(c));
    }
}
