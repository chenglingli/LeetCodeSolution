public class L796_Rotate_String {

    public boolean rotateString(String s, String goal) {

        if (s.equals(goal)) {
            return true;
        }

        if (s.length() != goal.length()) {
            return false;
        }

        for (int i = 1; i < s.length(); i++) {
            String firstString = s.substring(0, i);
            String secondString = s.substring(i);

            if (goal.indexOf(secondString) == 0
                    && goal.indexOf(firstString) == s.length() - i) {
                return true;
            }
        }

        return false;
    }

    // 更为简洁实现方式
    public boolean rotateString2(String s, String goal) {

        if (s.length() != goal.length()) {
            return false;
        }

        s = s + s;
        return s.contains(goal);
    }

    public static void main(String[] args) {

        L796_Rotate_String s = new L796_Rotate_String();
        long sysDate1 = System.currentTimeMillis();

        String start = "abcde";
        String goal = "abced";
        boolean res = s.rotateString(start, goal);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}