package com.github;

import java.util.Arrays;

/**
 * 快速排序模板
 *
 * @author ZhangFuQi
 * @date 2021/8/3 21:49
 */
public class QuickSort {
    public void sort(int[] array, int low, int high) {
        if (low < high) {
            int pi = partitionSwapped(array, low, high);

            sort(array, low, pi - 1);
            sort(array, pi + 1, high);
        }
    }

    private int partitionSwapped(int[] array, int low, int high) {
        int pivot = array[low];
        //start存放pivot坐标
        int start = low;
        while (low < high) {
            while (low < high && array[high] >= pivot) {
                high--;
            }
            while (low < high && array[low] <= pivot) {
                low++;
            }
            swap(array, low, high);
        }
        swap(array, low, start);
        return low;
    }

    private void swap(int[] array, int low, int high) {
        int temp = array[low];
        array[low] = array[high];
        array[high] = temp;
    }

    private int partition(int[] array, int low, int high) {
        int pivot = array[low];
        int left = low;
        int right = high;
        while (left < right) {
            while (left < right && array[right] >= pivot) {
                right--;
            }
            if (left < right) {
                array[left] = array[right];
            }
            while (left < right && array[left] <= pivot) {
                left++;
            }
            if (left < right) {
                array[right] = array[left];
            }
        }
        array[left] = pivot;
        return left;
    }

    public static void main(String[] args) {
        int[] ints = {3, 2, 3, 1, 2, 4, 5, 5, 6, 4};
        new QuickSort().sort(ints, 0, ints.length - 1);
        System.out.println(Arrays.toString(ints));
    }
}
