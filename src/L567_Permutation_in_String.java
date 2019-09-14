public class L567_Permutation_in_String {

    /**
     * Given two strings s1 and s2, write a function to return true
     * if s2 contains the permutation of s1. In other words,
     * one of the first string's permutations is the substring of the second string.
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: s1 = "ab" s2 = "eidbaooo"
     * Output: True
     * Explanation: s2 contains one permutation of s1 ("ba").
     * <p>
     * <p>
     * Example 2:
     * <p>
     * Input:s1= "ab" s2 = "eidboaoo"
     * Output: False
     */
    // 做dict，滑动窗口
    public boolean checkInclusion(String s1, String s2) {
        if (s2 == null || s2.length() == 0) {
            return s2.equals(s1);
        }
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] s1map = new int[26];
        int[] s2map = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1map[s1.charAt(i) - 'a']++;
            s2map[s2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (match(s1map, s2map)) {
                return true;
            }
            // if don't match, we move the sliding window
            // remove the preceding character and add a new succeeding character to the new window
            s2map[s2.charAt(i + s1.length()) - 'a']++;
            s2map[s2.charAt(i) - 'a']--;
        }
        return match(s1map, s2map);
    }

    public boolean match(int[] arr1, int[] arr2) {
        for (int i = 0; i < 26; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

//    全排列，超时
//    private void swap(char[] charArray,int i,int j)
//    {
//        char temp = charArray[i];
//        charArray[i] = charArray[j];
//        charArray[j] = temp;
//    }
//
//    public void permutation(char[] s, int start, List<String> stringArrays) {
//
//        if (start > s.length - 1) {
//            return;
//        }
//        if (start == s.length - 1) {
//            stringArrays.add(String.valueOf(s));
//            return;
//        }
//        for (int i = start; i < s.length; i++) {
//            swap(s, i, start);
//            permutation(s, start + 1, stringArrays);
//            swap(s, i, start);
//        }
//    }
//
//    public boolean checkInclusion2(String s1, String s2) {
//
//        if (s2 == null || s2.length() == 0) {
//            return s2.equals(s1);
//        }
//        if (s1.length() > s2.length()) {
//            return false;
//        }
//
//        char[] s1Copy = s1.toCharArray();
//        List<String> stringArrays = new ArrayList<>();
//        permutation(s1Copy, 0, stringArrays);
//
//        for (String stringArray : stringArrays) {
//            if (s2.contains(stringArray)) {
//                return true;
//            }
//        }
//        return false;
//    }

    public static void main(String[] args) {

        L567_Permutation_in_String s = new L567_Permutation_in_String();
        long sysDate1 = System.currentTimeMillis();

        String s1 = "abc";
        String s2 = "cabasdas";
        boolean res = s.checkInclusion(s1, s2);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}