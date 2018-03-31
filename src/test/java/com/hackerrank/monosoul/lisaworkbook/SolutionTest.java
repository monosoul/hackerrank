package com.hackerrank.monosoul.lisaworkbook;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void workbook1() {
        assertThat(Solution.workbook(3, new int[] {4, 2, 6, 1, 10})).isEqualTo(4);
    }

    @Test
    void workbook2() {
        assertThat(Solution.workbook(1, new int[] {4, 2})).isEqualTo(4);
    }
}