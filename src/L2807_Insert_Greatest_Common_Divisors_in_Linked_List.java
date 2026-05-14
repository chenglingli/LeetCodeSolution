import struct.ListNode;

public class L2807_Insert_Greatest_Common_Divisors_in_Linked_List {

    /*
    Given the head of a linked list head, in which each node contains an integer value.

    Between every pair of adjacent nodes, insert a new node with a value equal to the greatest common divisor of them.

    Return the linked list after insertion.

    The greatest common divisor of two numbers is the largest positive integer that evenly divides both numbers.



    Example 1:


    Input: head = [18,6,10,3]
    Output: [18,6,6,2,10,1,3]
    Explanation: The 1st diagram denotes the initial linked list and the 2nd diagram denotes the linked list after inserting the new nodes (nodes in blue are the inserted nodes).
    - We insert the greatest common divisor of 18 and 6 = 6 between the 1st and the 2nd nodes.
    - We insert the greatest common divisor of 6 and 10 = 2 between the 2nd and the 3rd nodes.
    - We insert the greatest common divisor of 10 and 3 = 1 between the 3rd and the 4th nodes.
    There are no more adjacent nodes, so we return the linked list.
    Example 2:


    Input: head = [7]
    Output: [7]
    Explanation: The 1st diagram denotes the initial linked list and the 2nd diagram denotes the linked list after inserting the new nodes.
    There are no pairs of adjacent nodes, so we return the initial linked list.


    Constraints:

    The number of nodes in the list is in the range [1, 5000].
    1 <= Node.val <= 1000

     */
    public ListNode insertGreatestCommonDivisors(ListNode head) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;

        while (cur.next != null && cur.next.next != null) {

            int a = cur.next.val;
            int b = cur.next.next.val;
            int gcd = gcd(a, b);

            ListNode node = new ListNode(gcd);
            node.next = cur.next.next;
            cur.next.next = node;

            cur = cur.next.next;
        }

        return dummy.next;
    }

    public ListNode insertGreatestCommonDivisors2(ListNode head) {

        if (head == null || head.next == null)
            return head;

        ListNode curr = head;

        while (curr.next != null) {

            int gcdVal = gcd(curr.val, curr.next.val);
            ListNode newNode = new ListNode(gcdVal);

            newNode.next = curr.next;
            curr.next = newNode;

            curr = newNode.next;
        }

        return head;
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

public static void main(String[] args) {

    L2807_Insert_Greatest_Common_Divisors_in_Linked_List s = new L2807_Insert_Greatest_Common_Divisors_in_Linked_List();
    long sysDate1 = System.currentTimeMillis();

    ListNode head = new ListNode(18);
    head.next = new ListNode(6);
    head.next.next = new ListNode(10);
    head.next.next.next = new ListNode(3);

    ListNode res = s.insertGreatestCommonDivisors(head);
    System.out.println(res);

    long sysDate2 = System.currentTimeMillis();
    System.out.println("\ntime ");
    System.out.print(sysDate2 - sysDate1);
}
}