package com.hackerrank.monosoul.sherlockandanagrams;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void sherlockAndAnagrams1() {
        assertAnagrams("abba", 4);
    }

    @Test
    void sherlockAndAnagrams2() {
        assertAnagrams("abcd", 0);
    }

    @Test
    void sherlockAndAnagrams3() {
        assertAnagrams("ifailuhkqq", 3);
    }

    @Test
    void sherlockAndAnagrams4() {
        assertAnagrams("hucpoltgty", 2);
    }

    @Test
    void sherlockAndAnagrams5() {
        assertAnagrams("ovarjsnrbf", 2);
    }

    @Test
    void sherlockAndAnagrams6() {
        assertAnagrams("pvmupwjjjf", 6);
    }

    @Test
    void sherlockAndAnagrams7() {
        assertAnagrams("iwwhrlkpek", 3);
    }

    @Test
    void sherlockAndAnagrams8() {
        assertAnagrams("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", 166650);
    }

    @Test
    void sherlockAndAnagrams9() {
        assertAnagrams("bbcaadacaacbdddcdbddaddabcccdaaadcadcbddadababdaaabcccdcdaacadcababbabbdbacabbdcbbbbbddacdbbcdddbaaa", 4832);
    }

    @Test
    void sherlockAndAnagrams10() {
        assertAnagrams("cacccbbcaaccbaacbbbcaaaababcacbbababbaacabccccaaaacbcababcbaaaaaacbacbccabcabbaaacabccbabccabbabcbba", 13022);
    }

    @Test
    void sherlockAndAnagrams11() {
        assertAnagrams("bbcbacaabacacaaacbbcaabccacbaaaabbcaaaaaaaccaccabcacabbbbabbbbacaaccbabbccccaacccccabcabaacaabbcbaca", 9644);
    }

    @Test
    void sherlockAndAnagrams12() {
        assertAnagrams("cbaacdbaadbabbdbbaabddbdabbbccbdaccdbbdacdcabdbacbcadbbbbacbdabddcaccbbacbcadcdcabaabdbaacdccbbabbbc", 6346);
    }

    private void assertAnagrams(final String s, int amount) {
        assertThat(Solution.sherlockAndAnagrams(s)).isEqualTo(amount);
    }
}