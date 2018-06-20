package com.hackerrank.monosoul.crackingthecodinginterview.ctcilonelyinteger;

import static com.hackerrank.monosoul.crackingthecodinginterview.ctcilonelyinteger.Solution.findLonely;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void oneItem() {
        assertThat(findLonely(1)).isEqualTo(1);
    }

    @Test
    void oneNotUniqueAndOneUnique() {
        assertThat(findLonely(1, 1, 2)).isEqualTo(2);
    }

    @Test
    void twoNotUniqueAndOneUnique() {
        assertThat(findLonely(0, 0, 1, 2, 1)).isEqualTo(2);
    }
}