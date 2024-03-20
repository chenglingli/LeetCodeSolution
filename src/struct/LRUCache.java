package struct;

import java.util.HashMap;

public class LRUCache {

    // 使用双向链表 + map实现
    // HashMap<Integer, ListNode>

    // 双向链表
    private class ListNode {
        int key;
        int value;
        ListNode prev;
        ListNode next;

        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

    private int capacity;
    private HashMap<Integer, ListNode> map;
    private ListNode head;
    private ListNode tail;

    // 构造函数
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new ListNode(-1, -1);
        this.tail = new ListNode(-1, -1);
        tail.prev = head;
        head.next = tail;
    }

    public int get(int key) {

        // 看map是否存在，不存在返回-1
        if (!map.containsKey(key)) {
            return -1;
        }

        // 存在的话，将节点移动到链表头部
        ListNode current = map.get(key);
        removeNode(current);
        moveToHead(current);

        // 返回节点的值
        return current.value;
    }

    public void put(int key, int value) {

        // 如果key已经存在，更新value
        if (get(key) != -1) {
            map.get(key).value = value;
            return;
        }

        // 如果超出容量，删除链表尾部节点
        if (map.size() == capacity) {
            map.remove(tail.prev.key);
            removeNode(tail.prev);
        }

        // 添加新节点到链表头部
        ListNode newNode = new ListNode(key, value);
        moveToHead(newNode);
        map.put(key, newNode);
    }

    private void removeNode(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(ListNode node) {
        node.next = head.next;
        head.next.prev = node;

        head.next = node;
        node.prev = head;
    }
}
