import java.util.ArrayList;
import java.util.List;

public class L448_Find_All_Numbers_Disappeared_in_an_Array {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;

        int[] mark = new int[n + 1];
        for (int i = 0; i < nums.length; i++) {
            mark[nums[i]] = 1;
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (mark[i] != 1) {
                res.add(i);
            }
        }

        return res;
    }

    public static void main(String[] args) {

        L448_Find_All_Numbers_Disappeared_in_an_Array s = new L448_Find_All_Numbers_Disappeared_in_an_Array();

        long sysDate1 = System.currentTimeMillis();
        int[] nums = {1, 1};
        List<Integer> res = s.findDisappearedNumbers(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}