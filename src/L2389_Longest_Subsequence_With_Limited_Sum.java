import java.util.Arrays;

public class L2389_Longest_Subsequence_With_Limited_Sum {

    public int[] answerQueries(int[] nums, int[] queries) {

        Arrays.sort(nums);
        int[] sum = new int[nums.length];

        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            ans[i] = findKey(sum, queries[i]);
        }

        return ans;
    }

    private int findKey(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (array[middle] < key) {
                left = middle + 1;
            } else if (array[middle] > key) {
                right = middle - 1;
            } else {
                return middle + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {

        L2389_Longest_Subsequence_With_Limited_Sum s =
                new L2389_Longest_Subsequence_With_Limited_Sum();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {4, 5, 2, 1};
        int[] queries = {3, 10, 21};
        int[] res = s.answerQueries(nums, queries);
        System.out.println(Arrays.toString(res));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}