import struct.ListNode;

public class L445_Add_Two_Numbers_II {

    /*
    先进行逆转，然后累加，再逆转返回
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode reversedL1 = reverse(l1);
        ListNode reversedL2 = reverse(l2);

        ListNode reversedL3 = add(reversedL1, reversedL2);
        return reverse(reversedL3);
    }

    /*
    链表逆转
     */
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;

            curr = nextTemp;
        }
        return prev;
    }

    /*
    链表累加
     */
    private ListNode add(ListNode l1, ListNode l2) {

        ListNode p1 = l1;
        ListNode p2 = l2;

        int carry = 0;

        // 使用l1做基底
        ListNode pre = l1;

        // 两个链表都有节点
        while (p1 != null && p2 != null) {
            int sum = p1.val + p2.val + carry;
            carry = sum / 10;
            p1.val = sum % 10;

            pre = p1;
            p1 = p1.next;
            p2 = p2.next;
        }

        // 两个链表等长
        if (p1 == null && p2 == null) {
            if (carry > 0) {
                pre.next = new ListNode(carry);
            }
        }
        // l1比l2长
        else if (p1 != null) {
            while (p1 != null && carry > 0) {
                int sum = p1.val + carry;
                carry = sum / 10;
                p1.val = sum % 10;

                pre = p1;
                p1 = p1.next;
            }
            if (carry > 0) {
                pre.next = new ListNode(carry);
            }
        }
        // l2比l1长
        else {
            pre.next = p2;
            while (p2 != null && carry > 0) {
                int sum = p2.val + carry;
                carry = sum / 10;
                p2.val = sum % 10;

                pre = p2;
                p2 = p2.next;
            }
            if (carry > 0) {
                pre.next = new ListNode(carry);
            }
        }

        // 返回l1
        return l1;
    }


    public static void main(String[] args) {

        L445_Add_Two_Numbers_II s = new L445_Add_Two_Numbers_II();

        long sysDate1 = System.currentTimeMillis();

//        ListNode l1 = new ListNode(7);
//        ListNode l3 = new ListNode(4);
//        l1.next = l3;
//        ListNode l4 = new ListNode(4);
//        l3.next = l4;
//
//        ListNode l2 = new ListNode(2);
//        ListNode l6 = new ListNode(6);
//        l2.next = l6;
//        ListNode l7 = new ListNode(4);
//        l6.next = l7;

        ListNode l1 = new ListNode(1);
        ListNode l3 = new ListNode(1);
        l1.next = l3;

        ListNode l2 = new ListNode(9);
        ListNode l6 = new ListNode(9);
        l2.next = l6;
        ListNode l7 = new ListNode(9);
        l6.next = l7;

        ListNode res = s.addTwoNumbers(l1, l2);

        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}