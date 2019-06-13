import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode p = head;
        ListNode q = head.next;

        p.next = q.next;
        q.next = p;
        ListNode res = q;

        ListNode cur = p;

        while (p.next != null) {
            // move step
            p = p.next;
            q = p.next;
            if (q == null) {
                break;
            }

            // adjust
            p.next = q.next;
            q.next = p;
            cur.next = q;
            cur = p;
        }

        return res;
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

        ListNode res = s.swapPairs(head);

        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }


        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}