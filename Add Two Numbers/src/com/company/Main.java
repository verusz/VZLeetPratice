package com.company;
class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }

public class Main {

    public static void main(String[] args) {
	// write your code here
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(4);
        ListNode e = new ListNode(3);

        ListNode c = new ListNode(5);
        ListNode d = new ListNode(6);
        ListNode f = new ListNode(4);

        a.next = b;
        b.next = e;

        c.next = d;

        d.next = f;

        addTwoNumbers(a,c);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        boolean add = false;
        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;

            temp.next = new ListNode(add ? x + y + 1 : x + y);
            if (temp.next.val > 9) {
                add = true;
                temp.next.val = temp.next.val % 10;
            } else {
                add = false;
            }

            if ( l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }

            temp = temp.next;
        }

        if (add) {
            temp.next = new ListNode(1);
        }


        return dummy.next;
    }
}
