package com.github;

/**
 * 104 二叉树的最大深度
 *
 * @author ZhangFuQi
 * @date 2021/7/31 15:57
 */
public class S104MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //1+表示当前有节点，深度+1，两个节点的深度取长的那个
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
