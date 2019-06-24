import struct.Node;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public void reorderList(ListNode head) {

        if(head == null || head.next == null || head.next.next == null) {
            return;
        }

        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode first = slow.next;
        ListNode second = first.next;
        slow.next = null;
        first.next = null;
        while (second != null) {
            ListNode third = second.next;
            second.next = first;

            first = second;
            second = third;
        }

        ListNode tmp = head;
        ListNode p = null;
        while(first != null) {
            p = first.next;
            first.next = tmp.next;
            tmp.next = first;
            tmp = tmp.next.next;
            first = p;
        }

        return;
    }

    public static void main(String[] args) {

        Solution s = new Solution();

        long sysDate1 = System.currentTimeMillis();

        ListNode f = new ListNode(1);
        ListNode head = f;
        f.next = new ListNode(2);
        f = f.next;
        f.next = new ListNode(3);
        f = f.next;

        ListNode newNode = f;

        f.next = new ListNode(4);
        f = f.next;
        f.next = new ListNode(5);
        f = f.next;
        f.next = new ListNode(6);
        f = f.next;

        s.reorderList(head);

        ListNode p = head;
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}