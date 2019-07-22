import java.util.*;

public class L126_Word_Ladder_II {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        HashSet<String> dict = new HashSet<>(wordList);
        HashMap<String, Integer> distance = new HashMap<>();
        HashMap<String, List<String>> adj = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        List<String> path = new ArrayList<>();
        dict.add(beginWord);

        bfs(beginWord, endWord, dict, adj, distance);
        path.add(beginWord);

        dfs(beginWord, endWord, result, path, dict, adj, distance);
        return result;
    }

    public List<String> getNeighbor(String word, HashSet<String> dict) {
        List<String> result = new ArrayList<>();
        char[] arr = word.toCharArray();
        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == c) {
                    continue;
                }
                char ch = arr[i];
                arr[i] = c;
                if (dict.contains(String.valueOf(arr))) {
                    result.add(String.valueOf(arr));
                }
                arr[i] = ch;
            }
        }
        return result;
    }


    public void bfs(String start,
                    String end,
                    HashSet<String> dict,
                    HashMap<String, List<String>> adj,
                    HashMap<String, Integer> distance) {

        for (String word : dict) {
            adj.put(word, new ArrayList<String>());
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        distance.put(start, 0);
        while (!queue.isEmpty()) {
            String curr = queue.poll();
            int level = distance.get(curr);
            List<String> neighbor = getNeighbor(curr, dict);
            for (String nei : neighbor) {
                adj.get(curr).add(nei);
                if (!distance.containsKey(nei)) {
                    distance.put(nei, level + 1);
                    if (!end.equals(nei)) {
                        queue.offer(nei);
                    }
                }
            }
        }
    }

    public void dfs(String curr,
                    String end,
                    List<List<String>> result,
                    List<String> path,
                    HashSet<String> dict,
                    HashMap<String, List<String>> adj,
                    HashMap<String, Integer> distance) {

        if (curr.equals(end)) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (String nei : adj.get(curr)) {
            path.add(nei);
            if (distance.containsKey(nei) && distance.get(nei) == distance.get(curr) + 1) {
                dfs(nei, end, result, path, dict, adj, distance);
            }
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {

        L126_Word_Ladder_II s = new L126_Word_Ladder_II();

        long sysDate1 = System.currentTimeMillis();

        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        List<List<String>> x = s.findLadders(beginWord, endWord, wordList);

        System.out.println(x);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}