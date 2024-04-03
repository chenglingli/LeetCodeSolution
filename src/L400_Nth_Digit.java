public class L400_Nth_Digit {


    /*
    1 - 9 				9 * 1
    10 - 99 			99 - 9 = 90 * 2
    100 - 999 			999 - 99 = 900 * 3
    1000 - 9999       	9999 - 999 = 9000 * 4
     */
    public int findNthDigit(int n) {

        // 循环数，计算前面的整段
        int i = 1;
        int base = 9;

        // 过滤之前区间
        while (n > i * base) {

            n -= i * base;

            i++;
            base *= 10;

            // 正整数值越界
            if (i * base < 0) {
                break;
            }
        }

        /*
        假设n = 2000
        n = 2000 - 9 - 180 * 2 = 1632

        i = 3
        base = 900
         */

        int num = (n - 1) / i;
        /*
        10 index = 0 newIndex = 2
        11 index = 1 newIndex = 1
        12 index = 0
        13 index = 1
        14
         */
        int index = (n - 1) % i;
        int newIndex = i - index;

        // 起始数，譬如：100
        int start = base / 9;

        // 目标数，譬如：134，index = 1，newIndex = 2
        int des = start + num;

        // 在目标数里面找到正确bit位置
        while (newIndex > 1) {
            des /= 10;
            newIndex--;
        }

        // 返回结果
        return des % 10;
    }


    public int findNthDigit2(int n) {

        int len = 1;
        long count = 9;
        int start = 1;

        while (n > len * count) {
            n -= len * count;
            len += 1;
            count *= 10;
            start *= 10;
        }

        start += (n - 1) / len;
        String s = Integer.toString(start);
        return s.charAt((n - 1) % len) - '0';
    }

    public static void main(String[] args) {

        L400_Nth_Digit s = new L400_Nth_Digit();

        long sysDate1 = System.currentTimeMillis();

        for (int k = 1; k < 30; k++) {
            int res = s.findNthDigit(k);
            System.out.print("k = " + k + " ");
            System.out.println(res);
        }

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}