public class L1957_Delete_Characters_to_Make_Fancy_String {


    public String makeFancyString(String s) {

        if (s.length() < 3) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        sb.append(s.charAt(1));

        int i = 2;
        while (i < s.length()) {

            while (i < s.length()
                    && s.charAt(i) == sb.charAt(sb.length() - 1)
                    && s.charAt(i) == sb.charAt(sb.length() - 2)) {
                i++;
            }

            if (i < s.length()) {
                sb.append(s.charAt(i));
                i++;
            }
        }

        return sb.toString();
    }

    public String makeFancyString2(String s) {

        if (s.length() < 3) return s;

        char[] newChars = new char[s.length()];
        int i = 0;
        char c = s.charAt(0);
        char c1 = s.charAt(1);

        char[] chars = s.toCharArray();

        newChars[i++] = c;
        newChars[i++] = c1;

        for (int j = 2; j < chars.length; j++) {
            char c2 = chars[j];

            if (c == c1 && c1 == c2) {
                continue;
            }

            c = c1;
            c1 = c2;
            newChars[i++] = c2;
        }

        char[] newChars1 = new char[i];
        System.arraycopy(newChars, 0, newChars1, 0, i);
        return new String(newChars1);
    }

    public static void main(String[] args) {

        L1957_Delete_Characters_to_Make_Fancy_String s = new L1957_Delete_Characters_to_Make_Fancy_String();
        long sysDate1 = System.currentTimeMillis();

        String input = "123123333";
        String res = s.makeFancyString(input);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}