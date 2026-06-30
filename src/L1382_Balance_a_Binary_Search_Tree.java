import struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class L1382_Balance_a_Binary_Search_Tree {


    /*
     Given the root of a binary search tree, return a balanced binary search tree with the same node values.
     If there is more than one answer, return any of them.

    A binary search tree is balanced if the depth of the two subtrees of every node never differs by more than 1.

    Example 1:
    Input: root = [1,null,2,null,3,null,4,null,null]
    Output: [2,1,3,null,null,null,4]
    Explanation: This is not the only correct answer, [3,1,4,null,2] is also correct.
    Example 2:


    Input: root = [2,1,3]
    Output: [2,1,3]

    Constraints:
    The number of nodes in the tree is in the range [1, 10^4].
    1 <= Node.val <= 10^5

     */
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        inOrderTraversal(root, values);
        return buildBalancedBST(values, 0, values.size() - 1);
    }

    private void inOrderTraversal(TreeNode node, List<Integer> values) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left, values);
        values.add(node.val);
        inOrderTraversal(node.right, values);
    }

    private TreeNode buildBalancedBST(List<Integer> values, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(values.get(mid));
        node.left = buildBalancedBST(values, left, mid - 1);
        node.right = buildBalancedBST(values, mid + 1, right);
        return node;
    }


    public static void main(String[] args) {

        L1382_Balance_a_Binary_Search_Tree s = new L1382_Balance_a_Binary_Search_Tree();
        long sysDate1 = System.currentTimeMillis();

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);

        TreeNode res = s.balanceBST(root);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}