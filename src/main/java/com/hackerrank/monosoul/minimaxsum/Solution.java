package com.hackerrank.monosoul.minimaxsum;

import java.util.*;

import static java.util.Arrays.*;

/**
 * https://www.hackerrank.com/challenges/mini-max-sum/problem
 */
public class Solution {

    static void miniMaxSum(int[] arr) {
        sort(arr);
        System.out.println(
                sumFromTo(arr, 0, 4) + " " +
                        sumFromTo(arr, arr.length-1, arr.length - 5)
        );
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = new int[5];
        for(int arr_i = 0; arr_i < 5; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        miniMaxSum(arr);
        in.close();
    }

    private static long sumFromTo(final int[] arr, int startIndex, int endIndex) {
        long sum = 0L;
        final int step = startIndex <= endIndex ? 1 : -1;
        for (int i = startIndex; i != endIndex; i += step) {
            sum += arr[i];
        }
        return sum;
    }
}
