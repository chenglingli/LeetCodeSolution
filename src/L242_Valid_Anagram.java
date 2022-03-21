public class L242_Valid_Anagram {

    public boolean isAnagram2(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }
        int[] ocupied = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            int index = t.indexOf(temp);

            if (index == -1) {
                return false;
            } else {
                while (index != -1 && ocupied[index] != 0) {
                    index = t.indexOf(temp, index + 1);
                }
                if (index == -1) {
                    return false;
                } else {
                    ocupied[index] = 1;
                }
            }
        }

        return true;
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] counts = new int['z' + 1];

        for (char c : s.toCharArray()) {
            counts[c]++;
        }

        for (char c : t.toCharArray()) {
            counts[c]--;
        }

        for (int i = 'a'; i < 'z'; i++) {
            if (counts[i] != 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {

        L242_Valid_Anagram s = new L242_Valid_Anagram();

        long sysDate1 = System.currentTimeMillis();

        String x = "aad";
        //String y = "nagaram";
        String y = "cab";

        boolean res = s.isAnagram(x, y);

        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}