package com.hackerrank.monosoul.twodimensionarray;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import lombok.val;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void hourglassSumAtPos() {
        val arr = new int[][] {
                {1, 1, 1},
                {0, 1, 0},
                {1, 1, 1}
        };

        assertThat(Solution.hourglassSumAtPos(arr, 0, 0)).isEqualTo(7);
    }

    @Test
    void hourglassSum1() {
        val arr = new int[][] {
                {1, 1, 1, 2, 2},
                {0, 1, 0, 2, 0},
                {1, 1, 1, 2, 2}
        };

        assertThat(Solution.hourglassSum(arr)).isEqualTo(12);
    }

    @Test
    void hourglassSum2() {
        val arr = new int[][] {
                {1, 1, 1},
                {0, 1, 0},
                {1, 1, 1}
        };

        assertThat(Solution.hourglassSum(arr)).isEqualTo(7);
    }
}