import java.util.Arrays;

public class L561_Array_Partition {

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }

    public int arrayPairSum2(int[] nums) {

        final int K = 10000;

        int[] elementToCount = new int[2 * K + 1];
        for (int element : nums) {
            elementToCount[element + K]++;
        }

        int maxSum = 0;
        boolean isEvenIndex = true;
        for (int element = 0; element <= 2 * K; element++) {
            while (elementToCount[element] > 0) {
                maxSum += (isEvenIndex ? element - K : 0);
                isEvenIndex = !isEvenIndex;
                elementToCount[element]--;
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {

        L561_Array_Partition s = new L561_Array_Partition();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {1, 1, 2, 4, 1, 3};
        int res = s.arrayPairSum2(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}