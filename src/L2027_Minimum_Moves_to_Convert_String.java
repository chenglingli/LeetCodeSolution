public class L2027_Minimum_Moves_to_Convert_String {


    /*
    3 <= s.length <= 1000
    s[i] is either 'X' or 'O'.

    "XXX000"
    "XX0XX00"
    "X0XX"
    "X0XXX0X0X"
    "X0XXX0X00"
    "X0X0X0X00"
     */
    public int minimumMoves(String s) {

        int i = 0;
        int count = 0;

        char[] ch = s.toCharArray();

        while (i < s.length()) {
            while (i < s.length() && ch[i] == 'O') {
                i++;
            }

            if (i >= s.length()) {
                break;
            }
            i += 3;
            count++;
        }

        return count;
    }

    public int minimumMoves2(String s) {

        int ptr = 0;
        int rst = 0;

        char[] ch = s.toCharArray();
        while (ptr < s.length()) {
            if (ch[ptr] == 'X') {
                ptr += 3;
                rst++;
            } else {
                ptr++;
            }
        }

        return rst;
    }

    public static void main(String[] args) {

        L2027_Minimum_Moves_to_Convert_String s = new L2027_Minimum_Moves_to_Convert_String();
        long sysDate1 = System.currentTimeMillis();

        String ss = "OOOO";
        int res = s.minimumMoves(ss);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}