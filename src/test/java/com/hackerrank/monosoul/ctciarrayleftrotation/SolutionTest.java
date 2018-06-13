package com.hackerrank.monosoul.ctciarrayleftrotation;

import org.junit.jupiter.api.Test;

import static com.hackerrank.monosoul.ctciarrayleftrotation.Solution.rotLeft;
import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void rotLeft1() {
        assertThat(rotLeft(new int[] {1, 2, 3, 4, 5}, 4)).isEqualTo(new int[] {5, 1, 2, 3, 4});
    }

    @Test
    void rotLeft2() {
        assertThat(
                rotLeft(new int[] {41, 73, 89, 7, 10, 1, 59, 58, 84, 77, 77, 97, 58, 1, 86, 58, 26, 10, 86, 51}, 10)
        ).isEqualTo(new int[] {77, 97, 58, 1, 86, 58, 26, 10, 86, 51, 41, 73, 89, 7, 10, 1, 59, 58, 84, 77});
    }
}