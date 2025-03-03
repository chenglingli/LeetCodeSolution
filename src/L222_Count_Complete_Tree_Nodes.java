import struct.TreeNode;

public class L222_Count_Complete_Tree_Nodes {

    /*
    Given the root of a complete binary tree, return the number of the nodes in the tree.

    According to Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree,
     and all nodes in the last level are as far left as possible.

     It can have between 1 and 2h nodes inclusive at the last level h.

    Design an algorithm that runs in less than O(n) time complexity.



    Example 1:


    Input: root = [1,2,3,4,5,6]
    Output: 6

    Example 2:
    Input: root = []
    Output: 0

    Example 3:
    Input: root = [1]
    Output: 1


    Constraints:

    The number of nodes in the tree is in the range [0, 5 * 10^4].
    0 <= Node.val <= 5 * 10^4
    The tree is guaranteed to be complete.
     */

    public int countNodes(TreeNode root) {
        int leftDepth = 0;
        int rightDepth = 0;
        TreeNode l = root, r = root;

        while (l != null) {
            l = l.left;
            leftDepth++;
        }

        while (r != null) {
            r = r.right;
            rightDepth++;
        }

        if (leftDepth == rightDepth) {
            return (1 << leftDepth) - 1; // 2^leftDepth -1
        } else {
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
    }

    public static void main(String[] args) {

        L222_Count_Complete_Tree_Nodes s = new L222_Count_Complete_Tree_Nodes();
        long sysDate1 = System.currentTimeMillis();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.right.left = new TreeNode(8);
        root.left.right.right = new TreeNode(9);
        root.right.left.left = new TreeNode(10);

        int res = s.countNodes(root);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}