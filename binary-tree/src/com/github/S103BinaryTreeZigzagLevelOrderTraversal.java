package com.github;

import java.util.*;

/**
 * 二叉树锯齿形状遍历
 *
 * @author ZhangFuQi
 * @date 2021/8/6 0:36
 */
public class S103BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        List<List<Integer>> ans = new ArrayList<>();
        if (root != null) {
            queue.push(root);
        }
        boolean flag = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> list = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (!flag) {
                    list.offerFirst(cur.val);
                } else {
                    list.offerLast(cur.val);
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }

            }
            ans.add(list);
            flag = !flag;
        }
        return ans;
    }
}
