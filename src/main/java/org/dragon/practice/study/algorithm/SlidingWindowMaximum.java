package org.dragon.practice.study.algorithm;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * 移动窗口最大值
 *
 * @Author: Liuwl
 * Date: 2020/6/4
 **/
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> a.compareTo(b) * -1);
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                queue.add(nums[i]);
            } else {
                if (queue.size() == k) {
                    queue.remove(nums[i - k]);
                }
                queue.add(nums[i]);
                result[i - k + 1] = queue.peek();
            }
        }
        return result;
    }

    public int[] maxSlidingWindow1(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> window = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            if (window.size() > 0) {
                if (nums[i] > nums[window.getFirst()]) {
                    window.clear();
                } else {
                    if (window.getFirst() <= i - k) {
                        window.removeFirst();
                    }
                    while (!window.isEmpty() && nums[window.getLast()] < nums[i]) {
                        window.removeLast();
                    }

                }

            }
            window.addLast(i);
            if (i >= k - 1) {
                result[i - k + 1] = nums[window.getFirst()];
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        int[] test=new int[]{1,3,1,2,0,5};
//        new SlidingWindowMaximum().maxSlidingWindow1(test,3);
        double temp = 30.0 * 50 * 0.4 + 30 * 50 * 1.1 / 2 - 3.5 * 1.3717 * 13 - 3.5 * 13 * 0.13 / 2;
        System.out.println(temp);
    }
}
