package com.github;

/**
 * 二叉树中的最大路径和
 *
 * @author ZhangFuQi
 * @date 2021/8/12 23:48
 */
public class S124BinaryTreeMaximumPathSum {
    int maxPathSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

        dfs(root);
        return maxPathSum;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = Math.max(dfs(root.left), 0);
        int r = Math.max(dfs(root.right), 0);
        maxPathSum = Math.max(maxPathSum, root.val + l + r);
        //这里只返回了左右子树中最大的一个加上根节点的值，避免了在一棵树上吊死，
        // 如果两个都返回说明 走的A->B->C这条路径了，不符合题意，但是计算的时候要加上，因为要的是最大值
        /*
         *
         *       B
         *     /  \
         *   A     C
         */
        return root.val + Math.max(l, r);
    }
}
