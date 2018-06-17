package com.hackerrank.monosoul.crackingthecodinginterview.ctcibubblesort;

import org.junit.jupiter.api.Test;

import static com.hackerrank.monosoul.crackingthecodinginterview.ctcibubblesort.Solution.bubbleSortCountingSwaps;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void sortSorted() {
        assertThat(bubbleSortCountingSwaps(new int[] {1, 2, 3})).isEqualTo(0);
    }

    @Test
    void sortUnsorted() {
        assertThat(bubbleSortCountingSwaps(new int[] {3, 2, 1})).isEqualTo(3);
    }
}