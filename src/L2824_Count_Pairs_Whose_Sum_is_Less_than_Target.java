import java.util.ArrayList;
import java.util.List;

public class L2824_Count_Pairs_Whose_Sum_is_Less_than_Target {

    public int countPairs(List<Integer> nums, int target) {

        int ans = 0;

        for (int i = 0; i < nums.size(); i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                if (nums.get(i) + nums.get(j) < target) {
                    ans++;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        L2824_Count_Pairs_Whose_Sum_is_Less_than_Target s = new L2824_Count_Pairs_Whose_Sum_is_Less_than_Target();
        long sysDate1 = System.currentTimeMillis();

        List<Integer> nums = new ArrayList<>();
        nums.add(-6);
        // -6,2,5,-2,-7,-1,3
        nums.add(2);
        nums.add(5);
        nums.add(-2);
        nums.add(-7);
        nums.add(-1);
        nums.add(3);

        int target = -2;
        int res = s.countPairs(nums, target);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}