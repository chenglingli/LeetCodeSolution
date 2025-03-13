import struct.TreeNode;

public class L543_Diameter_of_Binary_Tree {


    /*
    Given the root of a binary tree, return the length of the diameter of the tree.

    The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
    This path may or may not pass through the root.

    The length of a path between two nodes is represented by the number of edges between them.



    Example 1:


    Input: root = [1,2,3,4,5]
    Output: 3
    Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].

    Example 2:

    Input: root = [1,2]
    Output: 1


    Constraints:

    The number of nodes in the tree is in the range [1, 10^4].
    -100 <= Node.val <= 100
     */
    public int diameterOfBinaryTree(TreeNode root) {

        // 值为：左子树深度+右子树深度
        if (root != null) {
            int leftDepth = depth(root.left);
            int rightDepth = depth(root.right);
            return Math.max(
                    leftDepth + rightDepth,
                    Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right)));
        }
        return 0;
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }


    public int diameterOfBinaryTree2(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int[] resArray = new int[1];
        helper(root, resArray);

        return resArray[0];
    }

    private int helper(TreeNode node, int[] resArray) {

        if (node == null) {
            return 0;
        }

        int leftDepth = helper(node.left, resArray);
        int rightDepth = helper(node.right, resArray);
        resArray[0] = Math.max(resArray[0], leftDepth + rightDepth);

        return 1 + Math.max(leftDepth, rightDepth);
    }


    public static void main(String[] args) {

        L543_Diameter_of_Binary_Tree s = new L543_Diameter_of_Binary_Tree();
        long sysDate1 = System.currentTimeMillis();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        int res = s.diameterOfBinaryTree2(root);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}