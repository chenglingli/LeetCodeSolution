

/*

    Design a HashMap without using any built-in hash table libraries.

    Implement the MyHashMap class:

    MyHashMap() initializes the object with an empty map.
    void put(int key, int value) inserts a (key, value) pair into the HashMap. If the key already exists in the map,
        update the corresponding value.
    int get(int key) returns the value to which the specified key is mapped,
        or -1 if this map contains no mapping for the key.
    void remove(key) removes the key and its corresponding value if the map contains the mapping for the key.


    Example 1:

    Input
    ["MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"]
    [[], [1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]]
    Output
    [null, null, null, 1, -1, null, 1, null, -1]

    Explanation
    MyHashMap myHashMap = new MyHashMap();
    myHashMap.put(1, 1); // The map is now [[1,1]]
    myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
    myHashMap.get(1);    // return 1, The map is now [[1,1], [2,2]]
    myHashMap.get(3);    // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
    myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
    myHashMap.get(2);    // return 1, The map is now [[1,1], [2,1]]
    myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
    myHashMap.get(2);    // return -1 (i.e., not found), The map is now [[1,1]]


    Constraints:

    0 <= key, value <= 10^6
    At most 10^4 calls will be made to put, get, and remove.

 */

import java.util.Arrays;

class MyHashMap {

    int[] arr = new int[1000001];

    public MyHashMap() {
        // 初始化数组为-1，表示不存在映射关系（或者说key不存在
        Arrays.fill(arr, -1);
    }

    public void put(int key, int value) {
        arr[key] = value; // arr[1000000
    }

    public int get(int key) {
        return arr[key];
    }

    public void remove(int key) {
        arr[key] = -1;
    }
}

/*

    在大多数情况下，MyHashMap2在效率查询上应该与MyHashMap相当或更优，但这取决于具体的实现细节和查询操作的分布情况。


    MyHashMap 的效率
    优点：MyHashMap通过直接访问数组元素来获取值，时间复杂度为 O(1)。
    当键的分布非常均匀且大部分键都存在时，这是非常高效的 ！！！！

    缺点：然而，当键的分布不均匀或存在大量未使用的键时，MyHashMap会浪费大量内存。此外，如果键超出了数组的范围，它将无法处理。


    MyHashMap2 的效率
    哈希函数：MyHashMap2使用了一个简单的哈希函数（取模运算）来将键映射到存储桶的索引上。这种哈希函数在键的分布较为均匀时表现良好，
        但在最坏情况下（所有键都哈希到同一个存储桶）会导致性能下降。

    链表处理：在存储桶内部，MyHashMap2使用链表来处理哈希冲突。这意味着在查询时，可能需要遍历链表来找到正确的节点。
    然而，在哈希函数设计良好且键的分布较为均匀的情况下，链表的长度通常会很短，因此遍历的开销可以忽略不计。

    优点：MyHashMap2能够处理任意大小的键，并且内存使用更加灵活，不会因为键的分布不均匀而浪费大量内存。
    此外，它还可以处理键的删除操作，而不会像MyHashMap那样留下“空洞”。

    缺点：在最坏情况下（哈希冲突严重），查询性能可能会下降。但是，通过选择一个合适的哈希函数和存储桶大小，可以最大限度地减少这种情况的发生。


    为什么 MyHashMap2 可能在效率查询上更高
    内存使用效率：MyHashMap2的内存使用更加灵活，不会浪费大量内存来存储不存在的键。这在处理大量稀疏数据时尤为重要。

    处理哈希冲突：虽然MyHashMap2在查询时可能需要遍历链表，但在哈希函数设计良好且键的分布较为均匀的情况下，链表的长度通常会很短。
    此外，链表结构允许动态调整大小，以适应不同的查询负载。

    删除操作：MyHashMap2能够高效地处理键的删除操作，而不会留下“空洞”，这有助于保持哈希表的紧凑性和查询效率。

    综上所述，虽然MyHashMap在直接访问数组元素时具有 O(1) 的时间复杂度，但在实际应用中，
        MyHashMap2通过灵活的内存使用和有效的哈希冲突处理机制，往往能够在查询效率上表现得更优或至少相当。
        当然，这取决于具体的实现细节和查询操作的分布情况。

 */
class MyHashMap2 {

    class Node {
        int key;
        int val;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    Node[] storage;
    Node root;

    public MyHashMap2() {
        this.storage = new Node[10000];

    }

    private int hash1(int key) {
        return key % 10000;
    }

    public void put(int key, int value) {

        int bucket = hash1(key);
        if (storage[bucket] == null) {
            storage[bucket] = new Node(-1, -1);
        }

        Node prevNode = findPrev(key, storage[bucket]);
        if (prevNode.next == null) {
            prevNode.next = new Node(key, value);
        } else {
            prevNode.next.val = value;
        }
    }

    private Node findPrev(int key, Node curr) {
        // Node curr = root;
        Node prev = null;
        while (curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    public int get(int key) {
        int bucket = hash1(key);
        if (storage[bucket] == null) {
            return -1;
        }

        Node curr = storage[bucket];
        while (curr != null && curr.key != key) {
            curr = curr.next;
        }

        return curr != null ? curr.val : -1;
    }

    public void remove(int key) {
        int bucket = hash1(key);
        if (storage[bucket] == null) {
            return;
        }

        Node prevNode = findPrev(key, storage[bucket]);
        if (prevNode.next != null) {
            prevNode.next = prevNode.next.next;
        }
    }
}

public class L706_Design_HashMap {


    public static void main(String[] args) {

        MyHashMap s = new MyHashMap();
        long sysDate1 = System.currentTimeMillis();

        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(1, 1); // The map is now [[1,1]]
        myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
        System.out.println(myHashMap.get(1));    // return 1, The map is now [[1,1], [2,2]]
        System.out.println(myHashMap.get(3));    // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
        myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
        System.out.println(myHashMap.get(2));    // return 1, The map is now [[1,1], [2,1]]
        myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
        System.out.println(myHashMap.get(2));    // return -1 (i.e., not found), The map is now [[1,1]]

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}