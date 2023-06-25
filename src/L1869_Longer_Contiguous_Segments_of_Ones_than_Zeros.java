public class L1869_Longer_Contiguous_Segments_of_Ones_than_Zeros {

    /*
    1 <= s.length <= 100
    s[i] is either '0' or '1'.
     */
    public boolean checkZeroOnes(String s) {

        int lenOne = 0;
        int lenZero = 0;
        int i = 0;
        int j = 0;
        while (i < s.length()) {
            j = i;
            while (j < s.length() && s.charAt(j) == '0') {
                j++;
            }
            lenZero = Math.max(lenZero, j - i);
            i = j;

            while (j < s.length() && s.charAt(j) == '1') {
                j++;
            }
            lenOne = Math.max(lenOne, j - i);

            i = j;
        }

        return lenOne > lenZero;
    }

    public boolean checkZeroOnes2(String s) {
        int ones = 0, zeroes = 0, maxOnes = 0, maxZeroes = 0;

        char[] arr = s.toCharArray();
        char prev = arr[0];

        for (char c : arr) {
            if (c == '1') {
                ones++;
                zeroes = 0;
                maxOnes = Math.max(maxOnes, ones);
            } else if (c == '0') {
                zeroes++;
                ones = 0;
                maxZeroes = Math.max(maxZeroes, zeroes);
            }
        }
        
        return maxOnes > maxZeroes;
    }

    public static void main(String[] args) {

        L1869_Longer_Contiguous_Segments_of_Ones_than_Zeros s = new L1869_Longer_Contiguous_Segments_of_Ones_than_Zeros();
        long sysDate1 = System.currentTimeMillis();

        //        String ss = "110100010";
        String ss = "1101";
        boolean res = s.checkZeroOnes(ss);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}