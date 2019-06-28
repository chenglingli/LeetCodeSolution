public class L203_Remove_Linked_List_Elements {

    public ListNode removeElements(ListNode head, int val) {

        if (head == null) {
            return head;
        }

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode p = dummyHead.next;
        ListNode pre = dummyHead;

        while (p != null) {
            if (p.val == val) {
                pre.next = p.next;
                p = pre.next;
            }
            else {
                p = p.next;
                pre = pre.next;
            }
        }

        return dummyHead.next;
    }


    public static void main(String[] args) {

        L203_Remove_Linked_List_Elements s = new L203_Remove_Linked_List_Elements();

        long sysDate1 = System.currentTimeMillis();

        ListNode f = new ListNode(2);
        ListNode head = f;
        f.next = new ListNode(2);
        f = f.next;
        f.next = new ListNode(3);
        f = f.next;
        f.next = new ListNode(1);

        ListNode res = s.removeElements(head, 1);

        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }


        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}