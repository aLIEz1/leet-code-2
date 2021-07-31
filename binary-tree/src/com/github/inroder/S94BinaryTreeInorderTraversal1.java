package com.github.inroder;

import com.github.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树中序遍历递归法
 *
 * @author ZhangFuQi
 * @date 2021/7/31 14:09
 */
public class S94BinaryTreeInorderTraversal1 {
    List<Integer> list = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        traversal(root);
        return list;
    }

    private void traversal(TreeNode root) {
        if (root == null) {
            return;
        }
        traversal(root.left);
        list.add(root.val);
        traversal(root.right);
    }
}
