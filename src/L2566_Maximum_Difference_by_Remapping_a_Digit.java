public class L2566_Maximum_Difference_by_Remapping_a_Digit {

    /*
    1 <= num <= 10^8

    得到最大值，将首个非9数字变为9
    得到最小值，将首个数字变为0

     */
    public int minMaxDifference(int num) {

        int[] digit = new int[9];
        int i = 0;
        int originNum = num;

        while (num > 0) {
            digit[i++] = num % 10;
            num /= 10;
        }

        int len = i;

        int max = 0;
        int min = 0;
        i = len - 1;
        int maxReplaceDigit = 0;
        while (i >= 0) {
            if (digit[i] != 9) {
                maxReplaceDigit = digit[i];
                break;
            }
            i--;
        }

        if (i != -1) {
            i = len - 1;
            while (i >= 0) {
                if (digit[i] == maxReplaceDigit) {
                    max = max * 10 + 9;
                } else {
                    max = max * 10 + digit[i];
                }
                i--;
            }
        } else {
            max = originNum;
        }

        int minReplaceDigit = digit[len - 1];
        i = len - 1;
        while (i >= 0) {
            if (digit[i] == minReplaceDigit) {
                min = min * 10;
            } else {
                min = min * 10 + digit[i];
            }
            i--;
        }


        return max - min;
    }

    public static void main(String[] args) {

        L2566_Maximum_Difference_by_Remapping_a_Digit s = new L2566_Maximum_Difference_by_Remapping_a_Digit();
        long sysDate1 = System.currentTimeMillis();

        int num = 1;
        int res = s.minMaxDifference(num);
        System.out.println(res);


        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}