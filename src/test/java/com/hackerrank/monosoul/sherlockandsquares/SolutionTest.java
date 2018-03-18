package com.hackerrank.monosoul.sherlockandsquares;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void squares1() {
        assertThat(Solution.squares(3, 9)).isEqualTo(2);
    }

    @Test
    void squares2() {
        assertThat(Solution.squares(17, 24)).isEqualTo(0);
    }
}