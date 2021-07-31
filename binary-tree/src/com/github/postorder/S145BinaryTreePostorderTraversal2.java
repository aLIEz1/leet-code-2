package com.github.postorder;

import com.github.TreeNode;

import java.util.*;

/**
 * 145 后序遍历迭代版本
 * 中左右-> 中右左 -> 左右中
 * 反转再反转
 *
 * @author ZhangFuQi
 * @date 2021/7/31 1:39
 */
public class S145BinaryTreePostorderTraversal2 {
    List<Integer> list = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        if (root != null) {
            stack.push(root);
        }
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            list.add(cur.val);
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (cur.right != null) {
                stack.push(cur.right);
            }
        }
        Collections.reverse(list);
        return list;
    }


}
