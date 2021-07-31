package com.github;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的所有路径
 *
 * @author ZhangFuQi
 * @date 2021/7/31 18:40
 */
public class S257BinaryTreePaths {
    List<String> ans = new ArrayList<>();
    LinkedList<String> path = new LinkedList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        path(root);
        return ans;
    }

    private void path(TreeNode root) {
        path.add(root.val + "->");
        if (root.left == null && root.right == null) {
            StringBuilder sb = new StringBuilder();
            for (String s : path) {
                sb.append(s);
            }
            sb.delete(sb.length() - 2, sb.length());
            ans.add(sb.toString());
            return;
        }
        if (root.left != null) {
            path(root.left);
            path.removeLast();
        }
        if (root.right != null) {
            path(root.right);
            path.removeLast();
        }
    }
}
