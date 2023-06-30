public class L1903_Largest_Odd_Number_in_String {

    /*
    1 <= num.length <= 105
    num only consists of digits and does not contain any leading zeros.


    123245
    1234
     */
    public String largestOddNumber(String num) {
        int i = num.length() - 1;
        while (i >= 0) {
            if ((num.charAt(i) - '0') % 2 != 0) {
                break;
            }
            i--;
        }

        if (i < 0) {
            return "";
        }

        return num.substring(0, i + 1);
    }

    public static void main(String[] args) {

        L1903_Largest_Odd_Number_in_String s = new L1903_Largest_Odd_Number_in_String();
        long sysDate1 = System.currentTimeMillis();

        String num = "1234";

        String res = s.largestOddNumber(num);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}