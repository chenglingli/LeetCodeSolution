import struct.TreeNode;

public class L2236_Root_Equals_Sum_of_Children {


    /*

    You are given the root of a binary tree that consists of exactly 3 nodes:
        the root, its left child, and its right child.

    Return true if the value of the root is equal to the sum of the values of its two children, or false otherwise.



    Example 1:
    Input: root = [10,4,6]
    Output: true
    Explanation: The values of the root, its left child, and its right child are 10, 4, and 6, respectively.
    10 is equal to 4 + 6, so we return true.

    Example 2:
    Input: root = [5,3,1]
    Output: false
    Explanation: The values of the root, its left child, and its right child are 5, 3, and 1, respectively.
    5 is not equal to 3 + 1, so we return false.


    Constraints:
    The tree consists only of the root, its left child, and its right child.
    -100 <= Node.val <= 100

     */
    public boolean checkTree(TreeNode root) {
        return root.val == (root.left.val + root.right.val);
    }

    public static void main(String[] args) {

        L2236_Root_Equals_Sum_of_Children s =
                new L2236_Root_Equals_Sum_of_Children();
        long sysDate1 = System.currentTimeMillis();

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(4);
        root.right = new TreeNode(6);
        boolean res = s.checkTree(root);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}