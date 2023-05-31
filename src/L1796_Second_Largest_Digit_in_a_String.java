public class L1796_Second_Largest_Digit_in_a_String {


    public int secondHighest(String s) {

        int[] mark = new int[10];

        for (char c : s.toCharArray()) {
            if (c <= '9' && c >= '0') {
                mark[c - '0'] = 1;
            }
        }

        int i = 9;
        while (i >= 0) {
            if (mark[i] == 1) {
                break;
            }
            i--;
        }
        i--;
        if (i < 0) {
            return -1;
        }

        while (i >= 0) {
            if (mark[i] == 1) {
                break;
            }
            i--;
        }

        return i;
    }

    public static void main(String[] args) {

        L1796_Second_Largest_Digit_in_a_String s = new L1796_Second_Largest_Digit_in_a_String();
        long sysDate1 = System.currentTimeMillis();

        String word1 = "dfa12321afd";
        int res = s.secondHighest(word1);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}