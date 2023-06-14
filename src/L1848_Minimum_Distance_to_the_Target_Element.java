import java.util.ArrayList;
import java.util.List;

public class L1848_Minimum_Distance_to_the_Target_Element {

    /*
    1 <= nums.length <= 1000
    1 <= nums[i] <= 10^4
    0 <= start < nums.length
    target is in nums
     */
    public int getMinDistance(int[] nums, int target, int start) {

        List<Integer> candidateList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                if (i == start) {
                    return 0;
                }
                candidateList.add(i);
            }
        }

        int ans = Integer.MAX_VALUE;
        for (Integer cur : candidateList) {
            if (Math.abs(cur - start) < ans) {
                ans = Math.abs(cur - start);
            }
        }

        return ans;
    }

    public int getMinDistance2(int[] nums, int target, int start) {
        int min = 1000;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == target) {
                min = Math.min(min, Math.abs(i - start));
            }
        }

        return min;
    }

    public static void main(String[] args) {

        L1848_Minimum_Distance_to_the_Target_Element s = new L1848_Minimum_Distance_to_the_Target_Element();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {1, 2, 3, 4, 5};
        int target = 5;
        int start = 3;
        int res = s.getMinDistance(nums, target, start);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}