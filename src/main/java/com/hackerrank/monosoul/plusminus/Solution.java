package com.hackerrank.monosoul.plusminus;

import java.util.*;

/**
 * https://www.hackerrank.com/challenges/plus-minus/problem
 */
public class Solution {

    static void plusMinus(int[] arr) {
        int positive = 0;
        int negative = 0;
        int zeros = 0;
        for (int i : arr) {
            if (i > 0) {
                positive++;
                continue;
            }
            if (i < 0) {
                negative++;
                continue;
            }
            zeros++;
        }
        System.out.println(
                format(
                        calcPart(arr.length, positive)
                )
        );
        System.out.println(
                format(
                        calcPart(arr.length, negative)
                )
        );
        System.out.println(
                format(
                        calcPart(arr.length, zeros)
                )
        );
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        plusMinus(arr);
        in.close();
    }

    private static String format(final Float num) {
        return String.format("%.6f", num);
    }

    private static Float calcPart(int size, int amount) {
        return (float) amount / size;
    }
}