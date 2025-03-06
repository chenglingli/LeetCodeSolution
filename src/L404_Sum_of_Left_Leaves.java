import struct.TreeNode;

import java.util.HashMap;
import java.util.HashSet;

public class L404_Sum_of_Left_Leaves {


    /*

    Given the root of a binary tree, return the sum of all left leaves.

    A leaf is a node with no children.
    A left leaf is a leaf that is the left child of another node.



    Example 1:


    Input: root = [3,9,20,null,null,15,7]
    Output: 24
    Explanation: There are two left leaves in the binary tree,
    with values 9 and 15 respectively.

    Example 2:

    Input: root = [1]
    Output: 0


    Constraints:

    The number of nodes in the tree is in the range [1, 1000].
    -1000 <= Node.val <= 1000

     */
    public int sumOfLeftLeaves(TreeNode root) {

        // 为空直接返回0
        if (root == null)
            return 0;

        // 左子树为空，直接返回右子树的求和
        if (root.left == null)
            return sumOfLeftLeaves(root.right);

        // 左子树不为空，判断是否为叶子节点
        if (root.left.left == null && root.left.right == null)
            return root.left.val + sumOfLeftLeaves(root.right);

        // 左右子树递归求和
        int x = sumOfLeftLeaves(root.left);
        int y = sumOfLeftLeaves(root.right);
        return x + y;
    }

    public static void main(String[] args) {

        L404_Sum_of_Left_Leaves s = new L404_Sum_of_Left_Leaves();

        long sysDate1 = System.currentTimeMillis();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int res = s.sumOfLeftLeaves(root);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}