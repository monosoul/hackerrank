package com.hackerrank.monosoul.determiningdnahealth;

import com.google.common.collect.ImmutableMap;
import com.hackerrank.monosoul.determiningdnahealth.Solution.DNAStrand;
import lombok.val;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.Map.Entry;

import static com.google.common.collect.ImmutableMap.of;
import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    private static Entry<String[], Map<String, List<Integer>>> build(final String[] genes, final int[] health) {
        val map = new HashMap<String, List<Integer>>();
        for (int i = 0; i < genes.length; i++) {
            Solution.put(map, genes[i], health[i]);
        }

        return new SimpleImmutableEntry<>(genes, map);
    }

    @Test
    void determineDNAHealth() {
        val entry = build(new String[]{"a", "b", "c", "aa", "d", "b"}, new int[]{1, 2, 3, 4, 5, 6});
        val actual = Solution.determineDNAHealth(
                entry.getKey(),
                entry.getValue(),
                new DNAStrand[]{
                        new DNAStrand(1, 5, "caaab"),
                        new DNAStrand(0, 4, "xyz"),
                        new DNAStrand(2, 4, "bcdybc")
                }
        );

        assertThat(actual).isEqualTo(new int[] {0, 19});
    }

    @Test
    void testTrie() {
        val trie = new Trie();
        trie.addWord("a");
        trie.addWord("ab");
        trie.addWord("bab");
        trie.addWord("bc");
        trie.addWord("bca");
        trie.addWord("c");
        trie.addWord("caa");

        assertThat(trie.matches("abccab")).isEqualTo(
                of(
                        "a", 2,
                        "ab", 2,
                        "bc", 1,
                        "c", 2
                )
        );
    }

    @Test
    void testTrie2() {
        val trie = new Trie();
        trie.addWord("a");
        trie.addWord("b");
        trie.addWord("c");
        trie.addWord("aa");
        trie.addWord("d");
        trie.addWord("b");

        assertThat(trie.matches("caaab")).isEqualTo(
                of(
                        "a", 3,
                        "aa", 2,
                        "b", 1,
                        "c", 1
                )
        );
    }

    @Test
    void testTrie3() {
        val trie = new Trie();
        trie.addWord("a");
        trie.addWord("b");
        trie.addWord("c");
        trie.addWord("aa");
        trie.addWord("d");
        trie.addWord("b");

        assertThat(trie.matches("bcdybc")).isEqualTo(
                of(
                        "b", 2,
                        "c", 2,
                        "d", 1
                )
        );
    }

    @Test
    void testTrie4() {
        val trie = new Trie();
        trie.addWord("a");
        trie.addWord("b");
        trie.addWord("c");
        trie.addWord("aa");
        trie.addWord("d");
        trie.addWord("b");

        assertThat(trie.matches("xyz")).isEqualTo(of());
    }

    @Test
    void testTrie5() {
        val trie = new Trie();
        trie.addWord("he");
        trie.addWord("she");
        trie.addWord("hers");
        trie.addWord("her");

        assertThat(trie.matches("he is here")).isEqualTo(
                of(
                        "her", 1,
                        "he", 2
                )
        );
    }

    @Test
    void testTrie6() {
        val trie = new Trie();
        trie.addWord("he");
        trie.addWord("she");
        trie.addWord("hers");
        trie.addWord("her");

        assertThat(trie.matches("this is she")).isEqualTo(
                of(
                        "she", 1,
                        "he", 1
                )
        );
    }

    @Test
    void testTrie7() {
        val trie = new Trie();
        trie.addWord("he");
        trie.addWord("she");
        trie.addWord("hers");
        trie.addWord("her");

        assertThat(trie.matches("this is hers")).isEqualTo(
                of(
                        "hers", 1,
                        "he", 1,
                        "her", 1
                )
        );
    }

    @Test
    void testTrie8() {
        val trie = new Trie();
        trie.addWord("he");
        trie.addWord("she");
        trie.addWord("hers");
        trie.addWord("her");

        assertThat(trie.matches("her bag is big")).isEqualTo(
                of(
                        "he", 1,
                        "her", 1
                )
        );
    }
}