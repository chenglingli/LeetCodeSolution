public class L383_Ransom_Note {

    public boolean canConstruct(String ransomNote, String magazine) {

        int[] letterCount = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            letterCount[magazine.charAt(i) - 'a']++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            char cur = ransomNote.charAt(i);
            if (letterCount[cur - 'a'] > 0) {
                letterCount[cur - 'a']--;
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean canConstruct2(String ransomNote, String magazine) {

        int[] left = new int[26];
        int totalLeft = ransomNote.length();

        for (int i = 0; i < ransomNote.length(); i += 1) {
            left[ransomNote.charAt(i) - 'a'] += 1;
        }

        for (int i = 0; i < magazine.length(); i += 1) {
            if (left[magazine.charAt(i) - 'a'] == 0) {
                continue;
            }

            left[magazine.charAt(i) - 'a'] -= 1;
            totalLeft -= 1;

            if (totalLeft == 0) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        L383_Ransom_Note s = new L383_Ransom_Note();
        long sysDate1 = System.currentTimeMillis();

        String a = "loveleetcode";
        String b = "loveleetcode";
        boolean res = s.canConstruct(a, b);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}