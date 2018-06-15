package com.hackerrank.monosoul.ctciqueueusingtwostacks;

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
            if (dequeueStack.isEmpty()) {
                moveItems(enqueueStack, dequeueStack);
            }

            return dequeueStack.pop();
        }

        T peek() {
            if (dequeueStack.isEmpty()) {
                moveItems(enqueueStack, dequeueStack);
            }

            return dequeueStack.peek();
        }

        private void moveItems(final Deque<T> from, final Deque<T> to) {
            while(!from.isEmpty()) {
                to.push(from.pop());
            }
        }
    }
}
