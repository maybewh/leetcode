package com.leetcode.top100;

import java.util.*;

public class L_394_DecodeString {

    public String decodeString(String s) {

        LinkedList<Character> stack = new LinkedList<>();

        char[] chars = s.toCharArray();
        int index = 0;

        while (index < s.length()) {

            if (chars[index] != ']') {
                stack.push(chars[index]);
            } else {

                LinkedList<Character> list = new LinkedList<>();
                while (!stack.isEmpty()) {

                    char ele = stack.pop();

                    if (ele == '[') {
                        String numResult = "";
                        while (!stack.isEmpty()) {
                            char numTmp = stack.peek();
                            int num = numTmp - '0';
                            if (num >= 0 && num <= 9) {
                                numResult = String.valueOf(numTmp) + numResult;
                                stack.pop();
                            } else {
                                break;
                            }
                        }

                        for (int i = 0; i < Integer.parseInt(numResult); i++) {
                            stack.addAll(0, list); // 用LinkedList模拟栈的时候，第一个元素为栈顶
                        }
                        list.clear();
                        break;
                    } else {
                        list.add(ele); //保持倒序，因此，在addAll到栈中时，依旧可以保持栈的顺序
                    }
                }


            }
            index++;
        }

        StringBuilder sb = new StringBuilder();
        stack.stream().forEach(str -> sb.append(str));
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
//        String s = "3[a]2[bc]";
        String s = "10[leetcode]";
        L_394_DecodeString decodeString = new L_394_DecodeString();
        System.out.println(decodeString.decodeString(s));
    }

    // 使用递归
    String src; // 要解析的字符串
    int ptr; // 起始位置

    // 构造函数初始化
    public String decodeStringByRecursion(String src) {
        this.src = src;
        this.ptr = 0; // 标识读取到要解析的字符串的何处
        return getString();
    }

    /**
     * 递归函数
     * @return
     */
    private String getString() {

        // 递归结束条件 1.ptr已经指向字符串最后一个字母 2. 遇到']'符号
        if (ptr == src.length() || src.charAt(ptr) == ']') {
            return "";
        }

        String ret = "";

        char cur = src.charAt(ptr);
        // 1. 如果是数字
        int repTime = 1;
        if (Character.isDigit(cur)) {
            // String -> Digit[String]String
            repTime = getDigits();
            // 过滤左括号
            ++ptr;
            // 然后解析字符串
            String str = getString();
            //过滤右括号
            ++ptr;
            // 构造字符串
            while(repTime-- > 0) {
                ret += str;
            }
        } else if (Character.isLetter(cur)) { // 如果是字母
            ret = String.valueOf(cur);
            ptr++;
        }
        return ret + getString(); // ]后面的字符串
    }

    private int getDigits() {
        int ret = 0;
        while (ptr < src.length() && Character.isDigit(src.charAt(ptr))) {
            ret = ret * 10 + src.charAt(ptr++) - '0';
        }
        return ret;
    }
}
