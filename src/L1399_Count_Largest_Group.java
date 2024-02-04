public class L1399_Count_Largest_Group {


    /*

    1 <= n <= 10^4

    数字各位累加和 做group，给出最大size 的group个数


     */
    public int countLargestGroup(int n) {

        int[] digitSum = new int[37];

        for (int i = 1; i <= n; i++) {
            int tempSum = countSum(i);
            digitSum[tempSum]++;
        }

        int max = 1;
        int count = 0;
        for (int i = 1; i <= 36; i++) {

            if (digitSum[i] == max) {
                count++;
            } else if (digitSum[i] > max) {
                max = digitSum[i];
                count = 1;
            }
        }

        return count;
    }

    int countSum(int x) {
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {

        L1399_Count_Largest_Group s = new L1399_Count_Largest_Group();
        long sysDate1 = System.currentTimeMillis();

        int res = s.countLargestGroup(26);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}