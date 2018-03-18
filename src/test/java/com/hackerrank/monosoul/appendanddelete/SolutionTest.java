package com.hackerrank.monosoul.appendanddelete;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void appendAndDelete1() {
        assertThat(Solution.appendAndDelete("hackerhappy", "hackerrank", 9)).isEqualTo("Yes");
    }

    @Test
    void appendAndDelete2() {
        assertThat(Solution.appendAndDelete("aba", "aba", 7)).isEqualTo("Yes");
    }

    @Test
    void appendAndDelete3() {
        assertThat(Solution.appendAndDelete("ashley", "ash", 2)).isEqualTo("No");
    }

    @Test
    void appendAndDelete4() {
        assertThat(Solution.appendAndDelete("ash", "ashley", 4)).isEqualTo("No");
    }

    @Test
    void appendAndDelete5() {
        assertThat(Solution.appendAndDelete("ababa", "ababa", 3)).isEqualTo("No");
    }

    @Test
    void appendAndDelete6() {
        assertThat(Solution.appendAndDelete("ababa", "ababa", 4)).isEqualTo("Yes");
    }

    @Test
    void appendAndDelete7() {
        assertThat(Solution.appendAndDelete("aaa", "a", 5)).isEqualTo("Yes");
    }
}