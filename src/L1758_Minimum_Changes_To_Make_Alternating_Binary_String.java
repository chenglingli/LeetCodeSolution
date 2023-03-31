public class L1758_Minimum_Changes_To_Make_Alternating_Binary_String {


    /*

    1 <= s.length <= 104
    s[i] is either '0' or '1'.


    00000
    01101
    01001
    010101

     */
    public int minOperations(String s) {

        int count1 = 0; // 010101
        int count2 = 0; // 101010

        for (int i = 0; i < s.length(); i++) {

            char cur = s.charAt(i);

            if (i % 2 == 0) {
                if (cur == '1') {
                    count1++;
                }
            } else {
                if (cur == '0') {
                    count1++;
                }
            }

            if (i % 2 == 0) {
                if (cur == '0') {
                    count2++;
                }
            } else {
                if (cur == '1') {
                    count2++;
                }
            }
        }

        return Math.min(count1, count2);
    }


    public int minOperations2(String s) {
        char[] w = s.toCharArray();
        return Math.min(changes(w, 0), changes(w, 1));
    }

    public int changes(char[] w, int start) {
        int res = 0;

        for (char c : w) {
            if (c - '0' != start)
                res++;
            start = start ^ 1;
        }

        return res;
    }

    public static void main(String[] args) {

        L1758_Minimum_Changes_To_Make_Alternating_Binary_String s = new L1758_Minimum_Changes_To_Make_Alternating_Binary_String();
        long sysDate1 = System.currentTimeMillis();

        String input = "";
        int res = s.minOperations(input);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}