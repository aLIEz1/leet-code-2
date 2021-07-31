package com.github.levelorder;

import com.github.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 102 二叉树层序遍历
 * 迭代写法
 *
 * @author ZhangFuQi
 * @date 2021/7/31 14:25
 */
public class S102BinaryTreeLevelOrderTraversal {
    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> innerList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                innerList.add(cur.val);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            list.add(innerList);
        }
        return list;
    }
}
