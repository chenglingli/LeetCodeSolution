import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class L1636_Sort_Array_by_Increasing_Frequency {


    /*
        -100 <= nums[i] <= 100
        1 <= nums.length <= 100

        custom sort explanation:
        .stream(nums)
        iterates through the nums array

        .boxed()
        converts each int to Integer object, this is because .sorted() can only operate on objects

        .sorted((a,b) -> map.get(a) != map.get(b) ? map.get(a) - map.get(b) : b - a)
        if frequency of two numbers are not the same, sort by ascending frequency. If frequencies are the same, sort by decending numeric value

        .mapToInt(n -> n)
        converts Integer to int

        .toArray()
        returns array
     */
    public int[] frequencySort(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        // count frequency of each number
        Arrays.stream(nums).forEach(n -> map.put(n, map.getOrDefault(n, 0) + 1));

        // custom sort
        return Arrays.stream(nums).boxed()
                .sorted(
                        (a, b) -> map.get(a) != map.get(b) ?
                                map.get(a) - map.get(b) :
                                b - a)
                .mapToInt(n -> n)
                .toArray();
    }


    /*

    两个数揉到一个数里面去，用高位和地位表示

     */
    public int[] frequencySort2(int[] nums) {
        int[] counts = new int[201];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = -nums[i] + 100;
            counts[nums[i]]++;
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] += (counts[nums[i]] << 8);
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] & 255; // 255 = 2^8 - 1
            nums[i] = -nums[i] + 100;
        }

        return nums;
    }

    public static void main(String[] args) {

        L1636_Sort_Array_by_Increasing_Frequency s = new L1636_Sort_Array_by_Increasing_Frequency();
        long sysDate1 = System.currentTimeMillis();

        int[] input = {2, 3, 1, 3, 2};
        int[] res = s.frequencySort2(input);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}