import java.util.Arrays;

public class L1103_Distribute_Candies_to_People {

    public int[] distributeCandies(int candies, int num_people) {

        int n = num_people;
        int sum = candies;

        int[] res = new int[n];

        int d = n * n;
        int a = (n + 1) * n / 2;

        int temp = a;
        int j = 1;
        while (temp <= sum) {
            j++;
            temp = (a + a + d * (j - 1)) * j / 2;
        }

        j--;

        int counted = (a + a + d * (j - 1)) * j / 2;
        int remained = sum - counted;

        for (int i = 1; i <= n; i++) {

            // 整行可以获得的
            res[i - 1] = ((i + (i + (j - 1) * n)) * j) / 2;

            // 最后一行的累加
            if (remained > 0) {
                if (remained > i + j * n) {
                    res[i - 1] += i + j * n;
                    remained -= i + j * n;
                } else {
                    res[i - 1] += remained;
                    remained = 0;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {

        L1103_Distribute_Candies_to_People s = new L1103_Distribute_Candies_to_People();
        long sysDate1 = System.currentTimeMillis();

        int candies = 30;
        int num_people = 1;
        int[] res = s.distributeCandies(candies, num_people);
        System.out.println(Arrays.toString(res));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}