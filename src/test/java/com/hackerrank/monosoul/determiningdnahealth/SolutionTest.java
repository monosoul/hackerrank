package com.hackerrank.monosoul.determiningdnahealth;

import com.hackerrank.monosoul.determiningdnahealth.Solution.DNAStrand;
import lombok.val;
import org.junit.jupiter.api.Test;

import static com.google.common.collect.ImmutableMap.of;
import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void determineDNAHealth() {
        val actual = Solution.determineDNAHealth(
                new String[]{"a", "b", "c", "aa", "d", "b"},
                new int[]{1, 2, 3, 4, 5, 6},
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
}