package com.hackerrank.monosoul.ctcimakinganagrams;

import java.util.*;
import java.util.Map.Entry;

import static java.lang.Math.min;

/**
 * https://www.hackerrank.com/challenges/ctci-making-anagrams/problem
 */
public class Solution {

    private static final Scanner SCANNER = new Scanner(System.in);

    static int countDeletions(final String a, final String b) {
        return a.length() + b.length() - countSameChars(a, b) * 2;
    }

    static int countSameChars(final String a, final String b) {
        int count = 0;
        final Map<Integer, Integer> aMap = countChars(a);
        final Map<Integer, Integer> bMap = countChars(b);
        for (final Entry<Integer, Integer> entry : aMap.entrySet()) {
            if (bMap.containsKey(entry.getKey())) {
                count += min(bMap.get(entry.getKey()), entry.getValue());
            }
        }

        return count;
    }

    private static Map<Integer, Integer> countChars(final String input) {
        final Map<Integer, Integer> result = new HashMap<>();
        input.chars().forEach(c -> put(result, c));

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
        String a = SCANNER.nextLine();

        String b = SCANNER.nextLine();

        SCANNER.close();

        System.out.println(countDeletions(a, b));
    }
}

