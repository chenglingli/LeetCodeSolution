import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L2469_Convert_the_Temperature {

    /*
    3 <= nums.length <= 100
    1 <= nums[i] <= 1000

     */
    public int unequalTriplets(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        List<Integer> keyList = new ArrayList<>();
        for (int x : nums) {
            if (!count.containsKey(x)) {
                count.put(x, 1);
                keyList.add(x);
            } else {
                count.put(x, count.get(x) + 1);
            }

        }

        int ans = 0;

        int l = count.keySet().size();
        for (int i = 0; i < l; i++) {
            for (int j = i + 1; j < l; j++) {
                for (int k = j + 1; k < l; k++) {
                    ans += count.get(keyList.get(i)) * count.get(keyList.get(j)) * count.get(keyList.get(k));
                }
            }
        }

        return ans;
    }

    public int unequalTriplets2(int[] nums) {

        int triples = 0;
        int pairs = 0;

        int[] freq = new int[1000];

        for (int i = 0; i < nums.length; i++) {
            triples += pairs - freq[nums[i] - 1] * (i - freq[nums[i] - 1]);
            pairs += i - freq[nums[i] - 1];
            freq[nums[i] - 1]++;
        }
        return triples;
    }


    /*
    假设统计值为
    a b c
    1 2 3
     sum = 1 * 2 * 3

     假设统计值为
    a b c d
    1 2 3 4
     sum = 1 * 2 * 7 + 3 * 3 * 4


    所以
    ans =Sigma(sum(left) * count(i) * sum(right) , i)
     */
    public int unequalTriplets3(int[] nums) {

        int res = 0;
        int count[] = new int[1001];

        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }

        int left = 0;
        int right = nums.length;

        for (int i = 0; i < count.length; i++) {
            int freq = count[i];
            if (freq != 0) {
                right = right - freq;
                res += left * freq * right;
                left += freq;
            }
        }

        return res;

    }

    public static void main(String[] args) {

        L2469_Convert_the_Temperature s = new L2469_Convert_the_Temperature();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {4, 4, 3, 4, 3, 2, 2};
        int res = s.unequalTriplets(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}