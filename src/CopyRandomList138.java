import struct.Node;

import java.util.HashMap;
import java.util.Map;

public class CopyRandomList138 {

    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();

        //第一次遍历做映射
        Node tmp = head;
        while (tmp != null) {
            map.put(tmp, new Node(tmp.val, tmp.next, tmp.random));
            tmp = tmp.next;
        }

        //第二次遍历做连接
        tmp = head;
        while (tmp != null) {
            map.get(tmp).next = map.get(tmp.next);
            map.get(tmp).random = map.get(tmp.random);
            tmp = tmp.next;
        }

        return map.get(head);
    }

    public static void main(String[] args) {

        CopyRandomList138 s = new CopyRandomList138();

        long sysDate1 = System.currentTimeMillis();

//        ListNode f = new ListNode(1);
//        ListNode head = f;
//        f.next = new ListNode(2);
//        f = f.next;
//        f.next = new ListNode(3);
//        f = f.next;
//        f.next = new ListNode(4);
//        f = f.next;
//        f.next = new ListNode(5);
//        f = f.next;
//        f.next = new ListNode(6);
//
//        TreeNode res = s.sortedListToBST(head);
//
//        System.out.println(res.val);
//        System.out.println(res.left.val);
//        System.out.println(res.right.val);




        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}