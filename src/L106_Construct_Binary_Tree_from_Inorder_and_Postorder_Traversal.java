import struct.TreeNode;

import java.util.Arrays;

public class L106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {

    /*
    Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree
    and postorder is the postorder traversal of the same tree, construct and return the binary tree.



    Example 1:


    Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
    Output: [3,9,20,null,null,15,7]
    Example 2:

    Input: inorder = [-1], postorder = [-1]
    Output: [-1]


    Constraints:

    1 <= inorder.length <= 3000
    postorder.length == inorder.length
    -3000 <= inorder[i], postorder[i] <= 3000
    inorder and postorder consist of unique values.
    Each value of postorder also appears in inorder.
    inorder is guaranteed to be the inorder traversal of the tree.
    postorder is guaranteed to be the postorder traversal of the tree.
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // 基于一颗二叉树的中序和后续遍历，构建二叉树
        // 思路：
        // 后序遍历的最后一个节点一定是根节点
        // 在中序遍历中找到根节点，左子树的中序遍历是[0, index)，右子树是中序遍历是(index + 1, n)
        // 后序遍历的左子树是[0, index - 1)，右子树是(index, n - 1)
        // 递归构建左子树和右子树

        if (inorder == null || postorder == null || postorder.length != inorder.length || postorder.length == 0) {
            return null;
        }

        int n = postorder.length;
        TreeNode root = new TreeNode(postorder[n - 1]);

        for (int i = 0; i < n; i++) {
            if (inorder[i] == postorder[n - 1]) {
                root.left = buildTree(Arrays.copyOfRange(inorder, 0, i), Arrays.copyOfRange(postorder, 0, i));
                root.right = buildTree(Arrays.copyOfRange(inorder, i + 1, n), Arrays.copyOfRange(postorder, i, n - 1));
                break;
            }
        }

        return root;
    }

    private int idx;
    private int pidx;

    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        idx = inorder.length - 1;
        pidx = postorder.length - 1;

        return helper(inorder, postorder, Integer.MAX_VALUE);
    }

    private TreeNode helper(int[] inorder, int[] postorder, int limit) {
        if (pidx < 0) return null;

        if (inorder[idx] == limit) {
            idx--;
            return null;
        }

        TreeNode root = new TreeNode(postorder[pidx--]);
        root.right = helper(inorder, postorder, root.val);
        root.left = helper(inorder, postorder, limit);

        return root;
    }

    public static void main(String[] args) {
        L106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal s = new L106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal();
        long sysDate1 = System.currentTimeMillis();

        int[] inorder = new int[]{9, 3, 15, 20, 7};
        int[] postorder = new int[]{9, 15, 7, 20, 3};
        TreeNode t = s.buildTree(inorder, postorder);

        System.out.println(t.val);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}