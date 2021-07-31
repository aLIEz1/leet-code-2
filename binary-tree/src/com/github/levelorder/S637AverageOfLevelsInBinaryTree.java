package com.github.levelorder;

import com.github.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 163 二叉树层平均值
 *
 * @author ZhangFuQi
 * @date 2021/7/31 15:07
 */
public class S637AverageOfLevelsInBinaryTree {
    List<Double> list = new ArrayList<>();

    public List<Double> averageOfLevels(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                sum += cur.val;
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            list.add(sum / size);
        }
        return list;
    }
}
