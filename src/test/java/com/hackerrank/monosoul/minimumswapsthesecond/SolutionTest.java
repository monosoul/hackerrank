package com.hackerrank.monosoul.minimumswapsthesecond;

import static com.hackerrank.monosoul.minimumswapsthesecond.Solution.minimumSwaps;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void countSwapsForArrayOf4() {
        assertThat(minimumSwaps(new int[]{4, 3, 1, 2})).isEqualTo(3);
    }

    @Test
    void countSwapsForArrayOf5() {
        assertThat(minimumSwaps(new int[]{2, 3, 4, 1, 5})).isEqualTo(3);
    }

    @Test
    void countSwapsForArrayOf7() {
        assertThat(minimumSwaps(new int[]{7, 1, 3, 2, 4, 5, 6})).isEqualTo(5);
    }
}