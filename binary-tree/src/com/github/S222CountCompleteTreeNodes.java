package com.github;

/**
 * 完全二叉树的节点个数
 * 满二叉树的结点数为：2^depth - 1
 * 求完全二叉树最大深度肯定是最左边的叶子节点
 * 画出完全二叉树，当左右子树深度相等的时候，一定是左边的子树是完全二叉树
 * 当左右子树深度不相等的时候，一定是右边子树是完全二叉树
 *
 * @author ZhangFuQi
 * @date 2021/7/31 16:19
 */
public class S222CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        if (leftDepth == rightDepth) {
            return (1 << leftDepth) + countNodes(root.right);
        } else {
            return (1 << rightDepth) + countNodes(root.left);

        }
    }

    private int getDepth(TreeNode node) {
        int depth = 0;
        while (node != null) {
            depth++;
            node = node.left;
        }
        return depth;
    }
}
