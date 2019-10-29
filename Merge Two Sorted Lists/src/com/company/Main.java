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
        a.next = new ListNode(2);
        a.next.next = new ListNode(4);


        ListNode b = new ListNode(1);
        b.next = new ListNode(3);
        b.next.next = new ListNode(4);


        Main in = new Main();

        in.mergeTwoLists2(a, b);
    }

    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        return this.helper(l1, l2, null);
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode temp = head;

        while (l1 != null || l2 != null) {
            if (l1 == null || l1.val > l2.val) {
                temp.next = l2;
                temp = temp.next;
                l2 = l2.next;
            } else {
                temp.next = l1;
                temp = temp.next;
                l1 = l1.next;
            }
        }
        return head.next;
    }

    public ListNode helper(ListNode l1, ListNode l2, ListNode result) {
        ListNode x1 = new ListNode(-1);
        ListNode x2 = new ListNode(-1);

        if (l1 == null && l2 == null) {
            return  result;
        }

        if (l1 == null) {
            x2 = l2.next;
            x1 = l1;

            result = new ListNode(l2.val);
        }

        if (l2 == null) {
            x2 = l2;
            x1 = l1.next;

            result = new ListNode(l1.val);
        }


        if (l2 != null && l1 != null) {

            if (l1.val < l2.val) {
                x1 = l1.next;
                x2 = l2;

                result = new ListNode(l1.val);
            } else {
                x1 = l1;
                x2 = l2.next;

                result = new ListNode(l2.val);
            }
        }

        result.next = helper(x1, x2, result.next);

        return result;
    }
}
