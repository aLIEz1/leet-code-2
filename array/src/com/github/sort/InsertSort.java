package com.github.sort;

import java.util.Arrays;

/**
 * 插入排序
 *
 * @author ZhangFuQi
 * @date 2021/8/20 23:10
 */
public class InsertSort implements ArraySort {
    @Override
    public void sort(int[] nums) {
        int n = nums.length;
        //i是次数，也即排好的个数;j是继续排
        // 第一个数字默认是排好序的，i从1开始
        // j从i开始，从右向左寻找，如果遇到前面的一个比后面的要大则交换
        // 否则退出循环
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
                    swap(nums, j, j - 1);
                } else {
                    break;
                }

            }

        }
    }

    private void swap(int[] nums, int j, int i) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {3, 35, 2, 1, 6, 43, 3};
        ArraySort sort = new InsertSort();
        sort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
