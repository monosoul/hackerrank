package com.hackerrank.monosoul.crackingthecodinginterview.ctcifibonaccinumbers;

        import java.util.*;

/**
 * https://www.hackerrank.com/challenges/ctci-fibonacci-numbers/problem
 */
public class Solution {

    static int fibonacci(int n) {
        return fibonacci(n, 1, 0);
    }

    static int fibonacci(final int n, final int current, final int previous) {
        if (n == 1) {
            return current;
        }

        return fibonacci(n - 1, current + previous, current);
    }

    public static void main(String[] args) {
        try (final Scanner scanner = new Scanner(System.in)) {
            System.out.println(
                    fibonacci(scanner.nextInt())
            );
        }
    }
}
