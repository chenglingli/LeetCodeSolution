import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L2465_Number_of_Distinct_Averages {

    public int distinctAverages(int[] nums) {

        List<Double> averageList = new ArrayList<>();

        Arrays.sort(nums);

        int i = 0;
        int j = nums.length - 1;

        while (i < j) {
            double average = (nums[i] + nums[j]) / 2.0;
            if (!averageList.contains(average)) {
                averageList.add(average);
            }
            i++;
            j--;
        }

        return averageList.size();
    }

    public int distinctAverages2(int[] nums) {

        boolean[] sums = new boolean[201];

        int distinct = 0;
        Arrays.sort(nums);

        for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
            if (!sums[nums[i] + nums[j]]) {
                distinct++;
            }
            sums[nums[i] + nums[j]] = true;
        }

        return distinct;
    }

    public static void main(String[] args) {

        L2465_Number_of_Distinct_Averages s = new L2465_Number_of_Distinct_Averages();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {4, 1, 4, 0, 3, 5};
        int res = s.distinctAverages(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}