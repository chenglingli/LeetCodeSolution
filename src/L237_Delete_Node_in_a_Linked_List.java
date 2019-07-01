public class L237_Delete_Node_in_a_Linked_List {

    public void deleteNode(ListNode node) {

        if (node == null) {
            return;
        }

        node.val = node.next.val;
        node.next = node.next.next;
    }


    public static void main(String[] args) {

        L237_Delete_Node_in_a_Linked_List s = new L237_Delete_Node_in_a_Linked_List();

        long sysDate1 = System.currentTimeMillis();

        ListNode f = new ListNode(1);
        ListNode head = f;
        f.next = new ListNode(2);
        f = f.next;
        f.next = new ListNode(3);
        f = f.next;
        f.next = new ListNode(4);

        s.deleteNode(head);

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }


        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}