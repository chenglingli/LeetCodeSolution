import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class L2215_Find_the_Difference_of_Two_Arrays {

    /*
    1 <= nums1.length, nums2.length <= 1000
    -1000 <= nums1[i], nums2[i] <= 1000

    answer[0] is a list of all distinct integers in nums1 which are not present in nums2.
    answer[1] is a list of all distinct integers in nums2 which are not present in nums1.

     */
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {

        int[] count1 = new int[2001];
        for (int x : nums1) count1[x + 1000] = 1;

        int[] count2 = new int[2001];
        for (int x : nums2) count2[x + 1000] = 1;

        List<Integer> res1 = new ArrayList<>();
        List<Integer> res2 = new ArrayList<>();

        for (int i = 0; i < 2001; i++) {
            if (count1[i] != 0 && count2[i] == 0) res1.add(i - 1000);
            else if (count1[i] == 0 && count2[i] != 0) res2.add(i - 1000);
        }

        List<List<Integer>> res = new ArrayList<>();
        res.add(res1);
        res.add(res2);
        return res;
    }


    public static void main(String[] args) {

        L2215_Find_the_Difference_of_Two_Arrays s =
                new L2215_Find_the_Difference_of_Two_Arrays();
        long sysDate1 = System.currentTimeMillis();

        int[] nums1 = {1, 2, 3};
        int[] nums2 = {2, 4, 6};
        List<List<Integer>> res = s.findDifference(nums1, nums2);
        System.out.println(Collections.unmodifiableList(res));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}