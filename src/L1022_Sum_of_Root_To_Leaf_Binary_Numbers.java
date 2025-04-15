import struct.TreeNode;

import java.util.Stack;

public class L1022_Sum_of_Root_To_Leaf_Binary_Numbers {

    /*

    You are given the root of a binary tree where each node has a value 0 or 1.
    Each root-to-leaf path represents a binary number starting with the most significant bit.

    For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01101 in binary, which is 13.
    For all leaves in the tree,
    consider the numbers represented by the path from the root to that leaf. Return the sum of these numbers.

    The test cases are generated so that the answer fits in a 32-bits integer.



    Example 1:

    Input: root = [1,0,1,0,1,0,1]
    Output: 22
    Explanation: (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22


    Example 2:

    Input: root = [0]
    Output: 0

    Constraints:

    The number of nodes in the tree is in the range [1, 1000].
    Node.val is 0 or 1.

     */
    public int sumRootToLeaf(TreeNode root) {

        int res = 0;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            if (node.left == null && node.right == null) {
                res += Integer.parseInt(Integer.toBinaryString(node.val), 2);
            } else {
                int val = node.val;
                if (node.left != null) {
                    node.left.val += val * 2;
                    stack.push(node.left);
                }
                if (node.right != null) {
                    node.right.val += val * 2;
                    stack.push(node.right);
                }
            }
        }

        return res;
    }

    public int sumRootToLeaf2(TreeNode root) {
        return dfs(root, 0);

    }

    public int dfs(TreeNode root, int val) {

        if (root == null)
            return 0;
        val = val * 2 + root.val;

        if (root.left == root.right) {
            return val;
        }
        else {
            return dfs(root.left, val) + dfs(root.right, val);
        }
    }

    public static void main(String[] args) {


        long sysDate1 = System.currentTimeMillis();

        L1022_Sum_of_Root_To_Leaf_Binary_Numbers s = new L1022_Sum_of_Root_To_Leaf_Binary_Numbers();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);

        int res = s.sumRootToLeaf(root);

        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}