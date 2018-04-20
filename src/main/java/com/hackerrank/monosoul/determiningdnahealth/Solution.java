package com.hackerrank.monosoul.determiningdnahealth;

import java.util.*;

import static java.util.Arrays.stream;
import static java.util.Objects.hash;
import static java.util.stream.Collectors.joining;

/**
 * https://www.hackerrank.com/challenges/determining-dna-health/problem
 */
public class Solution {

    public static int[] determineDNAHealth(final String[] genes, final Map<String, List<Integer>> genesHealth, final DNAStrand[] strands) {
        final Trie trie = new Trie().addWords(genesHealth.keySet());
        Integer min = null;
        Integer max = null;

        for (final DNAStrand strand : strands) {
            final Map<String, Integer> matches = trie.matches(strand.getDna());
            int strHealth = 0;
            final Set<String> calculated = new HashSet<>();
            for (int i = strand.getFirst(); i <= strand.getLast(); i++) {
                final String gene = genes[i];
                if (calculated.contains(gene)) continue;

                final Integer matchAmount = matches.get(gene);
                if (matchAmount == null) continue;

                final List<Integer> healthes = genesHealth.get(gene);
                for (final Integer geneHealth : healthes) {
                    strHealth += matchAmount * geneHealth;
                }

                calculated.add(gene);
            }

            if (min == null || strHealth < min) min = strHealth;
            if (max == null || strHealth > max) max = strHealth;
        }

        return new int[]{min, max};
    }

    public static void put(final Map<String, List<Integer>> map, final String gene, final int health) {
        if (!map.containsKey(gene)) {
            map.put(gene, new ArrayList<>());
        }
        map.get(gene).add(health);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        final Map<String, List<Integer>> genesHealth = new TreeMap<>();
        final String[] genes = new String[n];
        for (int genes_i = 0; genes_i < n; genes_i++) {
            genes[genes_i] = in.next();
        }
        for (int health_i = 0; health_i < n; health_i++) {
            put(genesHealth, genes[health_i], in.nextInt());
        }
        int s = in.nextInt();
        final DNAStrand[] strands = new DNAStrand[s];
        for (int a0 = 0; a0 < s; a0++) {
            strands[a0] = new DNAStrand(in.nextInt(), in.nextInt(), in.next());
        }
        in.close();
        System.out.println(
                stream(determineDNAHealth(genes, genesHealth, strands))
                        .mapToObj(String::valueOf).collect(joining(" "))
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
