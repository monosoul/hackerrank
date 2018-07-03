package com.hackerrank.monosoul.newyearchaos;

import static com.hackerrank.monosoul.newyearchaos.Solution.bubbleSortAndCountSwaps;
import static com.hackerrank.monosoul.newyearchaos.Solution.minimumBribes;
import static com.hackerrank.monosoul.newyearchaos.Solution.printResult;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void arrIsTooChaotic1() {
        assertThat(minimumBribes(new int[] {2, 5, 1, 3, 4})).isEqualTo(-1);
    }

    @Test
    void arrIsThreeBribes() {
        assertThat(minimumBribes(new int[] {2, 1, 5, 3, 4})).isEqualTo(3);
    }

    @Test
    void arrIsOneBribe() {
        assertThat(minimumBribes(new int[] {1, 2, 3, 5, 4, 6, 7, 8})).isEqualTo(1);
    }

    @Test
    void arrIsTooChaotic2() {
        assertThat(minimumBribes(new int[] {5, 1, 2, 3, 7, 8, 6, 4})).isEqualTo(-1);
    }

    @Test
    void arrIsSevenBribes() {
        assertThat(minimumBribes(new int[] {1, 2, 5, 3, 7, 8, 6, 4})).isEqualTo(7);
    }

    @Test
    void sevenSwaps() {
        assertThat(bubbleSortAndCountSwaps(new int[] {1, 2, 5, 3, 7, 8, 6, 4})).isEqualTo(7);
    }

    @Test
    void printTooChaotic() {
        assertThat(printResult(-1)).isEqualTo("Too chaotic");
    }

    @Test
    void printNumber() {
        assertThat(printResult(100500)).isEqualTo("100500");
    }
}