import java.util.Arrays;

public class L2956_Find_Common_Elements_Between_Two_Arrays {

    /*
    n == nums1.length
    m == nums2.length
    1 <= n, m <= 100
    1 <= nums1[i], nums2[i] <= 100
     */
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        int[] res = new int[2];

        int[] count1 = new int[101];
        int[] count2 = new int[101];
        int c1 = 0;
        int c2 = 0;

        for (int x : nums1) {
            count1[x] = 1;
        }
        for (int x : nums2) {
            count2[x] = 1;
            if (count1[x] == 1) {
                c2++;
            }
        }

        for (int x : nums1) {
            if (count2[x] == 1) {
                c1++;
            }
        }

        res[0] = c1;
        res[1] = c2;

        return res;
    }

    public static void main(String[] args) {

        L2956_Find_Common_Elements_Between_Two_Arrays s = new L2956_Find_Common_Elements_Between_Two_Arrays();
        long sysDate1 = System.currentTimeMillis();

        int[] nums1 = {4, 3, 2, 3, 1};
        int[] nums2 = {2, 2, 5, 2, 3, 6};
        int[] res = s.findIntersectionValues(nums1, nums2);
        System.out.println(Arrays.toString(res));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}