package com.hackerrank.monosoul.servicelane;

import lombok.val;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class SolutionTest {

    @Test
    void serviceLane1() {
        val actual = Solution.serviceLane(
                new int[]{2, 3, 1, 2, 3, 2, 3, 3},
                new int[][]{{0, 3}, {4, 6}, {6, 7}, {3, 5}, {0, 7}}
        );

        assertThat(actual).isEqualTo(new int[] {1, 2, 3, 2, 1});
    }

    @Test
    void serviceLane2() {
        val actual = Solution.serviceLane(
                new int[]{1, 2, 2, 2, 1},
                new int[][]{{2, 3}, {1, 4}, {2, 4}, {2, 4}, {2, 3}}
        );

        assertThat(actual).isEqualTo(new int[] {2, 1, 1, 1, 2});
    }
}