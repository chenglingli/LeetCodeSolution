import java.util.ArrayList;
import java.util.List;

public class L2032_Two_Out_of_Three {


    /*
    1 <= nums1.length, nums2.length, nums3.length <= 100
    1 <= nums1[i], nums2[j], nums3[k] <= 100
     */
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        int[] count = new int[101];
        List<Integer> res = new ArrayList<>();

        fillCount(nums1, count);
        fillCount(nums2, count);
        fillCount(nums3, count);

        for (int i = 1; i <= 100 ;i ++) {
            if (count[i] >=2) {
                res.add(i);
            }
        }

        return res;
    }

    void fillCount(int[] nums, int[] count) {
        int[] temp = new int[101];
        for (int num : nums) {
            if (temp[num] == 0) {
                temp[num] = 1;
                count[num]++;
            }
        }
    }

    public static void main(String[] args) {

        L2032_Two_Out_of_Three s = new L2032_Two_Out_of_Three();
        long sysDate1 = System.currentTimeMillis();

        int[] nums1 = {1, 1, 3, 2};
        int[] nums2 = {2, 3};
        int[] nums3 = {3};
        List<Integer> res = s.twoOutOfThree(nums1, nums2, nums3);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}