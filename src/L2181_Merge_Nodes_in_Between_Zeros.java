import struct.ListNode;


public class L2181_Merge_Nodes_in_Between_Zeros {


    /*

    You are given the head of a linked list, which contains a series of integers separated by 0's.
    The beginning and end of the linked list will have Node.val == 0.

    For every two consecutive 0's, merge all the nodes lying in between them into a single node whose value is the sum of all the merged nodes.
    The modified list should not contain any 0's.

    Return the head of the modified linked list.



    Example 1:


    Input: head = [0,3,1,0,4,5,2,0]
    Output: [4,11]
    Explanation:
    The above figure represents the given linked list. The modified list contains
    - The sum of the nodes marked in green: 3 + 1 = 4.
    - The sum of the nodes marked in red: 4 + 5 + 2 = 11.
    Example 2:


    Input: head = [0,1,0,3,0,2,2,0]
    Output: [1,3,4]
    Explanation:
    The above figure represents the given linked list. The modified list contains
    - The sum of the nodes marked in green: 1 = 1.
    - The sum of the nodes marked in red: 3 = 3.
    - The sum of the nodes marked in yellow: 2 + 2 = 4.


    Constraints:

    The number of nodes in the list is in the range [3, 2 * 105].
    0 <= Node.val <= 1000
    There are no two consecutive nodes with Node.val == 0.
    The beginning and end of the linked list have Node.val == 0.

     */
    public ListNode mergeNodes(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int sum = 0;

        while (head != null) {
            if (head.val == 0) {
                cur.next = new ListNode(sum);
                cur = cur.next;
                sum = 0;
            } else {
                sum += head.val;
            }
            head = head.next;
        }

        return dummy.next.next;
    }

    // 原地写法
    public ListNode mergeNodes3(ListNode head) {

        ListNode write = head.next;  // 跳过首 0
        int sum = 0;
        ListNode pre = write;

        for (ListNode cur = head.next; cur != null; cur = cur.next) {
            sum += cur.val;
            if (cur.val == 0) {
                write.val = sum;
                sum = 0;
                pre = write;
                write = write.next;
            }
        }

        pre.next = null;
        return head.next;
    }

    public static void main(String[] args) {

        L2181_Merge_Nodes_in_Between_Zeros s = new L2181_Merge_Nodes_in_Between_Zeros();
        long sysDate1 = System.currentTimeMillis();

        ListNode head = new ListNode(0);
        head.next = new ListNode(3);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(0);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next.next = new ListNode(0);

        ListNode res = s.mergeNodes3(head);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}