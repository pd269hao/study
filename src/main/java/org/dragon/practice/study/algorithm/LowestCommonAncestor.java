package org.dragon.practice.study.algorithm;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * 1. 二叉搜索树寻找最近公共祖先；
 * 2. 二叉树搜索最近公共祖先；
 *
 * @Author: Liuwl
 * Date: 2020/6/11
 **/
public class LowestCommonAncestor {
    /**
     * 普通二叉树
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> pStack = new Stack<>();
        Stack<TreeNode> qStack = new Stack<>();

        findNode(root, p, pStack);
        findNode(root, q, qStack);
        while (qStack.size() > 0 && pStack.size() > 0) {
            if (qStack.size() > pStack.size()) {
                qStack.pop();
                continue;
            }
            if (qStack.size() < pStack.size()) {
                pStack.pop();
                continue;
            }
            TreeNode n;
            if ((n = pStack.pop()) == qStack.pop())
                return n;
        }
        return null;
    }


    private boolean findNode(TreeNode root, TreeNode node, Stack<TreeNode> nodeStack) {
        if (root == null) {
            return false;
        }
        nodeStack.push(root);
        if (root.val == node.val) {
            return true;
        } else {
            if (findNode(root.left, node, nodeStack)) {
                return true;
            }
            if (findNode(root.right, node, nodeStack)) {
                return true;
            }
            nodeStack.pop();
            return false;
        }
    }


    /**
     * BST
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        Set<TreeNode> nodeStack = new HashSet<>();
        findNode(root, p, nodeStack);
        List<TreeNode> nodeList = new ArrayList<>();
        findNode(root, q, nodeList);
        TreeNode node = null;
        for (int i = 0; i < nodeList.size(); i++) {
            if (nodeStack.contains(nodeList.get(i))) {
                node = nodeList.get(i);
            }
        }
        return node;
    }

    private void findNode(TreeNode root, TreeNode node, Set<TreeNode> nodeSet) {
        nodeSet.add(root);
        if (root.val > node.val) {
            findNode(root.left, node, nodeSet);
        } else if (root.val < node.val) {
            findNode(root.right, node, nodeSet);
        }
    }

    private void findNode(TreeNode root, TreeNode node, List<TreeNode> nodeSet) {
        nodeSet.add(root);
        if (root.val > node.val) {
            findNode(root.left, node, nodeSet);
        } else if (root.val < node.val) {
            findNode(root.right, node, nodeSet);
        }
    }


    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        } else {
            if (root.val > p.val && root.val > q.val) {
                return lowestCommonAncestor2(root.left, p, q);
            }
            if (root.val < p.val && root.val < q.val) {
                return lowestCommonAncestor2(root.left, p, q);
            }
            return root;
        }
    }

    private TreeNode findPorQ(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val) {
            return root;
        }
        TreeNode left = findPorQ(root.left, p, q);
        TreeNode right = findPorQ(root.right, p, q);

        if (left != null && right != null) {
            return root;
        } else if (left == null) {
            return right;
        } else {
            return left;
        }

    }

}
