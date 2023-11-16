import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L2553_Separate_the_Digits_in_an_Array {


    public int[] separateDigits(int[] nums) {
        List<Integer> numsArray = new ArrayList<>();
        for (int x : nums) {
            if (x < 10) {
                numsArray.add(x);
            } else {
                String tmp = Integer.toString(x);
                for (int i = 0; i < tmp.length(); i++) {
                    numsArray.add(tmp.charAt(i) - '0');
                }
            }
        }

        int[] res = new int[numsArray.size()];
        int i = 0;
        for (Integer x : numsArray) {
            res[i++] = x;
        }

        return res;
    }

    public int[] separateDigits2(int[] nums) {

        int size = 0;
        int temp;

        for (int num : nums) {
            temp = num;
            while (temp > 0) {
                size++;
                temp /= 10;
            }
        }

        int[] answer = new int[size];
        for (int i = nums.length - 1; i >= 0; i--) {
            while (nums[i] > 0) {
                answer[--size] = nums[i] % 10;
                nums[i] /= 10;
            }
        }
        return answer;
    }

    public static void main(String[] args) {

        L2553_Separate_the_Digits_in_an_Array s = new L2553_Separate_the_Digits_in_an_Array();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {25, 64, 9, 4, 100};
        int[] res = s.separateDigits(nums);
        System.out.println(Arrays.toString(res));


        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}