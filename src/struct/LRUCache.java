package struct;

import java.util.HashMap;

public class LRUCache {

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

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new ListNode(-1, -1);
        this.tail = new ListNode(-1, -1);
        tail.prev = head;
        head.next = tail;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        ListNode current = map.get(key);
        removeNode(current);
        moveToHead(current);
        return current.value;
    }

    public void put(int key, int value) {
        if (get(key) != -1) {
            map.get(key).value = value;
            return;
        }

        if (map.size() == capacity) {
            map.remove(tail.prev.key);
            removeNode(tail.prev);
        }

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
