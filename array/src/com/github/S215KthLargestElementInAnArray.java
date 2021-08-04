package com.github;

/**
 * 数组中第K个最大元素
 *
 * @author ZhangFuQi
 * @date 2021/8/3 18:14
 */
public class S215KthLargestElementInAnArray {

    public int findKthLargest(int[] nums, int k) {
        return sort(nums, 0, nums.length - 1, nums.length - k);
    }

    private int sort(int[] nums, int low, int high, int index) {
        int pi = partitionSwapped(nums, low, high);
        if (index == pi) {
            return nums[pi];
        } else if (pi < index) {
            return sort(nums, pi + 1, high, index);
        } else {
            return sort(nums, low, pi - 1, index);
        }
    }

    private int partition(int[] nums, int low, int high) {
        int pivot = nums[low];
        while (low < high) {
            while (low < high && nums[high] >= pivot) {
                high--;
            }
            if (low < high) {
                nums[low] = nums[high];
            }
            while (low < high && nums[low] <= pivot) {
                low++;
            }
            if (low < high) {
                nums[high] = nums[low];
            }
        }
        nums[low] = pivot;
        return low;
    }

    private int partitionSwapped(int[] nums, int low, int high) {
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
}
