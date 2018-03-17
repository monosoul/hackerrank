package com.hackerrank.monosoul.lilyshomework;

import org.junit.jupiter.api.Test;

import static com.hackerrank.monosoul.lilyshomework.Solution.lilysHomework;
import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void doHomeWorkForArrayOf4() {
        assertThat(lilysHomework(new int[]{2, 5, 3, 1})).isEqualTo(2);
    }

    @Test
    void doHomeWorkForArrayOf7() {
        assertThat(lilysHomework(new int[]{2, 5, 3, 1, 7, 9, 2})).isEqualTo(7);
    }
}