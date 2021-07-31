package com.github.levelorder;

import com.github.TreeNode;

import java.util.*;

/**
 * 107 二叉树层序遍历II
 *
 * @author ZhangFuQi
 * @date 2021/7/31 14:48
 */
public class S107BinaryTreeLevelOrderTraversal2 {
    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list1 = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                list1.add(cur.val);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            list.add(list1);
        }
        Collections.reverse(list);
        return list;
    }
}
