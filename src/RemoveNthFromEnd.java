

public class Solution {


    public ListNode removeNthFromEnd(ListNode head, int n) {
        int i = 1;
        ListNode p = head;
        while (i < n) {
            p = p.next;
            i++;
        }

        ListNode q = head;

        if (p.next == null) {
            head = head.next;
            return head;
        }

        p = p.next;
        while(p.next != null) {
            p = p.next;
            q = q.next;
        }

        q.next = q.next.next;
        return head;
    }

    public static void main(String[] args) {

        Solution s = new Solution();

        long sysDate1 = System.currentTimeMillis();

        ListNode f = new ListNode(1);
        ListNode head = f;
        f.next = new ListNode(2);
        f = f.next;
        f.next = new ListNode(3);
        f = f.next;
        f.next = new ListNode(4);

        ListNode res = s.removeNthFromEnd(head, 4);
        while (res != null) {
            System.out.println("->" + res.val);
            res = res.next;
        }


        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}