import java.util.ArrayList;
import java.util.List;

public class L2869_Minimum_Operations_to_Collect_Elements {

    /*
        1 <= nums.length <= 50
        1 <= nums[i] <= nums.length
        1 <= k <= nums.length
        The input is generated such that you can collect elements 1, 2, ..., k.
     */
    public int minOperations(List<Integer> nums, int k) {

        int n = nums.size();
        int[] arr = new int[n + 1];

        int j = 1;
        for (int i = n - 1; i >= 0; i--) {
            int cur = nums.get(i);
            arr[cur] = 1;

            while (arr[j] == 1) {
                if (j >= k) {
                    return n - i;
                }

                j++;
            }
        }

        return n;
    }

    public static void main(String[] args) {

        L2869_Minimum_Operations_to_Collect_Elements s = new L2869_Minimum_Operations_to_Collect_Elements();
        long sysDate1 = System.currentTimeMillis();

        List<Integer> nums = new ArrayList<>();
        nums.add(3);
        nums.add(2);
        nums.add(5);
        nums.add(3);
        nums.add(1);

        int k = 3;
        int res = s.minOperations(nums, k);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}