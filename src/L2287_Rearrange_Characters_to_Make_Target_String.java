import javax.swing.text.MaskFormatter;

public class L2287_Rearrange_Characters_to_Make_Target_String {

    /*
    1 <= s.length <= 100
    1 <= target.length <= 10
    s and target consist of lowercase English letters.
     */
    public int rearrangeCharacters(String s, String target) {
        int[] count = new int[26];
        for (int i = 0 ; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        int[] targetCount = new int[26];
        for (int i = 0 ; i < target.length(); i++) {
            targetCount[target.charAt(i) - 'a']++;
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0 ; i < 26 ; i++) {
            if (targetCount[i] != 0) {
                ans = Math.min(ans, count[i] / targetCount[i]);
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        L2287_Rearrange_Characters_to_Make_Target_String s =
                new L2287_Rearrange_Characters_to_Make_Target_String();
        long sysDate1 = System.currentTimeMillis();

        String ss = "ilovecodingonleetcode";
        String target = "code";
        int res = s.rearrangeCharacters(ss, target);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}