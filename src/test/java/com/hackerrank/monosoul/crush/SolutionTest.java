package com.hackerrank.monosoul.crush;

import static com.hackerrank.monosoul.crush.Solution.arrayManipulation;
import static org.assertj.core.api.Assertions.assertThat;
import com.google.common.collect.ImmutableList;
import com.hackerrank.monosoul.crush.Solution.Query;
import lombok.val;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void arrayManipulation1() {
        val arr = ImmutableList.of(
                new Query(1, 2, 100),
                new Query(2, 5, 100),
                new Query(3, 4, 100)
        );

        assertThat(arrayManipulation(5, arr)).isEqualTo(200L);
    }

    @Test
    void arrayManipulation2() {
        val arr = ImmutableList.of(
                new Query(29, 40, 787),
                new Query(9, 26, 219),
                new Query(21, 31, 214),
                new Query(8, 22, 719),
                new Query(15, 23, 102),
                new Query(11, 24, 83),
                new Query(14, 22, 321),
                new Query(5, 22, 300),
                new Query(11, 30, 832),
                new Query(5, 25, 29),
                new Query(16, 24, 577),
                new Query(3, 10, 905),
                new Query(15, 22, 335),
                new Query(29, 35, 254),
                new Query(9, 20, 20),
                new Query(33, 34, 351),
                new Query(30, 38, 564),
                new Query(11, 31, 969),
                new Query(3, 32, 11),
                new Query(29, 35, 267),
                new Query(4, 24, 531),
                new Query(1, 38, 892),
                new Query(12, 18, 825),
                new Query(25, 32, 99),
                new Query(3, 39, 107),
                new Query(12, 37, 131),
                new Query(3, 26, 640),
                new Query(8, 39, 483),
                new Query(8, 11, 194),
                new Query(12, 37, 502)
        );

        assertThat(arrayManipulation(40, arr)).isEqualTo(8628L);
    }
}