import struct.TreeNode;

public class L124_Binary_Tree_Maximum_Path_Sum {

    /*

    A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them.
    A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.

    The path sum of a path is the sum of the node's values in the path.

    Given the root of a binary tree, return the maximum path sum of any non-empty path.



    Example 1:


    Input: root = [1,2,3]
    Output: 6
    Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.

    Example 2:

    Input: root = [-10,9,20,null,null,15,7]
    Output: 42
    Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.


    Constraints:

    The number of nodes in the tree is in the range [1, 3 * 104].
    -1000 <= Node.val <= 1000


     */
    public int maxPathSum(TreeNode root) {

        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;

        dfs(root, max);

        return max[0];
    }

    // 递归计算以当前节点为根节点的最大贡献值
    /*

    dfs 返回该节点路线贡献值
    max[] 更新全局最大值

     */
    private int dfs(TreeNode root, int[] max) {
        if (root == null)
            return 0;

        // 左子树的最大贡献值（如果左子树的贡献值小于0，则说明左子树不可能提供正向的贡献，直接忽略）
        int leftMax = Math.max(dfs(root.left, max), 0);
        // 右子树的最大贡献值
        int rightMax = Math.max(dfs(root.right, max), 0);

        // 当前节点的最大路径和取决于三种可能：
        // 1.只有当前节点；2.只有左子树；3.只有右子树
        int priceNewPath = root.val + leftMax + rightMax;
        // 更新答案
        max[0] = Math.max(max[0], priceNewPath);
        // 对于任何一个节点而言，其最大贡献值是其本身加上左右子树贡献值的最大者

        return root.val + Math.max(leftMax, rightMax);
    }



    private int ans = Integer.MIN_VALUE;

    public int maxPathSum2(TreeNode root) {
        helper(root);
        return ans;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;

        int left = Math.max(0, helper(root.left));
        int right = Math.max(0, helper(root.right));

        ans = Math.max(ans, root.val + left + right);

        return root.val + Math.max(left, right);
    }

    public static void main(String[] args) {

        L124_Binary_Tree_Maximum_Path_Sum s = new L124_Binary_Tree_Maximum_Path_Sum();

        long sysDate1 = System.currentTimeMillis();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);


        int res = s.maxPathSum(root);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}