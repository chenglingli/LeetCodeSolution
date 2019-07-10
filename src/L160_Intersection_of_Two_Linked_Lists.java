public class L160_Intersection_of_Two_Linked_Lists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) {
            return null;
        }

        int lenA = 0;
        int lenB = 0;

        ListNode pA = headA;
        ListNode pB = headB;

        while (pA != null) {
            lenA ++;
            pA = pA.next;
        }

        while (pB != null) {
            lenB ++;
            pB = pB.next;
        }

        pA = headA;
        pB = headB;

        int steps = Math.abs(lenA - lenB);
        if (lenA > lenB) {
            while (steps > 0) {
                pA = pA.next;
                steps --;
            }
        }
        else {
            while (steps > 0) {
                pB = pB.next;
                steps --;
            }
        }

        while (pA != null) {
            if (pA == pB) {
                return pA;
            }
            pA = pA.next;
            pB = pB.next;
        }

        return null;
    }


    public static void main(String[] args) {

        L160_Intersection_of_Two_Linked_Lists s = new L160_Intersection_of_Two_Linked_Lists();

        long sysDate1 = System.currentTimeMillis();

        ListNode f = new ListNode(1);
        ListNode headA = f;
        f.next = new ListNode(2);
        f = f.next;
        f.next = new ListNode(3);
        f = f.next;
        f.next = new ListNode(4);
        f = f.next;


        ListNode q = new ListNode(10);
        ListNode headB = q;

        ListNode x = s.getIntersectionNode(headB, headA);

        if (x != null) {
            System.out.println(x.val);
        } else {
            System.out.println("null");
        }

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}