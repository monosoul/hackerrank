package com.hackerrank.monosoul.appleandorange;

import java.util.*;

import static java.util.stream.IntStream.of;

/**
 * https://www.hackerrank.com/challenges/apple-and-orange/problem
 */
public class Solution {

    static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {
        System.out.println(countWins(s ,t , a, apples));
        System.out.println(countWins(s ,t , b, oranges));
    }

    private static long countWins(int s, int t, int treePos, final int[] fruits) {
        return of(fruits).filter(x -> {
            final int pos = treePos + x;
            return s <= pos && pos <= t;
        }).count();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int t = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int m = in.nextInt();
        int n = in.nextInt();
        int[] apple = new int[m];
        for(int apple_i = 0; apple_i < m; apple_i++){
            apple[apple_i] = in.nextInt();
        }
        int[] orange = new int[n];
        for(int orange_i = 0; orange_i < n; orange_i++){
            orange[orange_i] = in.nextInt();
        }
        countApplesAndOranges(s, t, a, b, apple, orange);
        in.close();
    }
}
