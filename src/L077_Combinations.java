import java.util.ArrayList;
import java.util.List;

public class L077_Combinations {

    public List<List<Integer>> combine(int n, int k) {

        if (n < k) return new ArrayList();

        List<List<Integer>> res = new ArrayList<>();
        backTrack(n, 1, new ArrayList<>(), k, res);

        return res;
    }


    public void backTrack(int n, int start, List<Integer> ans, int k, List<List<Integer>> res) {

        if (k == 0) {
            res.add(new ArrayList<>(ans));
        } else {
            for (int i = start; i <= n - k + 1; i++) {
                ans.add(i);
                backTrack(n, i + 1, ans, k - 1, res);
                ans.remove(ans.size() - 1);
            }
        }
    }

    public List<List<Integer>> combine2(int n, int k) {
        if (n < k) {
            return new ArrayList();
        }

        List<Integer> candidate = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            candidate.add(i);
        }

        List<List<Integer>> res = new ArrayList<>();
        backTrack2(candidate, 0, new ArrayList<>(), k, res);

        return res;
    }

    public void backTrack2(
            List<Integer> candidate, int start, List<Integer> tmp, int k, List<List<Integer>> res) {
        if (tmp.size() == k) {
            res.add(new ArrayList<>(tmp));
        } else {
            for (int i = start; i < candidate.size(); i++) {
                tmp.add(candidate.get(i));
                backTrack2(candidate, i + 1, tmp, k, res);
                tmp.remove(tmp.size() - 1);
            }
        }
    }


    public static void main(String[] args) {

        L077_Combinations s = new L077_Combinations();

        long sysDate1 = System.currentTimeMillis();

        List<List<Integer>> res = s.combine2(4, 2);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}