package com.hackerrank.monosoul.servicelane;

import static java.util.Arrays.stream;
import static java.util.stream.IntStream.rangeClosed;

import java.util.*;

public class Solution {

    static int[] serviceLane(int[] width, int[][] cases) {
        return stream(cases).mapToInt(x -> rangeClosed(x[0], x[1]).map(i -> width[i]).min().getAsInt()).toArray();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int t = in.nextInt();
        int[] width = new int[n];
        for(int width_i = 0; width_i < n; width_i++){
            width[width_i] = in.nextInt();
        }
        int[][] cases = new int[t][2];
        for(int cases_i = 0; cases_i < t; cases_i++){
            for(int cases_j = 0; cases_j < 2; cases_j++){
                cases[cases_i][cases_j] = in.nextInt();
            }
        }
        int[] result = serviceLane(width, cases);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
        }
        System.out.println("");


        in.close();
    }
}
