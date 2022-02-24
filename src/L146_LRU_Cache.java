import struct.LRUCache;

public class L146_LRU_Cache {

    public static void main(String[] args) {

        long sysDate1 = System.currentTimeMillis();

        int capacity = 3;
        LRUCache obj = new LRUCache(capacity);
        int param_1 = obj.get(1);
        obj.put(1, 2);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}