package com.hackerrank.monosoul.crackingthecodinginterview.ctciisbinarysearchtree;

/**
 * https://www.hackerrank.com/challenges/ctci-is-binary-search-tree/problem
 */
public class Solution {

    static boolean checkBST(Node root) {
        return false;
    }

    static class Node {
        final int data;
        Node left;
        Node right;

        public Node(final int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public Node getLeft() {
            return left;
        }

        public Node setLeft(final Node left) {
            this.left = left;
            return this;
        }

        public Node getRight() {
            return right;
        }

        public Node setRight(final Node right) {
            this.right = right;
            return this;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Node{");
            sb.append("data=").append(data);
            sb.append('}');
            return sb.toString();
        }
    }
}
