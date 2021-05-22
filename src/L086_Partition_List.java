public class L086_Partition_List {

    public ListNode partition(ListNode head, int x) {

        if (head == null) {
            return null;
        }

        ListNode p1 = new ListNode(0);
        ListNode p2 = new ListNode(0);

        ListNode p1Head = p1;
        ListNode p2Head = p2;

        ListNode p = head;
        while (p != null) {

            ListNode temp = p.next;
            if (p.val < x) {
                p1.next = p;
                p.next = null;
                p1 = p;
            } else {
                p2.next = p;
                p.next = null;
                p2 = p;
            }

            p = temp;
        }
        p1.next = p2Head.next;

        return p1Head.next;
    }


    public static void main(String[] args) {

        L086_Partition_List s = new L086_Partition_List();

        long sysDate1 = System.currentTimeMillis();

        ListNode f = new ListNode(1);
        ListNode head = f;
        f.next = new ListNode(0);
        f = f.next;
        f.next = new ListNode(5);
        f = f.next;
        f.next = new ListNode(4);
        f = f.next;
        f.next = new ListNode(3);
        f = f.next;
        f.next = new ListNode(2);
        f = f.next;
        f.next = new ListNode(1);

        ListNode x = s.partition(head, 3);

        while (x != null) {
            System.out.println(x.val);
            x = x.next;
        }

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}