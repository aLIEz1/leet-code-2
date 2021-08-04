package com.github;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 *
 * @author ZhangFuQi
 * @date 2021/8/4 0:06
 */
public class S1TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashMap = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (!hashMap.containsKey(target - nums[i])) {
                hashMap.put(nums[i], i);
            } else {
                return new int[]{hashMap.get(target - nums[i]), i};
            }
        }
        return new int[]{};
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
        int[] ints = {4, 2, 5, 3, 7};
        System.out.println(Arrays.toString(new S1TwoSum().twoSum(ints, 7)));
        System.out.println(Arrays.toString(ints));
    }
}
