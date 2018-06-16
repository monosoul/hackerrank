package com.hackerrank.monosoul.crackingthecodinginterview.ctciisbinarysearchtree;

/**
 * https://www.hackerrank.com/challenges/ctci-is-binary-search-tree/problem
 */
public class Solution {

    static boolean checkBST(final Node root) {
        return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    static boolean checkBST(final Node node, final int min, final int max) {
        if (node == null) return true;
        if (node.data <= min || node.data >= max) return false;

        return checkBST(node.left, min, node.data) && checkBST(node.right, node.data, max);
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
