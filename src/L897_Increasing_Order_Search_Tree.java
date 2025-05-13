import struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class L897_Increasing_Order_Search_Tree {

    /*
    Given the root of a binary search tree,
    rearrange the tree in in-order so that
        the leftmost node in the tree is now the root of the tree,
        and every node has no left child and only one right child.

    Example 1:
    Input: root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
    Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]

    Example 2:
    Input: root = [5,1,7]
    Output: [1,null,5,null,7]

    Constraints:
    The number of nodes in the given tree will be in the range [1, 100].
    0 <= Node.val <= 1000

     */
    public TreeNode increasingBST(TreeNode root) {

        // 进行中序遍历，得到一个有序的数组
        // 然后根据这个数组构建一个新的树

        List<Integer> list = new ArrayList<>();
        inorder(root, list);

        TreeNode dummyNode = new TreeNode(-1);
        TreeNode cur = dummyNode;
        for (int val : list) {
            cur.right = new TreeNode(val);
            cur = cur.right;
        }

        return dummyNode.right;
    }

    void inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    public static void main(String[] args) {

        L897_Increasing_Order_Search_Tree s = new L897_Increasing_Order_Search_Tree();

        long sysDate1 = System.currentTimeMillis();

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);

        root.right.right = new TreeNode(8);
        root.right.right.left = new TreeNode(7);
        root.right.right.right = new TreeNode(9);

        TreeNode res = s.increasingBST(root);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}