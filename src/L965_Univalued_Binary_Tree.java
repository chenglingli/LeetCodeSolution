import struct.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class L965_Univalued_Binary_Tree {

    /*

    A binary tree is uni-valued if every node in the tree has the same value.

    Given the root of a binary tree, return true if the given tree is uni-valued, or false otherwise.



    Example 1:


    Input: root = [1,1,1,1,1,null,1]
    Output: true

    Example 2:

    Input: root = [2,2,2,5,2]
    Output: false


    Constraints:

    The number of nodes in the tree is in the range [1, 100].
    0 <= Node.val < 100

     */
    public boolean isUnivalTree(TreeNode root) {

        int x = root.val;
        return isUnivalTree(root, x);
    }

    public boolean isUnivalTree(TreeNode root, int val) {
        if (root == null) {
            return true;
        }
        if (root.val != val) {
            return false;
        }
        return isUnivalTree(root.left, val) && isUnivalTree(root.right, val);
    }

    public static void main(String[] args) {

        L965_Univalued_Binary_Tree s = new L965_Univalued_Binary_Tree();

        long sysDate1 = System.currentTimeMillis();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        boolean res = s.isUnivalTree(root);

        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}