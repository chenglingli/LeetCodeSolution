public class DetectCycle142 {

    public ListNode detectCycle(ListNode head) {

        if (head == null) {
            return null;
        }

        if (head.next == null || head.next.next == null) {
            return null;
        }

        ListNode p1 = head;
        ListNode p2 = head;

        while (p1.next != null
                && p2.next != null
                && p2.next.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2) {
                break;
            }
        }

        ListNode common = head;
        if (p1 != p2) {
            return null;
        } else {
            common = p1;
        }

        p1 = head;
        while (p1 != common) {
            p1 = p1.next;
        }

        p2 = head;
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p2;
    }

    public static void main(String[] args) {

        DetectCycle142 s = new DetectCycle142();

        long sysDate1 = System.currentTimeMillis();

        ListNode f = new ListNode(1);
        ListNode head = f;
        f.next = new ListNode(2);
        f = f.next;

//
//        f.next = new ListNode(3);
//        f = f.next;
//
//        ListNode newNode = f;
//
//        f.next = new ListNode(4);
//        f = f.next;
//        f.next = new ListNode(5);
//        f = f.next;
//        f.next = new ListNode(6);
//        f = f.next;
//        f.next = newNode;

        ListNode res = s.detectCycle(head);

        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}