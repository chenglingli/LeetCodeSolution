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

public class AddTwoNumbersV2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode p1 = l1;
        ListNode p2 = l2;

        ListNode res = new ListNode(0);
        ListNode pRes = res;

        // add
        int carry = 0;
        while (p1 != null || p2 != null) {

            int val1 = (p1 != null ? p1.val : 0);
            int val2 = (p2 != null ? p2.val : 0);

            int curVal = val1 + val2 + carry;
            carry = curVal / 10;
            curVal = curVal % 10;

            pRes.next = new ListNode(curVal);
            pRes = pRes.next;

            if (p1 != null) p1 = p1.next;
            if (p2 != null) p2 = p2.next;
        }

        // last step
        if (carry > 0 ) pRes.next = new ListNode(carry);

        return res.next;
    }

    public static void main(String[] args) {

        AddTwoNumbersV2 s = new AddTwoNumbersV2();

        ListNode l1 = new ListNode(2);
        ListNode p1 = l1;
        p1.next = new ListNode(4);
        p1 = p1.next;
        p1.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        ListNode p2 = l2;
        p2.next = new ListNode(6);
        p2 = p2.next;
        p2.next = new ListNode(9);

        ListNode res = s.addTwoNumbers(l1, l2);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}

