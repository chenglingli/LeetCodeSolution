import java.util.ArrayList;
import java.util.List;

public class L442_Find_All_Duplicates_in_an_Array {

    /*
    You must write an algorithm that runs in O(n) time
        and uses only constant extra space.

    n == nums.length
    1 <= n <= 10^5
    1 <= nums[i] <= n
    Each element in nums appears once or twice.

     */
    public List<Integer> findDuplicates(int[] nums) {

        int len = nums.length;
        int [] count = new int[len + 1];
        List<Integer> res = new ArrayList<>();

        for (int x : nums) {
            count[x]++;
            if (count[x] == 2) {
                res.add(x);
            }
        }

        return res;
    }

    public static void main(String[] args) {

        L442_Find_All_Duplicates_in_an_Array s = new L442_Find_All_Duplicates_in_an_Array();

        long sysDate1 = System.currentTimeMillis();
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> res = s.findDuplicates(nums);

        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}