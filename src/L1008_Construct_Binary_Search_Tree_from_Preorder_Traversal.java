import struct.TreeNode;

import java.util.Arrays;

public class L1008_Construct_Binary_Search_Tree_from_Preorder_Traversal {

    /*

    Given an array of integers preorder, which represents the preorder traversal of a BST (i.e., binary search tree), construct the tree and return its root.

    It is guaranteed that there is always possible to find a binary search tree with the given requirements for the given test cases.

    A binary search tree is a binary tree where for every node, any descendant of Node.left has a value strictly less than Node.val, and any descendant of Node.right has a value strictly greater than Node.val.

    A preorder traversal of a binary tree displays the value of the node first, then traverses Node.left, then traverses Node.right.



    Example 1:
    Input: preorder = [8,5,1,7,10,12]
    Output: [8,5,10,1,7,null,12]

    Example 2:
    Input: preorder = [1,3]
    Output: [1,null,3]


    Constraints:
    1 <= preorder.length <= 100
    1 <= preorder[i] <= 1000
    All the values of preorder are unique.

     */
    public TreeNode bstFromPreorder(int[] preorder) {
        // 基于一个二叉搜索树的先续遍历，构造这科二叉搜索树
        return constructBSTFromPreorder(preorder, 0, preorder.length);
    }

    private TreeNode constructBSTFromPreorder(int[] preorder, int start, int end) {
        if (start >= end) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[start]);
        int i = start + 1;
        while (i < end && preorder[i] < root.val) {
            i++;
        }

        root.left = constructBSTFromPreorder(preorder, start + 1, i);
        root.right = constructBSTFromPreorder(preorder, i, end);

        return root;
    }


    public static void main(String[] args) {

        L1008_Construct_Binary_Search_Tree_from_Preorder_Traversal s = new L1008_Construct_Binary_Search_Tree_from_Preorder_Traversal();

        long sysDate1 = System.currentTimeMillis();

        int[] preorder = new int[]{8, 5, 1, 7, 10, 12};
        TreeNode res = s.bstFromPreorder(preorder);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}