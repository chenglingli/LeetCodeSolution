import struct.TreeNode;

public class L129_Sum_Root_to_Leaf_Numbers {

    /*
    The number of nodes in the tree is in the range [1, 1000].
    0 <= Node.val <= 9
    The depth of the tree will not exceed 10.
     */
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int sum) {

        if (root.left == null && root.right == null) {
            return sum * 10 + root.val;
        }

        int leftValue = 0;
        if (root.left != null) {
            leftValue = dfs(root.left, sum * 10 + root.val);
        }

        int rightValue  = 0;
        if (root.right != null) {
            rightValue = dfs(root.right, sum * 10 + root.val);
        }

        return leftValue + rightValue;
    }

    public static void main(String[] args) {

        L129_Sum_Root_to_Leaf_Numbers s = new L129_Sum_Root_to_Leaf_Numbers();

        long sysDate1 = System.currentTimeMillis();

        TreeNode root = new TreeNode(3);
        TreeNode root1 = new TreeNode(9);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(5);
        TreeNode root4 = new TreeNode(7);
        /*

         3
        / \
       9  2
     /  \
    5   7

    395 + 32 + 397 = 824
         */

        root.right = root1;
        root.left = root2;
        root1.right = root3;
        root1.left = root4;

        int x = s.sumNumbers(root);

        System.out.println(x);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}