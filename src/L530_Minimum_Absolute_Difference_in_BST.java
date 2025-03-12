import struct.TreeNode;


public class L530_Minimum_Absolute_Difference_in_BST {

    /*

    Given the root of a Binary Search Tree (BST),
    return the minimum absolute difference between the values of any two different nodes in the tree.

    Example 1:

    Input: root = [4,2,6,1,3]
    Output: 1

    Example 2:

    Input: root = [1,0,48,null,null,12,49]
    Output: 1


    Constraints:

    The number of nodes in the tree is in the range [2, 104].
    0 <= Node.val <= 10^5

     */

    public int getMinimumDifference(TreeNode root) {

        // 初始化答案数组和当前值数组
        int[] ans = new int[1];
        ans[0] = Integer.MAX_VALUE;
        int[] currentVal = new int[1];
        currentVal[0] = Integer.MAX_VALUE;

        // 中序遍历，更新答案数组和当前值数组
        inOrderTraversal(root, ans, currentVal);

        // 返回答案数组的第一个元素
        return ans[0];
    }

    private void inOrderTraversal(TreeNode node, int[] ans, int[] currentVal) {
        // 如果当前节点为空，则直接返回
        if (node == null)
            return;

        // 先遍历左子树
        inOrderTraversal(node.left, ans, currentVal);

        // 更新答案数组和当前值数组
        ans[0] = Math.min(ans[0], Math.abs(node.val - currentVal[0]));
        currentVal[0] = node.val;

        // 最后遍历右子树
        inOrderTraversal(node.right, ans, currentVal);
    }

    public static void main(String[] args) {

        L530_Minimum_Absolute_Difference_in_BST s = new L530_Minimum_Absolute_Difference_in_BST();
        long sysDate1 = System.currentTimeMillis();

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        int res = s.getMinimumDifference(root);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}