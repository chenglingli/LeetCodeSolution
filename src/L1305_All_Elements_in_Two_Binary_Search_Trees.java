import struct.TreeNode;

import java.util.Arrays;
import java.util.List;

public class L1305_All_Elements_in_Two_Binary_Search_Trees {

    /*

    Given two binary search trees root1 and root2, return a list containing all the integers from both trees sorted in ascending order.


    Example 1:
    Input: root1 = [2,1,4], root2 = [1,0,3]
    Output: [0,1,1,2,3,4]

    Example 2:
    Input: root1 = [1,null,8], root2 = [8,1]
    Output: [1,1,8,8]

    Constraints:
    The number of nodes in each tree is in the range [0, 5000].
    -10^5 <= Node.val <= 10^5

     */
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        /*
        题目：
        将两颗二叉搜索树的节点值排序输出

        思路：
        1. 中序遍历两棵树，得到两个有序数组
        2. 合并两个有序数组

         */

        List<Integer> res1 = new java.util.ArrayList<>();
        inorder(root1, res1);

        List<Integer> res2 = new java.util.ArrayList<>();
        inorder(root2, res2);

        List<Integer> res = new java.util.ArrayList<>();
        mergeList(res1, res2, res);
        return res;
    }

    private void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }

    private void mergeList(List<Integer> L1, List<Integer> L2, List<Integer> res) {
        int i = 0, j = 0;
        while (i < L1.size() && j < L2.size()) {
            if (L1.get(i) < L2.get(j)) {
                res.add(L1.get(i++));
            } else {
                res.add(L2.get(j++));
            }
        }
        while (i < L1.size()) {
            res.add(L1.get(i++));
        }
        while (j < L2.size()) {
            res.add(L2.get(j++));
        }
    }

    public static void main(String[] args) {

        L1305_All_Elements_in_Two_Binary_Search_Trees s = new L1305_All_Elements_in_Two_Binary_Search_Trees();
        long sysDate1 = System.currentTimeMillis();

        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(4);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(0);
        root2.right = new TreeNode(3);

        List<Integer> res = s.getAllElements(root1, root2);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}