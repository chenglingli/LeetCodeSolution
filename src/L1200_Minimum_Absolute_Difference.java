import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class L1200_Minimum_Absolute_Difference {


    /*
    2 <= arr.length <= 10^5
    -10^6 <= arr[i] <= 10^6

    distinct integers arr

     */
    public List<List<Integer>> minimumAbsDifference(int[] arr) {

        Arrays.sort(arr);

        List<List<Integer>> res = new ArrayList<>();
        int duration = Integer.MAX_VALUE;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] < duration) {
                duration = arr[i] - arr[i - 1];
                res.clear();
                List<Integer> temp = Stream.of(arr[i - 1], arr[i]).collect(Collectors.toList());
                res.add(temp);
            } else if (arr[i] - arr[i - 1] == duration) {
                List<Integer> temp = Stream.of(arr[i - 1], arr[i]).collect(Collectors.toList());
                res.add(temp);
            }
        }

        return res;
    }

    // 不排序做法
    public List<List<Integer>> minimumAbsDifference2(int[] arr) {

        countingSort(arr);

        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            minDiff = Math.min(minDiff, arr[i + 1] - arr[i]);
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] - arr[i] == minDiff) {
                List<Integer> r = new ArrayList<>();
                r.add(arr[i]);
                r.add(arr[i + 1]);
                res.add(r);
            }
        }

        return res;
    }

    public void countingSort(int[] nums) {

        int min = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) max = nums[i];
            if (nums[i] < min) min = nums[i];
        }

        if (min < 0) {
            for (int i = 0; i < nums.length; i++) {
                nums[i] -= min;
            }
            max -= min;
        } else {
            min = 0;
        }

        boolean[] count = new boolean[max + 1];
        for (int num : nums) {
            count[num] = true;
        }

        int j = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i]) {
                nums[j++] = i + min;
            }
        }
    }

    public static void main(String[] args) {

        L1200_Minimum_Absolute_Difference s = new L1200_Minimum_Absolute_Difference();
        long sysDate1 = System.currentTimeMillis();

        //        int[] arr = {3, 8, -10, 23, 19, -4, -14, 27};
        int[] arr = {40, 11, 26, 27, -20};
        List<List<Integer>> res = s.minimumAbsDifference(arr);
        System.out.println(Collections.unmodifiableList(res));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}