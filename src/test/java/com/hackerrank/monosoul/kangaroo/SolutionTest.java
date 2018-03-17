package com.hackerrank.monosoul.kangaroo;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void kangaroo1() {
        assertThat(Solution.kangaroo(0, 3, 4, 2)).isEqualTo("YES");
    }

    @Test
    void kangaroo2() {
        assertThat(Solution.kangaroo(0, 2, 5, 3)).isEqualTo("NO");
    }
}