import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            if (i == 0 || (i > 0 && nums1[i] != nums1[i - 1])) {
                if (Arrays.binarySearch(nums2, nums1[i]) > -1) {
                    list.add(nums1[i]);
                }
            }
        }

        int[] result = new int[list.size()];
        int k = 0;
        for (int i : list) {
            result[k++] = i;
        }

        return result;
    }

    public static void main(String[] args) {

        Solution s = new Solution();

        long sysDate1 = System.currentTimeMillis();
        int[] nums = {5, 6, 7, 8, 0, 1, 1, 3};
        int[] res = s.intersection(nums, nums);

        System.out.println(res.length);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}