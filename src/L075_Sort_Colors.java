import java.util.Arrays;

public class L075_Sort_Colors {

    // zeroTail和twoHead分别表示最后一个0的下一个和第一个2的前一个，
    // 比如[0,1,1,2]，zeroTail=1，twoHead=2
    public void sortColors(int[] nums) {

        if (nums.length <= 1) return;

        int zeroTail = 0;
        int twoHead = nums.length - 1;
        while (nums[zeroTail] == 0 && zeroTail < twoHead) zeroTail++;
        while (nums[twoHead] == 2 && zeroTail < twoHead) twoHead--;

        int i = zeroTail;
        while (i <= twoHead) {
            if (nums[i] == 0) {
                swap(nums, zeroTail, i);
                zeroTail++;
                i++;
            } else if (nums[i] == 2) {
                swap(nums, twoHead, i);
                twoHead--;
            } else {
                i++;
            }
        }
    }

    void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    public static void main(String[] args) {

        L075_Sort_Colors s = new L075_Sort_Colors();

        long sysDate1 = System.currentTimeMillis();
//        int[] nums = {2, 0, 2, 1, 1, 0};
        int[] nums = {2, 1, 0, 1};
//        int[] nums = {0, 0};
//        int[] nums = {1, 1, 2, 1, 1};

        s.sortColors(nums);

        System.out.println(Arrays.toString(nums));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}