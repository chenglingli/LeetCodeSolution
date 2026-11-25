import struct.TreeNode;

public class L1026_Maximum_Difference_Between_Node_and_Ancestor {


    /*
    Given the root of a binary tree, find the maximum value v for which there exist different nodes a and b where v = |a.val - b.val| and a is an ancestor of b.

    A node a is an ancestor of b if either: any child of a is equal to b or any child of a is an ancestor of b.

    Example 1:
    Input: root = [8,3,10,1,6,null,14,null,null,4,7,13]

    Output: 7
    Explanation: We have various ancestor-node differences, some of which are given below :
    |8 - 3| = 5
    |3 - 7| = 4
    |8 - 1| = 7
    |10 - 13| = 3
    Among all possible differences, the maximum value of 7 is obtained by |8 - 1| = 7.

    Example 2:
    Input: root = [1,null,2,null,0,3]
    Output: 3

    Constraints:
    The number of nodes in the tree is in the range [2, 5000].
    0 <= Node.val <= 10^5
     */
    public int maxAncestorDiff(TreeNode root) {
        /*
        题意：
        给定一个二叉数，树上任意一对「祖先–后代」节点，它们数值差的绝对值里最大的那个。

        关键观察:
        固定一个节点 b，它上面可能有很多祖先。但 |祖先 - b| 最大的那个祖先，一定是路径上最大的祖先，或者最小的祖先。中间那些祖先算出来的差只会更小。

        所以不用把每个节点和所有祖先逐个比较。从根走到当前节点时，只要带着这条路径上见过的最小值和最大值就够了。

        再往前推一步：路径上的最大值和最小值，谁在上面谁就是祖先。因此这条路径上任意一对祖先–后代的差，都不会超过 路径最大值 - 路径最小值。
        整棵树的答案，就是所有「根到某节点」路径上，这个极差的最大值。

        怎么走:
        自顶向下做一次深度优先遍历，每个调用多带两个参数：lo（到目前为止的最小值）、hi（到目前为止的最大值）。

        空节点直接返回。走到空节点时，hi - lo 就是父节点那条路径的极差；极差只会随深度变大或不变，所以最大值一定出现在某条走到叶子的路径上。
        用当前节点的值更新 lo 和 hi。
        左、右子树各走一遍，取较大的那个极差。
         */

        return dfs(root, root.val, root.val);

    }

    public int dfs(TreeNode node, int max, int min) {
        
        if (node == null) {
            return max - min;
        }

        max = Math.max(max, node.val);
        min = Math.min(min, node.val);
        return Math.max(dfs(node.left, max, min), dfs(node.right, max, min));
    }

    public static void main(String[] args) {


        long sysDate1 = System.currentTimeMillis();

        L1026_Maximum_Difference_Between_Node_and_Ancestor s = new L1026_Maximum_Difference_Between_Node_and_Ancestor();
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(3);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(7);

        root.right.right = new TreeNode(14);
        root.right.right.left = new TreeNode(13);


        int res = s.maxAncestorDiff(root);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}