package com.hackerrank.monosoul.crackingthecodinginterview.ctciransomnote;

import java.util.*;
import java.util.Map.Entry;

/**
 * https://www.hackerrank.com/challenges/ctci-ransom-note/problem
 */
public class Solution {

    private static final Scanner SCANNER = new Scanner(System.in);

    // Complete the checkMagazine function below.
    static String checkMagazine(String[] magazine, String[] note) {
        final Map<String, Integer> magazineWords = count(magazine);
        final Map<String, Integer> noteWords = count(note);

        for (final Entry<String, Integer> entry : noteWords.entrySet()) {
            if (!magazineWords.containsKey(entry.getKey()) || magazineWords.get(entry.getKey()) < entry.getValue()) {
                return "No";
            }
        }

        return "Yes";
    }

    private static <T> Map<T, Integer> count(final T[] objArr) {
        final Map<T, Integer> result = new HashMap<>();
        for (final T obj : objArr) {
            put(result, obj);
        }

        return result;
    }

    private static <T> void put(final Map<T, Integer> map, final T value) {
        if (!map.containsKey(value)) {
            map.put(value, 1);
            return;
        }
        map.put(value, map.get(value) + 1);
    }

    public static void main(String[] args) {
        String[] mn = SCANNER.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = SCANNER.nextLine().split(" ");
        SCANNER.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = SCANNER.nextLine().split(" ");
        SCANNER.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        SCANNER.close();

        System.out.println(checkMagazine(magazine, note));
    }
}