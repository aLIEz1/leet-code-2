package com.github;

/**
 * 二叉树的最近公共祖先
 *
 * @author ZhangFuQi
 * @date 2021/8/6 22:31
 */
public class S236LowestCommonAncestorOfaBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return dfs(root, p, q);
    }

    private TreeNode dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = dfs(root.left, p, q);
        TreeNode right = dfs(root.right, p, q);
        if (right != null && left != null) {
            return root;
        }
        if (left == null) {
            return right;
        }
        return left;
    }
}
