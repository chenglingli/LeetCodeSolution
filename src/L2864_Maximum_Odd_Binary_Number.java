public class L2864_Maximum_Odd_Binary_Number {

    /*
    1 <= s.length <= 100
    s consists only of '0' and '1'.
    s contains at least one '1'.
     */
    public String maximumOddBinaryNumber(String s) {

        StringBuilder res = new StringBuilder();

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                res.append('1');
                count++;
            }
        }

        int countZero = s.length() - count;
        for (int i = 0; i < countZero; i++) {
            res.insert(res.length() - 1, '0');
        }

        return res.toString();
    }

    public String maximumOddBinaryNumber2(String s) {

        StringBuilder sb = new StringBuilder();

        int n = s.length();
        int onesCount = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                onesCount += 1;
            }
        }

        int zeroesCount = n - onesCount;

        if (onesCount >= 2) {
            while (onesCount > 1) {
                sb.append('1');
                onesCount--;
            }

        }
        
        while (zeroesCount > 0) {
            sb.append('0');
            zeroesCount--;
        }

        sb.append('1');

        return sb.toString();
    }

    public static void main(String[] args) {

        L2864_Maximum_Odd_Binary_Number s = new L2864_Maximum_Odd_Binary_Number();
        long sysDate1 = System.currentTimeMillis();


        //        String input = "0101";
        String input = "0111101";
        String res = s.maximumOddBinaryNumber(input);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}