import struct.TreeNode;

import java.util.PriorityQueue;
import java.util.Queue;

public class L700_Search_in_a_Binary_Search_Tree {

    /*
    You are given the root of a binary search tree (BST) and an integer val.

    Find the node in the BST that the node's value equals val and return the subtree rooted with that node.
    If such a node does not exist, return null.



    Example 1:


    Input: root = [4,2,7,1,3], val = 2
    Output: [2,1,3]


    Example 2:

    Input: root = [4,2,7,1,3], val = 5
    Output: []


    Constraints:

    The number of nodes in the tree is in the range [1, 5000].
    1 <= Node.val <= 10^7
    root is a binary search tree.
    1 <= val <= 10^7


    */

    public TreeNode searchBST(TreeNode root, int val) {

        if (root == null) {
            return null;
        }

        if (val < root.val) {
            return searchBST(root.left, val);
        }
        else if (val > root.val) {
            return searchBST(root.right, val);
        }
        else {
            return root;
        }
    }


    public static void main(String[] args) {

        L700_Search_in_a_Binary_Search_Tree s = new L700_Search_in_a_Binary_Search_Tree();
        long sysDate1 = System.currentTimeMillis();

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        TreeNode res = s.searchBST(root, 2);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}