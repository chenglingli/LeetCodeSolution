import java.util.Arrays;

public class L2966_Divide_Array_Into_Arrays_With_Max_Difference {

    /*
    You are given an integer array nums of size n where n is a multiple of 3 and a positive integer k.

    Divide the array nums into n / 3 arrays of size 3 satisfying the following condition:

    The difference between any two elements in one array is less than or equal to k.
    Return a 2D array containing the arrays. If it is impossible to satisfy the conditions,
        return an empty array. And if there are multiple answers, return any of them.


    Example 1:
    Input: nums = [1,3,4,8,7,9,3,5,1], k = 2

    Output: [[1,1,3],[3,4,5],[7,8,9]]

    Explanation:

    The difference between any two elements in each array is less than or equal to 2.

    Example 2:
    Input: nums = [2,4,2,2,5,2], k = 2

    Output: []

    Explanation:

    Different ways to divide nums into 2 arrays of size 3 are:

    [[2,2,2],[2,4,5]] (and its permutations)
    [[2,2,4],[2,2,5]] (and its permutations)
    Because there are four 2s there will be an array with the elements 2 and 5 no matter how we divide it.
        since 5 - 2 = 3 > k, the condition is not satisfied and so there is no valid division.


    Example 3:
    Input: nums = [4,2,9,8,2,12,7,12,10,5,8,5,5,7,9,2,5,11], k = 14

    Output: [[2,2,2],[4,5,5],[5,5,7],[7,8,8],[9,9,10],[11,12,12]]

    Explanation:
    The difference between any two elements in each array is less than or equal to 14.


    Constraints:
    n == nums.length
    1 <= n <= 10^5
    n is a multiple of 3
    1 <= nums[i] <= 10^5
    1 <= k <= 10^5
     */

    public int[][] divideArray(int[] nums, int k) {

        Arrays.sort(nums);
        int n = nums.length;

        int[][] res = new int[n / 3][];
        int i = 0;

        while (i * 3 < n) {
            int[] arr = new int[3];
            int j = i * 3;
            arr[0] = nums[j++];
            arr[1] = nums[j++];
            arr[2] = nums[j++];

            if (arr[2] - arr[0] > k) {
                return new int[0][];
            }

            res[i] = arr;
            i++;
        }

        return res;
    }

    public int[][] divideArray2(int[] nums, int k) {
        int n = nums.length;
        int n3 = n / 3;
        int[][] ans = new int[n3][3];

        int[] freq = new int[100001];
        for (int v : nums) {
            freq[v]++;
        }

        int idx = 0;
        for (int i = 0; i < n3; i++) {
            int[] arr = new int[3];
            for (int j = 0; j < 3; j++) {
                while (freq[idx] == 0) {
                    idx++;
                }

                arr[j] = idx;
                freq[idx]--;
            }

            if (arr[2] - arr[0] > k) {
                return new int[0][0];
            }

            ans[i] = arr;
        }

        return ans;
    }



    // 寻找最大值
    int max(int[] nums) {
        int out = nums[0];
        for (int num : nums) {
            if (num > out) {
                out = num;
            }
        }
        return out;
    }

    // 桶排序
    int[] bucket_sort(int[] nums) {

        int[] count = new int[max(nums) + 1];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }

        int pos = 0;
        int[] out = new int[nums.length];
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                out[pos] = i;
                pos++;
            }
        }

        return out;
    }

    public int[][] divideArray3(int[] nums, int k) {

        nums = bucket_sort(nums);

        int[][] out = new int[nums.length / 3][3];
        for (int i = 0; i < nums.length / 3; i++) {
            for (int j = 0; j < 3; j++) {
                out[i][j] = nums[j + 3 * i];
            }
            if (out[i][2] - out[i][0] > k) {
                return new int[0][0];
            }
        }

        return out;
    }

    public static void main(String[] args) {

        L2966_Divide_Array_Into_Arrays_With_Max_Difference s = new L2966_Divide_Array_Into_Arrays_With_Max_Difference();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {1, 3, 4, 8, 7, 9, 3, 5, 1};
        int k = 2;

        int[][] res = s.divideArray3(nums, k);
        System.out.println(Arrays.toString(res));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}