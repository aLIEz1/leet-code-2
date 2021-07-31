package com.github;

/**
 * 101 对称二叉树
 *
 * @author ZhangFuQi
 * @date 2021/7/31 15:26
 */
public class S101SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return symmetric(root.left, root.right);
    }

    private boolean symmetric(TreeNode left, TreeNode right) {
        //左右都不为空，则比较数值，不相等就返回false
        if (left != null && right != null) {
            if (left.val != right.val) {
                return false;
            }
            //左右都为空返回true
        } else if (left == null && right == null) {
            return true;
            //左右有一个不为空，返回false
        } else {
            return false;
        }
        return symmetric(left.left, right.right) && symmetric(left.right, right.left);
    }
}
