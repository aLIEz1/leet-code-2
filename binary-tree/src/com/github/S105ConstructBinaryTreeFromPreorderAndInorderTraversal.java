package com.github;

import java.util.HashMap;
import java.util.Map;

/**
 * 中序与后序序列构造二叉树
 *
 * @author ZhangFuQi
 * @date 2021/7/31 22:35
 */
public class S105ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>(16);
        int n = inorder.length;
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        return build(map, preorder, 0, n - 1, 0, n - 1);
    }

    private TreeNode build(Map<Integer, Integer> map, int[] preorder, int pl, int pr, int il, int ir) {
        if (il > ir) {
            return null;
        }
        int curValue = preorder[pl];
        int index = map.get(curValue);
        int leftSize = index - il;
        TreeNode root = new TreeNode(curValue);
        root.left = build(map, preorder, pl + 1, pl + leftSize, il, index - 1);
        root.right = build(map, preorder, pl + leftSize + 1, pr, index + 1, ir);
        return root;
    }
}
