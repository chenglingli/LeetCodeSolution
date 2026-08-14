import struct.ListNode;

public class L2130_Maximum_Twin_Sum_of_a_Linked_List {

    /*
    In a linked list of size n, where n is even, the ith node (0-indexed) of the linked list is known as the twin of the (n-1-i)th node, if 0 <= i <= (n / 2) - 1.

    For example, if n = 4, then node 0 is the twin of node 3, and node 1 is the twin of node 2. These are the only nodes with twins for n = 4.
    The twin sum is defined as the sum of a node and its twin.

    Given the head of a linked list with even length, return the maximum twin sum of the linked list.



    Example 1:


    Input: head = [5,4,2,1]
    Output: 6
    Explanation:
    Nodes 0 and 1 are the twins of nodes 3 and 2, respectively. All have twin sum = 6.
    There are no other nodes with twins in the linked list.
    Thus, the maximum twin sum of the linked list is 6.
    Example 2:


    Input: head = [4,2,2,3]
    Output: 7
    Explanation:
    The nodes with twins present in this linked list are:
    - Node 0 is the twin of node 3 having a twin sum of 4 + 3 = 7.
    - Node 1 is the twin of node 2 having a twin sum of 2 + 2 = 4.
    Thus, the maximum twin sum of the linked list is max(7, 4) = 7.
    Example 3:


    Input: head = [1,100000]
    Output: 100001
    Explanation:
    There is only one node with a twin in the linked list having twin sum of 1 + 100000 = 100001.


    Constraints:

    The number of nodes in the list is an even integer in the range [2, 105].
    1 <= Node.val <= 105
     */
    public int pairSum(ListNode head) {
        int n = 0;
        ListNode cur = head;
        while (cur != null) {
            n++;
            cur = cur.next;
        }

        int[] num = new int[n];
        cur = head;
        for (int i = 0; i < n; ++i) {
            num[i] = cur.val;
            cur = cur.next;
        }

        int max = 0;
        for (int i = 0; i < n / 2; ++i) {
            max = Math.max(max, num[i] + num[n - 1 - i]);
        }

        return max;
    }

    public static int pairSum2(ListNode head) {

        if (head.next.next == null) {
            return head.val + head.next.val;
        }

        ListNode slow = head;
        ListNode fast = head;

        // find the middle of the list
        int count = 0;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            count++;
        }

        // reverse the second half
        ListNode prev = null;
        while (slow != null) {
            ListNode nexttemp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = nexttemp;
        }

        // find the max sum
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < count; i++) {
            max = Math.max(head.val + prev.val, max);
            head = head.next;
            prev = prev.next;
        }

        return max;
    }

    public static void main(String[] args) {

        L2130_Maximum_Twin_Sum_of_a_Linked_List s = new L2130_Maximum_Twin_Sum_of_a_Linked_List();
        long sysDate1 = System.currentTimeMillis();

        ListNode head = new ListNode(5);
        head.next = new ListNode(4);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        int res = s.pairSum(head);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}