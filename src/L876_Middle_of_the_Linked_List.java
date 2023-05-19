import struct.ListNode;

public class L876_Middle_of_the_Linked_List {


    public ListNode middleNode(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
            if (p2.next != null) {
                p2 = p2.next;
            }
        }

        return p1;
    }

    public static void main(String[] args) {

        L876_Middle_of_the_Linked_List s = new L876_Middle_of_the_Linked_List();
        long sysDate1 = System.currentTimeMillis();

        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        ListNode res = s.middleNode(head);
        System.out.println(res.val);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}