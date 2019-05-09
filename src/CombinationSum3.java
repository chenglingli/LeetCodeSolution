
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {


    List<List<Integer>> res = new ArrayList<>();
    int[] input = {1,2,3,4,5,6,7,8,9};

    public void backTrack(int start, List<Integer> ans, int [] num, int target, int count) {

        if (target < 0 || ans.size() > count) {
            return;
        }
        else if (target == 0 && ans.size() == count) {
            res.add(new ArrayList<>(ans));
        }
        else {
            for (int i = start; i < num.length ; i++) {

                ans.add(num[i]);
                backTrack(i + 1, ans, num, target - num[i], count);
                ans.remove(ans.size() - 1);
            }
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {

        if (k != 0 && n!= 0 ) {
            List<Integer> ans = new ArrayList<>();
            backTrack(0, ans, input, n, k);
        }
        return res;
    }

    public static void main(String[] args) {

        Solution s = new Solution();

        long sysDate1 = System.currentTimeMillis();

        int k = 3;
        int n = 9;
        List<List<Integer>> res = s.combinationSum3(k, n);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}