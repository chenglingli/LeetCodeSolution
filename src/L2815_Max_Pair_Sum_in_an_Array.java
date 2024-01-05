import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class L2815_Max_Pair_Sum_in_an_Array {

    /*
    2 <= nums.length <= 100
    1 <= nums[i] <= 104
     */
    public int maxSum(int[] nums) {

        HashMap<Integer, List<Integer>> maxDigitList = new HashMap<>();
        // int[][] maxDigitArray = new int[10][100];

        for (int x : nums) {
            int t = maxDigit(x);
            List<Integer> tempList;
            if (maxDigitList.containsKey(t)) {
                tempList = maxDigitList.get(t);
            } else {
                tempList = new ArrayList<>();
            }
            tempList.add(x);
            maxDigitList.put(t, tempList);
        }

        int ans = 0;
        for (int x : maxDigitList.keySet()) {
            List<Integer> curList = maxDigitList.get(x);
            for (int i = 0; i < curList.size(); i++) {
                for (int j = i + 1; j < curList.size(); j++) {
                    int temp = curList.get(i) + curList.get(j);
                    ans = Math.max(temp, ans);
                }
            }
        }

        return ans;
    }

    public int maxSum2(int[] nums) {

        // 存储当前以x为key的最大值
        int[] flag = new int[10];

        int maxSum = -1;

        for (int num : nums) {
            int idx = maxDigit(num); // idx is the big digit in num
            if (flag[idx] != 0) {
                int sum = num + flag[idx];
                if (sum > maxSum)
                    maxSum = sum;
            }
            if (num > flag[idx])
                flag[idx] = num;
        }

        return maxSum;
    }

    private int maxDigit(int x) {
        int maxDigit = 1;
        while (x > 0) {
            if (x % 10 > maxDigit) {
                maxDigit = x % 10;
            }
            x /= 10;
        }

        return maxDigit;
    }

    public static void main(String[] args) {

        L2815_Max_Pair_Sum_in_an_Array s = new L2815_Max_Pair_Sum_in_an_Array();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {51, 71, 17, 24, 42};
        int res = s.maxSum(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}