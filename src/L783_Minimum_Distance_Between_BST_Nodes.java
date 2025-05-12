import struct.TreeNode;

public class L783_Minimum_Distance_Between_BST_Nodes {

    /*

    Given the root of a Binary Search Tree (BST),
    return the minimum difference between the values of any two different nodes in the tree.



    Example 1:
    Input: root = [4,2,6,1,3]
    Output: 1

    Example 2:
    Input: root = [1,0,48,null,null,12,49]
    Output: 1


    Constraints:

    The number of nodes in the tree is in the range [2, 100].
    0 <= Node.val <= 10^5

     */
    public int minDiffInBST(TreeNode root) {

        // 遍历二叉搜索树，用一个变量记录上一个节点的值，然后用当前节点和上一个节点的值的差更新最小值。
        // 为了方便传递，使用数组进行记录
        // 也可以用全局变量，但是全局变量的写法在多线程环境下可能会有问题。
        // 遍历的顺序是：左子树，当前节点，右子树。

        int[] min = new int[1];
        min[0] = Integer.MAX_VALUE;
        int[] prevVal = new int[1];
        prevVal[0] = -1;

        dfs(root, min, prevVal);

        return min[0];
    }

    private void dfs(TreeNode node, int[] min, int[] prevVal) {
        if (node == null) {
            return;
        }

        dfs(node.left, min, prevVal);

        if (prevVal[0] != -1) {
            min[0] = Math.min(min[0], node.val - prevVal[0]);
        }

        prevVal[0] = node.val;

        dfs(node.right, min, prevVal);
    }

    public static void main(String[] args) {

        L783_Minimum_Distance_Between_BST_Nodes s = new L783_Minimum_Distance_Between_BST_Nodes();

        long sysDate1 = System.currentTimeMillis();

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        int res = s.minDiffInBST(root);

        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}