package com.hackerrank.monosoul.appendanddelete;

import java.util.*;

/**
 * https://www.hackerrank.com/challenges/append-and-delete/problem
 */
public class Solution {

    static String appendAndDelete(String s, String t, int k) {
        if (s.length() + t.length() <= k) return "Yes";

        final MaxMinLength cLength = compareLength(s, t);
        final int total = swapsCount(s, t, cLength.getMin()) + cLength.getDiff();
        final int unusedActions = k - total;

        if (unusedActions >= t.length() * 2 ||
                (unusedActions >= 0 && (unusedActions % 2) == 0)) return "Yes";
        return "No";
    }

    private static int swapsCount(final String s, final String t, final int minLength) {
        int diffPosition = 0;
        for (; diffPosition < minLength; diffPosition++) {
            if (s.charAt(diffPosition) != t.charAt(diffPosition)) {
                break;
            }
        }

        return (minLength - diffPosition) * 2;
    }

    private static MaxMinLength compareLength(final String s, final String t) {
        if (s.length() > t.length()) {
            return new MaxMinLength(s.length(), t.length());
        }

        return new MaxMinLength(t.length(), s.length());
    }

    static class MaxMinLength {
        private final int max;
        private final int min;

        MaxMinLength(int max, int min) {
            this.max = max;
            this.min = min;
        }

        int getMax() {
            return max;
        }

        int getMin() {
            return min;
        }

        int getDiff() {
            return max - min;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String t = in.next();
        int k = in.nextInt();
        String result = appendAndDelete(s, t, k);
        System.out.println(result);
        in.close();
    }
}

