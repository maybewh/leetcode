package com.leetcode.top100;

import javax.sql.rowset.CachedRowSet;
import java.util.*;

public class L_438_FindAllAnagramsInAString {

    public List<Integer> findAnagrams(String s, String p) {


        List<Integer> res = new ArrayList<>();

        int sLength = s.length();
        int pLength = p.length();

        if (sLength == 0 || pLength == 0 || p.length() > s.length()) {
            return res;
        }

        // 字符串中间已经判断的，可以不用再做处理，只需要减去第一个，和加上后面添加的字符，然后再做判断即可
        int[] sChars = new int[26];
        int[] pChars = new int[26];


        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            pChars[c - 'a']++;
        }

        int start = 0;
        int end = 0;
        while (end < s.length()) {
            char endC = s.charAt(end);
            sChars[endC - 'a']++;
            if (end - start + 1 == p.length()) {
                boolean tmp = Arrays.equals(sChars, pChars); //关键API，简化代码。判断两个数组对应元素是否相等
                if (tmp) res.add(start);
                sChars[s.charAt(start) - 'a']--;
                start++;
            }
            end++;
        }

        return res;
    }

}
