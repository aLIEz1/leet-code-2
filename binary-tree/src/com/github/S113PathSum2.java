package com.github;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 路径总和
 *
 * @author ZhangFuQi
 * @date 2021/8/14 23:17
 */
public class S113PathSum2 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new LinkedList<>();
        dfs(root, targetSum, ans, path, 0);
        return ans;
    }

    private void dfs(TreeNode root, int targetSum, List<List<Integer>> ans, List<Integer> path, int curSum) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        //当前是叶子节点
        if (root.left == null && root.right == null) {
            if (curSum + root.val == targetSum) {
                ans.add(new ArrayList<>(path));
            }
        } else {
            curSum += root.val;
            dfs(root.left, targetSum, ans, new ArrayList<>(path), curSum);
            dfs(root.right, targetSum, ans, new ArrayList<>(path), curSum);
        }
    }
}
