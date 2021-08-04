package com.github.doublepointer.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 无重复字符的最长子串
 *
 * @author ZhangFuQi
 * @date 2021/8/3 22:50
 */
public class S3LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        char[] arr = s.toCharArray();
        int length = arr.length;
        if (length == 0) {
            return 0;
        }

        int left = 0;
        int right = 0;
        Map<Character, Integer> window = new HashMap<>(16);
        int maxLen = 0;

        while (right < length) {
            char c = arr[right];
            window.put(c, window.getOrDefault(c, 0) + 1);
            right++;
            while (window.get(c) > 1) {
                window.put(arr[left], window.get(arr[left]) - 1);
                left++;
            }
            //前面while循环已经将window削减到合适的大小，此时比较最大值和
            maxLen = Math.max(maxLen, right - left);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(new S3LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("avba"));
    }
}
