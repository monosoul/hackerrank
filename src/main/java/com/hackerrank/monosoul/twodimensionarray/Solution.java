package com.hackerrank.monosoul.twodimensionarray;

import java.io.*;
import java.util.*;

/**
 * https://www.hackerrank.com/challenges/2d-array/problem
 */
public class Solution {

    private static final Scanner SCANNER = new Scanner(System.in);

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        int max = -63;

        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = 0; j < arr[i].length - 2; j++) {
                final int sum = hourglassSumAtPos(arr, j, i);
                if (max < sum) {
                    max = sum;
                }
            }
        }

        return max;
    }

    static int hourglassSumAtPos(final int[][] arr, final int x, final int y) {
        return arr[y][x] + arr[y][x+1] + arr[y][x+2]
                + arr[y+1][x+1]
                + arr[y+2][x] + arr[y+2][x+1] + arr[y+2][x+2];
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = SCANNER.nextLine().split(" ");
            SCANNER.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        SCANNER.close();
    }
}

