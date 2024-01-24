public class L135_Candy {

    /*
    n == ratings.length
    1 <= n <= 2 * 10^4
    0 <= ratings[i] <= 2 * 10^4

    1 0 2
        - 2 1 2
    1 2 2
        - 1 2 1

    1 2 3 4
        - 1 2 3 4

    1 2 3 2
        - 1 2 3 1

    1 0 2 1
        - 2 1 2 1


    x1, x2, x3, x4, xn


    思路：
    我们能否基于前x个的count，推导出第x+1个的count呢？
    1. 如果x+1的rating比x的rating大，那么x+1的count = x的count + 1
    2. 如果x+1的rating比x的rating小，那么x+1的count 可以考虑设置为 1，此时需要检查前一个rating是否为1，
        如果为1，那么需要将前一个rating的count设置为2，然后再检查前一个rating是否为1，以此类推

        如 3 2 1
        check3时： 1
        check2时： 2 1
        check1时： 3 2 1

    3. 如果x+1的rating比x的rating相等，那么x+1的count = 1

    candy2的思路就是更为高效的candy1：
    1. 先从左到右遍历一遍，如果x+1的rating比x的rating大，那么x+1的count = x的count + 1
    2. 再从右到左遍历一遍，如果x+1的rating比x的rating小 && count反向关系，那么x的count = x+1的count + 1
    (就是将上述2的动作合并在一块做)
    最后再累加一遍。

     */
    public int candy(int[] ratings) {
        int n = ratings.length;
        int ans = 0;
        int[] count = new int[n];

        count[0] = 1;
        ans += count[0];

        for (int i = 1; i < n; i++) {
            int left = ratings[i - 1];
            int cur = ratings[i];
            count[i] = 1;

            if (left < cur) {
                count[i] = count[i - 1] + 1;
            } else if (left > cur) {
                if (count[i] == count[i - 1]) {

                    int j = i - 1;
                    while (j >= 0 && ratings[j] > ratings[j + 1] && count[j] == count[j + 1]) {
                        count[j] += 1;
                        ans += 1;
                        j--;
                    }
                }
                count[i] = 1;
            } else {
                count[i] = 1;
            }

            ans += count[i];
        }

        //        System.out.println(Arrays.toString(count));

        return ans;
    }


    /*

     */
    public int candy2(int[] ratings) {

        int n = ratings.length;

        int[] count = new int[n];
        count[0] = 1;
        int i;
        int sum = 0;

        for (i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                count[i] = count[i - 1] + 1;
            } else
                count[i] = 1;
        }

        for (i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && count[i] <= count[i + 1]) {
                count[i] = count[i + 1] + 1;
            }
        }

        for (i = 0; i < n; i++) {
            sum += count[i];
        }

        return sum;
    }

    public static void main(String[] args) {

        L135_Candy s = new L135_Candy();

        long sysDate1 = System.currentTimeMillis();

        //        int[] ratings = {1, 0, 2};
        int[] ratings = {1, 2, 87, 87, 87, 2, 1};
        // 1, 2, 3 , 1, 3, 2, 1
        //        int[] ratings = {1, 2, 2};
        //        int[] ratings = {1, 2, 2};

        int res = s.candy2(ratings);

        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}