import java.util.ArrayList;
import java.util.List;

public class L046_Permutations {

    public void backTrack(List<List<Integer>> res, List<Integer> tmp, int[] num, int target) {

        if (tmp.size() == target) {
            res.add(new ArrayList<>(tmp));
            return;
        }

        for (int value : num) {

            if (tmp.contains(value)) {
                continue;
            }

            tmp.add(value);
            backTrack(res, tmp, num, target);
            tmp.remove(tmp.size() - 1);
        }

    }

    public List<List<Integer>> permute(int[] nums) {

        int target = nums.length;
        if (target == 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();

        backTrack(res, tmp, nums, target);

        return res;
    }


    public static void main(String[] args) {

        L046_Permutations s = new L046_Permutations();

        long sysDate1 = System.currentTimeMillis();

        int[] input = {1, 2, 3};
        List<List<Integer>> res = s.permute(input);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}