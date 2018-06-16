package com.hackerrank.monosoul.crackingthecodinginterview.ctciisbinarysearchtree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://www.hackerrank.com/challenges/ctci-is-binary-search-tree/problem
 */
public class Solution {

    static boolean checkBST(final Node root) {
        return checkBST(root, new ArrayList<>(), new ArrayList<>(), new HashSet<>());
    }

    static boolean checkBST(
            final Node node,
            final List<Integer> lessThan,
            final List<Integer> greaterThan,
            final Set<Integer> dataSet
    ) {
        if (node == null) return true;
        if (dataSet.contains(node.data)) return false;

        for (final Integer data : lessThan) {
            if (node.data > data) return false;
        }
        for (final Integer data : greaterThan) {
            if (node.data < data) return false;
        }

        dataSet.add(node.data);

        final List<Integer> localLessThan = new ArrayList<>(lessThan);
        localLessThan.add(node.data);
        final boolean leftIsBST = checkBST(node.left, localLessThan, greaterThan, dataSet);

        final List<Integer> localGreaterThan = new ArrayList<>(greaterThan);
        localGreaterThan.add(node.data);
        final boolean rightIsBST = checkBST(node.right, lessThan, localGreaterThan, dataSet);

        return leftIsBST && rightIsBST;
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
