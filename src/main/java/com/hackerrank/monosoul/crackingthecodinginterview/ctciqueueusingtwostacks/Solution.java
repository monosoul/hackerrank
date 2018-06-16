package com.hackerrank.monosoul.crackingthecodinginterview.ctciqueueusingtwostacks;

import java.util.*;

/**
 * https://www.hackerrank.com/challenges/ctci-queue-using-two-stacks/problem
 */
public class Solution {
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }

    static class MyQueue<T> {
        private final Deque<T> enqueueStack = new ArrayDeque<>();
        private final Deque<T> dequeueStack = new ArrayDeque<>();

        void enqueue(final T item) {
            enqueueStack.push(item);
        }

        T dequeue() {
            enqueToDequeue();

            return dequeueStack.pop();
        }

        T peek() {
            enqueToDequeue();

            return dequeueStack.peek();
        }

        private void enqueToDequeue() {
            if (dequeueStack.isEmpty()) {
                moveItems(enqueueStack, dequeueStack);
            }
        }

        private void moveItems(final Deque<T> from, final Deque<T> to) {
            while(!from.isEmpty()) {
                to.push(from.pop());
            }
        }
    }
}
