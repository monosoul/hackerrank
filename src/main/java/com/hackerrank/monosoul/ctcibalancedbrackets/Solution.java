package com.hackerrank.monosoul.ctcibalancedbrackets;

import java.util.*;

/**
 * https://www.hackerrank.com/challenges/ctci-balanced-brackets/problem
 */
public class Solution {

    private static final Scanner SCANNER = new Scanner(System.in);

    static Boolean isBalanced(final String bracketString) {
        final Deque<Character> stack = new ArrayDeque<>();

        for (final char c : bracketString.toCharArray()) {
            switch (c) {
                case '{':
                    stack.add('}');
                    break;
                case '(':
                    stack.add(')');
                    break;
                case '[':
                    stack.add(']');
                    break;
                default:
                    if (stack.isEmpty() || !stack.getLast().equals(c)) {
                        return false;
                    }
                    stack.removeLast();
            }
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

