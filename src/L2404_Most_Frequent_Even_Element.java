import java.util.HashMap;


public class L2404_Most_Frequent_Even_Element {

    /*
    1 <= nums.length <= 2000
    0 <= nums[i] <= 10^5
     */
    public int mostFrequentEven(int[] nums) {

        HashMap<Integer, Integer> countMap = new HashMap<>();

        for (int x : nums) {
            if (x % 2 == 0) {
                if (countMap.containsKey(x)) {
                    countMap.put(x, countMap.get(x) + 1);
                } else {
                    countMap.put(x, 1);
                }
            }
        }

        int ans = -1;
        int k = 100001;
        for (int x : countMap.keySet()) {
            int cur = countMap.get(x);
            if (cur > ans) {
                ans = cur;
                k = x;
            } else if (cur == ans) {
                if (x < k) {
                    ans = cur;
                    k = x;
                }
            }
        }

        return k == 100001 ? -1 : k;
    }

    public int mostFrequentEven2(int[] nums) {

        int max = 0;
        for (int i : nums) max = Math.max(i, max);

        int[] arr = new int[(max / 2) + 1];
        int res = -1;

        for (int i : nums) {
            if (i % 2 == 0) {
                // >> basically means division by 2
                //  so all of our even index becomes index/2 :
                //  ex -> 2 -> 1, 4 -> 2 and so on
                //      that's why we only need max/2 space.
                i = i >> 1;
                arr[i]++;

                if (res < 0
                        || arr[i] > arr[res]
                        || (arr[i] == arr[res] && i < res)) {
                    res = i;
                }
            }
        }

        return res == -1 ? -1 : res << 1;
    }

    public static void main(String[] args) {

        L2404_Most_Frequent_Even_Element s = new L2404_Most_Frequent_Even_Element();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {0, 1, 2, 2, 4, 4, 1};
        int res = s.mostFrequentEven(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}