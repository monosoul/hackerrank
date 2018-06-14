package com.hackerrank.monosoul.ctcilinkedlistcycle;

import java.util.HashSet;
import java.util.Set;

/**
 * https://www.hackerrank.com/challenges/ctci-linked-list-cycle/problem
 */
public class Solution {

    static boolean hasCycle(Node head) {
        return hasCycle(new HashSet<Node>(), head);
    }

    static boolean hasCycle(final Set<Node> nodes, final Node head) {
        if (head == null) return false;
        if (nodes.contains(head)) return true;
        nodes.add(head);

        return hasCycle(nodes, head.next);
    }

    static class Node {
        int data;
        Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Node() {
        }

        public int getData() {
            return data;
        }

        public Node setData(int data) {
            this.data = data;
            return this;
        }

        public Node getNext() {
            return next;
        }

        public Node setNext(Node next) {
            this.next = next;
            return this;
        }
    }
}
