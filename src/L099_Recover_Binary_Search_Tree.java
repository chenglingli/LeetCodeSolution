import struct.TreeNode;

public class L099_Recover_Binary_Search_Tree {

    /*
    You are given the root of a binary search tree (BST),
    where the values of exactly two nodes of the tree were swapped by mistake. Recover the tree without changing its structure.



    Example 1:
    Input: root = [1,3,null,null,2]
    Output: [3,1,null,null,2]
    Explanation: 3 cannot be a left child of 1 because 3 > 1. Swapping 1 and 3 makes the BST valid.

    Example 2:
    Input: root = [3,1,4,null,null,2]
    Output: [2,1,4,null,null,3]
    Explanation: 2 cannot be in the right subtree of 3 because 2 < 3. Swapping 2 and 3 makes the BST valid.


    Constraints:

    The number of nodes in the tree is in the range [2, 1000].
    -2^31 <= Node.val <= 2^31 - 1

     */

    TreeNode first;
    TreeNode second;
    TreeNode prev;

    public void recoverTree(TreeNode root) {

        /*
        思路：
        1，中序遍历二叉树
        2，找到两个被交换的节点：如果前一个节点大于后一个节点，第一个节点是候选交换的第一个。最后一个满足该条件的后一个节点是候选交换的第二个
        被交换的两个节点可能不相邻（There can be one or two violations depending on whether the swapped nodes are adjacent or not.）
        3，执行交换

         */
        helper(root);

        // Swap the values of the two misplaced nodes
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    void helper(TreeNode node) {
        if (node == null) return;

        // Traverse left subtree
        helper(node.left);

        // Detect swapped nodes
        if (prev != null && prev.val > node.val) {
            if (first == null) {
                first = prev;
            }
            second = node;
        }

        prev = node;

        // Traverse right subtree
        helper(node.right);
    }


    public static void main(String[] args) {

        L099_Recover_Binary_Search_Tree s = new L099_Recover_Binary_Search_Tree();

        long sysDate1 = System.currentTimeMillis();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(2);

        s.recoverTree(root);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}