package com.leetcode.top100;

import java.util.ArrayList;
import java.util.List;

public class L_784_LetterCasePermutation {

    public List<String> letterCasePermutation(String s) {

        List<StringBuilder> list = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            List<StringBuilder> tmp = new ArrayList<>();

            for (int j = 0; j < list.size(); j++) {
                StringBuilder ss1 = list.get(j);

                if (c > '9' && c < 'a') {
                    tmp.add(new StringBuilder(ss1).append(String.valueOf(c).toLowerCase()));
                } else if (c >= 'a'){
                    tmp.add(new StringBuilder(ss1).append(String.valueOf(c).toUpperCase()));
                }

                ss1.append(c);
                tmp.add(ss1);
            }

            if (list.size() == 0) {
                tmp.add(new StringBuilder(String.valueOf(c)));
                if (c > '9' && c < 'a') {
                    tmp.add(new StringBuilder(String.valueOf(c).toLowerCase()));
                } else if (c >= 'a'){
                    tmp.add(new StringBuilder(String.valueOf(c).toUpperCase()));
                }
            }

            list = tmp;
        }

        List<String> result = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            result.add(new String(list.get(i)));
        }
        return result;
    }

    public static void main(String[] args) {
        L_784_LetterCasePermutation letterCasePermutation = new L_784_LetterCasePermutation();
        List<String> res = letterCasePermutation.letterCasePermutation("a1b2");
        System.out.println(res.size());
    }
}
