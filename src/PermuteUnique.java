import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermuteUnique {


    List<List<Integer>> res = new ArrayList<>();

    public void backTrack(List<Integer> ans, int[] num, boolean[] used) {
        if (ans.size() == num.length) {
            res.add(new ArrayList<>(ans));
        } else {
            for (int i = 0; i < num.length; i++) {

                if (used[i] ||
                        i > 0 && num[i] == num[i - 1] && !used[i - 1]) {
                    continue;
                }

                used[i] = true;
                ans.add(num[i]);

                backTrack(ans, num, used);

                ans.remove(ans.size() - 1);
                used[i] = false;
            }
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {

        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        if (nums.length != 0) {
            List<Integer> ans = new ArrayList<>();
            backTrack(ans, nums, used);
        }
        return res;
    }


    public static void main(String[] args) {

        PermuteUnique s = new PermuteUnique();

        long sysDate1 = System.currentTimeMillis();

        int[] input = {1, 1, 3};
        List<List<Integer>> res = s.permuteUnique(input);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}