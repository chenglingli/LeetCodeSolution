import struct.ListNode;

public class L148_Sort_List {

    public ListNode sortList(ListNode head) {

        // validation
        if (head == null || head.next == null) {
            return head;
        }

        // divide
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;

        // recursion
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);

        // merge
        ListNode blank = new ListNode(0);
        ListNode p = blank;
        while (left != null && right != null) {
            if (left.val < right.val) {
                p.next = left;
                left = left.next;
                p = p.next;
            } else {
                p.next = right;
                right = right.next;
                p = p.next;
            }
        }
        if (left != null) {
            p.next = left;
        }
        if (right != null) {
            p.next = right;
        }

        // return
        return blank.next;
    }

    public static void main(String[] args) {

        L148_Sort_List s = new L148_Sort_List();

        long sysDate1 = System.currentTimeMillis();

        ListNode f = new ListNode(1);
        ListNode head = f;
        f.next = new ListNode(2);
        f = f.next;
        f.next = new ListNode(9);
        f = f.next;

        ListNode newNode = f;

        f.next = new ListNode(4);
        f = f.next;
        f.next = new ListNode(5);
        f = f.next;
        f.next = new ListNode(6);
        f = f.next;

        ListNode p = s.sortList(head);

        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}