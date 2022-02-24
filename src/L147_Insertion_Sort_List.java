import struct.ListNode;

public class L147_Insertion_Sort_List {

    public ListNode insertionSortList(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode p = head;
        ListNode pre = dummyHead;
        while (p != null) {

            pre.next = p.next;

            insert(dummyHead, p);

            if (pre.next == p) {
                p = p.next;
                pre = pre.next;
            } else {
                p = pre.next;
            }
        }

        return dummyHead.next;
    }

    public void insert(ListNode dummyHead, ListNode newNode) {
        ListNode p = dummyHead;
        while (p.next != null && p.next.val < newNode.val) {
            p = p.next;
        }
        newNode.next = p.next;
        p.next = newNode;
    }

    public static void main(String[] args) {

        L147_Insertion_Sort_List s = new L147_Insertion_Sort_List();

        long sysDate1 = System.currentTimeMillis();

        ListNode f = new ListNode(1);
        ListNode head = f;
        f.next = new ListNode(2);
        f = f.next;
        f.next = new ListNode(3);
        f = f.next;
        f.next = new ListNode(4);
        f = f.next;
        f.next = new ListNode(3);
        f = f.next;
        f.next = new ListNode(2);
        f = f.next;
        f.next = new ListNode(1);

        ListNode x = s.insertionSortList(head);

        while (x != null) {
            System.out.println(x.val);
            x = x.next;
        }

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}