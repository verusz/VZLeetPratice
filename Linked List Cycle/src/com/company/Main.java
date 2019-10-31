package com.company;
import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
    }

    public boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head, fast = head.next;

        while (fast != slow) {
            if(fast==null || fast.next==null)
                return false;

            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}
