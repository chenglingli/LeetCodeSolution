import struct.TreeNode;

import java.util.HashSet;

public class L572_Subtree_of_Another_Tree {


    /*

    Given the roots of two binary trees root and subRoot,
    return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.

    A subtree of a binary tree is a tree that consists of a node in tree and all of this node's descendants.
    The tree could also be considered as a subtree of itself.



    Example 1:


    Input: root = [3,4,5,1,2], subRoot = [4,1,2]
    Output: true


    Example 2:

    Input: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
    Output: false


    Constraints:

    The number of nodes in the root tree is in the range [1, 2000].
    The number of nodes in the subRoot tree is in the range [1, 1000].
    -104 <= root.val <= 10^4
    -104 <= subRoot.val <= 10^4

     */
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if (root == null) {
            return false;
        }

        if (root.val == subRoot.val && isSameTree(root, subRoot)) {
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }


    // 另一种解法
    // 比1更快
    public boolean isSubtree2(TreeNode root, TreeNode subRoot) {
        return hasTree(root, subRoot, subRoot);
    }

    /**
     * 判断给定的树中是否包含指定的子树。
     *
     * @param root         给定的树的根节点。
     * @param subRoot      指定的子树的根节点。
     * @param parentSubNode 子树的父节点，用于递归检查。
     * @return 如果给定的树中包含指定的子树，则返回true；否则返回false。
     */
    public boolean hasTree(TreeNode root, TreeNode subRoot, TreeNode parentSubNode) {
        // 如果两个树的根节点都为空，则认为它们是相同的树
        if (root == null && subRoot == null) {
            return true;
        }

        // 如果其中一个树的根节点为空，则它们不可能是相同的树
        if(root == null || subRoot == null){
            return false;
        }

        boolean in = false;
        // 如果当前节点值相等，则递归检查左右子树是否相同
        if (root.val == subRoot.val) {
            in = hasTree(root.left, subRoot.left, subRoot) && hasTree(root.right, subRoot.right, subRoot);
        }

        // 返回当前节点是否相同或者递归检查左右子树是否包含相同的子树
        return in || hasTree(root.left, parentSubNode, parentSubNode)
                || hasTree(root.right, parentSubNode, parentSubNode);

    }


    public static void main(String[] args) {

        L572_Subtree_of_Another_Tree s = new L572_Subtree_of_Another_Tree();

        long sysDate1 = System.currentTimeMillis();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);

        TreeNode subRoot = new TreeNode(4);
        subRoot.left = new TreeNode(1);
        subRoot.right = new TreeNode(2);

        boolean res = s.isSubtree(root, subRoot);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}