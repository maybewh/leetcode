package com.leetcode.top100;

/**
 * 环形链表 II
 * 思路：快慢指针
 * https://www.nowcoder.com/practice/253d2c59ec3e4bc68da16833f79a38e4?tpId=13&tqId=11208&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking&tab=answerKey
 *
 */
public class LinkedListCycleII_142 {
    
      class ListNode {
          int val;
          ListNode next;
          ListNode(int x) {
              val = x;
              next = null;
          }
      }

    /**
     * 在两个节点相遇后，只需要把快指针指向头节点，再和慢节点一起走过同样的距离并相遇，则相遇的点为环的起始节点
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {

          ListNode slow = head;
          ListNode fast = head;

          ListNode meeting = null;

          while (fast != null) {
              slow = slow.next;
              fast = fast.next;
              if (fast != null) {
                  fast = fast.next;
              }

              if (slow == fast) {
                  meeting = slow;
                  break;
              }
          }

          if (meeting != null) {
              fast = head;
              while (slow != fast) {
                  slow = slow.next;
                  fast = fast.next;
              }
          }
          return fast;
    }
}
