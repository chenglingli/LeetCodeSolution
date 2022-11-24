public class L520_Detect_Capital {

    public boolean detectCapitalUse(String word) {

        int count = 0;

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) >= 'A' && word.charAt(i) <= 'Z') {
                count++;
            }
        }

        if (count == word.length()) {
            return true;
        }

        if (count == 0) {
            return true;
        }

        if (count == 1 && word.charAt(0) >= 'A' && word.charAt(0) <= 'Z') {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {

        L520_Detect_Capital s = new L520_Detect_Capital();
        long sysDate1 = System.currentTimeMillis();
        String a = "abcf";
        boolean res = s.detectCapitalUse(a);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}