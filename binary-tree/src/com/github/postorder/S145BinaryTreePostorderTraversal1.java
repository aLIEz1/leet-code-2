package com.github.postorder;

import com.github.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 145 后序遍历递归版本
 *
 * @author ZhangFuQi
 * @date 2021/7/31 1:39
 */
public class S145BinaryTreePostorderTraversal1 {
    List<Integer> list = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        traversal(root);
        return list;
    }

    private void traversal(TreeNode root) {
        if (root == null) {
            return;
        }
        traversal(root.left);
        traversal(root.right);
        list.add(root.val);
    }

}
