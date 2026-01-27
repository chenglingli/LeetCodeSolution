import java.util.*;

public class L3740_Minimum_Distance_Between_Three_Equal_Elements_I {

    /*
    You are given an integer array nums.

    A tuple (i, j, k) of 3 distinct indices is good if nums[i] == nums[j] == nums[k].

    The distance of a good tuple is abs(i - j) + abs(j - k) + abs(k - i), where abs(x) denotes the absolute value of x.

    Return an integer denoting the minimum possible distance of a good tuple. If no good tuples exist, return -1.



    Example 1:

    Input: nums = [1,2,1,1,3]

    Output: 6

    Explanation:

    The minimum distance is achieved by the good tuple (0, 2, 3).

    (0, 2, 3) is a good tuple because nums[0] == nums[2] == nums[3] == 1. Its distance is abs(0 - 2) + abs(2 - 3) + abs(3 - 0) = 2 + 1 + 3 = 6.

    Example 2:

    Input: nums = [1,1,2,3,2,1,2]

    Output: 8

    Explanation:

    The minimum distance is achieved by the good tuple (2, 4, 6).

    (2, 4, 6) is a good tuple because nums[2] == nums[4] == nums[6] == 2. Its distance is abs(2 - 4) + abs(4 - 6) + abs(6 - 2) = 2 + 2 + 4 = 8.

    Example 3:

    Input: nums = [1]

    Output: -1

    Explanation:

    There are no good tuples. Therefore, the answer is -1.



    Constraints:

    1 <= n == nums.length <= 100
    1 <= nums[i] <= n

     */
    public int minimumDistance(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }

        int res = Integer.MAX_VALUE;
        for (List<Integer> list : map.values()) {
            if (list.size() >= 3) {
                Collections.sort(list);

                int temp = Integer.MAX_VALUE;
                for (int i = 0; i < list.size() - 2; i++) {
                    temp = Math.min(temp,
                            Math.abs(list.get(i + 2) - list.get(i))
                                    + Math.abs(list.get(i + 1) - list.get(i + 2))
                                    + Math.abs(list.get(i + 1) - list.get(i))
                    );
                }

                res = Math.min(res, temp);
            }
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public int minimumDistance2(int[] nums) {

        int min = Integer.MAX_VALUE;
        int n = nums.length - 1;

        for (int i = n; i > 1; i--) {
            int num = nums[i];
            for (int j = i - 1, cnt = 1; j >= 0; j--) {
                if (nums[j] == num) {
                    if (cnt == 2) {
                        if (min > i - j) {
                            min = i - j;
                        }
                        break;
                    }
                    cnt++;
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min * 2;
    }

    public static void main(String[] args) {

        L3740_Minimum_Distance_Between_Three_Equal_Elements_I s = new L3740_Minimum_Distance_Between_Three_Equal_Elements_I();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {1, 1, 2, 3, 2, 1, 2};
        int res = s.minimumDistance(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}