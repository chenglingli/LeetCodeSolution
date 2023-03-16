import java.util.Arrays;

public class L1470_Shuffle_the_Array {

    public int[] shuffle(int[] nums, int n) {

        int[] res = new int[n * 2];

        int i = 0;
        int j = n;

        int k = 0;
        while (k < n * 2) {
            if (k % 2 == 0) {
                res[k++] = nums[i++];
            } else {
                res[k++] = nums[j++];
            }
        }

        return res;
    }

    public static void main(String[] args) {

        L1470_Shuffle_the_Array s = new L1470_Shuffle_the_Array();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {4, 8, 5, 2, 3, 1};
        int n = 3;
        int[] res = s.shuffle(nums, n);
        System.out.println(Arrays.toString(res));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}