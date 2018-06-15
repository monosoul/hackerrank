package com.hackerrank.monosoul.ctcibalancedbrackets;

import java.util.*;

/**
 * https://www.hackerrank.com/challenges/ctci-balanced-brackets/problem
 */
public class Solution {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Map<Character, Character> BRACKET_PAIRS = new HashMap<>();

    static {
        BRACKET_PAIRS.put('(', ')');
        BRACKET_PAIRS.put('{', '}');
        BRACKET_PAIRS.put('[', ']');
    }

    static Boolean isBalanced(final String bracketString) {
        if ((bracketString.length() & 1) == 1) return false;

        final Deque<Character> stack = new ArrayDeque<>();

        for (final char c : bracketString.toCharArray()) {
            if (BRACKET_PAIRS.containsKey(c)) {
                stack.add(c);
                continue;
            }

            if (stack.isEmpty() || !BRACKET_PAIRS.get(stack.peekLast()).equals(c)) {
                return false;
            }

            stack.removeLast();
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        final int t = SCANNER.nextInt();
        SCANNER.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            System.out.println(isBalanced(SCANNER.nextLine()) ? "YES" : "NO");
        }

        SCANNER.close();
    }
}

