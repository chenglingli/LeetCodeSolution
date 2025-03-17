import struct.NodeN;

import java.util.ArrayList;

public class L559_Maximum_Depth_of_N_ary_Tree {


    /*
     Given a n-ary tree, find its maximum depth.

    The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

    Nary-Tree input serialization is represented in their level order traversal, each group of children is
        separated by the null value (See examples).



    Example 1:


    Input: root = [1,null,3,2,4,null,5,6]
    Output: 3

    Example 2:

    Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
    Output: 5


    Constraints:

    The total number of nodes is in the range [0, 10^4].
    The depth of the n-ary tree is less than or equal to 1000.
     */

    public int maxDepth(NodeN root) {

        if (root == null) return 0;
        if (root.children == null || root.children.size() == 0) return 1;

        int max = 0;
        for (NodeN child : root.children) {
            max = Math.max(max, maxDepth(child));
        }

        return max + 1;
    }

    public static void main(String[] args) {

        L559_Maximum_Depth_of_N_ary_Tree s = new L559_Maximum_Depth_of_N_ary_Tree();
        long sysDate1 = System.currentTimeMillis();


        NodeN node = new NodeN(1);
        node.children = new ArrayList<>();

        NodeN node1 = new NodeN(21);
        node.children.add(node1);
        NodeN node2 = new NodeN(22);
        node.children.add(node2);
        NodeN node3 = new NodeN(23);
        node.children.add(node3);
        NodeN node4 = new NodeN(24);
        node.children.add(node4);

        int res = s.maxDepth(node);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}