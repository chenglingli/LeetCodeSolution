
import java.util.ArrayList;
import java.util.List;

public class Permutations {


    List<List<Integer>> res = new ArrayList<>();

    public void backTrack(List<Integer> ans, int [] num) {
        if (ans.size() == num.length) {
            res.add(new ArrayList<>(ans));
        }
        else {
            for (int i = 0; i < num.length ; i++) {
                if (ans.contains(num[i])) {
                    continue;
                }
                ans.add(num[i]);
                backTrack(ans, num);
                ans.remove(ans.size() - 1);
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length != 0) {
            List<Integer> ans = new ArrayList<>();
            backTrack(ans, nums);
        }
        return res;
    }


    public static void main(String[] args) {

        Permutations s = new Permutations();

        long sysDate1 = System.currentTimeMillis();

        int[] input = {1, 2, 3};
        List<List<Integer>> res = s.permute(input);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}