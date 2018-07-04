package com.hackerrank.monosoul.crush;

import static java.lang.Integer.parseInt;
import static java.util.Arrays.stream;
import java.io.*;
import java.util.*;

/**
 * https://www.hackerrank.com/challenges/crush/problem
 */
public class Solution {

    private static final Scanner SCANNER = new Scanner(System.in);

    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, final List<Query> queries) {
        final long[] arr = new long[n];

        for (final Query query : queries) {
            for (int j = query.getLeft(); j <= query.getRight(); j++) {
                arr[j - 1] = arr[j - 1] + query.getValue();
            }
        }

        return stream(arr).max().orElse(0);
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = SCANNER.nextLine().split(" ");

        int n = parseInt(nm[0]);

        int m = parseInt(nm[1]);

        final List<Query> queries = new ArrayList<>(m);

        for (int i = 0; i < m; i++) {
            queries.add(
                    new Query(
                            SCANNER.nextLine().split(" ")
                    )
            );
            SCANNER.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        }

        long result = arrayManipulation(n, queries);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        SCANNER.close();
    }

    static class Query {

        final private int left;
        final private int right;
        final private int value;

        Query(final int left, final int right, final int value) {
            this.left = left;
            this.right = right;
            this.value = value;
        }

        Query(final String[] a) {
            this(parseInt(a[0]), parseInt(a[1]), parseInt(a[2]));
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
            final StringBuffer sb = new StringBuffer("Query{");
            sb.append("left=").append(left);
            sb.append(", right=").append(right);
            sb.append(", value=").append(value);
            sb.append('}');
            return sb.toString();
        }
    }
}
