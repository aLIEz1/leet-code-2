package com.github;

import java.util.HashMap;
import java.util.Map;

/**
 * 中序与后序序列构造二叉树
 *
 * @author ZhangFuQi
 * @date 2021/7/31 21:29
 */
public class S106ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> hashMap = new HashMap<>(16);
        for (int i = 0; i < inorder.length; i++) {
            hashMap.put(inorder[i], i);
        }
        return build(hashMap, postorder, 0, postorder.length - 1, inorder, 0, postorder.length - 1);

    }

    private TreeNode build(
            Map<Integer, Integer> hashMap,
            int[] postorder, int pl, int pr,
            int[] inorder, int il, int ir) {
        if (il > ir) {
            return null;
        }
        int cur = postorder[pr];
        int index = hashMap.get(cur);
        int leftSize = index - il;
        TreeNode root = new TreeNode(cur);
        root.left = build(hashMap, postorder, pl, pl + leftSize - 1, inorder, il, index - 1);
        root.right = build(hashMap, postorder, pl + leftSize, pr - 1, inorder, index + 1, ir);
        return root;
    }
}
