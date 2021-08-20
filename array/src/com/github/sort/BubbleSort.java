package com.github.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 *
 * @author ZhangFuQi
 * @date 2021/8/20 21:12
 */
public class BubbleSort implements ArraySort {

    @Override
    public void sort(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
            }
        }
    }

    private static void swap(int[] nums, int j, int i) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {3, 5, 2, 6, 8, 2, 5};
        ArraySort bubbleSort = new BubbleSort();
        bubbleSort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
