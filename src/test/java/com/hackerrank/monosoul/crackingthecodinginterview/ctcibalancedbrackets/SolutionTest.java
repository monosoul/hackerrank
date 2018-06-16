package com.hackerrank.monosoul.crackingthecodinginterview.ctcibalancedbrackets;

import static com.hackerrank.monosoul.crackingthecodinginterview.ctcibalancedbrackets.Solution.isBalanced;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void isBalanced1() {
        assertThat(isBalanced("{[()]}")).isTrue();
    }

    @Test
    void isBalanced2() {
        assertThat(isBalanced("{[(])}")).isFalse();
    }

    @Test
    void isBalanced3() {
        assertThat(isBalanced("{{[[(())]]}}")).isTrue();
    }

    @Test
    void isBalanced4() {
        assertThat(isBalanced("{{[[((")).isFalse();
    }
    @Test
    void isBalanced5() {
        assertThat(isBalanced("(())]]}}")).isFalse();
    }
}