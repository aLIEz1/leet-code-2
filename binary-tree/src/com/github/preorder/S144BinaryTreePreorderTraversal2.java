package com.github.preorder;

import com.github.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 144 前序遍历 迭代版本
 *
 * @author ZhangFuQi
 * @date 2021/7/31 1:02
 */
public class S144BinaryTreePreorderTraversal2 {
    List<Integer> list = new LinkedList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        if (root != null) {
            stack.push(root);
        }
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            list.add(cur.val);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
        return list;
    }

}
