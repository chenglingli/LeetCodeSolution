import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L611_Valid_Triangle_Number {

    /**
     * Given an array consists of non-negative integers, your task is to count the number of triplets chosen from the
     * array that can make triangles if we take them as side lengths of a triangle.
     * Example 1:
     * Input: [2,2,3,4]
     * Output: 3
     * Explanation:
     * Valid combinations are:
     * 2,3,4 (using the first 2)
     * 2,3,4 (using the second 2)
     * 2,2,3
     * Note:
     * The length of the given array won't exceed 1000.
     * The integers in the given array are in the range of [0, 1000].
     */
    public int triangleNumber(int[] nums) {

        if (nums.length < 3) {
            return 0;
        }

        List<Integer> ans = new ArrayList<>();
        backTrack(0, ans, nums);

        return count;
    }

    int count = 0;

    public void backTrack(int start, List<Integer> ans, int[] num) {

        if (ans.size() == 3) {
            if (exist(ans)) {
                count += 1;
            }
        } else if (ans.size() < 3) {
            for (int i = start; i < num.length; i++) {
                ans.add(num[i]);
                backTrack(i + 1, ans, num);
                ans.remove(ans.size() - 1);
            }
        }
    }

    boolean exist(List<Integer> ans) {
        Integer a = ans.get(0);
        Integer b = ans.get(1);
        Integer c = ans.get(2);
        if (a + b <= c || a + c <= b || b + c <= a) {
            return false;
        }
        return true;
    }

    public int triangleNumber2(int[] nums) {
        int res = 0, n = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                int sum = nums[i] + nums[j], left = j + 1, right = n;
                while (left < right) {
                    int mid = left + (right - left) / 2;
                    if (nums[mid] < sum) left = mid + 1;
                    else right = mid;
                }
                res += right - 1 - j;
            }
        }
        return res;
    }

    public int triangleNumber3(int[] nums) {
        int count = 0;

        if (nums == null || nums.length < 3)
            return count;

        Arrays.sort(nums);
        int n = nums.length;

        for (int i = n - 1; i >= 2; i--) {
            int l = 0, r = i - 1;

            while (l < r) {
                if (nums[l] + nums[r] > nums[i]) {
                    count += r - l;
                    r--;
                } else
                    l++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        L611_Valid_Triangle_Number s = new L611_Valid_Triangle_Number();
        long sysDate1 = System.currentTimeMillis();

        int[] matrix = {2, 2, 3, 4};
        // int[][] matrix = {{1, 3}, {3, 5}, {6, 7}, {6, 8}, {8, 4}, {9, 5}};
        // int[][] matrix = {{5,4},{6,4},{6,7},{2,3}};
        int res2 = s.triangleNumber(matrix);
        System.out.println(res2);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}