import struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class L114_Flatten_Binary_Tree_to_Linked_List {

    /*

    Given the root of a binary tree, flatten the tree into a "linked list":

    The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
    The "linked list" should be in the same order as a pre-order traversal of the binary tree.


    Example 1:
    Input: root = [1,2,5,3,4,null,6]
    Output: [1,null,2,null,3,null,4,null,5,null,6]

    Example 2:
    Input: root = []
    Output: []

    Example 3:
    Input: root = [0]
    Output: [0]

    Constraints:
    The number of nodes in the tree is in the range [0, 2000].
    -100 <= Node.val <= 100


    Follow up: Can you flatten the tree in-place (with O(1) extra space)?
     */
    public void flatten(TreeNode root) {
        // 目的：将二叉树转化为链表
        // 思路：
        //  1. 递归
        //  2. 迭代
        if (root == null) return;
        List<TreeNode> list = new ArrayList<>();
        preorder(root, list);
        for (int i = 1; i < list.size(); i++) {
            list.get(i - 1).left = null;
            list.get(i - 1).right = list.get(i);
        }
    }

    private void preorder(TreeNode root, List<TreeNode> list) {
        if (root == null) return;
        list.add(root);
        preorder(root.left, list);
        preorder(root.right, list);
    }


    private TreeNode lastNode = null;
    public void flatten2(TreeNode root) {
        if (root == null) {
            return;
        }

        if (lastNode != null) {
            lastNode.left = null;
            lastNode.right = root;
        }

        lastNode = root;
        TreeNode right = root.right;
        flatten(root.left);
        flatten(right);
    }

    public static void main(String[] args) {

        L114_Flatten_Binary_Tree_to_Linked_List s = new L114_Flatten_Binary_Tree_to_Linked_List();

        long sysDate1 = System.currentTimeMillis();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);

        s.flatten(root);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}