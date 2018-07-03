package com.hackerrank.monosoul.minimumswapsthesecond;

import static java.util.Arrays.copyOf;
import static java.util.Arrays.sort;
import static java.util.stream.IntStream.of;
import java.io.*;
import java.util.*;

/**
 * https://www.hackerrank.com/challenges/minimum-swaps-2/problem
 */
public class Solution {

    private static final Scanner SCANNER = new Scanner(System.in);

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
        final ArraySwapper swapper = new ArraySwapper(arr);
        final int[] sortedArr = copyOf(arr, arr.length);
        sort(sortedArr);

        int swapCount = 0;
        for (int i = 0; i < sortedArr.length; i++) {
            if (swapper.swap(sortedArr[i], i)) swapCount++;
        }

        return swapCount;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = SCANNER.nextInt();
        SCANNER.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = SCANNER.nextLine().split(" ");
        SCANNER.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = minimumSwaps(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        SCANNER.close();
    }

    static class ArraySwapper {
        private int index = 0;
        private final int[] arr;
        private final Map<Integer, Set<Integer>> map;

        ArraySwapper(final int[] arr) {
            this.arr = new int[arr.length];
            this.map = new HashMap<>();
            of(arr).forEachOrdered(this::put);
        }

        private void put(final Integer key, final Integer value) {
            if (!map.containsKey(key)) {
                map.put(key, new HashSet<>());
            }

            map.get(key).add(value);
            arr[value] = key;
        }

        private void put(final Integer value) {
            put(value, index++);
        }

        Boolean swap(final Integer num, final Integer newPos) {
            if (map.get(num).contains(newPos)) return false;

            final Integer num1Pos = popPos(num);
            final Integer num2 = arr[newPos];
            popPos(num2);


            put(num, newPos);
            put(num2, num1Pos);
            return true;
        }

        private Integer popPos(final Integer num) {
            final Iterator<Integer> posIterator = map.get(num).iterator();
            final Integer pos = posIterator.next();
            posIterator.remove();

            return pos;
        }

        public int[] getArr() {
            return arr;
        }
    }
}

