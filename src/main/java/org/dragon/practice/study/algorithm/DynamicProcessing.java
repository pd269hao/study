package org.dragon.practice.study.algorithm;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Liuwl
 * Date: 2020/6/30
 **/
public class DynamicProcessing {
    public int maxProduct(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        /**
         * 每个位置的最大值
         */
        int[] max = new int[nums.length];
        /**
         * 每个位置负的最小值，可以为0
         */
        int[] min = new int[nums.length];
        if (nums[0] >= 0) {
            max[0] = nums[0];
            min[0] = 0;
        } else {
            min[0] = nums[0];
            max[0] = 0;
        }
        int result = max[0];

        for (int i = 1; i < nums.length; i++) {
            int n = nums[i];
            max[i] = Math.max(Math.max(max[i - 1] * n, n), min[i - 1] * n);
            min[i] = Math.min(Math.min(min[i - 1] * n, n), max[i - 1] * n);

            if (result < max[i]) {
                result = max[i];
            }
        }

        return result;

    }
}
