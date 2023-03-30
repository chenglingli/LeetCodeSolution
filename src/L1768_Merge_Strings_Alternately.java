public class L1768_Merge_Strings_Alternately {


    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();

        int i = 0;
        int j = 0;
        while (i < word1.length() && j < word2.length()) {
            sb.append(word1.charAt(i++));
            sb.append(word2.charAt(j++));
        }

        while (i < word1.length()) {
            sb.append(word1.charAt(i++));
        }

        while (j < word2.length()) {
            sb.append(word2.charAt(j++));
        }

        return sb.toString();
    }

    public String mergeAlternately2(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int min = Math.min(word1.length(),word2.length());
        for (int i = 0; i < min; i++) {
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
        }
        return sb.append(word1.substring(min)).append(word2.substring(min)).toString();
    }


    public static void main(String[] args) {

        L1768_Merge_Strings_Alternately s = new L1768_Merge_Strings_Alternately();
        long sysDate1 = System.currentTimeMillis();

        String word1 = "abc";
        String word2 = "d";
        String res = s.mergeAlternately(word1, word2);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}