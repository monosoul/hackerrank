package com.hackerrank.monosoul.sherlockandanagrams;

import static java.util.stream.Collectors.toList;
import java.util.*;

/**
 * https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem
 */
public class Solution {

    static int sherlockAndAnagrams(String s) {
        return countSubstrings(s).values().stream().filter(x -> x > 1).mapToInt(x -> x * (x - 1) / 2).sum();
    }

    private static Map<List<Integer>, Integer> countSubstrings(final String s) {
        final Map<List<Integer>, Integer> result = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j + i < s.length(); j++) {
                put(
                        result,
                        s.substring(j, j + i + 1).chars().sorted().boxed().collect(toList())
                );
            }
        }

        return result;
    }

    private static void put(final Map<List<Integer>, Integer> map, final List<Integer> value) {
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
