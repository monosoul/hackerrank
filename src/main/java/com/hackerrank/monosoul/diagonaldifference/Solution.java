package com.hackerrank.monosoul.diagonaldifference;

import java.util.*;

import static java.lang.Math.abs;

/**
 * https://www.hackerrank.com/challenges/diagonal-difference/problem
 */
public class Solution {

    static int diagonalDifference(int[][] a) {
        return abs(diagonalSum(a, false) - diagonalSum(a, true));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] a = new int[n][n];
        for(int a_i = 0; a_i < n; a_i++){
            for(int a_j = 0; a_j < n; a_j++){
                a[a_i][a_j] = in.nextInt();
            }
        }
        int result = diagonalDifference(a);
        System.out.println(result);
        in.close();
    }

    private static int diagonalSum(int[][] arr, boolean reversed) {
        int sum = 0;
        int revCol = reversed ? 0 : arr.length-1;
        int shift = reversed ? 1 : -1;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i][revCol];
            revCol += shift;
        }

        return sum;
    }
}
