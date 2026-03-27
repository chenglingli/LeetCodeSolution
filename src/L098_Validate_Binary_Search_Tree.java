import struct.TreeNode;

public class L098_Validate_Binary_Search_Tree {

    /*
    Given the root of a binary tree, determine if it is a valid binary search tree (BST).

    A valid BST is defined as follows:

    The left subtree of a node contains only nodes with keys strictly less than the node's key.
    The right subtree of a node contains only nodes with keys strictly greater than the node's key.
    Both the left and right subtrees must also be binary search trees.


    Example 1:


    Input: root = [2,1,3]
    Output: true
    Example 2:


    Input: root = [5,1,4,null,null,3,6]
    Output: false
    Explanation: The root node's value is 5 but its right child's value is 4.


    Constraints:

    The number of nodes in the tree is in the range [1, 104].
    -2^31 <= Node.val <= 2^31 - 1

     */

    public boolean isValidBST(TreeNode root) {
        /*
        判断一颗二叉树是不是平衡二叉树
        递归判断每个节点是否满足：
        1. 左子树的所有节点的值都小于当前节点
        2. 右子树的所有节点的值都大于当前节点

         */

        return isValidBST(root , Long.MIN_VALUE , Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root , long minVal , long maxVal) {
        if(root == null) {
            return true;
        }
        if(root.val >= maxVal || root.val <= minVal) {
            return false;
        }
        return isValidBST(root.left , minVal , root.val) && isValidBST(root.right , root.val , maxVal);
    }

    public static void main(String[] args) {

        L098_Validate_Binary_Search_Tree s = new L098_Validate_Binary_Search_Tree();

        long sysDate1 = System.currentTimeMillis();

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(7);

        boolean res = s.isValidBST(root);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}