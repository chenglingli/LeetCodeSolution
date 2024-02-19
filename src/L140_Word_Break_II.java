import java.util.*;

public class L140_Word_Break_II {

    /*
     *  回溯搜索算法
     */
    public List<String> wordBreak(String s, List<String> wordDict) {

        List<String> res = new ArrayList<>();

        solveRec(s, 0, new HashSet<>(wordDict), res, new StringBuilder());

        return res;
    }

    private void solveRec(
            String s, int idx, Set<String> wordDict, List<String> res, StringBuilder ans) {

        // 结束条件
        if (idx == s.length()) {
            res.add(ans.toString().trim());
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = idx; i < s.length(); i++) {
            sb.append(s.charAt(i));

            // Backtracking and Recursion
            if (wordDict.contains(sb.toString())) {
                ans.append(sb).append(" "); // --->Forward...
                solveRec(s, i + 1, wordDict, res, ans); // --->Recursion....
                ans.delete(ans.length() - sb.length() - 1, ans.length()); // --->Backward..
            }
        }
    }



    /*
    速度更快做法
     */
    public List<String> wordBreak2(String s, List<String> wordDict) {

        List<String> ans = new ArrayList<>();

        sol(s, wordDict, new StringBuilder(), ans);

        return ans;
    }

    public void sol(String s, List<String> list, StringBuilder curAns, List<String> ans) {

        int n = s.length();

        for (int i = 1; i <= n; i++) {

            String t = s.substring(0, i);

            if (list.contains(t)) {

                if (i == n) {
                    curAns.append(t);
                    ans.add(curAns.toString());
                    return;
                }

                int z = curAns.length();

                curAns.append(t).append(" ");
                sol(s.substring(i), list, curAns, ans);
                curAns.setLength(z);
            }
        }
    }

    public static void main(String[] args) {

        L140_Word_Break_II s = new L140_Word_Break_II();

        long sysDate1 = System.currentTimeMillis();

        String ss = "catsanddog";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cats");
        wordDict.add("dog");
        wordDict.add("sand");
        wordDict.add("and");
        wordDict.add("cat");
        List<String> res = s.wordBreak2(ss, wordDict);

        System.out.println(Collections.unmodifiableList(res));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}