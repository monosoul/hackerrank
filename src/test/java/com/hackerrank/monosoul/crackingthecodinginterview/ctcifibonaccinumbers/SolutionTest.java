package com.hackerrank.monosoul.crackingthecodinginterview.ctcifibonaccinumbers;

import static com.hackerrank.monosoul.crackingthecodinginterview.ctcifibonaccinumbers.Solution.fibonacci;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void test1() {
        assertThat(fibonacci(3)).isEqualTo(2);
    }

    @Test
    void test2() {
        assertThat(fibonacci(6)).isEqualTo(8);
    }

    @Test
    void test3() {
        assertThat(fibonacci(1)).isEqualTo(1);
    }
}