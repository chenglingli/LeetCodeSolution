import struct.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L501_Find_Mode_in_Binary_Search_Tree {

    /*

    Given the root of a binary search tree (BST) with duplicates, return all the mode(s)
    (i.e., the most frequently occurred element) in it.

    If the tree has more than one mode, return them in any order.

    Assume a BST is defined as follows:

    The left subtree of a node contains only nodes with keys less than or equal to the node's key.
    The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
    Both the left and right subtrees must also be binary search trees.


    Example 1:
    Input: root = [1,null,2,2]
    Output: [2]

    Example 2:
    Input: root = [0]
    Output: [0]


    Constraints:
    The number of nodes in the tree is in the range [1, 104].
    -10^5 <= Node.val <= 10^5

     */
    public int[] findMode(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        List<Integer> res = new ArrayList<>();


        // 中序遍历，将所有元素放入list中
        inorder(root, list);

        int count = 0;
        int maxCount = 0;

        // 遍历数组，找出出现次数最多的元素
        for (int i = 0; i < list.size(); ) {

            int cur = list.get(i);
            while (i < list.size() && cur == list.get(i)) {
                count++;
                i++;
            }
            if (count > maxCount) {
                maxCount = count;
                res.clear();
                res.add(cur);
            } else if (count == maxCount) {
                res.add(cur);
            }
            count = 0;
        }

        // 转化为数组
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        inorder(root.left, list);

        list.add(root.val);

        inorder(root.right, list);
    }




    private int currentVal;
    private int currentCount = 0;
    private int maxCount = 0;
    private List<Integer> modes = new ArrayList<>();

    public int[] findMode2(TreeNode root) {

        inOrderTraversal(root);

        int[] result = new int[modes.size()];
        for (int i = 0; i < modes.size(); i++) {
            result[i] = modes.get(i);
        }
        return result;
    }

    private void inOrderTraversal(TreeNode node) {
        if (node == null)
            return;

        inOrderTraversal(node.left);

        currentCount = (node.val == currentVal) ? currentCount + 1 : 1;
        if (currentCount == maxCount) {
            modes.add(node.val);
        } else if (currentCount > maxCount) {
            maxCount = currentCount;
            modes.clear();
            modes.add(node.val);
        }
        currentVal = node.val;

        inOrderTraversal(node.right);
    }

    public static void main(String[] args) {

        L501_Find_Mode_in_Binary_Search_Tree s = new L501_Find_Mode_in_Binary_Search_Tree();
        long sysDate1 = System.currentTimeMillis();

        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(2);

        int[] res = s.findMode2(root);
        System.out.println(Arrays.toString(res));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}