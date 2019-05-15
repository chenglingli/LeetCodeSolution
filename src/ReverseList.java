public class ReverseList {


    public ListNode reverseList(ListNode head) {
        ListNode newHead = new ListNode(0);
        newHead.next = null;

        ListNode p = head;
        while (p!=null) {

            int value = p.val;
            ListNode temp = new ListNode(value);
            temp.next = newHead.next;
            newHead.next = temp;

            p = p.next;
        }

        return newHead.next;
    }

    public static void main(String[] args) {

        ReverseList s = new ReverseList();

        long sysDate1 = System.currentTimeMillis();

        ListNode head = new ListNode(1);
        ListNode p = head;
        head.next = new ListNode(2);
        head = head.next;
        head.next = new ListNode(3);
        head = head.next;

        ListNode res = s.reverseList(p);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }



        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}