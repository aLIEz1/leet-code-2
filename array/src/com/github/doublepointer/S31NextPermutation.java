package com.github.doublepointer;

/**
 * 下一个排列
 *
 * @author ZhangFuQi
 * @date 2021/8/9 23:44
 */
public class S31NextPermutation {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        //找到最靠右边的较小的数字，逆序寻找
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        //没找到头
        if (i >= 0) {
            int j = nums.length - 1;
            //找到第一个nums[i] < nums[j]的j下标
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        //此时i+1 区间的数字一定是逆序排列的，直接反转，编程正序即可得到最小的下一个排列
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int i) {
        int left = i;
        int right = nums.length - 1;
        while (left <= right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
