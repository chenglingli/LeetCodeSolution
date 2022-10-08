import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L039_Combination_Sum {


    List<List<Integer>> res = new ArrayList<>();

    public void backTrack(int start, List<Integer> ans, int[] num, int target) {

        if (target < 0) {
            return;
        } else if (target == 0) {
            res.add(new ArrayList<>(ans));
        } else {
            for (int i = start; i < num.length; i++) {

                ans.add(num[i]);
                backTrack(i, ans, num, target - num[i]);
                ans.remove(ans.size() - 1);
            }
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        if (candidates.length != 0) {
            List<Integer> ans = new ArrayList<>();
            backTrack(0, ans, candidates, target);
        }
        return res;
    }

    public static void main(String[] args) {

        L039_Combination_Sum s = new L039_Combination_Sum();

        long sysDate1 = System.currentTimeMillis();

        int[] input = {1, 2, 3, 4};
        List<List<Integer>> res = s.combinationSum(input, 8);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}