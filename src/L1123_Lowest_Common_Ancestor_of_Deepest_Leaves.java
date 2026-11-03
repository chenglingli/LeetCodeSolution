import struct.TreeNode;

public class L1123_Lowest_Common_Ancestor_of_Deepest_Leaves {


    /*
    Given the root of a binary tree, return the lowest common ancestor of its deepest leaves.

    Recall that:

    The node of a binary tree is a leaf if and only if it has no children
    The depth of the root of the tree is 0. if the depth of a node is d, the depth of each of its children is d + 1.
    The lowest common ancestor of a set S of nodes, is the node A with the largest depth such that every node in S is in the subtree with root A.


    Example 1:
    Input: root = [3,5,1,6,2,0,8,null,null,7,4]
    Output: [2,7,4]
    Explanation: We return the node with value 2, colored in yellow in the diagram.
    The nodes coloured in blue are the deepest leaf-nodes of the tree.
    Note that nodes 6, 0, and 8 are also leaf nodes, but the depth of them is 2, but the depth of nodes 7 and 4 is 3.

    Example 2:
    Input: root = [1]
    Output: [1]
    Explanation: The root is the deepest node in the tree, and it's the lca of itself.

    Example 3:
    Input: root = [0,1,3,null,2]
    Output: [2]
    Explanation: The deepest leaf node in the tree is 2, the lca of one node is itself.


    Constraints:
    The number of nodes in the tree will be in the range [1, 1000].
    0 <= Node.val <= 1000
    The values of the nodes in the tree are unique.

    Note: This question is the same as 865: https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/

     */


    // 信息类，记录节点和高度
    private static class Info {

        TreeNode node;
        int height;

        Info(TreeNode node, int height) {
            this.node = node;
            this.height = height;
        }
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return dfs(root).node;
    }

    /*
        一次后序遍历即可，时间 O(n)，空间 O(h)。每个子树向上交两样东西：这棵子树里最深叶子的祖先候选，以及这棵子树的高度（到最深叶子的距离）。

        对当前节点比较左右子树的高度：

        左右一样高：两边都有同样深的叶子，当前节点才是它们的分叉点，候选改成自己。
        左边更高：这棵子树里的最深叶子全在左边，候选沿用左子树的结果。
        右边更高：同理，沿用右子树的结果。

    */
    private Info dfs(TreeNode node) {

        if (node == null) {
            return new Info(null, 0);
        }

        Info left = dfs(node.left);
        Info right = dfs(node.right);

        if (left.height == right.height) {
            return new Info(node, left.height + 1);
        }

        if (left.height > right.height) {
            return new Info(left.node, left.height + 1);
        }

        return new Info(right.node, right.height + 1);
    }



    // 另一种写法
    TreeNode res;
    int maxDepth = -1;

    public TreeNode lcaDeepestLeaves2(TreeNode root) {
        dfs2(root, 0);
        return res;
    }

    private int dfs2(TreeNode node, int depth) {
        if (node == null) {
            maxDepth = Math.max(maxDepth, depth);
            return depth;
        }

        int left = dfs2(node.left, depth + 1);
        int right = dfs2(node.right, depth + 1);
        if (left == right && left == maxDepth)
            res = node;
        return Math.max(left, right);
    }

    public static void main(String[] args) {

        L1123_Lowest_Common_Ancestor_of_Deepest_Leaves s = new L1123_Lowest_Common_Ancestor_of_Deepest_Leaves();
        long sysDate1 = System.currentTimeMillis();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        TreeNode res = s.lcaDeepestLeaves(root);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}