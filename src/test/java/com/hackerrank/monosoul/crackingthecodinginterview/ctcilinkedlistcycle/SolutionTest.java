package com.hackerrank.monosoul.crackingthecodinginterview.ctcilinkedlistcycle;

import com.hackerrank.monosoul.crackingthecodinginterview.ctcilinkedlistcycle.Solution.Node;
import lombok.val;
import org.junit.jupiter.api.Test;

import static com.hackerrank.monosoul.crackingthecodinginterview.ctcilinkedlistcycle.Solution.hasCycle;
import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void hasNullHead() {
        assertThat(hasCycle(null)).isEqualTo(false);
    }

    @Test
    void hasOnlyOneNode() {
        assertThat(hasCycle(new Node())).isEqualTo(false);
    }

    @Test
    void has2NodesWithCycle() {
        val head = new Node();
        head.setNext(new Node().setNext(head));

        assertThat(hasCycle(head)).isEqualTo(true);
    }

    @Test
    void hasMultipleNodesWithCycleBetweenTwoNearNodes() {
        val head = new Node();
        val previousNode = new Node();
        head.setNext(
                new Node().setNext(
                        new Node().setNext(
                                new Node().setNext(
                                        previousNode.setNext(
                                                new Node().setNext(previousNode)
                                        )
                                )
                        )
                )
        );

        assertThat(hasCycle(head)).isEqualTo(true);
    }

    @Test
    void hasMultipleNodesWithCycleBetweenFirstAndLastNodes() {
        val head = new Node();
        head.setNext(
                new Node().setNext(
                        new Node().setNext(
                                new Node().setNext(
                                        new Node().setNext(
                                                head
                                        )
                                )
                        )
                )
        );

        assertThat(hasCycle(head)).isEqualTo(true);
    }

    @Test
    void hasNoCycle() {
        val head = new Node();
        head.setNext(
                new Node().setNext(
                        new Node().setNext(
                                new Node().setNext(
                                        new Node()
                                )
                        )
                )
        );

        assertThat(hasCycle(head)).isEqualTo(false);
    }
}