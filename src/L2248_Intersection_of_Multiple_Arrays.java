import java.util.ArrayList;
import java.util.List;

public class L2248_Intersection_of_Multiple_Arrays {

    /*
    1 <= nums.length <= 1000
    1 <= sum(nums[i].length) <= 1000
    1 <= nums[i][j] <= 1000
    All the values of nums[i] are unique.
     */
    public List<Integer> intersection(int[][] nums) {

        int[] count = new int[1001];
        int max = 0;

        for (int[] cur : nums) {
            for (int x : cur) {
                count[x]++;
                max = Math.max(x, max);
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= max; i++) {
            if (count[i] == nums.length) {
                res.add(i);
            }
        }

        return res;
    }

    public static void main(String[] args) {

        L2248_Intersection_of_Multiple_Arrays s =
                new L2248_Intersection_of_Multiple_Arrays();
        long sysDate1 = System.currentTimeMillis();

        int[][] nums = {{3, 1, 2, 4, 5}, {1, 2, 3, 4}, {3, 4, 5, 6}};

        List<Integer> res = s.intersection(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}