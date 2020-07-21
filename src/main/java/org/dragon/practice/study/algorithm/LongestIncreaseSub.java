package org.dragon.practice.study.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Liuwl
 * Date: 2020/7/16
 **/
public class LongestIncreaseSub {
    /**
     * n*n时间复杂度
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 1;

        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    /**
     * 二分查找
     * 维护一个最长子序列的数组lis，然后维护这个数组
     * 遍历原数组i，如果比lis最右元素大，则加在后面
     * 否则找到第一个比i大的数，然后替换它
     * lis数组长度就是结果
     *
     * @param nums
     * @return
     */
    public static int lengthOfLIS1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        List<Integer> lis = new ArrayList<>();
        lis.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > lis.get(lis.size() - 1)) {
                lis.add(nums[i]);
            } else {
                // 找到第一个比nums[i]大于或者等于的数，替换这个数
                int j = lis.size() / 2;
                while (j > 0) {
                    if (lis.get(j) >= nums[i] && lis.get(j - 1) < nums[i]) {
                        break;
                    }
                    if (lis.get(j) > nums[i]) {
                        j = j / 2;
                        continue;
                    }
                    if (lis.get(j) < nums[i]) {
                        j = (j + lis.size()) / 2;
                    }
                }
                lis.set(j, nums[i]);
            }
        }


        return lis.size();
    }
}
