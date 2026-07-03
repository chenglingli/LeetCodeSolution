import struct.TreeNode;

import java.util.Arrays;

public class L1315_Sum_of_Nodes_with_Even_Valued_Grandparent {

    /*

    Given the root of a binary tree, return the sum of values of nodes with an even-valued grandparent. If there are no nodes with an even-valued grandparent, return 0.

    A grandparent of a node is the parent of its parent if it exists.



    Example 1:


    Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
    Output: 18
    Explanation: The red nodes are the nodes with even-value grandparent while the blue nodes are the even-value grandparents.
    Example 2:


    Input: root = [1]
    Output: 0


    Constraints:

    The number of nodes in the tree is in the range [1, 104].
    1 <= Node.val <= 100

     */

    private int sum = 0;

    public int sumEvenGrandparent(TreeNode root) {
        // 遍历二叉树，找到祖父节点值为偶数的节点，累加其值
        dfs(root, null, null);
        return sum;
    }

    private void dfs(TreeNode node, TreeNode parent, TreeNode grandparent) {
        if (node == null) {
            return;
        }
        if (grandparent != null && grandparent.val % 2 == 0) {
            sum += node.val;
        }
        dfs(node.left, node, parent);
        dfs(node.right, node, parent);
    }

    // 递归写法
    // 传递值，更好一些
    private int dfs2(TreeNode node, int parent, int grandParent){
        if( node == null ) return 0;
        int sum =0;
        if(grandParent % 2== 0){
            sum += node.val;
        }

        sum += dfs2(node.left, node.val, parent);
        sum += dfs2(node.right, node.val, parent);

        return sum;
    }
    public int sumEvenGrandparent2(TreeNode root) {
        return dfs2(root, 1, 1);
    }

    public static void main(String[] args) {

        L1315_Sum_of_Nodes_with_Even_Valued_Grandparent s = new L1315_Sum_of_Nodes_with_Even_Valued_Grandparent();
        long sysDate1 = System.currentTimeMillis();

        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(7);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(3);
        root.left.left.left = new TreeNode(9);
        root.left.right.left = new TreeNode(1);
        root.left.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(5);

        int res = s.sumEvenGrandparent(root);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}