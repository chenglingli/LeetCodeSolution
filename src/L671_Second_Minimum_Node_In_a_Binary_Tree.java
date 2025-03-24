import struct.TreeNode;

public class L671_Second_Minimum_Node_In_a_Binary_Tree {

    /*

    Given a non-empty special binary tree consisting of nodes with the non-negative value,
    where each node in this tree has exactly two or zero sub-node. If the node has two sub-nodes,
    then this node's value is the smaller value among its two sub-nodes.

    More formally, the property root.val = min(root.left.val, root.right.val) always holds.

    Given such a binary tree, you need to output the second minimum value in the set made of
        all the nodes' value in the whole tree.

    If no such second minimum value exists, output -1 instead.



    Example 1:
    Input: root = [2,2,5,null,null,5,7]
    Output: 5
    Explanation: The smallest value is 2, the second smallest value is 5.

    Example 2:
    Input: root = [2,2,2]
    Output: -1
    Explanation: The smallest value is 2, but there isn't any second smallest value.


    Constraints:

    The number of nodes in the tree is in the range [1, 25].
    1 <= Node.val <= 2^31 - 1
    root.val == min(root.left.val, root.right.val) for each internal node of the tree.

    [1,1,3,1,1,3,4,3,1,1,1,3,8,4,8,3,3,1,6,2,1]


     */
    public int findSecondMinimumValue(TreeNode root) {
        // 如果根节点为空，返回-1
        if (root == null) {
            return -1;
        }

        // 如果左子树为空，递归调用右子树
        if (root.left == null) {
            return findSecondMinimumValue(root.right);
        }

        // 如果右子树为空，递归调用左子树
        if (root.right == null) {
            return findSecondMinimumValue(root.left);
        }

        // 递归调用左子树和右子树，获取第二小的值
        int leftSecond = findSecondMinimumValue(root.left);
        leftSecond = (leftSecond == -1) ? Integer.MAX_VALUE : leftSecond; // 如果左子树没有第二小的值，则将其设为最大值
        int rightSecond = findSecondMinimumValue(root.right);
        rightSecond = (rightSecond == -1) ? Integer.MAX_VALUE : rightSecond; // 如果右子树没有第二小的值，则将其设为最大值

        // 如果左子树和右子树的值相等
        if (root.left.val == root.right.val) {
            // 如果左子树和右子树都没有第二小的值，则返回-1
            if (leftSecond == Integer.MAX_VALUE && rightSecond == Integer.MAX_VALUE)
                return -1;
            // 否则返回左右子树第二小值的较小值
            return Math.min(leftSecond, rightSecond);
        }

        // 如果左子树的值小于右子树的值
        if (root.left.val < root.right.val) {
            // 返回右子树的值和左子树第二小值的较小值
            return Math.min(root.right.val, leftSecond);
        }
        else {
            // 返回左子树的值和右子树第二小值的较小值
            return Math.min(root.left.val, rightSecond);
        }
    }



    public static void main(String[] args) {

        L671_Second_Minimum_Node_In_a_Binary_Tree s = new L671_Second_Minimum_Node_In_a_Binary_Tree();

        long sysDate1 = System.currentTimeMillis();

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        int res = s.findSecondMinimumValue(root);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}