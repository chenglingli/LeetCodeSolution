import java.util.*;

public class L127_Word_Ladder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if (beginWord.equals(endWord)) {
            return 1;
        }

        Set<String> set = new HashSet<>(wordList);
        Queue<String> q = new LinkedList<>();
        int len = 2;

        q.offer(beginWord);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                for (int j = 0; j < cur.length(); j++) {
                    StringBuilder sb = new StringBuilder(cur);

                    for (char c = 'a'; c <= 'z'; c++) {
                        sb.setCharAt(j, c);
                        String tmp = sb.toString();
                        if (set.contains(tmp)) {
                            if (tmp.equals(endWord)) {
                                return len;
                            }

                            q.offer(tmp);
                            set.remove(tmp);
                        }
                    }
                }
            }
            len++;
        }
        return 0;
    }



    public static void main(String[] args) {

        L127_Word_Ladder s = new L127_Word_Ladder();

        long sysDate1 = System.currentTimeMillis();

        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        int x = s.ladderLength(beginWord, endWord, wordList);

        System.out.println(x);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}