package com.github;

/**
 * 路径总和
 *
 * @author ZhangFuQi
 * @date 2021/8/13 0:20
 */
public class S112PathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, targetSum);
    }

    private boolean dfs(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null &&
                root.right == null &&
                root.val == targetSum //当剩下的targetSum等于root.val且root为叶子节点的时候直接返回true
        ) {
            return true;
        }
        //每次dfs减去当前的root.val，以便于上面的比较
        boolean l = dfs(root.left, targetSum - root.val);
        boolean r = dfs(root.right, targetSum - root.val);
        return l || r;
    }
}
