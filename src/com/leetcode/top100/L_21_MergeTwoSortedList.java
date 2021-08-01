package com.leetcode.top100;

public class L_21_MergeTwoSortedList {

    /**
     * [5]
     * [1,2,4]
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        if (l1 == null && l2 == null) {
            return null;
        }

        // 以一个链接为准，现以第一个为准，进行插入排序
        ListNode tmp1 = l1;
        ListNode tmp2 = l2;
        ListNode tmp1Before = null;
        ListNode result = l1;
        while (tmp1 != null && tmp2 != null) {
            if (tmp1.val <= tmp2.val) {
                tmp1Before = tmp1;
                tmp1 = tmp1.next;

            } else {

                if (tmp1Before == null) {
                    tmp1Before = tmp2;
                    result = tmp1Before;
                } else {
                    tmp1Before.next = tmp2;
                    /**
                     * 此处是需要注意的，因为，tpm1没动，在tm1Before和tmp1之间插入一个元素,所以tmp1Before需要向后移动一位，
                     * 这样才能保证这个变量的定义，即tmp1的前一个节点
                     */
                    tmp1Before = tmp2;
                }

                ListNode currentTmp = tmp2.next;
                tmp2.next = tmp1;
                tmp2 = currentTmp;
            }
        }

        if (tmp2 != null && tmp1Before != null) {
            tmp1Before.next = tmp2;
        }
        return result;

    }

    class ListNode {

        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val ,ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
