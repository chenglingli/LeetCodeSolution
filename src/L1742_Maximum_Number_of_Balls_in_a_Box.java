public class L1742_Maximum_Number_of_Balls_in_a_Box {


    /*
    1 <= lowLimit <= highLimit <= 105
     */
    public int countBalls(int lowLimit, int highLimit) {

        int[] count = new int[100001];
        int max = -1;

        for (int i = lowLimit; i <= highLimit; i++) {
            int value = CountValue(i);
            count[value]++;
            max = Math.max(count[value], max);
        }

        return max;
    }

    private int CountValue(int x) {
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {

        L1742_Maximum_Number_of_Balls_in_a_Box s = new L1742_Maximum_Number_of_Balls_in_a_Box();
        long sysDate1 = System.currentTimeMillis();

        int lowLimit = 10;
        int highLimit = 20;
        int res = s.countBalls(lowLimit, highLimit);
        System.out.println(res);
        //        int x = s.CountValue(1234);
        //        System.out.println(x);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}