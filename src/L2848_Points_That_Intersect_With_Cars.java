import java.util.ArrayList;
import java.util.List;

public class L2848_Points_That_Intersect_With_Cars {

    /*

    You are given a 0-indexed 2D integer array nums representing the coordinates of the cars parking on a number line.
    For any index i, nums[i] = [starti, endi] where starti is the starting point of the ith car and endi is the ending point of the ith car.

    Return the number of integer points on the line that are covered with any part of a car.



    Example 1:

    Input: nums = [[3,6],[1,5],[4,7]]
    Output: 7
    Explanation: All the points from 1 to 7 intersect at least one car, therefore the answer would be 7.

    Example 2:

    Input: nums = [[1,3],[5,8]]
    Output: 7
    Explanation: Points intersecting at least one car are 1, 2, 3, 5, 6, 7, 8. There are a total of 7 points, therefore the answer would be 7.


    Constraints:

    1 <= nums.length <= 100
    nums[i].length == 2
    1 <= starti <= endi <= 100

     */
    public int numberOfPoints(List<List<Integer>> nums) {
        int ans = 0;

        for (int i = 1; i <= 100; i++) {
            boolean intersects = false;
            for (List<Integer> car : nums) {
                if (i >= car.get(0) && i <= car.get(1)) {
                    intersects = true;
                    break;
                }
            }
            if (intersects) ans++;
        }

        return ans;
    }

    public int numberOfPoints2(List<List<Integer>> nums) {
        int[] diff = new int[102];

        for (List<Integer> car : nums) {
            int start = car.get(0);
            int end = car.get(1);
            diff[start]++;
            diff[end + 1]--;
        }

        int count = 0;
        int prefixSum = 0;
        for (int i = 1; i <= 100; i++) {
            prefixSum += diff[i];

            if (prefixSum > 0)
                count++;
        }

        return count;
    }

    public static void main(String[] args) {

        L2848_Points_That_Intersect_With_Cars s = new L2848_Points_That_Intersect_With_Cars();
        long sysDate1 = System.currentTimeMillis();

        List<Integer> num1 = new ArrayList<>();
        List<Integer> num2 = new ArrayList<>();
        List<Integer> num3 = new ArrayList<>();
        List<List<Integer>> nums = new ArrayList<>();
        num1.add(3);
        num1.add(6);
        num2.add(1);
        num2.add(5);
        num3.add(4);
        num3.add(7);
        nums.add(num1);
        nums.add(num2);
        nums.add(num3);

        int res = s.numberOfPoints2(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}