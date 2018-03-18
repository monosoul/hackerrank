package com.hackerrank.monosoul.extralongfactorials;

import java.math.BigInteger;
import java.util.*;

import static java.math.BigInteger.ONE;
import static java.util.stream.IntStream.iterate;

/**
 * https://www.hackerrank.com/challenges/extra-long-factorials/problem
 */
public class Solution {

    static BigInteger extraLongFactorials(int n) {
        return iterate(n, x -> x-1).limit(n).mapToObj(BigInteger::valueOf).reduce(ONE, BigInteger::multiply);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(extraLongFactorials(n));
        in.close();
    }
}

