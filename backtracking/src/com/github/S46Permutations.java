package com.github;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 全排列
 *
 * @author ZhangFuQi
 * @date 2021/8/7 21:58
 */
public class S46Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        int n = nums.length;
        //用used数组记录访问过的数据
        boolean[] used = new boolean[n];
        backtracking(nums, ans, path, used, n);
        return ans;
    }

    private void backtracking(int[] nums, List<List<Integer>> ans, LinkedList<Integer> path, boolean[] used, int n) {
        if (path.size() == n) {
            List<Integer> add = new LinkedList<>(path);
            ans.add(add);
            return;
        }
        for (int i = 0; i < n; i++) {
            //如果当前数据这次已经访问过了，则直接跳过此次循环
            if (used[i]) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            backtracking(nums, ans, path, used, n);
            used[i] = false;
            path.removeLast();
        }
    }
}
