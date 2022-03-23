public class L670_Maximum_Swap {

    /*
    思路是这样的，由于我们希望置换后的数字最大，
    那么肯定最好的高位上的小数字和低位上的大数字进行置换，

    所以我们需要找到每个数字右边的最大数字(包括其自身)，这样我们再从高位向低位遍历，
    如果某一位上的数字小于其右边的最大数字，说明需要调换，由于最大数字可能不止出现一次，
    我们希望能跟较低位的数字置换，这样置换后的数字最大，所以我们就从低位向高位遍历来找那个最大的数字，
    找到后进行调换即可。比如对于1993这个数：

    1 9 9 3

    9 9 9 3  (back数组)

    9 9 1 3

    我们建立好back数组后，从头遍历原数字，发现1比9小，于是从末尾往前找9，找到后一置换，就得到了9913。

    */

    int maximumSwap(int num) {

        char[] res = Integer.toString(num).toCharArray();
        char[] back = new char[res.length];
        System.arraycopy(res, 0, back, 0, res.length);

        for (int i = back.length - 2; i >= 0; --i) {
            if (back[i] < back[i + 1]) {
                back[i] = back[i + 1];
            }
        }

        for (int i = 0; i < res.length; ++i) {
            if (res[i] == back[i])
                continue;

            for (int j = res.length - 1; j > i; --j) {
                if (res[j] == back[i]) {
                    swap(res, i, j);
                    return Integer.parseInt(String.valueOf(res));
                }
            }
        }

        return Integer.parseInt(String.valueOf(res));
    }

    void swap(char[] str, int i, int j) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }


    public static void main(String[] args) {

        L670_Maximum_Swap s = new L670_Maximum_Swap();

        long sysDate1 = System.currentTimeMillis();

        int input = 2736;
        int res = s.maximumSwap(input);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}