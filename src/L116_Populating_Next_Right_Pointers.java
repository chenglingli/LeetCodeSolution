import struct.NextNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L116_Populating_Next_Right_Pointers {

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