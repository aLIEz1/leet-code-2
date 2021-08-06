package com.github;

/**
 * 搜索旋转排序数组
 *
 * @author ZhangFuQi
 * @date 2021/8/6 20:47
 */
public class S33SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return mid;
            }
            //4567012当mid选中5 6 7 的时候，都是要比nums[left]要大的说明此时mid偏左了，左边是有序的
            //注意！ mid通过left + ((right - left) >> 1)计算出来是偏左的，即向下取整，
            // 所以nums[mid]可能等于nums[left],
            // 但是nums[mid]一定不可能等于nums[right]，相等的时候已经跳出循环了
            //mid偏左
            if (nums[mid] >= nums[left]) {
                //再判断target是否在左边的区间里
                // 即比nums[left]要大于等于，比nums[mid]要小
                // 此时target在左边区间寻找令right=mid-1
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                    //如果不在这个区间内则说明是在右边区间，令left=mid+1
                } else {
                    left = mid + 1;
                }
                //mid偏右
                //下面的情况和上面的类似，不在赘述
            } else {
                if (target <= nums[right] && target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
