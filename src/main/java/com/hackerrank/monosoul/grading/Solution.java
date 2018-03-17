package com.hackerrank.monosoul.grading;

import static java.util.stream.IntStream.of;
import java.util.*;

/**
 * https://www.hackerrank.com/challenges/grading/problem
 */
public class Solution {

    static int[] solve(int[] grades) {
        return of(grades).map(x -> {
            if (x < 38) return x;
            final int leftover = x % 5;
            if (leftover < 3) return x;
            return x + 5 - leftover;
        }).toArray();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] grades = new int[n];
        for (int grades_i = 0; grades_i < n; grades_i++) {
            grades[grades_i] = in.nextInt();
        }
        int[] result = solve(grades);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
        }
        System.out.println("");
    }
}

