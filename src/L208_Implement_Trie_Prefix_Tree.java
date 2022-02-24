import struct.Trie;

public class L208_Implement_Trie_Prefix_Tree {

    public static void main(String[] args) {
        long sysDate1 = System.currentTimeMillis();

        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // return True
        System.out.println(trie.search("app"));     // return False
        trie.startsWith("app"); // return True
        trie.insert("app");
        System.out.println(trie.search("app"));     // return True

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}