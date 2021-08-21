package com.github;

import java.util.ArrayList;
import java.util.List;

/**
 * 复原IP地址
 *
 * @author ZhangFuQi
 * @date 2021/8/15 22:42
 */
public class S93RestoreIpAddresses {

    private static final int SEG_COUNT = 4;
    private final List<String> ans = new ArrayList<>();
    private int[] segment;

    public List<String> restoreIpAddresses(String s) {
        segment = new int[SEG_COUNT];
        dfs(s, 0, 0);
        return ans;
    }

    private void dfs(String s, int segId, int segStart) {
        if (segId == SEG_COUNT) {
            if (segStart == s.length()) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < SEG_COUNT; i++) {
                    sb.append(segment[i]);
                    if (i != SEG_COUNT - 1) {
                        sb.append(".");
                    }
                }
                ans.add(sb.toString());
            }
            return;
        }
        //对应没找到4段ip就遍历完了字符串的情况
        if (segStart == s.length()) {
            return;
        }
        //如果当前数字为0，则这一段ip地址只能为0
        if (s.charAt(segStart) == '0') {
            segment[segId] = 0;
            dfs(s, segId + 1, segStart + 1);
        }

        //对应一般情况
        int address = 0;
        for (int i = segStart; i < s.length(); i++) {
            address = address * 10 + (s.charAt(i) - '0');
            if (address > 0 && address <= 0xFF) {
                segment[segId] = address;
                dfs(s, segId + 1, i + 1);
            } else {
                break;
            }
        }
    }
}
