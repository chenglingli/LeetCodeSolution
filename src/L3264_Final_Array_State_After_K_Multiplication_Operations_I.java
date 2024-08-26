import java.util.Arrays;

public class L3264_Final_Array_State_After_K_Multiplication_Operations_I {

    /*
        You need to perform k operations on nums. In each operation:

        Find the minimum value x in nums.
            If there are multiple occurrences of the minimum value,
            select the one that appears first.
        Replace the selected minimum value x with x * multiplier.
        Return an integer array denoting the final state of nums after performing all k operations.

        Example 1:[2,1,3,5,6], k = 5, multiplier = 2
        After operation 1	[2, 2, 3, 5, 6]
        After operation 2	[4, 2, 3, 5, 6]
        After operation 3	[4, 4, 3, 5, 6]
        After operation 4	[4, 4, 6, 5, 6]
        After operation 5	[8, 4, 6, 5, 6]

        1 <= nums.length <= 100
        1 <= nums[i] <= 100
        1 <= k <= 10
        1 <= multiplier <= 5
     */
    public int[] getFinalState(int[] nums, int k, int multiplier) {

        int len = nums.length;

        for (int i = 0; i < k; i++) {

            int min = nums[0];
            int index = 0;
            for (int j = 1; j < len; j++) {
                if (nums[j] < min) {
                    min = nums[j];
                    index = j;
                }
            }
            nums[index] *= multiplier;
        }

        return nums;
    }

    public static void main(String[] args) {

        L3264_Final_Array_State_After_K_Multiplication_Operations_I s = new L3264_Final_Array_State_After_K_Multiplication_Operations_I();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {2, 1, 3, 5, 6};
        int k = 5;
        int multiplier = 2;

        int[] res = s.getFinalState(nums, k, multiplier);
        System.out.println(Arrays.toString(res));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}