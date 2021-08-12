package com.github;

import java.util.LinkedList;

/**
 * 跟节点到叶子节点数字之和
 *
 * @author ZhangFuQi
 * @date 2021/8/13 0:49
 */
public class S129SumRoot2LeafNumbers {

    public int sumNumbers(TreeNode root) {
        LinkedList<Integer> path = new LinkedList<>();
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int prev) {
        if (root == null) {
            return 0;
        }
        //知道前一个节点的时候就可以直到怎么计算总和了，前一个节点*10加上本节点即可
        int sum = prev * 10 + root.val;
        //对应叶子节点情况
        if (root.left == null && root.right == null) {
            return sum;
        }
        int l = dfs(root.left, sum);
        int r = dfs(root.right, sum);
        return l + r;
    }
}
