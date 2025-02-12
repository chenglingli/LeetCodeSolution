import struct.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L095_Unique_Binary_Search_Trees_II {

    /*

    Given an integer n,
    return all the structurally unique BST's (binary search trees),
    which has exactly n nodes of unique values from 1 to n.

    Return the answer in any order.

    1 <= n <= 8

    There 3 important things.

    One is we try to create subtrees with some range between start(minimum) and end(maximum) value.

    Second is calculation of the range.
    left range should be between start and current root - 1 as end value
        because all values of left side must be smaller than current root.
    right range should be between current root + 1 and end
        because all values on the right side should be greater than current root value.

    Thrid is we call the same funtion recursively,
    so it's good idea to keep results of current start and end, so that we can use the results later. It's time saving.


     */
    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int start, int end) {

        List<TreeNode> result = new ArrayList<>();
        if (start > end) {
            result.add(null);
            return result;
        }

        for (int i = start; i <= end; i++) {

            List<TreeNode> leftSubTrees = generateTrees(start, i - 1);
            List<TreeNode> rightSubTrees = generateTrees(i + 1, end);

            for (TreeNode left : leftSubTrees) {
                for (TreeNode right : rightSubTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }
        }
        return result;
    }



    public List<TreeNode> generateTrees2(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }

        Map<String, List<TreeNode>> memo = new HashMap<>();
        return generateTreesHelper(1, n, memo);
    }

    private List<TreeNode> generateTreesHelper(int start, int end, Map<String, List<TreeNode>> memo) {
        String key = start + "-" + end;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        List<TreeNode> trees = new ArrayList<>();
        if (start > end) {
            trees.add(null);
            return trees;
        }

        for (int rootVal = start; rootVal <= end; rootVal++) {
            List<TreeNode> leftTrees = generateTreesHelper(start, rootVal - 1, memo);
            List<TreeNode> rightTrees = generateTreesHelper(rootVal + 1, end, memo);

            for (TreeNode leftTree : leftTrees) {
                for (TreeNode rightTree : rightTrees) {
                    TreeNode root = new TreeNode(rootVal);
                    root.left = leftTree;
                    root.right = rightTree;
                    trees.add(root);
                }
            }
        }

        memo.put(key, trees);
        return trees;
    }

    public static void main(String[] args) {
        L095_Unique_Binary_Search_Trees_II s = new L095_Unique_Binary_Search_Trees_II();
        long sysDate1 = System.currentTimeMillis();

        System.out.println(s.generateTrees(5));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}