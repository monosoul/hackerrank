package com.hackerrank.monosoul.crackingthecodinginterview.ctcicomparatorsorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/ctci-comparator-sorting/problem
 */
class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();

        for(int i = 0; i < n; i++){
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();

        Arrays.sort(player, checker);
        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }

    static class Player{
        String name;
        int score;

        Player(String name, int score){
            this.name = name;
            this.score = score;
        }
    }

    static class Checker implements Comparator<Player>{

        @Override
        public int compare(final Player o1, final Player o2) {
            return 100 * Integer.compare(o2.score, o1.score) + o1.name.compareTo(o2.name);
        }
    }
}