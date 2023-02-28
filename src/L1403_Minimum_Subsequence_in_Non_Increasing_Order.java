import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class L1403_Minimum_Subsequence_in_Non_Increasing_Order {

    /*

    1 <= nums.length <= 500
    1 <= nums[i] <= 100

     */
    public List<Integer> minSubsequence(int[] nums) {

        Arrays.sort(nums);
        int n = nums.length;
        int[] tempSum = new int[n];

        tempSum[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            tempSum[i] = tempSum[i + 1] + nums[i];
        }
        int sum = tempSum[0];

        List<Integer> res = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            res.add(nums[i]);
            if (tempSum[i] > sum - tempSum[i]) {
                break;
            }
        }

        return res;
    }

    public List<Integer> minSubsequence2(int[] nums) {

        int[] countNums = new int[101];
        int sum = 0;

        for (int n : nums) {
            sum += n;
            countNums[n]++;
        }

        int tempSum = 0;
        List<Integer> res = new ArrayList<>();

        for (int i = countNums.length - 1; i >= 0; i--) {

            while (countNums[i] > 0) {

                tempSum += i;
                res.add(i);
                countNums[i]--;

                if (tempSum > (sum - tempSum))
                    return res;
            }
        }

        return res;
    }

    public static void main(String[] args) {

        L1403_Minimum_Subsequence_in_Non_Increasing_Order s = new L1403_Minimum_Subsequence_in_Non_Increasing_Order();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {4, 3, 10, 9, 8};

        List<Integer> res = s.minSubsequence(nums);
        System.out.println(Collections.unmodifiableList(res));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}