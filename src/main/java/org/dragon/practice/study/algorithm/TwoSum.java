package org.dragon.practice.study.algorithm;

//Given an array of integers, return indices of the two numbers such that they a
//dd up to a specific target.
//
// You may assume that each input would have exactly one solution, and you may n
//ot use the same element twice.
//
// Example:
//
//
//Given nums = [2, 7, 11, 15], target = 9,
//
//Because nums[0] + nums[1] = 2 + 7 = 9,
//return [0, 1].
//
// Related Topics Array Hash Table


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int[] twoSum(int[] nums, int target) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        list.sort(Integer::compareTo);
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            int sum = list.get(left) + list.get(right);
            if (sum == target) {
                return new int[]{left, right};
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return null;
    }

    //空间占用太多
    public int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (numMap.containsKey(nums[i])) {
                return new int[]{i,numMap.get(nums[i])};
            }

            numMap.put(target - nums[i], i);
        }
        return null;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
