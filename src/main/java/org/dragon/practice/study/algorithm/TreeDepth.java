package org.dragon.practice.study.algorithm;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Liuwl
 * Date: 2020/6/13
 **/
public class TreeDepth {
    private int min = Integer.MAX_VALUE;
    private int max = 1;

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, 1);
        return max;
    }

    private void dfs(TreeNode node, int level) {
        if (node == null) {
            return;
        }

        if (max < level) {
            max = level;
        }
        dfs(node.left, level + 1);
        dfs(node.right, level + 1);
        if (node.left==null&&node.right==null){
            if (min > level) {
                min = level;
            }
        }
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, 1);
        return min;
    }
}
