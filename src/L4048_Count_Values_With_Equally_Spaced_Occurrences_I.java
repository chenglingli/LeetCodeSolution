import java.util.HashSet;
import java.util.Set;

public class L4048_Count_Values_With_Equally_Spaced_Occurrences_I {

    /*
    You are given an integer array nums.

    An integer x is called special if:

    x appears exactly three times in nums.
    All three occurrences of x are equally spaced in nums. In other words, if all occurrences of x are at indices i1 < i2 < i3, then i2 - i1 = i3 - i2.
    Return the number of distinct special integers in nums.



    Example 1:

    Input: nums = [1,8,1,5,1,5,8,5]

    Output: 2

    Explanation:

    1 is special because it occurs exactly three times at equally spaced indices 0, 2, and 4.
    5 is special because it occurs exactly three times at equally spaced indices 3, 5, and 7.
    8 is not special because it occurs only twice.
    Therefore, the answer is 2.

    Example 2:

    Input: nums = [8,8,8,8]

    Output: 0

    Explanation:

    8 is not special because it does not occur exactly three times. Therefore, the answer is 0.

    Example 3:

    Input: nums = [8,6,6,8,8]

    Output: 0

    Explanation:

    8 occurs at indices 0, 3, and 4, which are not equally spaced. 6 occurs only twice. Therefore, no integer is special.



    Constraints:

    3 <= nums.length <= 100
    1 <= nums[i] <= 100

     */
    public int countSpecialIntegers(int[] nums) {
        /*
        寻找特殊数字
        一个数组A记录每个数字出现的第一个位置
        一个数组B记录每个数组出现的次数
        一个set C记录答案集合

        遍历数组，
        如果数字没出现过，则设置A中的值和B中的值
        如果数字出现过，
            先更新B中的值。
            看是否在C中，如果在，则更新B中的值，且从C中去掉
            如果不在C中，则看下个位置是否为C，如果是，则加入C中。

         */

        // 答案集合
        Set<Integer> C = new HashSet<>();

        // 记录每个数字出现的第一个位置
        int[] A = new int[101];

        // 记录每个数字出现的次数
        int[] B = new int[101];

        for (int i = 0; i < nums.length; i++) {
            if (A[nums[i]] == 0) {
                // 没出现过，设置第一个位置和次数为1
                A[nums[i]] = i + 1;
                B[nums[i]] = 1;
            } else {
                // 出现过，先更新次数
                B[nums[i]]++;

                // 如果次数为3，则直接跳过
                if (B[nums[i]] == 3) {
                    continue;
                }

                // 如果次数大于3，则从C中去掉
                if (B[nums[i]] > 3) {
                    C.remove(A[nums[i]]);
                    continue;
                }

                // 判断是否在C中，如果在，则更新次数，且从C中去掉
                if (C.contains(A[nums[i]])) {
                    C.remove(A[nums[i]]);
                } else {
                    int nextIndex = i + (i + 1 - A[nums[i]]);
                    if (nextIndex < nums.length && nums[nextIndex] == nums[i]) {
                        C.add(A[nums[i]]);
                    }
                }
            }
        }

        return C.size();
    }

    public int countSpecialIntegers3(int[] nums) {

        // 答案集合
        Set<Integer> C = new HashSet<>();

        // 记录每个数字出现的第一个位置
        int[] A = new int[101];

        // 记录每个数字出现的次数
        int[] B = new int[101];

        for (int num : nums) {
            B[num]++;
        }

        for (int i = 0; i < nums.length; i++) {

            int cur = nums[i];
            if (B[cur] != 3) {
                continue;
            }

            if (A[cur] == 0) {
                A[cur] = i + 1;
            }
            else {
                int nextIndex = i + (i + 1 - A[cur]);
                if (nextIndex < nums.length && nums[nextIndex] == cur) {
                    C.add(A[cur]);
                }
            }
        }

        return C.size();
    }

    public int countSpecialIntegers2(int[] nums) {

        // Intuition: go left to right, skip values that don't occur exactly 3 times
        // then check for an equally spaced triple with increasing distance

        int n = nums.length;
        int r = 0;

        int[] freq = new int[100];
        for (int c : nums) {
            freq[c - 1]++;
        }

        for (int i = 0; i < n; i++) {
            int c = nums[i];
            if (freq[c - 1] != 3) continue;

            freq[c - 1] = -1;
            for (int distance = 1; i + (distance * 2) < n; distance++) {
                if (nums[i + distance] == c && nums[i + (distance * 2)] == c) {
                    r++;
                    break;
                }
            }
        }

        return r;
    }

    public static void main(String[] args) {

        L4048_Count_Values_With_Equally_Spaced_Occurrences_I s = new L4048_Count_Values_With_Equally_Spaced_Occurrences_I();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {1, 8, 1, 5, 1, 5, 8, 5};

        int res = s.countSpecialIntegers3(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}