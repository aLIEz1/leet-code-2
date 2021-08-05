package com.github;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 三数之和
 *
 * @author ZhangFuQi
 * @date 2021/8/5 22:44
 */
public class S15ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return Collections.emptyList();
        }
        //先排序，方便移动指针
        sort(nums, 0, nums.length - 1);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            //如果第一个就大于0了，后面的肯定也大于0
            // 直接返回结果即可
            if (nums[i] > 0) {
                return ans;
            }
            //nums[i]去重,当前面一个和现在的这个相等的时候直接跳过当前的i
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            //注意left和right要在这里定义，
            // 因为每次遍历nums[i]的时候right都要在最右边，而left每次都是在i+1的位置上
            int left = i + 1;
            int right = nums.length - 1;
            //动态查找，三数之和比0大就把right往左挪动
            // 三数之和比0小就把left往有挪动
            // 相等就把三个数加在list中添加到ans中
            // 要注意添加完之后left 和right也需要去重，去重逻辑与i类似，但是条件变成了left要小于right要用while去重
            // 找到答案并去重之后left和right要同时收缩区间
            while (left < right) {
                if (nums[i] + nums[right] + nums[left] > 0) {
                    right--;
                } else if (nums[i] + nums[right] + nums[left] < 0) {
                    left++;
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    ans.add(list);
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (right > left && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    right--;
                    left++;
                }
            }
        }
        return ans;
    }

    private void sort(int[] nums, int low, int high) {
        if (low < high) {
            int pi = partition(nums, low, high);
            sort(nums, low, pi - 1);
            sort(nums, pi + 1, high);
        }
    }

    private int partition(int[] nums, int low, int high) {
        int pivot = nums[low];
        int start = low;
        while (low < high) {
            while (low < high && nums[high] >= pivot) {
                high--;
            }
            while (low < high && nums[low] <= pivot) {
                low++;
            }
            swap(nums, low, high);
        }
        swap(nums, start, low);
        return low;
    }

    private void swap(int[] nums, int low, int high) {
        int temp = nums[low];
        nums[low] = nums[high];
        nums[high] = temp;
    }

    public static void main(String[] args) {
        System.out.println(new S15ThreeSum().threeSum(new int[]{0, 0, 0}));
    }
}
