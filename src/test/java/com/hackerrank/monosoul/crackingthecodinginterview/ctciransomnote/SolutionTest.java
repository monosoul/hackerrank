package com.hackerrank.monosoul.crackingthecodinginterview.ctciransomnote;

import static com.hackerrank.monosoul.crackingthecodinginterview.ctciransomnote.Solution.checkMagazine;
import static org.assertj.core.api.Assertions.assertThat;
import lombok.val;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void checkMagazine1() {
        val actual = checkMagazine(
                new String[]{"give", "me", "one", "grand", "today", "night"},
                new String[]{"give", "one", "grand", "today"}
        );

        assertThat(actual).isEqualTo("Yes");
    }

    @Test
    void checkMagazine2() {
        val actual = checkMagazine(
                new String[]{"two", "times", "three", "is", "not", "four"},
                new String[]{"two", "times", "two", "is", "four"}
        );

        assertThat(actual).isEqualTo("No");
    }
}