import java.util.Arrays;

public class L167_Two_Sum_II_Input_array_is_sorted {

    public int[] twoSum(int[] numbers, int target) {

        if (numbers.length == 0 || target < numbers[0]) {
            return new int[]{-1, -1};
        }

        for (int i = 0; i < numbers.length; i++) {
            int temp = target - numbers[i];
            int l = i + 1;
            int r = numbers.length - 1;

            while (l < r) {
                int mid = (l + r) / 2;
                if (numbers[mid] < temp) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            if (numbers[r] == temp) {
                return new int[]{i + 1, r + 1};
            }
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {

        L167_Two_Sum_II_Input_array_is_sorted s = new L167_Two_Sum_II_Input_array_is_sorted();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {2, 3, 4, 6};
        int[] res = s.twoSum(nums, 10);
        System.out.println(Arrays.toString(res));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}