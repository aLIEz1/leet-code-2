package com.github.doublepointer;

/**
 * 移除元素
 *
 * @author ZhangFuQi
 * @date 2021/8/1 21:13
 */
public class S27RemoveElement {
    public int removeElement(int[] nums, int val) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        int fastIndex = 0;
        int slowIndex = 0;
        while (fastIndex < length) {
            if (nums[fastIndex] != val) {
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }
            fastIndex++;
        }
        return slowIndex;
    }

    public static void main(String[] args) {
        System.out.println(new S27RemoveElement().removeElement(new int[]{3, 2, 2, 3}, 3));
    }
}
