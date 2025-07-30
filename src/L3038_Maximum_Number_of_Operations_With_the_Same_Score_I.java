import java.util.PriorityQueue;

public class L3038_Maximum_Number_of_Operations_With_the_Same_Score_I {

    /*

   You are given an array of integers nums. Consider the following operation:

    Delete the first two elements nums and define the score of the operation as the sum of these two elements.
    You can perform this operation until nums contains fewer than two elements.
    Additionally, the same score must be achieved in all operations.

    Return the maximum number of operations you can perform.



    Example 1:
    Input: nums = [3,2,1,4,5]

    Output: 2

    Explanation:

    We can perform the first operation with the score 3 + 2 = 5. After this operation, nums = [1,4,5].
    We can perform the second operation as its score is 4 + 1 = 5, the same as the previous operation.
    After this operation, nums = [5].
    As there are fewer than two elements, we can't perform more operations.

    Example 2:
    Input: nums = [1,5,3,3,4,1,3,2,2,3]

    Output: 2

    Explanation:

    We can perform the first operation with the score 1 + 5 = 6. After this operation, nums = [3,3,4,1,3,2,2,3].
    We can perform the second operation as its score is 3 + 3 = 6, the same as the previous operation. After this operation, nums = [4,1,3,2,2,3].
    We cannot perform the next operation as its score is 4 + 1 = 5, which is different from the previous scores.
    Example 3:

    Input: nums = [5,3]

    Output: 1



    Constraints:

    2 <= nums.length <= 100
    1 <= nums[i] <= 1000
     */
    public int maxOperations(int[] nums) {

        int res = 0;
        int sum = nums[0] + nums[1];
        int i = 0;

        while (i < nums.length - 1) {
            if (nums[i] + nums[i + 1] == sum) {
                res++;
            } else {
                break;
            }
            i += 2;
        }

        return res;
    }

    public static void main(String[] args) {

        L3038_Maximum_Number_of_Operations_With_the_Same_Score_I s = new L3038_Maximum_Number_of_Operations_With_the_Same_Score_I();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {1, 5, 3, 3, 4, 1, 3, 2, 2, 3};
        int res = s.maxOperations(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}