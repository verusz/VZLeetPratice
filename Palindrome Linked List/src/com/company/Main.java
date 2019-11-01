package com.company;

  class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }

public class Main {

    public static void main(String[] args) {
	// write your code here

        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(1);

        a.next = b;
        isPalindrome(a);
    }

    public static boolean isPalindrome(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode pre = null;
        ListNode cur = slow.next;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }

        while (pre != null) {
            if (pre.val != head.val) {
                return false;
            }
            pre = pre.next;
            head = head.next;
        }

        return true;
    }
}
