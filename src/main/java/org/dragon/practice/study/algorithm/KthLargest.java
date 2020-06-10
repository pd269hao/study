package org.dragon.practice.study.algorithm;

import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Liuwl
 * Date: 2020/6/3
 **/
public class KthLargest {
    PriorityQueue<Integer> queue;
    private int maxSize;

    public KthLargest(int k, int[] nums) {
        queue = new PriorityQueue<>(Integer::compareTo);
        maxSize = k;
        for (int i = 0; i < nums.length; i++) {
            add(nums[i]);
        }
    }

    public int add(int val) {
        if (queue.size() < maxSize) {
            queue.add(val);
        } else {
            if (queue.peek() < val) {
                queue.poll();
                queue.add(val);
            }
        }

        return queue.peek();

    }
}
