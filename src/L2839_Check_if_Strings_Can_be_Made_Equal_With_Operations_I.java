public class L2839_Check_if_Strings_Can_be_Made_Equal_With_Operations_I {

    public boolean canBeEqual(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }

        if (s1.charAt(0) == s2.charAt(2)
                && s1.charAt(2) == s2.charAt(0)
                && s1.charAt(1) == s2.charAt(1) &&
                s1.charAt(3) == s2.charAt(3)) {
            return true;
        }

        if (s1.charAt(0) == s2.charAt(0)
                && s1.charAt(2) == s2.charAt(2)
                && s1.charAt(1) == s2.charAt(3) &&
                s1.charAt(3) == s2.charAt(1)) {
            return true;
        }

        if (s1.charAt(0) == s2.charAt(2)
                && s1.charAt(2) == s2.charAt(0)
                && s1.charAt(1) == s2.charAt(3) &&
                s1.charAt(3) == s2.charAt(1)) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {

        L2839_Check_if_Strings_Can_be_Made_Equal_With_Operations_I s = new L2839_Check_if_Strings_Can_be_Made_Equal_With_Operations_I();
        long sysDate1 = System.currentTimeMillis();


        String input1 = "cbad";
        String input2 = "abcd";

        boolean res = s.canBeEqual(input1, input2);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}