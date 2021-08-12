package com.github.doublepointer.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 最小覆盖子串
 *
 * @author ZhangFuQi
 * @date 2021/8/12 22:24
 */
public class S76MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        int left = 0;
        int right = 0;
        Map<Character, Integer> window = new HashMap<>(s.length());
        Map<Character, Integer> needle = new HashMap<>(t.length());
        int valid = 0;
        //初始化needle映射关系
        for (char c : tArr) {
            needle.put(c, needle.getOrDefault(c, 0) + 1);
        }

        int min = Integer.MAX_VALUE;
        int start = 0;
        String ans = "";
        while (right < sArr.length) {
            char r = sArr[right];
            right++;
            if (needle.containsKey(r)) {
                window.put(r, window.getOrDefault(r, 0) + 1);
                if (window.get(r).equals(needle.get(r))) {
                    valid++;
                }
            }

            //开始收缩窗口
            while (valid == needle.size()) {
                if (right - left < min) {
                    start = left;
                    min = right - left;
                }
                char l = sArr[left];
                left++;
                if (needle.containsKey(l)) {
                    if (window.get(l).equals(needle.get(l))) {
                        valid--;
                    }
                    window.put(l, window.get(l) - 1);
                }
            }
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(start, start + min + 1);
    }
}
