package com.github;

/**
 * 平衡二叉树
 *
 * @author ZhangFuQi
 * @date 2021/7/31 16:56
 */
public class S110BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(getDepth(root.left) - getDepth(root.right)) <= 1
                && (isBalanced(root.left) && isBalanced(root.right));
    }

    private int getDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(getDepth(node.left), getDepth(node.right));
    }
}
