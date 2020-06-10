package org.dragon.practice.study.algorithm;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Liuwl
 * Date: 2020/6/3
 **/
public class MyQueue {
    private Stack<Integer> stackIn = new Stack<>();
    private Stack<Integer> stackOut = new Stack<>();

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {

    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        stackIn.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (!stackIn.empty()) {
            do {
                int a = stackIn.pop();
                stackOut.push(a);

                if (stackIn.empty()) {
                    stackOut.pop();
                    while (!stackOut.empty()) {
                        stackIn.push(stackOut.pop());
                    }
                    return a;
                }

            } while (true);
        }
        throw new RuntimeException();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (!stackIn.empty()) {
            do {
                int a = stackIn.pop();
                stackOut.push(a);

                if (stackIn.empty()) {
                    while (!stackOut.empty()) {
                        stackIn.push(stackOut.pop());
                    }
                    return a;
                }

            } while (true);
        }
        throw new RuntimeException();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stackIn.empty();
    }
}
