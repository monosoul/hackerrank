package com.hackerrank.monosoul.comparethetriplets;

import java.util.*;

/**
 * https://www.hackerrank.com/challenges/compare-the-triplets/problem
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        final Triplet alice = new Triplet(in.nextInt(), in.nextInt(), in.nextInt());
        final Triplet bob = new Triplet(in.nextInt(), in.nextInt(), in.nextInt());
        int[] result = alice.compareTo(bob);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");


    }

    static class Triplet {
        final private int[] triplet;

        public Triplet(int a, int b, int c) {
            triplet = new int[]{a, b, c};
        }

        public Triplet(int[] triplet) {
            assert triplet.length == 3;
            this.triplet = triplet;
        }

        public int[] compareTo(final Triplet o) {
            assert triplet.length == o.triplet.length;
            int aResult = 0;
            int bResult = 0;

            for (int i = 0; i < triplet.length; i++) {
                int a = triplet[i];
                int b = o.triplet[i];

                if (a > b) aResult++;
                if (a < b) bResult++;
            }

            return new int[]{aResult, bResult};
        }
    }
}

