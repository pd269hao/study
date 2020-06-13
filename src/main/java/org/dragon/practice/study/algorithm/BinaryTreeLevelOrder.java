package org.dragon.practice.study.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * 二叉树层序遍历
 *
 * @Author: Liuwl
 * Date: 2020/6/13
 **/
public class BinaryTreeLevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> list = new LinkedList<>();
        list.add(root);
        while (list.size() > 0) {
            List<Integer> level = new ArrayList<>();
            Queue<TreeNode> tmp = new LinkedList<>();
            while (list.size() > 0) {
                TreeNode node = list.poll();
                level.add(node.val);
                if (node.left != null) {
                    tmp.add(node.left);
                }
                if (node.right != null) {
                    tmp.add(node.right);
                }
            }
            result.add(level);

            list = tmp;

        }
        return result;

    }
}
