import java.util.Arrays;

public class L2578_Split_With_Minimum_Sum {

    /*
    10 <= num <= 10^9
     */
    public int splitNum(int num) {
        String numStr = Integer.toString(num);
        int[] digitArray = new int[numStr.length()];

        int i = 0;
        while (num > 0) {
            digitArray[i++] = num % 10;
            num /= 10;
        }

        Arrays.sort(digitArray);

        int a = 0;
        int b = 0;
        i = 0;
        while (i < digitArray.length) {
            a *= 10;
            a += digitArray[i];
            i++;

            if (i < digitArray.length) {
                b *= 10;
                b += digitArray[i];
                i++;
            }
        }

        return a + b;
    }

    public int splitNum2(int num) {

        int[] ans = new int[10];
        while (num > 0) {
            ans[num % 10]++;
            num /= 10;
        }

        int num1 = 0;
        int num2 = 0;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < ans[i]; j++) {
                if (num1 <= num2) {
                    num1 = num1 * 10 + i;
                } else {
                    num2 = num2 * 10 + i;
                }
            }
        }

        return num1 + num2;
    }

    public static void main(String[] args) {

        L2578_Split_With_Minimum_Sum s = new L2578_Split_With_Minimum_Sum();
        long sysDate1 = System.currentTimeMillis();

        int num = 687;
        int res = s.splitNum(num);
        System.out.println(res);


        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}