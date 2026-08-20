import struct.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L894_All_Possible_Full_Binary_Trees {

    /*

    Given an integer n, return a list of all possible full binary trees with n nodes. Each node of each tree in the answer must have Node.val == 0.

    Each element of the answer is the root node of one possible tree. You may return the final list of trees in any order.

    A full binary tree is a binary tree where each node has exactly 0 or 2 children.



    Example 1:


    Input: n = 7
    Output: [[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]
    Example 2:

    Input: n = 3
    Output: [[0,0,0]]


    Constraints:

    1 <= n <= 20

     */
    public List<TreeNode> allPossibleFBT(int n) {
        return allPossibleFBT(n, new HashMap<>());
    }

    private List<TreeNode> allPossibleFBT(int n, Map<Integer, List<TreeNode>> memo) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        List<TreeNode> result = new ArrayList<>();
        if (n % 2 == 0) {
            memo.put(n, result);
            return result;
        }
        if (n == 1) {
            result.add(new TreeNode(0));
            memo.put(n, result);
            return result;
        }

        for (int leftSize = 1; leftSize < n; leftSize += 2) {
            List<TreeNode> leftTrees = allPossibleFBT(leftSize, memo);
            List<TreeNode> rightTrees = allPossibleFBT(n - 1 - leftSize, memo);
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode root = new TreeNode(0);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }
        }

        memo.put(n, result);
        return result;
    }

    public static void main(String[] args) {

        L894_All_Possible_Full_Binary_Trees s = new L894_All_Possible_Full_Binary_Trees();
        long sysDate1 = System.currentTimeMillis();

        int n = 7;

        List<TreeNode> res = s.allPossibleFBT(n);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}