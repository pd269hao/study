package org.dragon.practice.study.algorithm;

/**
 * Created with IntelliJ IDEA.
 * 验证是否是二叉搜索树
 * <p>
 * 记录所有子树的最大最小值
 * 注意，BST中不包含相同元素
 *
 * @Author: Liuwl
 * Date: 2020/6/10
 **/
public class ValidBST {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return validSubTree(root) != null;
    }

    private Child validSubTree(TreeNode node) {

        if (node.left == null && node.right == null) {
            return new Child(node.val, node.val);
        }
        int max = node.val;
        int min = node.val;
        Child left = null, right = null;
        if (node.left != null) {
            left = validSubTree(node.left);
            if (left != null) {
                if (node.val <= left.max) {
                    return null;
                }
                min = left.min;
            } else {
                return null;
            }
        }

        if (node.right != null) {
            right = validSubTree(node.right);
            if (right != null) {
                if (node.val >= right.min) {
                    return null;
                }
                max = right.max;
            } else {
                return null;
            }
        }


        return new Child(max, min);

    }

    class Child {
        int max;
        int min;

        public Child(int a, int b) {
            this.max = a;
            this.min = b;
        }
    }

    TreeNode pre = null;

    public boolean isValidBST1(TreeNode root) {

        // 中序遍历，记录前一个节点
        return valid(root);
    }

    private boolean valid(TreeNode node) {
        if (node == null) {
            return true;
        }
        if (!valid(node.left)) {
            return false;
        }

        if (pre != null && node.val <= pre.val) {
            return false;
        }
        pre = node;
        return valid(node.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode left = new TreeNode(-1);
        root.left = left;

        System.out.println(new ValidBST().isValidBST(root));
    }
}
