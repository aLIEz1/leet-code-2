package com.github;

/**
 * 二叉树最小深度
 *
 * @author ZhangFuQi
 * @date 2021/7/31 16:03
 */
public class S111MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left != null && root.right != null) {
            return 1 + Math.min(minDepth(root.left), minDepth(root.right));
        } else if (root.left == null && root.right != null) {
            return 1 + minDepth(root.right);
        } else if (root.left != null) {
            return 1 + minDepth(root.left);
        } else {
            return 1;
        }
    }
}
