import java.util.ArrayList;
import java.util.List;

public class Subsets {


    public void backtracking(List<List<Integer>> ret, List<Integer> list, int[] nums, int position) {
        ret.add(new ArrayList<>(list));  //每次递归将其加入结果集
        for (int i = position; i < nums.length; i++) {
            list.add(nums[i]);
            backtracking(ret, list, nums, i + 1); //从当前位置的下一位置开始选择
            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        if (nums.length > 0) {
            backtracking(ret, new ArrayList<>(), nums, 0);
        }
        return ret;
    }

    public static void main(String[] args) {

        Subsets s = new Subsets();

        long sysDate1 = System.currentTimeMillis();

        int[] nums = {1, 2, 3};
        List<List<Integer>> res = s.subsets(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}