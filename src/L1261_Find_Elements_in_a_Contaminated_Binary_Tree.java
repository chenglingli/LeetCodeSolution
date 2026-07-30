import struct.TreeNode;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/*

    Given a binary tree with the following rules:

    root.val == 0
    For any treeNode:
    If treeNode.val has a value x and treeNode.left != null, then treeNode.left.val == 2 * x + 1
    If treeNode.val has a value x and treeNode.right != null, then treeNode.right.val == 2 * x + 2
    Now the binary tree is contaminated, which means all treeNode.val have been changed to -1.

    Implement the FindElements class:

    FindElements(TreeNode* root) Initializes the object with a contaminated binary tree and recovers it.
    bool find(int target) Returns true if the target value exists in the recovered binary tree.


    Example 1:


    Input
    ["FindElements","find","find"]
    [[[-1,null,-1]],[1],[2]]
    Output
    [null,false,true]
    Explanation
    FindElements findElements = new FindElements([-1,null,-1]);
    findElements.find(1); // return False
    findElements.find(2); // return True

    Example 2:
    Input
    ["FindElements","find","find","find"]
    [[[-1,-1,-1,-1,-1]],[1],[3],[5]]
    Output
    [null,true,true,false]
    Explanation
    FindElements findElements = new FindElements([-1,-1,-1,-1,-1]);
    findElements.find(1); // return True
    findElements.find(3); // return True
    findElements.find(5); // return False
    Example 3:


    Input
    ["FindElements","find","find","find","find"]
    [[[-1,null,-1,-1,null,-1]],[2],[3],[4],[5]]
    Output
    [null,true,false,false,true]
    Explanation
    FindElements findElements = new FindElements([-1,null,-1,-1,null,-1]);
    findElements.find(2); // return True
    findElements.find(3); // return False
    findElements.find(4); // return False
    findElements.find(5); // return True


    Constraints:

    TreeNode.val == -1
    The height of the binary tree is less than or equal to 20
    The total number of nodes is between [1, 104]
    Total calls of find() is between [1, 104]
    0 <= target <= 106

 */

class FindElements {

    private Set<Integer> values;
    public FindElements(TreeNode root) {
        values = new HashSet<>();
        recover(root, 0);
    }

    private void recover(TreeNode node, int value) {
        if (node == null) {
            return;
        }
        values.add(value);
        recover(node.left, 2 * value + 1);
        recover(node.right, 2 * value + 2);
    }

    public boolean find(int target) {
        return values.contains(target);
    }
}

public class L1261_Find_Elements_in_a_Contaminated_Binary_Tree {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(-1);
        root.right = new TreeNode(-1);

        FindElements s = new FindElements(root);
        long sysDate1 = System.currentTimeMillis();

        boolean res = s.find(1);
        System.out.println(res);
        res = s.find(2);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}