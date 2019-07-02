public class L025_Reverse_Nodes_in_k_Group {

    public ListNode reverseKGroup(ListNode head, int k) {

        if (head == null || k <= 1) {
            return head;
        }

        int len = 0;
        for (ListNode n = head; n != null; n = n.next) {
            len++;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        for (int i = 0; i < len / k; i++) {
            prev = reverseK(prev, k);
        }
        return dummy.next;
    }

    // Perform K-1 reversals for K group
    private ListNode reverseK(ListNode prev, int k) {
        ListNode cur = prev.next;
        if (cur != null) {      // when len is divisible by k, no node left in last batch
            while (k-- > 1) {
                ListNode then = cur.next;
                cur.next = then.next;
                then.next = prev.next;
                prev.next = then;
            }
        }
        return cur;
    }

    public static void main(String[] args) {

        L025_Reverse_Nodes_in_k_Group s = new L025_Reverse_Nodes_in_k_Group();

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
        f = f.next;
        f.next = new ListNode(7);

        head = s.reverseKGroup(head, 2);

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }


        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}