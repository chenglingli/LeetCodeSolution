import struct.TreeNode;

public class L2265_Count_Nodes_Equal_to_Average_of_Subtree {

    /*
    Given the root of a binary tree, return the number of nodes where the value of the node is equal to the average of the values in its subtree.

    Note:

    The average of n elements is the sum of the n elements divided by n and rounded down to the nearest integer.
    A subtree of root is a tree consisting of root and all of its descendants.


    Example 1:


    Input: root = [4,8,5,0,1,null,6]
    Output: 5
    Explanation:
    For the node with value 4: The average of its subtree is (4 + 8 + 5 + 0 + 1 + 6) / 6 = 24 / 6 = 4.
    For the node with value 5: The average of its subtree is (5 + 6) / 2 = 11 / 2 = 5.
    For the node with value 0: The average of its subtree is 0 / 1 = 0.
    For the node with value 1: The average of its subtree is 1 / 1 = 1.
    For the node with value 6: The average of its subtree is 6 / 1 = 6.

    Example 2:
    Input: root = [1]
    Output: 1
    Explanation: For the node with value 1: The average of its subtree is 1 / 1 = 1.


    Constraints:
    The number of nodes in the tree is in the range [1, 1000].
    0 <= Node.val <= 1000
     */
    public int averageOfSubtree(TreeNode root) {
        int[] ans = new int[1];
        dfs(root, ans);
        return ans[0];
    }

    private int[] dfs(TreeNode node, int[] ans) {
        if (node == null) {
            return new int[]{0, 0};
        }

        int[] left = dfs(node.left, ans);
        int[] right = dfs(node.right, ans);
        int sum = node.val + left[0] + right[0];
        int count = 1 + left[1] + right[1];

        if (node.val == sum / count) {
            ans[0]++;
        }

        return new int[]{sum, count};
    }

    public static void main(String[] args) {

        L2265_Count_Nodes_Equal_to_Average_of_Subtree s =
                new L2265_Count_Nodes_Equal_to_Average_of_Subtree();
        long sysDate1 = System.currentTimeMillis();

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(8);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(6);

        int res = s.averageOfSubtree(root);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}