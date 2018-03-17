package com.hackerrank.monosoul.designerpdfviewer;

import java.util.*;

/**
 * https://www.hackerrank.com/challenges/designer-pdf-viewer/problem
 */
public class Solution {

    static int designerPdfViewer(int[] h, String word) {
        return word.chars().map(x -> h[x - 'a']).max().getAsInt() * word.length();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] h = new int[26];
        for(int h_i = 0; h_i < 26; h_i++){
            h[h_i] = in.nextInt();
        }
        String word = in.next();
        int result = designerPdfViewer(h, word);
        System.out.println(result);
        in.close();
    }
}


