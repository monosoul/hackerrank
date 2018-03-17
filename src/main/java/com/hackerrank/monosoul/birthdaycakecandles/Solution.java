package com.hackerrank.monosoul.birthdaycakecandles;

import java.util.*;

/**
 * https://www.hackerrank.com/challenges/birthday-cake-candles/problem
 */
public class Solution {

    static int birthdayCakeCandles(int n, int[] ar) {
        int max = ar[0];
        int amount = 0;

        for (int i : ar) {
            if (i == max) amount++;
            if (i > max) {
                max = i;
                amount = 1;
            };
        }

        return amount;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = birthdayCakeCandles(n, ar);
        System.out.println(result);
    }
}
