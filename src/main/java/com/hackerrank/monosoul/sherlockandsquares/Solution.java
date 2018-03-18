package com.hackerrank.monosoul.sherlockandsquares;

import java.util.*;

import static java.lang.Math.ceil;
import static java.lang.Math.floor;
import static java.lang.Math.sqrt;

/**
 * https://www.hackerrank.com/challenges/sherlock-and-squares/problem
 */
public class Solution {

    static int squares(int a, int b) {
        return (int) (floor(sqrt(b)) - ceil(sqrt(a)) + 1);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for (int a0 = 0; a0 < q; a0++) {
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(squares(a, b));
        }
        in.close();
    }
}
