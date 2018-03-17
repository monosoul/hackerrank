package com.hackerrank.monosoul.timeconversion;

import static java.time.format.DateTimeFormatter.ofPattern;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * https://www.hackerrank.com/challenges/time-conversion/problem
 */
public class Solution {

    private static final DateTimeFormatter DTF_12 = ofPattern("hh:mm:ssa");
    private static final DateTimeFormatter DTF_24 = ofPattern("HH:mm:ss");

    static String timeConversion(String s) {
        return DTF_24.format(DTF_12.parse(s));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = timeConversion(s);
        System.out.println(result);
    }
}
