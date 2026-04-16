import struct.TreeNode;

public class L337_House_Robber_III {


    /*

    The thief has found himself a new place for his thievery again. There is only one entrance to this area, called root.

    Besides the root, each house has one and only one parent house. After a tour, the smart thief realized
        that all houses in this place form a binary tree. It will automatically contact the police if two directly-linked houses were broken into on the same night.

    Given the root of the binary tree, return the maximum amount of money the thief can rob without alerting the police.



    Example 1:


    Input: root = [3,2,3,null,3,null,1]
    Output: 7
    Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.

    Example 2:
    Input: root = [3,4,5,1,3,null,1]
    Output: 9
    Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.


    Constraints:

    The number of nodes in the tree is in the range [1, 104].
    0 <= Node.val <= 104

     */

    // 解法1，超时
    public int rob2(TreeNode root) {
        return Math.max(robHelper(root, true), robHelper(root, false));
    }

    private int robHelper(TreeNode root, boolean isRobbed) {
        if (root == null) return 0;
        int res = 0;
        if (!isRobbed) {
            res += root.val;
            res += robHelper(root.left, true);
            res += robHelper(root.right, true);
        } else {
            res += Math.max(robHelper(root.left, false), robHelper(root.left, true));
            res += Math.max(robHelper(root.right, false), robHelper(root.right, true));
        }
        return res;
    }

    // 解法2
    public int rob(TreeNode root) {
        int[] res = robDfs(root); // res[0] 不偷当前节点，res[1] 偷当前节点
        return Math.max(res[0], res[1]);
    }

    private int[] robDfs(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }

        int[] left = robDfs(node.left);
        int[] right = robDfs(node.right);

        int notRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        int rob = node.val + left[0] + right[0];

        return new int[]{notRob, rob};
    }



    public static void main(String[] args) {

        L337_House_Robber_III s = new L337_House_Robber_III();
        long sysDate1 = System.currentTimeMillis();

//        TreeNode root = new TreeNode(3);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//        root.left.right = new TreeNode(1);
//        root.right.left = new TreeNode(3);

//        TreeNode root = new TreeNode(4);
//        root.left = new TreeNode(1);
//        root.left.left = new TreeNode(2);
//        root.left.left.left = new TreeNode(3);

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);

        int res = s.rob(root);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}