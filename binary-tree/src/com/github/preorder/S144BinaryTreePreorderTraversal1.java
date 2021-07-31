package com.github.preorder;

import com.github.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 144 前序遍历
 * 最基础的前序遍历版本，使用了递归，占用虚拟机栈较多
 * 在第二种解法中会写迭代法
 *
 * @author ZhangFuQi
 * @date 2021/7/31 1:02
 */
public class S144BinaryTreePreorderTraversal1 {
    List<Integer> list = new LinkedList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        traversal(root);
        return list;
    }

    private void traversal(TreeNode root) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        traversal(root.left);
        traversal(root.right);
    }
}
