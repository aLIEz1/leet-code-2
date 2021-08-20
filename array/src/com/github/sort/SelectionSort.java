package com.github.sort;

/**
 * 选择排序
 *
 * @author ZhangFuQi
 * @date 2021/8/20 22:59
 */
public class SelectionSort implements ArraySort {
    @Override
    public void sort(int[] nums) {
        int n = nums.length;

        //注意i<n-1,当i=i-1的时候交换之后就是顺序的了，这时是和最后一个进行交换
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            swap(nums, i, minIndex);
        }
    }

    private void swap(int[] nums, int j, int minIndex) {
        int temp = nums[j];
        nums[j] = nums[minIndex];
        nums[minIndex] = temp;
    }
}
