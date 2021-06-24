package com.leetcode.top100;

import java.util.List;

/**
 * 单词分割，子问题
 */
public class L_139_WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {

        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) {
            return false;
        }

        boolean[] result = new boolean[s.length() + 1];
        result[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            /**
             * 关键点：每增加一个字符判断时，都需要进行重新从头开始进行字符组合判定
             * 如：abcad子串，从a bcad， ab cad...依次进行判定，只要有一个为true则为true。否则为false。
             * 而本身已经存储了之前所有子串（a, ab,...）的结果
             */
            for (int j = 0; j < i; j++) {
                if (result[j] && wordDict.contains(s.substring(j, i))) {
                    result[i] = true;
                    break;
                }
            }
        }
        return result[s.length()];
    }


}
