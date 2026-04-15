public class L331_Verify_Preorder_Serialization_of_a_Binary_Tree {

    /*

    One way to serialize a binary tree is to use preorder traversal. When we encounter a non-null node,
    we record the node's value. If it is a null node, we record using a sentinel value such as '#'.


    For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#", where '#' represents a null node.

    Given a string of comma-separated values preorder, return true if it is a correct preorder traversal serialization of a binary tree.

    It is guaranteed that each comma-separated value in the string must be either an integer or a character '#' representing null pointer.

    You may assume that the input format is always valid.

    For example, it could never contain two consecutive commas, such as "1,,3".
    Note: You are not allowed to reconstruct the tree.



    Example 1:
    Input: preorder = "9,3,4,#,#,1,#,#,2,#,6,#,#"
    Output: true

    Example 2:
    Input: preorder = "1,#"
    Output: false

    Example 3:
    Input: preorder = "9,#,#,1"
    Output: false


    Constraints:
    1 <= preorder.length <= 10^4
    preorder consist of integers in the range [0, 100] and '#' separated by commas ','.

    核心想法：count 表示「还要填几个子树位置」
    把前序序列看成：按顺序往二叉树的「空位」里填节点。

    一开始 count = 1：整棵树只有一个根的位置要填。
    每读一个 token（不管是数字还是 #），都先 count--：用掉一个「当前正在填的位置」。
    若 count < 0：没有空位却还在读节点 → 多出来的节点，非法。
    若当前不是 #：这是一个有左右子树的真实结点，前序里后面还要接左子树、右子树，所以 count += 2：多出两个「子树槽位」要填。
    若是 #：叶子空指针，不再产生子树槽位，不加。
    扫完整个字符串后，count == 0 表示：所有槽位都刚好被用完，没有多也没有少 → 合法的一棵树。

    这和「不建树、只维护还能接多少子树」是等价的，所以满足题目「不能显式建树」的要求。

     */
    public boolean isValidSerialization(String preorder) {
        // 判断一个前序遍历的字符串是否为一个有效的二叉树的前序遍历
        // 思路：用一个计数器来记录当前节点的数量，初始化为1
        // 遍历字符串，每次遇到一个节点就将计数器减1
        // 如果计数器为0，则说明已经遍历完了所有的节点
        // 否则，如果遇到一个非空节点，就将计数器加2（因为每个非空节点都会有两个子节点）
        // 最后判断计数器的值是否为1即可

        String[] nodes = preorder.split(",");
        if (nodes.length % 2 == 0) return false; // 如果字符串长度为偶数，则说明出现了多余的节点（因为每个非空节点都会有两个子节点

        int count = 1; // 初始化计数器为1

        for (String node : nodes) {
            count--; // 每遇到一个节点就减1
            if (count < 0) return false; // 如果计数器小于0，则说明出现了多余的节点
            if (!node.equals("#")) count += 2; // 如果不是null节点，则将计数器增加2
        }

        return count == 0; // 最后判断计数器的值是否为0

    }

    public static void main(String[] args) {

        L331_Verify_Preorder_Serialization_of_a_Binary_Tree s = new L331_Verify_Preorder_Serialization_of_a_Binary_Tree();
        long sysDate1 = System.currentTimeMillis();
        String preorder = "9,3,4,#,#,1,#,#,2,#,6,#,#";

        boolean x = s.isValidSerialization(preorder);

        System.out.println(x);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}