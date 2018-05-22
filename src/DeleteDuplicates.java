

public class DeleteDuplicates {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode res = head;

        while (head != null) {
            ListNode temp = head.next;
            while (temp != null && temp.val == head.val) {
                head.next = temp.next;
                temp = head.next;
            }
            head = head.next;
        }

        return res;
    }


    public static void main(String[] args) {

        DeleteDuplicates s = new DeleteDuplicates();

        long sysDate1 = System.currentTimeMillis();

        ListNode x = new ListNode(1);
        ListNode x1 = new ListNode(1);
        ListNode x2 = new ListNode(1);
        ListNode x3 = new ListNode(3);

        x.next = x1;
        x1.next = x2;
        x2.next = x3;


        ListNode res = s.deleteDuplicates(x);

        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}