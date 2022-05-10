import java.util.Arrays;

public class L034_Find_First_and_Last_Position {

    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if (nums.length <= 0) {
            return res;
        }

        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] < target) l = mid + 1;
            else r = mid;
        }
        if (nums[r] == target)
            res[0] = r;
        else
            return res;

        l = 0;
        r = nums.length - 1;
        while (l < r) {
            int mid = (l + r + 1) / 2;
            if (nums[mid] > target) r = mid - 1;
            else l = mid;
        }
        if (nums[l] == target)
            res[1] = l;

        return res;
    }

    public static void main(String[] args) {

        L034_Find_First_and_Last_Position s = new L034_Find_First_and_Last_Position();

        long sysDate1 = System.currentTimeMillis();
        int[] nums = {1};
        int[] res = s.searchRange(nums, 1);

        System.out.println(Arrays.toString(res));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}