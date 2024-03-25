import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class L229_Majority_Element_II {

    /*
    1 <= nums.length <= 5 * 10^4
    -10^9 <= nums[i] <= 10^9
    find all elements that appear more than ⌊ n/3 ⌋ times.
    向下取整

    使用hashmap做统计，超过threshold的加入结果集
     */
    public List<Integer> majorityElement(int[] nums) {
        int len = nums.length;
        int threshold = len / 3;

        List<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int x : nums) {
            if (!res.contains(x)) {

                if (map.containsKey(x)) {
                    map.put(x, map.get(x) + 1);
                } else {
                    map.put(x, 1);
                }

                if (map.get(x) > threshold && !res.contains(x)) {
                    res.add(x);
                    if (res.size() == 2) {
                        break;
                    }
                }
            }
        }

        return res;
    }

    /*
    优化
    使用排序逻辑
     */
    public List<Integer> majorityElement2(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        qSort(nums, 0, nums.length - 1, ans);
        return ans;
    }

    private void qSort(int[] nums, int a, int b, List<Integer> ans) {

        int len = nums.length / 3;
        if (b - a < len)
            return;

        int l = a;
        int r = b;
        int i = a + 1;

        while (r >= i) {
            if (nums[l] > nums[i]) {
                swap(nums, l, i);
                i++;
                l++;
            } else if (nums[l] < nums[i]) {
                if (nums[i] > nums[r])
                    swap(nums, r, i);
                r--;
            } else
                i++;
        }

        if (r - l >= len)
            ans.add(nums[r]);

        qSort(nums, a, l - 1, ans);
        qSort(nums, r + 1, b, ans);
    }

    private void swap(int[] nums, int x, int y) {
        int t = nums[x];
        nums[x] = nums[y];
        nums[y] = t;
    }


    /*
    第三种办法
    符合条件的数量，最多只有两个
    Boyer-Moore Majority Vote Algorithm

    Here are the basic steps of the Boyer-Moore Majority Vote Algorithm:

    1，Candidate Element Selection:
        Choose the first element of the array as the candidate element and initialize a counter.

    2，Element Counting:
        Traverse through the array.
        If the current element matches the candidate element,
        increment the counter.
        If they don't match, decrement the counter.

    3，Check Counter:
        If the counter becomes zero,
        choose the current element as the new candidate element and reset the counter to one.

    4，Final Candidate Verification:
        After these steps, verify if the selected candidate is indeed the majority element.

     */
    public List<Integer> majorityElement3(int[] nums) {

        int val1 = Integer.MAX_VALUE, val2 = Integer.MAX_VALUE;
        int cnt1 = 0, cnt2 = 0;
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();

        /*
        1,找两个候选数
        2,统计两个候选数的数量
        3,判断是否符合条件
         */
        for (int num : nums) {
            if (cnt1 == 0 && val2 != num) {
                val1 = num;
                cnt1++;
            } else if (cnt2 == 0 && val1 != num) {
                val2 = num;
                cnt2++;
            } else if (val1 == num) {
                cnt1++;
            } else if (val2 == num) {
                cnt2++;
            } else {
                cnt1--;
                cnt2--;
            }
        }

        cnt1 = 0;
        cnt2 = 0;

        for (int num : nums) {
            if (num == val1) {
                cnt1++;
            }
            if (num == val2) {
                cnt2++;
            }
        }

        if (cnt1 > n / 3) {
            ans.add(val1);
        }
        if (cnt2 > n / 3) {
            ans.add(val2);
        }

        return ans;
    }

    public static void main(String[] args) {
        L229_Majority_Element_II s = new L229_Majority_Element_II();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {1, 4, 3, 3, 3, 2};
        List<Integer> res = s.majorityElement3(nums);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}