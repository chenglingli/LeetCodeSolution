import struct.ListNode;

public class L092_Reverse_Linked_List_II {


    /**
     *
     Reverse a linked list from position m to n. Do it in one-pass.

     Note: 1 ≤ m ≤ n ≤ length of list.

     Example:

     Input: 1->2->3->4->5->NULL, m = 2, n = 4
     Output: 1->4->3->2->5->NULL
     */

    public ListNode reverseBetween(ListNode head, int m, int n) {

        if (m >= n || head == null || head.next == null) {
            return head;
        }

        ListNode newHead = new ListNode(0);
        newHead.next = head;

        ListNode pre = newHead;
        ListNode front = newHead;

        int count = 0;

        while (count < m) {
            count++;
            pre = front;
            front = front.next;
        }

        ListNode q = front;
        ListNode temp = front;
        while ( count <= n) {
            temp = q.next;

            q.next = pre.next;
            pre.next = q;

            q = temp;
            count ++;
        }

        front.next = temp;

        return newHead.next;
    }

    public static void main(String[] args) {

        L092_Reverse_Linked_List_II s = new L092_Reverse_Linked_List_II();

        long sysDate1 = System.currentTimeMillis();

        ListNode f = new ListNode(1);
        ListNode head = f;
        f.next = new ListNode(2);
        f = f.next;
        f.next = new ListNode(3);
        f = f.next;
        f.next = new ListNode(4);
        f = f.next;
        f.next = new ListNode(5);
        f = f.next;
        f.next = new ListNode(6);

        ListNode res = s.reverseBetween(head, 1, 1);

        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }


        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}