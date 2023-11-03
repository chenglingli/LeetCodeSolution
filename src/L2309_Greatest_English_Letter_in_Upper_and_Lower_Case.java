public class L2309_Greatest_English_Letter_in_Upper_and_Lower_Case {

    public String greatestLetter(String s) {
        int[][] count = new int[26][2];
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur >= 'a' && cur <= 'z') {
                count[cur - 'a'][0] = 1;
            } else {
                count[cur - 'A'][1] = 1;
            }
        }

        for (int i = 25; i >= 0; i--) {
            if (count[i][0] == 1 && count[i][1] == 1) {
                return String.valueOf((char) ('A' + i));
            }
        }

        return "";
    }

    public String greatestLetter2(String s) {

        for (char i = 'z'; i >= 'a'; i--) {
            String lowercase = Character.toString(i);
            String uppercase = Character.toString(Character.toUpperCase(i));
            if (s.contains(lowercase) && s.contains(uppercase)) {
                return uppercase;
            }
        }

        return "";
    }

    public String greatestLetter3(String s) {

        for (char i = 'z'; i >= 'a'; i--) {
            char uppercase = Character.toUpperCase(i);
            if (s.indexOf(i) != -1 && s.indexOf(uppercase) != -1) {
                return String.valueOf(uppercase);
            }
        }

        return "";
    }

    public static void main(String[] args) {

        L2309_Greatest_English_Letter_in_Upper_and_Lower_Case s =
                new L2309_Greatest_English_Letter_in_Upper_and_Lower_Case();
        long sysDate1 = System.currentTimeMillis();

        String ss = "lEeTcOdE";
        String res = s.greatestLetter(ss);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}