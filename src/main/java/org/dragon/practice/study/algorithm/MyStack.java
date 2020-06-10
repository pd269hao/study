package org.dragon.practice.study.algorithm;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Liuwl
 * Date: 2020/6/3
 **/
public class MyStack {
    private Queue<Integer> queueA = new LinkedList<>();
    private Queue<Integer> queueB = new LinkedList<>();

    /**
     * Initialize your data structure here.
     */
    public MyStack() {

    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        if (!queueA.isEmpty()) {
            queueA.add(x);
        } else {
            queueB.add(x);
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        if (!queueA.isEmpty()) {
            do {
                int a = queueA.poll();
                if (queueA.isEmpty()) {
                    return a;
                }
                queueB.add(a);
            } while (true);
        } else if (!queueB.isEmpty()) {
            do {
                int a = queueB.poll();
                if (queueB.isEmpty()) {
                    return a;
                }
                queueA.add(a);
            } while (true);
        } else {
            throw new RuntimeException();
        }
    }

    /**
     * Get the top element.
     */
    public int top() {
        if (!queueA.isEmpty()) {
            do {
                int a = queueA.poll();
                queueB.add(a);
                if (queueA.isEmpty()) {
                    return a;
                }
            } while (true);
        } else if (!queueB.isEmpty()) {
            do {
                int a = queueB.poll();
                queueA.add(a);
                if (queueB.isEmpty()) {
                    return a;
                }
            } while (true);
        } else {
            throw new RuntimeException();
        }
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queueA.isEmpty() && queueB.isEmpty();
    }
}
