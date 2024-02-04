public class L1790_Check_if_One_String_Swap_Can_Make_Strings_Equal {

    /*
    1 <= s1.length, s2.length <= 100
    s1.length == s2.length
    s1 and s2 consist of only lowercase English letters.
     */
    public boolean areAlmostEqual(String s1, String s2) {

        if (s1.equals(s2)) {
            return true;
        }

        int i = 0;
        int[] diff = new int[2];
        int diffCount = 0;
        while (i < s1.length()) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (diffCount >= 2) {
                    return false;
                }
                diff[diffCount++] = i;
            }
            i++;
        }
        if (diffCount != 2) {
            return false;
        }
        if (s1.charAt(diff[0]) == s2.charAt(diff[1]) &&
                s1.charAt(diff[1]) == s2.charAt(diff[0])) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {

        L1790_Check_if_One_String_Swap_Can_Make_Strings_Equal s = new L1790_Check_if_One_String_Swap_Can_Make_Strings_Equal();
        long sysDate1 = System.currentTimeMillis();

        String s1 = "abc";
        String s2 = "def";
        boolean res = s.areAlmostEqual(s1, s2);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}