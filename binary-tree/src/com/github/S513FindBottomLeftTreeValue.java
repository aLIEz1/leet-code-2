package com.github;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 树左下角的值
 *
 * @author ZhangFuQi
 * @date 2021/7/31 21:20
 */
public class S513FindBottomLeftTreeValue {
    public int findBottomLeftValue(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        if (root != null) {
            queue.offer(root);
        }
        int leftValue = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (i == 0) {
                    leftValue = cur.val;
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }
        return leftValue;
    }
}
