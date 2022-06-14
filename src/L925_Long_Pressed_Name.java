public class L925_Long_Pressed_Name {

    public boolean isLongPressedName(String name, String typed) {

        int j = 0;

        for (int i = 0; i < name.length(); ) {
            char cur = name.charAt(i);
            int curIndex = i;
            while (i < name.length() && name.charAt(i) == cur) {
                i++;
            }
            int curDur = i - curIndex;

            int curIndexJ = j;
            if (j < typed.length() && typed.charAt(j) != cur) {
                return false;
            }
            while (j < typed.length() && typed.charAt(j) == cur) {
                j++;
            }
            int curDurJ = j - curIndexJ;

            if (curDurJ < curDur) {
                return false;
            }
        }

        if (j != typed.length()) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {

        L925_Long_Pressed_Name s = new L925_Long_Pressed_Name();
        long sysDate1 = System.currentTimeMillis();

        // boolean res = s.isLongPressedName("alex", "aaleex");
        boolean res = s.isLongPressedName("a", "aaaf");
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}