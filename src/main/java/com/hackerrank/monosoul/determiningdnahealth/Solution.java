package com.hackerrank.monosoul.determiningdnahealth;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.Arrays.stream;
import static java.util.Objects.hash;
import static java.util.stream.Collectors.joining;

/**
 * https://www.hackerrank.com/challenges/determining-dna-health/problem
 */
public class Solution {

    public static int[] determineDNAHealth(final String[] genes, final int[] health, final DNAStrand[] strands) {
        final Map<String, List<Integer>> reducedGenes = reduceGenes(genes, health);
        final Trie trie = new Trie().addWords(reducedGenes.keySet());
        Integer min = null;
        Integer max = null;

        for (final DNAStrand strand : strands) {
            int strHealth = 0;
            final Set<String> calculated = new HashSet<>();
            for (int i = strand.getFirst(); i <= strand.getLast(); i++) {
                calculated.add(genes[i]);
            }
            final Map<String, Integer> matches = trie.matches(strand.getDna());
            for (final String gene : calculated) {
                final List<Integer> healthes = reducedGenes.get(gene);
                final Integer matchAmount = matches.get(gene);
                if (matchAmount == null) continue;
                for (final Integer geneHealth : healthes) {
                    strHealth += matchAmount * geneHealth;
                }
            }

            if (min == null || strHealth < min) min = strHealth;
            if (max == null || strHealth > max) max = strHealth;
        }

        return new int[]{min, max};
    }

    private static Map<String, List<Integer>> reduceGenes(final String[] genes, final int[] health) {
        final Map<String, List<Integer>> result = new HashMap<>();
        for (int i = 0; i < health.length; i++) {
            put(result, genes[i], health[i]);
        }

        return result;
    }

    private static void put(final Map<String, List<Integer>> map, final String gene, final int health) {
        if (!map.containsKey(gene)) {
            map.put(gene, new ArrayList<>());
        }
        map.get(gene).add(health);
    }

    private static int countMatches(final Pattern pattern, final CharSequence input) {
        final Matcher matcher = pattern.matcher(input);
        int start = 0;
        int count = 0;

        while (matcher.find(start)) {
            start = matcher.start() + 1;
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] genes = new String[n];
        for (int genes_i = 0; genes_i < n; genes_i++) {
            genes[genes_i] = in.next();
        }
        int[] health = new int[n];
        for (int health_i = 0; health_i < n; health_i++) {
            health[health_i] = in.nextInt();
        }
        int s = in.nextInt();
        final DNAStrand[] strands = new DNAStrand[s];
        for (int a0 = 0; a0 < s; a0++) {
            strands[a0] = new DNAStrand(in.nextInt(), in.nextInt(), in.next());
        }
        in.close();
        System.out.println(
                stream(determineDNAHealth(genes, health, strands)).mapToObj(String::valueOf).collect(joining(" "))
        );
    }

    static class DNAStrand {
        final int first;
        final int last;
        final String dna;

        DNAStrand(final int first, final int last, final String dna) {
            this.first = first;
            this.last = last;
            this.dna = dna;
        }

        public int getFirst() {
            return first;
        }

        public int getLast() {
            return last;
        }

        public String getDna() {
            return dna;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            DNAStrand dnaStrand = (DNAStrand) o;
            return first == dnaStrand.first &&
                    last == dnaStrand.last &&
                    Objects.equals(dna, dnaStrand.dna);
        }

        @Override
        public int hashCode() {

            return hash(first, last, dna);
        }
    }
}
