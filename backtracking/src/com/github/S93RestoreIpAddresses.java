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
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backtracking(s, ans, sb, 0);
    }

    private void backtracking(String s, List<String> ans, StringBuilder sb, int startIndex) {
        if (startIndex > s.length()) {
            return;
        }
        if (sb.length() == s.length() + 3) {
            ans.add(sb.toString());
        }
        for (int i = startIndex; i < s.length(); i++) {

        }
    }
}
