package com.github;

/**
 * 226 翻转二叉树
 *
 * @author ZhangFuQi
 * @date 2021/7/31 15:15
 */
public class S226InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }

    private void invert(TreeNode invertRoot) {
        if (invertRoot == null) {
            return;
        }
        if (invertRoot.left != null || invertRoot.right != null) {
            TreeNode temp = invertRoot.left;
            invertRoot.left = invertRoot.right;
            invertRoot.right = temp;
        }
        invert(invertRoot.left);
        invert(invertRoot.right);
    }
}
