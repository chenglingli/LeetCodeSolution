import struct.ListNode;

public class L061_Rotate_List {

    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null || k == 0) {
            return head;
        }


        int len = 0;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode node = dummy.next;
        while (node != null) {
            len++;
            node = node.next;
        }

        int step = k % len;

        if (step == 0) {
            return head;
        }

        ListNode fast = head;
        ListNode slow = head;

        int i = step;
        while (i > 0) {
            fast = fast.next;
            i--;
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        ListNode newHead = slow.next;
        slow.next = null;
        fast.next = head;

        return newHead;

    }

    public static void main(String[] args) {

        L061_Rotate_List s = new L061_Rotate_List();

        long sysDate1 = System.currentTimeMillis();

        ListNode f = new ListNode(1);
        ListNode head = f;
        f.next = new ListNode(2);

        ListNode x = s.rotateRight(head, 2);

        while (x != null) {
            System.out.println(x.val);
            x = x.next;
        }

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}