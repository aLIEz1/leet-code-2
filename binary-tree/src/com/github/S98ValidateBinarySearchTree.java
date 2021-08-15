package com.github;

/**
 * 验证二叉搜索树
 *
 * @author ZhangFuQi
 * @date 2021/8/15 21:55
 */
public class S98ValidateBinarySearchTree {
    TreeNode prev = null;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean left = isValidBST(root.left);
        //中序遍历与前一个节点进行比较，二叉搜索树的特点就是中序遍历是有序序列，
        // prev小于当前root节点的时候才有可能是二叉搜索树，否则不可能是二叉搜索树
        if (prev != null && root.val <= prev.val) {
            return false;
        }
        prev = root;
        boolean right = isValidBST(root.right);

        return left && right;
    }
}
