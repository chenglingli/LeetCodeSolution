public class L1784_Check_if_Binary_String_Has_at_Most_One_Segment_of_Ones {


    /*
    1 <= s.length <= 100
    s[i] is either '0' or '1'.
    s[0] is '1'.

    110
    10110
    10001
    10000
    101111011110

     */
    public boolean checkOnesSegment(String s) {
        int i = 0;
        while (i < s.length() && s.charAt(i) == '1') {
            i++;
        }

        while (i < s.length() && s.charAt(i) == '0') {
            i++;
        }

        return i == s.length();
    }

    public static void main(String[] args) {

        L1784_Check_if_Binary_String_Has_at_Most_One_Segment_of_Ones s = new L1784_Check_if_Binary_String_Has_at_Most_One_Segment_of_Ones();
        long sysDate1 = System.currentTimeMillis();

        String word1 = "1000010";
        boolean res = s.checkOnesSegment(word1);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}