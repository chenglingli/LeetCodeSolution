import struct.TreeNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class L993_Cousins_in_Binary_Tree {

    /*

    Given the root of a binary tree with unique values and the values of two different nodes of the tree x and y,
    return true if the nodes corresponding to the values x and y in the tree are cousins, or false otherwise.

    Two nodes of a binary tree are cousins if they have the same depth with different parents.

    Note that in a binary tree, the root node is at the depth 0,
        and children of each depth k node are at the depth k + 1.



    Example 1:


    Input: root = [1,2,3,4], x = 4, y = 3
    Output: false

    Example 2:

    Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
    Output: true

    Example 3:

    Input: root = [1,2,3,null,4], x = 2, y = 3
    Output: false


    Constraints:

    The number of nodes in the tree is in the range [2, 100].
    1 <= Node.val <= 100
    Each node has a unique value.
    x != y
    x and y are exist in the tree.

     */
    public boolean isCousins(TreeNode root, int x, int y) {

        // 层序遍历，每层保存在queue中，每层遍历完后判断set中是否有两个元素
        Set<Integer> set = new HashSet<>();
        set.add(x);
        set.add(y);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        Set<Integer> tempSet = new HashSet<>();

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node.left != null && set.contains(node.left.val) && node.right != null && set.contains(node.right.val))
                    return false;

                // 判断当前层是否有两个元素，如果有且都在set中则返回true（即父节点不同且有共同的深度

                tempSet.add(node.val);
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }

            if (tempSet.size() >= 2 && tempSet.containsAll(set)) {
                return true;
            }
            tempSet.clear();
        }

        return false;
    }


    public boolean isCousins2(TreeNode root, int x, int y) {
        // logic : if both nodes are at same level and diff parent then they are cousins

        return findLevel(root, x, 0) == findLevel(root, y, 0) && !sameParents(root, x, y);

    }

    int findLevel(TreeNode root, int num, int level) {

        if (root == null) return 0;

        if (root.val == num) {
            return level;
        }

        int leftlevel = findLevel(root.left, num, level + 1);

        if (leftlevel != 0) {
            return leftlevel;
        }

        return findLevel(root.right, num, level + 1);

    }

    boolean sameParents(TreeNode root, int x, int y) {

        if (root == null) return false;

        if (root.left != null && root.right != null &&
                (root.left.val == x && root.right.val == y ||
                        root.left.val == y && root.right.val == x)) {

            return true;
        }

        return sameParents(root.left, x, y) || sameParents(root.right, x, y);
    }

    public static void main(String[] args) {

        L993_Cousins_in_Binary_Tree s = new L993_Cousins_in_Binary_Tree();

        long sysDate1 = System.currentTimeMillis();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.left = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        boolean res = s.isCousins(root, 4, 6);

        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}