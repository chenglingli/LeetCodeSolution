import java.util.HashMap;
import java.util.Map;

public class L1442_Count_Triplets_That_Can_Form_Two_Arrays_of_Equal_XOR {

    /*
    Given an array of integers arr.

    We want to select three indices i, j and k where (0 <= i < j <= k < arr.length).

    Let's define a and b as follows:

    a = arr[i] ^ arr[i + 1] ^ ... ^ arr[j - 1]
    b = arr[j] ^ arr[j + 1] ^ ... ^ arr[k]
    Note that ^ denotes the bitwise-xor operation.

    Return the number of triplets (i, j and k) Where a == b.



    Example 1:

    Input: arr = [2,3,1,6,7]
    Output: 4
    Explanation: The triplets are (0,1,2), (0,2,2), (2,3,4) and (2,4,4)

    Example 2:
    Input: arr = [1,1,1,1,1]
    Output: 10


    Constraints:

    1 <= arr.length <= 300
    1 <= arr[i] <= 10^8
     */
    public int countTriplets(int[] arr) {
        // a == b  <=>  a ^ b == 0  <=>  arr[i] ^ ... ^ arr[k] == 0
        // 用前缀异或：prefix[x] = arr[0] ^ ... ^ arr[x-1]
        // arr[i..k] 的异或 = prefix[k+1] ^ prefix[i] == 0  <=>  prefix[k+1] == prefix[i]
        // 此时任意 j ∈ (i, k] 都合法，贡献 (k - i) 个三元组
        //
        // 遍历 k 时，对所有历史出现过且值等于当前 prefix 的下标 i：
        //   sum(k - i) = count * k - sumOfIndices


        // 固定右端点 k 时，所有满足 prefix[i] == prefix[k+1] 的历史起点 i，每个都会贡献 k - i 个三元组（因为 j 有 k-i 种取法）。
        // 设这些 i 为 i₁, i₂, …, i_c：
        // 答案增量
        //   = (k - i₁) + (k - i₂) + … + (k - i_c)
        //   = c·k - (i₁ + i₂ + … + i_c)
        //   = count * k - sumOfIndices

        // 存储前缀异或值出现的次数
        Map<Integer, Integer> count = new HashMap<>();

        // 存储前缀异或值出现的下标和
        Map<Integer, Integer> totalIndex = new HashMap<>();

        count.put(0, 1);
        totalIndex.put(0, 0);

        int res = 0;
        int prefix = 0;
        for (int k = 0; k < arr.length; k++) {
            prefix ^= arr[k];
            int c = count.getOrDefault(prefix, 0);
            int sumIdx = totalIndex.getOrDefault(prefix, 0);
            // 当前右端点为 k，贡献 count * k - sumOfIndices
            res += c * k - sumIdx;

            count.put(prefix, c + 1);
            // 存的是 i = k+1（下一段的起点）
            // 扫完 arr[k] 之后：
            // 当前 prefix = arr[0] ^ … ^ arr[k] = prefix[k+1]
            totalIndex.put(prefix, sumIdx + k + 1);
        }
        return res;
    }

    public int countTriplets2(int[] arr) {
        int n = arr.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            int xorSum = 0;
            for (int k = i; k < n; k++) {
                xorSum ^= arr[k];
                if (xorSum == 0) {
                    count += (k - i);
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {

        L1442_Count_Triplets_That_Can_Form_Two_Arrays_of_Equal_XOR s = new L1442_Count_Triplets_That_Can_Form_Two_Arrays_of_Equal_XOR();
        long sysDate1 = System.currentTimeMillis();

        int[] arr = {2, 3, 1, 6, 7};
        int res = s.countTriplets(arr);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}