package com.github;

/**
 * 二叉树的直径
 *
 * @author ZhangFuQi
 * @date 2021/8/21 23:28
 */
public class S543DiameterOfBinaryTree {
    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return max;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        //比较每层节点的左右子树深度相加，取最大值
        max = Math.max(left + right, max);
        //计算深度的
        return Math.max(left, right) + 1;
    }

}
