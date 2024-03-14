import java.util.*;

public class L472_Concatenated_Words {


    /*
    1 <= words.length <= 10^4
    1 <= words[i].length <= 30
    words[i] consists of only lowercase English letters.
    All the strings of words are unique.
    1 <= sum(words[i].length) <= 10^5

    构建字典，然后查找是否能组成，TLE

     */
    public List<String> findAllConcatenatedWordsInADict(String[] words) {

        List<String> res = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            List<String> candidates = preProcess(word, i, words);
            if (candidates.isEmpty()) {
                continue;
            }

            if (isConcatenatedWord(word, i, candidates)) {
                res.add(word);
            }
        }

        return res;
    }

    private List<String> preProcess(String word, int index, String[] words) {
        List<String> candidates = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            if (i == index) {
                continue;
            }

            String x = words[i];
            if (word.contains(x)) {
                candidates.add(x);
            }
        }

        return candidates;
    }

    private boolean isConcatenatedWord(String word, int index, List<String> candidates) {

        for (int i = 0; i < candidates.size(); i++) {
            String x = candidates.get(i);

            if (word.startsWith(x)) {
                if (word.equals(x)) {
                    return true;
                }
                String subWord = word.substring(x.length());
                if (isConcatenatedWord(subWord, index, candidates)) {
                    return true;
                }
            }
        }

        return false;
    }


    /*
    针对1的优化，使用set来存储words，减少contains的时间复杂度
    TLE
     */
    public List<String> findAllConcatenatedWordsInADict2(String[] words) {

        List<String> res = new ArrayList<>();

        Set<String> set = new HashSet<>();
        Collections.addAll(set, words);

        for (String word : words) {
            if (checkConcatenate(word, set)) {
                res.add(word);
            }
        }

        return res;
    }

    private boolean checkConcatenate(String word, Set<String> set) {

        for (int i = 1; i < word.length(); i++) {
            String prefixWord = word.substring(0, i);
            String suffixWord = word.substring(i);

            if (set.contains(prefixWord) && (set.contains(suffixWord) || checkConcatenate(suffixWord, set)))
                return true;
        }
        return false;
    }


    /*
    第三种办法，使用字典树
     */

    // 字典树 树节点
    class TrieNode {
        boolean isLast;
        TrieNode[] child;

        TrieNode() {
            this.isLast = false;
            this.child = new TrieNode[26];
        }
    }

    private TrieNode root;

    // 构建字典树
    private void insert(String word) {

        TrieNode temp = root;

        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (temp.child[idx] == null) {
                temp.child[idx] = new TrieNode();
            }
            temp = temp.child[idx];
        }

        temp.isLast = true;
    }

    private int solve(TrieNode rt, int i, String s) {

        if (i == s.length()) {
            return 0;
        }

        // Iterating over the word to check if the word can be formed
        for (int j = i; j < s.length(); j++) {

            int idx = s.charAt(j) - 'a';
            if (rt.child[idx] == null) {
                return -1;
            }

            // 如果当前单词到底
            if (rt.child[idx].isLast) {

                // 寻找下一个拼凑的单词，从根部查找
                int next = solve(root, j + 1, s);

                // 如果能找到下一个单词，返回单词尾部节点数量
                if (next != -1) {
                    return next + 1;
                }
            }

            rt = rt.child[idx];
        }

        // If no words can be formed
        return -1;
    }

    public List<String> findAllConcatenatedWordsInADict3(String[] words) {

        // 构建字典树
        this.root = new TrieNode();
        for (String word : words) {
            insert(word);
        }

        List<String> ans = new ArrayList<>();

        // 查找
        for (String word : words) {
            int count = solve(root, 0, word);
            // 需要至少两个拼凑构成，所以需要大于1
            if (count > 1) {
                ans.add(word);
            }
        }

        return ans;
    }

    

    /*
    第四种办法，使用字典树，优化
    先按照长度排序，长度最短的肯定不是答案，然后依次插入到字典树中，然后查找是否能拼凑

     */
    private Trie trie = new Trie(); // Root of the trie

    public List<String> findAllConcatenatedWordsInADict4(String[] words) {

        Arrays.sort(words, (a, b) -> a.length() - b.length());
        List<String> result = new ArrayList<>(); // List to store the concatenated words

        for (String word : words) {
            if (isConcatenated(word)) { // If the word is a concatenated word
                result.add(word); // Add it to the result list
            } else {
                trie.insert(word); // Otherwise, insert it into the trie for future checks
            }
        }
        return result;
    }

    private boolean isConcatenated(String word) {

        if (word.isEmpty()) {
            return true;
        }

        Trie node = trie; // Start from the root of the trie
        for (int i = 0; i < word.length(); ++i) { // Go through each character in word
            int index = word.charAt(i) - 'a'; // Get index of the character
            if (node.children[index] == null) { // If there is no path, it's not a concatenated word
                return false;
            }
            node = node.children[index]; // Move to the corresponding child

            // If we reach the end of a word and the remaining substring is a concatenated
            // word
            if (node.isEndOfWord && isConcatenated(word.substring(i + 1))) {
                return true; // The word is a concatenated word
            }
        }
        return false; // The word is not a concatenated word
    }


    class Trie {
        // Trie children nodes
        Trie[] children = new Trie[26];
        // Flag to indicate if a word ends at this node
        boolean isEndOfWord;

        // Insert a word into the trie
        public void insert(String word) {
            Trie node = this; // Start with the root
            for (char c : word.toCharArray()) { // Traverse the word
                int index = c - 'a'; // map character to index (0-25)
                if (node.children[index] == null) { // If the path doesn't exist, create a new node
                    node.children[index] = new Trie();
                }
                node = node.children[index]; // Move to the child node
            }
            node.isEndOfWord = true; // Mark the end of a word
        }
    }


    public static void main(String[] args) {

        L472_Concatenated_Words s = new L472_Concatenated_Words();

        long sysDate1 = System.currentTimeMillis();

        //        String[] words = {
        //                "cat", "cats", "catsdogcats", "dog",
        //                "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat"};

        String[] words = {"lqdqrrcrwdnxeuo",
                "l", "q", "r", "c", "w", "d", "n", "x", "e", "u", "o"};
        List<String> res = s.findAllConcatenatedWordsInADict3(words);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}