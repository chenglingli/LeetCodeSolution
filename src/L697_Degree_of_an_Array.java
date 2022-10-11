import java.util.ArrayList;
import java.util.List;

public class L697_Degree_of_an_Array {

    public int findShortestSubArray(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int[] count = new int[50000];
        int[] start = new int[50000];
        int[] end = new int[50000];
        int max = -1;

        // 看起来好像意义不大，在最后一遍循环里面同时做和max比对即可
        List<Integer> candidateList = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {

            if (count[nums[i]] == 0) {
                start[nums[i]] = i;
            }

            count[nums[i]]++;
            if (count[nums[i]] > max) {
                max = count[nums[i]];
            }

            end[nums[i]] = i;
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] == max) {
                candidateList.add(i);
            }
        }

        int res = 50000 + 1;
        for (Integer x : candidateList) {
            if (end[x] - start[x] < res) {
                res = end[x] - start[x];
            }
        }

        return res + 1;
    }

    // 对50000做了优化
    public int findShortestSubArray2(int[] nums) {

        int size = 0;

        for (int num : nums) {
            size = Math.max(size, num);
        }

        int[] count = new int[size + 1];
        int[] start = new int[size + 1];
        int[] last = new int[size + 1];

        int max = 1;

        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
            max = Math.max(max, count[nums[i]]);

            if (start[nums[i]] == 0) {
                start[nums[i]] = i + 1;
            }
            last[nums[i]] = i + 1;
        }

        int result = Integer.MAX_VALUE;

        for (int i = 0; i < count.length; i++) {
            if (count[i] == max) {
                result = Math.min(result, last[i] - start[i] + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {

        L697_Degree_of_an_Array s = new L697_Degree_of_an_Array();
        long sysDate1 = System.currentTimeMillis();

        int[] operations = {1, 2, 2, 3, 1};
        int res = s.findShortestSubArray(operations);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}