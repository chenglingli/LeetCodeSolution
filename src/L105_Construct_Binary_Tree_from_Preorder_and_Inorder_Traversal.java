import struct.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class L105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {

    /*
    Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree
        and inorder is the inorder traversal of the same tree, construct and return the binary tree.

    Example 1:
    Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
    Output: [3,9,20,null,null,15,7]

    Example 2:

    Input: preorder = [-1], inorder = [-1]
    Output: [-1]


    Constraints:

    1 <= preorder.length <= 3000
    inorder.length == preorder.length
    -3000 <= preorder[i], inorder[i] <= 3000
    preorder and inorder consist of unique values.
    Each value of inorder also appears in preorder.
    preorder is guaranteed to be the preorder traversal of the tree.
    inorder is guaranteed to be the inorder traversal of the tree.
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 基于一颗二叉树的前序和中序遍历，构建二叉树
        // 思路：
        // 前序遍历的第一个节点一定是根节点
        // 在中序遍历中找到根节点，左子树的中序遍历是[0, index)，右子树是中序遍历是(index + 1, n)
        // 前序遍历的左子树是[1, index)，右子树是(index + 1, n)
        // 递归构建左子树和右子树

        if (preorder == null || inorder == null || preorder.length != inorder.length || preorder.length == 0) {
            return null;
        }

        int n = preorder.length;
        TreeNode root = new TreeNode(preorder[0]);

        for (int i = 0; i < n; i++) {
            if (inorder[i] == preorder[0]) {
                root.left = buildTree(Arrays.copyOfRange(preorder, 1, i + 1), Arrays.copyOfRange(inorder, 0, i));
                root.right = buildTree(Arrays.copyOfRange(preorder, i + 1, n), Arrays.copyOfRange(inorder, i + 1, n));
                break;
            }
        }

        return root;
    }

    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        // 使用数组索引，为了方便传值
        int[] preIndex = new int[]{0};
        int[] inIndex = new int[]{0};
        // 递归构建二叉树
        return recursion(preorder, inorder, preIndex, inIndex, Integer.MIN_VALUE);
    }

    private TreeNode recursion(int[] pre, int[] in, int[] preIndex, int[] inIndex, int nextValueIn) {

        // 递归终止：超出中序数组范围 或 遇到右子树边界值
        if(inIndex[0] >= in.length || in[inIndex[0]] == nextValueIn) {
            return null;
        }

        // 从前序数组取当前节点值作为根
        TreeNode root = new TreeNode(pre[preIndex[0]]);
        preIndex[0]++;

        // 递归构建左子树，root.val作为左子树的右边界(因为二叉树中所有值都不相同)
        root.left = recursion(pre, in, preIndex, inIndex, root.val);

        // 移动到中序数组的下一个位置
        inIndex[0]++;

        // 递归构建右子树，使用父节点的右边界值
        root.right = recursion(pre, in, preIndex, inIndex, nextValueIn);

        return root;
    }


    public static void main(String[] args) {
        L105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal s = new L105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal();
        long sysDate1 = System.currentTimeMillis();

        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        TreeNode t = s.buildTree(preorder, inorder);

        System.out.println(t.val);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}