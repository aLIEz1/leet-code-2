package com.github.doublepointer;

import java.util.Arrays;

/**
 * 有序数组的平方
 * 注意不能在原数组上更改，容易出错
 *
 * @author ZhangFuQi
 * @date 2021/8/1 21:46
 */
public class S977SquaresOfaSortedArray {
    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int index = right;
        int[] squares = new int[nums.length];
        while (left <= right && index >= 0) {
            if (nums[left] * nums[left] <= nums[right] * nums[right]) {
                squares[index] = nums[right] * nums[right];
                right--;
            } else {
                squares[index] = nums[left] * nums[left];
                left++;
            }
            index--;
        }
        return squares;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new S977SquaresOfaSortedArray().sortedSquares(new int[]{-4, -1, 0, 3, 10})));
    }
}
