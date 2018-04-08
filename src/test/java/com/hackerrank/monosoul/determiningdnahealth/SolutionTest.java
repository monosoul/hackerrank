package com.hackerrank.monosoul.determiningdnahealth;

import com.hackerrank.monosoul.determiningdnahealth.Solution.DNAStrand;
import lombok.val;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void determineDNAHealth() {
        val actual = Solution.determineDNAHealth(
                new String[]{"a", "b", "c", "aa", "d", "b"},
                new int[]{1, 2, 3, 4, 5, 6},
                new DNAStrand[]{
                        new DNAStrand(1, 5, "caaab"),
                        new DNAStrand(0, 4, "xyz"),
                        new DNAStrand(2, 4, "bcdybc")
                }
        );

        assertThat(actual).isEqualTo(new int[] {0, 19});
    }
}