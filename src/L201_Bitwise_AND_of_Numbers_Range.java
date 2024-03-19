
public class L201_Bitwise_AND_of_Numbers_Range {


    /*

    201. 数字范围按位与
    给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，
    返回此范围内所有数字的按位与（包含 m, n 两端点）。

    使用移位操作，找到公共前缀
    答案是 m 和 n 的公共前缀再补零

     */
    public int rangeBitwiseAnd(int left, int right) {
        int cnt = 0;

        while (left != right) {
            left >>= 1;
            right >>= 1;
            cnt++;
        }

        return left << cnt;
    }

    public static void main(String[] args) {

        L201_Bitwise_AND_of_Numbers_Range s = new L201_Bitwise_AND_of_Numbers_Range();

        long sysDate1 = System.currentTimeMillis();


        int left = 4;
        int right = 7;
        int res = s.rangeBitwiseAnd(left, right);

        System.out.println(res);
        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}