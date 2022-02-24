package struct;

public class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;

        // 按照节点去塞入单词
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (!node.containsKey(currentChar)) {
                node.put(currentChar, new TrieNode());
            }
            node = node.get(currentChar);
        }

        // 设置单词结束
        node.setEnd();
    }

    public boolean search(String word) {
        TrieNode node = root;

        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (!node.containsKey(currentChar)) {
                return false;
            }

            node = node.get(currentChar);
            if (node == null) {
                return false;
            }
        }

        return node.isEnd();
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;

        for (int i = 0; i < prefix.length(); i++) {
            char currentChar = prefix.charAt(i);
            if (!node.containsKey(currentChar)) {
                return false;
            }

            node = node.get(currentChar);
            if (node == null) {
                return false;
            }
        }

        return true;
    }

}
