package com.hackerrank.monosoul.crush;

import static java.util.Arrays.stream;
import java.io.*;
import java.util.*;

/**
 * https://www.hackerrank.com/challenges/crush/problem
 */
public class Solution {

    private static final Scanner SCANNER = new Scanner(System.in);

    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {
        final long[] arr = new long[n];
        for (int i = 0; i < queries.length; i++) {
            final Operation operation = new Operation(queries[i]);

            for (int j = operation.getLeft(); j <= operation.getRight(); j++) {
                arr[j-1] = arr[j-1] + operation.getValue();
            }
        }

        return stream(arr).max().orElse(0);
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = SCANNER.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = SCANNER.nextLine().split(" ");
            SCANNER.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        SCANNER.close();
    }

    static class Operation {
        final private int left;
        final private int right;
        final private int value;

        Operation(final int left, final int right, final int value) {
            this.left = left;
            this.right = right;
            this.value = value;
        }

        Operation(final int[] a) {
            this.left = a[0];
            this.right = a[1];
            this.value = a[2];
        }

        public int getLeft() {
            return left;
        }

        public int getRight() {
            return right;
        }

        public int getValue() {
            return value;
        }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("Operation{");
            sb.append("left=").append(left);
            sb.append(", right=").append(right);
            sb.append(", value=").append(value);
            sb.append('}');
            return sb.toString();
        }
    }
}
