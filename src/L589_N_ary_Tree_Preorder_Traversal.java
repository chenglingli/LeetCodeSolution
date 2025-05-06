import struct.NodeN;

import java.util.ArrayList;
import java.util.List;

public class L589_N_ary_Tree_Preorder_Traversal {


    /*

    Given the root of an n-ary tree, return the preorder traversal of its nodes' values.

    Nary-Tree input serialization is represented in their level order traversal.
        Each group of children is separated by the null value (See examples)



    Example 1:
    Input: root = [1,null,3,2,4,null,5,6]
    Output: [1,3,5,6,2,4]

    Example 2:
    Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
    Output: [1,2,3,6,7,11,14,4,8,12,5,9,13,10]


    Constraints:

    The number of nodes in the tree is in the range [0, 104].
    0 <= Node.val <= 104
    The height of the n-ary tree is less than or equal to 1000.

     */
    public List<Integer> preorder(NodeN root) {

        // 先续遍历，本质上就是深度优先遍历，递归实现
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        res.add(root.val);

        if (root.children == null) {
            return res;
        }
        for (NodeN child : root.children) {
            res.addAll(preorder(child));
        }
        return res;
    }

    /*

    方法2更好，通过参数带出最终result

     */
    public List<Integer> preorder2(NodeN root) {
        List<Integer> result = new ArrayList<>();
        traverse(root, result);
        return result;
    }
    private void traverse(NodeN node, List<Integer> result){
        if(node == null){
            return;
        }
        result.add(node.val);
        for(NodeN child : node.children ){
            traverse(child, result);
        }
    }

    public static void main(String[] args) {

        L589_N_ary_Tree_Preorder_Traversal s = new L589_N_ary_Tree_Preorder_Traversal();

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


        List<Integer> res = s.preorder(root);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}