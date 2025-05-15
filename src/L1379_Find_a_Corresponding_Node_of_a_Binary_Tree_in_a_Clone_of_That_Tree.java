import struct.TreeNode;

public class L1379_Find_a_Corresponding_Node_of_a_Binary_Tree_in_a_Clone_of_That_Tree {


    /*
    Given two binary trees original and cloned and given a reference to a node target in the original tree.

    The cloned tree is a copy of the original tree.

    Return a reference to the same node in the cloned tree.

    Note that you are not allowed to change any of the two trees or the target node
        and the answer must be a reference to a node in the cloned tree.



    Example 1:
    Input: tree = [7,4,3,null,null,6,19], target = 3
    Output: 3
    Explanation: In all examples the original and cloned trees are shown.
        The target node is a green node from the original tree. The answer is the yellow node from the cloned tree.


    Example 2:
    Input: tree = [7], target =  7
    Output: 7

    Example 3:
    Input: tree = [8,null,6,null,5,null,4,null,3,null,2,null,1], target = 4
    Output: 4


    Constraints:

    The number of nodes in the tree is in the range [1, 104].
    The values of the nodes of the tree are unique.
    target node is a node from the original tree and is not null.


    Follow up: Could you solve the problem if repeated values on the tree are allowed?


     */
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        // 同时遍历两个树，找到对应的节点，返回克隆树中的节点

        return dfs(original, cloned, target);
    }

    TreeNode dfs(TreeNode original, TreeNode cloned, TreeNode target) {

        if (original == null || cloned == null) {
            return null;
        }

        if (original == target) {
            return cloned;
        }

        TreeNode left = dfs(original.left, cloned.left, target);
        if (left != null) {
            return left;
        }
        TreeNode right = dfs(original.right, cloned.right, target);
        return right;
    }
    
    // 递归解法2，从根节点开始遍历，找到对应的节点，返回克隆树中的节点，如果找不到，返回null。
    public final TreeNode getTargetCopy2(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == target) {
            return cloned;
        }

        if (original.left != null) {
            TreeNode node = getTargetCopy2(original.left, cloned.left, target);
            if (node != null) return node;
        }

        if (original.right != null) {
            TreeNode node = getTargetCopy2(original.right, cloned.right, target);
            if (node != null) return node;
        }

        return null;
    }

    public static void main(String[] args) {

        L1379_Find_a_Corresponding_Node_of_a_Binary_Tree_in_a_Clone_of_That_Tree s = new L1379_Find_a_Corresponding_Node_of_a_Binary_Tree_in_a_Clone_of_That_Tree();
        long sysDate1 = System.currentTimeMillis();

        TreeNode original = new TreeNode(7);
        original.left = new TreeNode(4);
        original.right = new TreeNode(3);
        original.right.right = new TreeNode(19);
        original.right.left = new TreeNode(6);

        TreeNode cloned = new TreeNode(7);
        cloned.left = new TreeNode(4);
        cloned.right = new TreeNode(3);
        cloned.right.right = new TreeNode(19);
        cloned.right.left = new TreeNode(6);

        TreeNode target = original.right;

        TreeNode res = s.getTargetCopy(original, cloned, target);
        System.out.println(res.val);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}