import java.util.ArrayList;
import java.util.List;

public class L3285_Find_Indices_of_Stable_Mountains {

    /*

    There are n mountains in a row, and each mountain has a height.
    You are given an integer array height where height[i] represents the height of mountain i, and an integer threshold.

    A mountain is called stable if the mountain just before it (if it exists) has a height strictly greater than threshold.
    Note that mountain 0 is not stable.

    Return an array containing the indices of all stable mountains in any order.



    Example 1:

    Input: height = [1,2,3,4,5], threshold = 2

    Output: [3,4]

    Explanation:

    Mountain 3 is stable because height[2] == 3 is greater than threshold == 2.
    Mountain 4 is stable because height[3] == 4 is greater than threshold == 2.
    Example 2:

    Input: height = [10,1,10,1,10], threshold = 3

    Output: [1,3]

    Example 3:

    Input: height = [10,1,10,1,10], threshold = 10

    Output: []



    Constraints:

    2 <= n == height.length <= 100
    1 <= height[i] <= 100
    1 <= threshold <= 100

     */
    public List<Integer> stableMountains(int[] height, int threshold) {
        List<Integer> res = new ArrayList<>();

        for (int i = 1; i < height.length; i++) {
            if (height[i - 1] > threshold) {
                res.add(i);
            }
        }

        return res;
    }

    public static void main(String[] args) {

        L3285_Find_Indices_of_Stable_Mountains s = new L3285_Find_Indices_of_Stable_Mountains();
        long sysDate1 = System.currentTimeMillis();

        int[] height = {10, 1, 10, 1, 10};
        int threshold = 3;

        List<Integer> res = s.stableMountains(height, threshold);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}