import struct.NodeN;

import java.util.ArrayList;
import java.util.List;

public class L590_N_ary_Tree_Postorder_Traversal {


    /*

    Given the root of an n-ary tree, return the postorder traversal of its nodes' values.

    Nary-Tree input serialization is represented in their level order traversal.
        Each group of children is separated by the null value (See examples)



    Example 1:
    Input: root = [1,null,3,2,4,null,5,6]
    Output: [5,6,3,2,4,1]

    Example 2:
    Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
    Output: [2,6,14,11,7,3,12,8,4,13,9,10,5,1]


    Constraints:

    The number of nodes in the tree is in the range [0, 104].
    0 <= Node.val <= 104
    The height of the n-ary tree is less than or equal to 1000.

     */
    public List<Integer> postorder(NodeN root) {
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        traverse(root, result);
        return result;
    }
    private void traverse(NodeN node, List<Integer> result){
        if(node == null){
            return;
        }
        if (node.children != null && node.children.size() > 0) {
            for (NodeN child : node.children) {
                traverse(child, result);
            }
        }
        result.add(node.val);
    }

    public static void main(String[] args) {

        L590_N_ary_Tree_Postorder_Traversal s = new L590_N_ary_Tree_Postorder_Traversal();

        long sysDate1 = System.currentTimeMillis();


        NodeN root = new NodeN(1);
        NodeN child1 = new NodeN(3);
        NodeN child2 = new NodeN(2);
        NodeN child3 = new NodeN(4);
        root.children = new ArrayList<>();
        root.children.add(child1);
        root.children.add(child2);
        root.children.add(child3);

        NodeN child4 = new NodeN(5);
        NodeN child5 = new NodeN(6);
        child1.children = new ArrayList<>();
        child1.children.add(child4);
        child1.children.add(child5);


        List<Integer> res = s.postorder(root);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}