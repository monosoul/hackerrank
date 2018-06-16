package com.hackerrank.monosoul.crackingthecodinginterview.ctciisbinarysearchtree;

import com.hackerrank.monosoul.crackingthecodinginterview.ctciisbinarysearchtree.Solution.Node;
import lombok.val;
import org.junit.jupiter.api.Test;

import static com.hackerrank.monosoul.crackingthecodinginterview.ctciisbinarysearchtree.Solution.checkBST;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void checkBST1() {
        val root = new Node(4)
                .setLeft(
                        new Node(2)
                                .setLeft(new Node(1))
                                .setRight(new Node(3))
                )
                .setRight(
                        new Node(6)
                                .setLeft(new Node(5))
                                .setRight(new Node(7))
                );

        assertThat(checkBST(root)).isTrue();
    }

    @Test
    void checkBST2() {
        val root = new Node(3)
                .setLeft(
                        new Node(2)
                                .setLeft(new Node(1))
                                .setRight(new Node(4))
                )
                .setRight(
                        new Node(6)
                                .setLeft(new Node(5))
                                .setRight(new Node(7))
                );

        assertThat(checkBST(root)).isFalse();
    }

    @Test
    void checkBST3() {
        val root = new Node(3)
                .setLeft(
                        new Node(2)
                                .setLeft(new Node(1))
                )
                .setRight(
                        new Node(4)
                                .setLeft(new Node(5))
                                .setRight(new Node(6))
                );

        assertThat(checkBST(root)).isFalse();
    }

    @Test
    void checkBST4() {
        val root = new Node(3)
                .setLeft(
                        new Node(2)
                                .setLeft(new Node(1))
                )
                .setRight(
                        new Node(5)
                                .setLeft(new Node(6))
                                .setRight(new Node(1))
                );

        assertThat(checkBST(root)).isFalse();
    }
}