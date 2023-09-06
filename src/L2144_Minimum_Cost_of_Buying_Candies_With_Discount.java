import java.util.Arrays;

public class L2144_Minimum_Cost_of_Buying_Candies_With_Discount {

    /*
    1 <= cost.length <= 100
    1 <= cost[i] <= 100
     */
    public int minimumCost(int[] cost) {

        if (cost.length == 1) {
            return cost[0];
        }

        Arrays.sort(cost);

        int ans = 0;

        for (int i = cost.length - 1; i >= 0; i -= 3) {
            ans += cost[i];
            if (i - 1 >= 0) {
                ans += cost[i - 1];
            }
        }

        return ans;
    }

    /*
    桶排序
     */
    public int minimumCost2(int[] cost) {

        // 落入桶中
        int[] table = new int[101];
        for (int n : cost) {
            table[n]++;
        }

        int res = 0;
        int i = 100;
        int count = 0;

        while (i >= 0 && count < cost.length) {

            if (table[i] == 0) {
                i--;
            } else {

                // 找到第一个买的
                int first = i;
                table[i]--;
                count++;
                res += first;
                int j = i;

                while (j >= 0 && table[j] == 0) {
                    j--;
                }

                // 找到第二个买的
                if (j >= 0 && table[j] > 0) {
                    res += j;
                    table[j]--;
                    count++;
                    int k = j;

                    // 第三个免费拿走
                    while (k >= 0 && table[k] == 0) {
                        k--;
                    }
                    if (k >= 0 && table[k] > 0) {
                        table[k]--;
                        count++;
                    }

                    i = k;

                } else {

                    // 找不到第二个买的，结束
                    break;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {

        L2144_Minimum_Cost_of_Buying_Candies_With_Discount s = new L2144_Minimum_Cost_of_Buying_Candies_With_Discount();
        long sysDate1 = System.currentTimeMillis();

        int[] cost = {6, 5, 7, 9, 2, 2};
        int res = s.minimumCost(cost);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}