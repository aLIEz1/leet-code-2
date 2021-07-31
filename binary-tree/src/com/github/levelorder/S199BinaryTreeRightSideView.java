package com.github.levelorder;

import com.github.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 199 二叉树的右视图
 *
 * @author ZhangFuQi
 * @date 2021/7/31 14:59
 */
public class S199BinaryTreeRightSideView {
    List<Integer> list = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (i == size - 1) {
                    list.add(cur.val);
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }
        return list;
    }
}
