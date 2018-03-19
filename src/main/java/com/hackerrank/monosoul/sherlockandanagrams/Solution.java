package com.hackerrank.monosoul.sherlockandanagrams;

import static java.util.Arrays.copyOfRange;
import static java.util.Arrays.sort;
import java.util.*;

/**
 * https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem
 */
public class Solution {

    static int sherlockAndAnagrams(String s) {
        return countSubstrings(s).values().stream().filter(x -> x > 1).mapToInt(x -> x * (x - 1) / 2).sum();
    }

    private static Map<Integer, Integer> countSubstrings(final String s) {
        final Map<Integer, Integer> result = new HashMap<>();
        final char[] sArr = s.toCharArray();
        for (int i = 0; i < sArr.length; i++) {
            for (int j = 0; j + i < sArr.length; j++) {
                final char[] substr = copyOfRange(sArr, j, j + i + 1);
                sort(substr);
                put(
                        result,
                        Arrays.hashCode(substr)
                );
            }
        }

        return result;
    }

    private static void put(final Map<Integer, Integer> map, final Integer value) {
        if (!map.containsKey(value)) {
            map.put(value, 1);
            return;
        }
        map.put(value, map.get(value) + 1);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for (int a0 = 0; a0 < q; a0++) {
            String s = in.next();
            int result = sherlockAndAnagrams(s);
            System.out.println(result);
        }
    }
}

