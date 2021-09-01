import struct.NextNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L116_Populating_Next_Right_Pointers {

    /*
    Node* connect(Node* root) {
        if (!root) return NULL;
        queue<Node*> q;
        q.push(root);
        //每一个while循环都是一层
        //size就是这一层的节点数量
        //i<size-1时，代表要右指
        //每一层干三件事：1.弹出旧的 2.判断右指 3.添加新的
        while (!q.empty()) {
            auto size = q.size();
            for (int i = 0; i < size; ++i) {
                Node* t = q.front(); q.pop();
                if (i < size - 1) {
                    t->next = q.front();
                }
                if (t->left) q.push(t->left);
                if (t->right) q.push(t->right);
            }
        }
        return root;
    }
    */

    public NextNode connect(NextNode root) {

        if (root == null)
            return root;

        Queue<NextNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                NextNode cur = queue.poll();

                if (i < size - 1) {
                    cur.next = queue.peek();
                }

                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }

        return root;
    }

    public static void main(String[] args) {

        L116_Populating_Next_Right_Pointers s = new L116_Populating_Next_Right_Pointers();
        long sysDate1 = System.currentTimeMillis();


        // init data
        NextNode root = new NextNode(3);
        NextNode root1 = new NextNode(9);
        NextNode root2 = new NextNode(20);

        root.left = root1;
        root.right = root2;

        System.out.println(s.connect(root));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}