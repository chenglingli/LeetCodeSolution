import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L040_Combination_Sum_II {


    List<List<Integer>> res = new ArrayList<>();

    public void backTrack(int start, List<Integer> ans, int[] num, int target) {

        if (target < 0) {
            return;
        } else if (target == 0) {
            res.add(new ArrayList<>(ans));
        } else {
            for (int i = start; i < num.length; i++) {

                if (i > start && num[i - 1] == num[i]) {
                    continue;
                }

                ans.add(num[i]);
                backTrack(i + 1, ans, num, target - num[i]);
                ans.remove(ans.size() - 1);
            }
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        if (candidates.length != 0) {
            List<Integer> ans = new ArrayList<>();
            backTrack(0, ans, candidates, target);
        }
        return res;
    }

    public static void main(String[] args) {

        L040_Combination_Sum_II s = new L040_Combination_Sum_II();

        long sysDate1 = System.currentTimeMillis();

        int[] input = {10, 1, 2, 7, 6, 1, 5};
        List<List<Integer>> res = s.combinationSum2(input, 8);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}