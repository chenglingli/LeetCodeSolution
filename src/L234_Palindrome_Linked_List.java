import struct.ListNode;

public class L234_Palindrome_Linked_List {

    public boolean isPalindrome(ListNode head) {

        if (head == null) {
            return true;
        }

        ListNode newHead = reverseList(head);
        while (newHead.val == head.val && head.next != null) {
            head = head.next;
            newHead = newHead.next;
        }

        if (head.next == null) {
            return true;
        }

        return false;
    }

    public ListNode reverseList(ListNode head) {
        ListNode newHead = new ListNode(0);
        newHead.next = null;

        ListNode p = head;
        while (p != null) {

            int value = p.val;
            ListNode temp = new ListNode(value);
            temp.next = newHead.next;
            newHead.next = temp;

            p = p.next;
        }

        return newHead.next;
    }

    public static void main(String[] args) {

        L234_Palindrome_Linked_List s = new L234_Palindrome_Linked_List();

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

        boolean x = s.isPalindrome(head);

        System.out.println(x);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}