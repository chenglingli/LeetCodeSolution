public class L1945_Sum_of_Digits_of_String_After_Convert {


    /*
    1 <= s.length <= 100
    1 <= k <= 10
     */
    public int getLucky(String s, int k) {

        int curValue = 0;

        for (char ch : s.toCharArray())
            curValue += getValue(ch);

        for (int i = 1; i < k; i++)
            curValue = countValue(curValue);

        return curValue;
    }

    private int getValue(char ch) {
        int x = ch - 'a' + 1;
        return (x / 10) + (x % 10);
    }

    private int countValue(int v) {
        int res = 0;

        while (v > 0) {
            res += v % 10;
            v /= 10;
        }

        return res;
    }

    public static void main(String[] args) {

        L1945_Sum_of_Digits_of_String_After_Convert s = new L1945_Sum_of_Digits_of_String_After_Convert();
        long sysDate1 = System.currentTimeMillis();

        String input = "leetcode";
        int k = 2;
        int res = s.getLucky(input, k);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}