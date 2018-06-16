package com.hackerrank.monosoul.crackingthecodinginterview.ctcimakinganagrams;

import org.junit.jupiter.api.Test;

import static com.hackerrank.monosoul.crackingthecodinginterview.ctcimakinganagrams.Solution.countDeletions;
import static com.hackerrank.monosoul.crackingthecodinginterview.ctcimakinganagrams.Solution.countSameChars;
import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void countSameChars1() {
        assertThat(countSameChars("abc", "fbd")).isEqualTo(1);
    }

    @Test
    void countSameChars2() {
        assertThat(countSameChars("abbc", "fbd")).isEqualTo(1);
    }

    @Test
    void countSameChars3() {
        assertThat(countSameChars("abbc", "fbdc")).isEqualTo(2);
    }

    @Test
    void countSameChars4() {
        assertThat(countSameChars("abbc", "fbbdc")).isEqualTo(3);
    }

    @Test
    void countDeletions1() {
        assertThat(countDeletions("abc", "fbd")).isEqualTo(4);
    }

    @Test
    void countDeletions2() {
        assertThat(countDeletions("abbc", "fbd")).isEqualTo(5);
    }

    @Test
    void countDeletions3() {
        assertThat(countDeletions("abbc", "fbdc")).isEqualTo(4);
    }

    @Test
    void countDeletions4() {
        assertThat(countDeletions("abbc", "fbbdc")).isEqualTo(3);
    }
}