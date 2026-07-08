import struct.NextNode;
import struct.TreeNode;

public class L117_Populating_Next_Right_Pointers_in_Each_Node_II {

    /*

    Given a binary tree

    struct Node {
      int val;
      Node *left;
      Node *right;
      Node *next;
    }

    Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

    Initially, all next pointers are set to NULL.



    Example 1:


    Input: root = [1,2,3,4,5,null,7]
    Output: [1,#,2,3,#,4,5,7,#]
    Explanation: Given the above binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
    Example 2:

    Input: root = []
    Output: []


    Constraints:

    The number of nodes in the tree is in the range [0, 6000].
    -100 <= Node.val <= 100


    Follow-up:

    You may only use constant extra space.
    The recursive approach is fine. You may assume implicit stack space does not count as extra space for this problem.

     */

    public NextNode connect(NextNode root) {
        if (root == null)
            return null;

        NextNode cur = root;
        while (cur != null) {
            NextNode dummyHead = new NextNode(0);
            NextNode tail = dummyHead;
            for (; cur != null; cur = cur.next) {
                if (cur.left != null) {
                    tail.next = cur.left;
                    tail = tail.next;
                }
                if (cur.right != null) {
                    tail.next = cur.right;
                    tail = tail.next;
                }
            }
            cur = dummyHead.next;
        }

        return root;
    }

    public static void main(String[] args) {

        L117_Populating_Next_Right_Pointers_in_Each_Node_II s = new L117_Populating_Next_Right_Pointers_in_Each_Node_II();
        long sysDate1 = System.currentTimeMillis();

        NextNode root = new NextNode(1);
        root.left = new NextNode(2);
        root.right = new NextNode(3);
        root.left.left = new NextNode(4);
        root.left.right = new NextNode(5);
        root.right.right = new NextNode(7);

        NextNode res = s.connect(root);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}