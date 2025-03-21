import struct.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L617_Merge_Two_Binary_Trees {

    /*

    You are given two binary trees root1 and root2.

    Imagine that when you put one of them to cover the other,
        some nodes of the two trees are overlapped while the others are not.
     You need to merge the two trees into a new binary tree.
     The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node.
     Otherwise, the NOT null node will be used as the node of the new tree.

    Return the merged tree.

    Note: The merging process must start from the root nodes of both trees.



    Example 1:


    Input: root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
    Output: [3,4,5,5,4,null,7]

    Example 2:
    Input: root1 = [1], root2 = [1,2]
    Output: [2,2]


    Constraints:
    The number of nodes in both trees is in the range [0, 2000].
    -10^4 <= Node.val <= 10^4

     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        TreeNode res = new TreeNode(0);
        if (root1 == null) return root2;
        if (root2 == null) return root1;

        res.val = root1.val + root2.val;
        res.left = mergeTrees(root1.left, root2.left);
        res.right = mergeTrees(root1.right, root2.right);

        return res;
    }

    public static void main(String[] args) {

        L617_Merge_Two_Binary_Trees s = new L617_Merge_Two_Binary_Trees();
        long sysDate1 = System.currentTimeMillis();


        TreeNode roo1 = new TreeNode(1);
        roo1.left = new TreeNode(3);
        roo1.right = new TreeNode(2);
        roo1.left.left = new TreeNode(5);

        TreeNode roo2 = new TreeNode(1);
        roo2.left = new TreeNode(2);
        roo2.right = new TreeNode(3);
        roo2.left.right = new TreeNode(4);
        roo2.right.right = new TreeNode(7);

        TreeNode res2 = s.mergeTrees(roo1, roo2);
        System.out.println(res2.val);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}