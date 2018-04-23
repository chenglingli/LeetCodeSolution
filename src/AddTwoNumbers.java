/**
 * Add Two Numbers
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.

 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode p1 = l1;
        ListNode p2 = l2;

        ListNode res = new ListNode(0);
        ListNode pRes = res;

        // add
        while (p1 != null && p2 != null) {
            pRes.val = p1.val + p2.val;
            pRes.next = new ListNode(0);
            pRes = pRes.next;
            p1 = p1.next;
            p2 = p2.next;
        }

        while(p1 != null ) {
            pRes.val = p1.val;
            pRes.next = new ListNode(0);

            pRes = pRes.next;
            p1 = p1.next;
        }

        while(p2 != null ) {
            pRes.val = p2.val;
            pRes.next = new ListNode(0);

            pRes = pRes.next;
            p2 = p2.next;
        }

        // carry
        pRes = res;
        int tempValue = 0;
        while (pRes != null) {
            pRes.val += tempValue;
            tempValue = pRes.val / 10;
            pRes.val = pRes.val % 10;
            pRes = pRes.next;
        }
        if (tempValue > 0 ) {
            pRes = new ListNode(0);
            pRes.val = tempValue;
        }

        // clear
        pRes = res;
        while (pRes.next.next != null) {
            pRes = pRes.next;
        }
        if (pRes.next.val == 0) {
            pRes.next = null;
        }

        return res;
    }

    public static void main(String[] args) {

        AddTwoNumbers s = new AddTwoNumbers();

//        ListNode l1 = new ListNode(5);
//        ListNode p1 = l1;
//        p1.next = new ListNode(3);
//        p1 = p1.next;
//        p1.next = new ListNode(6);
//        p1 = p1.next;
//
//        ListNode l2 = new ListNode(9);
//        l2.next = new ListNode(8);


        ListNode l1 = new ListNode(2);
        ListNode p1 = l1;
        p1.next = new ListNode(4);
        p1 = p1.next;
        p1.next = new ListNode(3);


        ListNode l2 = new ListNode(5);
        ListNode p2 = l2;
        p2.next = new ListNode(6);
        p2 = p2.next;
        p2.next = new ListNode(2);

        ListNode res = s.addTwoNumbers(l1, l2);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}

