package org.dragon.practice.study.algorithm;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Liuwl
 * Date: 2020/6/11
 **/
public class Main {
    public static void main(String[] args) {
        Integer[] nums = new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4};
        TreeNode root = Utils.constructTree(nums);

        new LowestCommonAncestor().lowestCommonAncestor(root, root.left, root.right);
    }
}
