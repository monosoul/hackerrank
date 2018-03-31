package com.hackerrank.monosoul.lisaworkbook;

import java.util.*;

public class Solution {

    static int workbook(int k, int[] arr) {
        int count = 0;
        int page = 1;
        for (final int t : arr) {
            final int pages = (t - 1) / k + 1;
            count += countSpecial(page, pages, k, t);
            page += pages;
        }

        return count;
    }

    private static int countSpecial(int page, int pages, int k, int t) {
        int count = 0;
        for (int i = 0, curPage = page; i < pages; i++, curPage++) {
            final int index = k * i;
            if (curPage > index && curPage <= index + k && curPage <= t) count++;
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        for (int arr_i = 0; arr_i < n; arr_i++) {
            arr[arr_i] = in.nextInt();
        }
        int result = workbook(k, arr);
        System.out.println(result);
        in.close();
    }
}

