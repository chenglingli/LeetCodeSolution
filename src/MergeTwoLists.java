public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode l = new ListNode(0);
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode p = l;

        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }

        if (p1 != null) {
            p.next = p1;
        }
        if (p2 != null) {
            p.next = p2;
        }

        return l.next;
    }

    public static void main(String[] args) {

        MergeTwoLists s = new MergeTwoLists();

        ListNode l1 = new ListNode(2);
        ListNode p1 = l1;
        p1.next = new ListNode(3);
        p1 = p1.next;
        p1.next = new ListNode(5);

        ListNode l2 = new ListNode(2);
        ListNode p2 = l2;
        p2.next = new ListNode(4);
        p2 = p2.next;
        p2.next = new ListNode(6);

        long sysDate1 = System.currentTimeMillis();

        ListNode res = s.mergeTwoLists(l1, l2);

        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }


        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}

