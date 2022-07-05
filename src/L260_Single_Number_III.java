public class L260_Single_Number_III {

    public int[] singleNumber(int[] nums) {

        if (nums == null || nums.length == 0)
            return new int[]{};

        int xor = 0;
        for (int num : nums) {
            xor = xor ^ num;
        }

        /*
         * 对于这道题，
         * 首先比较简单的方法就是直接利用unordered_map来对其中出现的数字以及他们出现的数量进行统计，
         * 最后再进行遍历找到两个只出现一次的数字即可。这种方法虽然速度不错，但是需要额外开辟很大的空间。
         * 对于第二种方法，是找到这样单独出现的数字的一个比较常规的方法：XOR
         *
         * 如果只有一个只出现一次的数字就比较简单了，直接从都往后XOR一遍即可，因此0 XOR num = num，相同的数字的XOR的也为0，
         * 因此最后剩下的一定就是只出现一次的数字了。
         *
         * 但是这道题，有两个只出现一次的数字，因此我们要分开进行处理。
         * 首先，将所有的数字都进行XOR，最后得到的一定是两个不同的数字的XOR，这时，我们找到他们的最小的不同的比特位：
         * 比如，对于3和5，他们进行XOR的结果是6，二进制为110，因此10就是最小的不同的比特位。
         * 之所以要找这样的比特位，就是为这样的diff可以将3和5进行区分。
         *
         * XOR的运算里，相同取0不同取1，因此最小的比特位也是最小的二者不同的位。
         *
         * 因此，在找到这样的diff之后，就可以分开来对num进行遍历查找。
         */

        // 获得最后边一位（即原数组中连个不同数字的最右边的不同bit）

        /*
        整数转负数

        7 = 0 111

        1，最高位改为1			1 111
        2，除了最高位，其他取反		1 000
        3，结果+1 				1 001

        -7 = 1 001

        7 & -7 = 1

         */
        int temp = xor & (-xor);

        int[] res = new int[2];
        for (int num : nums) {
            if ((temp & num) == 0) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }
        return res;
    }

    public static void main(String[] args) {

        L260_Single_Number_III s = new L260_Single_Number_III();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {1, 2, 3, 1, 5, 3};
        int[] res = s.singleNumber(nums);
        System.out.println(res[0] + " " + res[1]);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}