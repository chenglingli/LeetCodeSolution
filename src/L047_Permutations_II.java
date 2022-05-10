import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L047_Permutations_II {

    public void backTrack(List<List<Integer>> res, List<Integer> tmp, int[] num, int target, boolean[] used) {

        if (tmp.size() == target) {
            res.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = 0; i < num.length; i++) {

            if (used[i]) {
                continue;
            }

            if (i > 0 && num[i] == num[i - 1] && !used[i - 1]) {
                continue;
            }

            used[i] = true;
            tmp.add(num[i]);

            backTrack(res, tmp, num, target, used);

            tmp.remove(tmp.size() - 1);
            used[i] = false;
        }

    }

    public List<List<Integer>> permuteUnique(int[] nums) {

        // 参数判断
        int target = nums.length;
        if (target == 0) {
            return new ArrayList<>();
        }

        // 返回结果
        List<List<Integer>> res = new ArrayList<>();

        // 排序
        Arrays.sort(nums);

        // 回溯
        boolean[] used = new boolean[target];
        backTrack(res, new ArrayList<>(), nums, target, used);

        // 返回结果
        return res;
    }


    public static void main(String[] args) {

        L047_Permutations_II s = new L047_Permutations_II();

        long sysDate1 = System.currentTimeMillis();

        int[] input = {1, 1, 3};
        List<List<Integer>> res = s.permuteUnique(input);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}