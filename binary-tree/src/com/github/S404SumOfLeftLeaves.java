package com.github;

/**
 * 404 左子叶之和
 *
 * @author ZhangFuQi
 * @date 2021/7/31 21:05
 */
public class S404SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null) {
            return sumOfLeftLeaves(root.right);
        } else if (root.left.left == null && root.left.right == null) {
            return root.left.val + sumOfLeftLeaves(root.right);
        } else {
            return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
        }
    }
}
