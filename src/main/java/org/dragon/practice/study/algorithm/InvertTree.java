package org.dragon.practice.study.algorithm;

/**
 * Created with IntelliJ IDEA.
 * 镜像翻转二叉树
 *
 * @Author: Liuwl
 * Date: 2020/5/20
 **/
public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if (root!=null) {
            invert(root);
        }
        return root;
    }

    private void invert(TreeNode node) {
        if (node.left != null) {
            invert(node.left);
        }
        if (node.right != null) {
            invert(node.right);
        }
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }



}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
