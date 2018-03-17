package com.hackerrank.monosoul.lilyshomework;

import java.util.*;

import static java.lang.Math.min;
import static java.util.Comparator.naturalOrder;
import static java.util.Comparator.reverseOrder;
import static java.util.stream.IntStream.of;

/**
 * https://www.hackerrank.com/challenges/lilys-homework/problem
 */
public class Solution {

    static int lilysHomework(int[] arr) {
        final int naturalOrderSwaps = getSwapCountForSorting(naturalOrder(), arr);
        final int reversedOrderSwaps = getSwapCountForSorting(reverseOrder(), arr);

        return min(naturalOrderSwaps, reversedOrderSwaps);
    }

    private static int getSwapCountForSorting(final Comparator<Integer> comparator, final int[] arr) {
        final ArraySwapper swapper = new ArraySwapper(arr);
        final int[] sortedArr = of(arr).boxed().sorted(comparator).mapToInt(x -> x).toArray();

        int swapCount = 0;
        for (int i = 0; i < sortedArr.length; i++) {
            final int value = sortedArr[i];
            if (swapper.swap(value, i)) swapCount++;
        }

        return swapCount;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        int result = lilysHomework(arr);
        System.out.println(result);
        in.close();
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
