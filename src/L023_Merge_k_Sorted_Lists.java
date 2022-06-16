import struct.ListNode;

public class L023_Merge_k_Sorted_Lists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode h = new ListNode(0);
        ListNode ans = h;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                h.next = l1;
                h = h.next;
                l1 = l1.next;
            } else {
                h.next = l2;
                h = h.next;
                l2 = l2.next;
            }
        }

        if (l1 == null) {
            h.next = l2;
        }
        if (l2 == null) {
            h.next = l1;
        }

        return ans.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 1) {
            return lists[0];
        }
        if (lists.length == 0) {
            return null;
        }
        ListNode head = mergeTwoLists(lists[0], lists[1]);
        for (int i = 2; i < lists.length; i++) {
            head = mergeTwoLists(head, lists[i]);
        }
        return head;
    }


    public ListNode mergeKLists2(ListNode[] lists) {

        if (lists.length == 0) {
            return null;
        }

        int interval = 1;

        while (interval < lists.length) {
            for (int i = 0; i + interval < lists.length; i = i + interval * 2) {
                lists[i] = mergeTwoLists(lists[i], lists[i + interval]);
            }
            interval *= 2;
        }

        return lists[0];
    }


    public static void main(String[] args) {

        L023_Merge_k_Sorted_Lists s = new L023_Merge_k_Sorted_Lists();

        long sysDate1 = System.currentTimeMillis();


        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(4);
        ListNode a3 = new ListNode(5);
        a1.next = a2;
        a2.next = a3;

        ListNode b1 = new ListNode(1);
        ListNode b2 = new ListNode(3);
        ListNode b3 = new ListNode(4);
        b1.next = b2;
        b2.next = b3;


        ListNode c1 = new ListNode(2);
        ListNode c2 = new ListNode(6);
        c1.next = c2;

        ListNode[] lists = new ListNode[]{a1, b1, c1};

        ListNode res = s.mergeKLists(lists);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}