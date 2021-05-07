package com.leetcode.top100;

import java.util.List;

public class SortList_148 {

      public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

      public ListNode sortList(ListNode head) {
          return sortNode(head);
      }

    /**
     * 使用归并排序的思路，先拆开链表，然后再合并两个已排序好的链表
     * @param head
     * @return
     */
      public ListNode sortNode(ListNode head) {

          if (head == null || head.next == null) {
              return head;
          }

          int len = 0;
          ListNode tmp = head;
          while (tmp != null) {
              len++;
              tmp = tmp.next;
          }

          int mid = len / 2;
          ListNode midNode = head;
          ListNode beforeMid = head;
          for (int i = 0; i < mid; i++) {
              beforeMid = midNode;
              midNode = midNode.next;
          }

          beforeMid.next = null;
          ListNode left = sortNode(head);
          ListNode right = sortNode(midNode);

          return mergeLinkedList(left, right);
      }

    /**
     * 合并两个已排好序的链表，已一个链表为基准，
     * 将另一个链表的元素合并到这个链表中。谁的头最小以谁为基准
     * @param node1
     * @param node2
     * @return
     */
      public ListNode mergeLinkedList(ListNode node1, ListNode node2) {
          ListNode tmp1 = node1;
          ListNode tmp2 = node2;

          if (tmp1 == null) {
              return tmp2;
          }

          if (tmp2 == null) {
              return tmp1;
          }

          if (tmp1 == null && tmp2 == null) {
              return null;
          }

          ListNode returnNode = tmp1;
          ListNode beforeNode = tmp1;
          if (tmp2.val < tmp1.val) {
              returnNode = tmp2;
              tmp2 = tmp2.next;
              returnNode.next = tmp1;
              beforeNode = returnNode;
          }

          while (tmp1 != null && tmp2 != null) {
              if (tmp2.val < tmp1.val) {
                  beforeNode.next = tmp2;
                  ListNode temp = tmp2;
                  tmp2 = tmp2.next;
                  temp.next = tmp1;
                  beforeNode = temp;
              } else {
                  beforeNode = tmp1;
                  tmp1 = tmp1.next;
              }
          }

          /**
           * 合并剩余的链表节点
           */
          if (tmp2 != null) {
              beforeNode.next = tmp2;
          }

          return returnNode;
      }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l1.next = l2;

        ListNode l3 = new ListNode(2);
        l2.next = l3;

        ListNode l4 = new ListNode(3);
        l3.next = l4;

        SortList_148 sortList_148 = new SortList_148();
        ListNode result = sortList_148.sortList(l1);

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
