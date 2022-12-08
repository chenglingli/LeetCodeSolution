import struct.ListNode;

public class L1290_Convert_Binary_Number_in_a_Linked {

    public int getDecimalValue(ListNode head) {
        int res = 0;
        ListNode p = head;
        while (p != null) {
            res *= 2;

            res += p.val;
            p = p.next;
        }

        return res;
    }

    public static void main(String[] args) {

        L1290_Convert_Binary_Number_in_a_Linked s = new L1290_Convert_Binary_Number_in_a_Linked();
        long sysDate1 = System.currentTimeMillis();

        ListNode root = new ListNode(1);
        ListNode p1 = new ListNode(1);
        ListNode p2 = new ListNode(0);
        ListNode p3 = new ListNode(1);
        root.next = p1;
        p1.next = p2;
        p2.next = p3;
        int res = s.getDecimalValue(root);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}