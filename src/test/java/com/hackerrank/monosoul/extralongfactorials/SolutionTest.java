package com.hackerrank.monosoul.extralongfactorials;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void extraLongFactorials() {
        assertThat(Solution.extraLongFactorials(25).toString()).isEqualTo("15511210043330985984000000");
    }
}