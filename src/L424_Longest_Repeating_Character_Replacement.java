public class L424_Longest_Repeating_Character_Replacement {


    /*
    1 <= s.length <= 10^5
    s consists of only uppercase English letters.
    0 <= k <= s.length
     */
    public int characterReplacement(String s, int k) {

        int n = s.length();
        int[] count = new int[26];
        char[] sArray = s.toCharArray();

        int l = 0, r = 0;
        int res = 0;
        int maxCount = 0;

        while (r < n) {

            // 计算当前窗口内出现次数最多的字母
            int curRLetter = sArray[r] - 'A';
            count[curRLetter]++;
            maxCount = Math.max(maxCount, count[curRLetter]);

            // 判断当前窗口内出现最多的字符是否成为目标字符
            if (r - l + 1 - maxCount > k) {
                count[sArray[l] - 'A']--;
                l++;
            }

            // 更新结果
            res = Math.max(res, r - l + 1);
            // System.out.println("l: " + l + " r: " + r + " res: " + res);

            // 右指针右移
            r++;
        }

        // 返回结果
        return res;
    }


    /*
    优化结果，实际上不用实时计算res，只要记录最后的l，然后n-l即可
     */
    public int characterReplacement2(String s, int k) {

        int[] arr = new int[26];
        char[] ans = s.toCharArray();
        int n = ans.length;
        int left = 0;
        int max = 0;

        for (int right = 0; right < n; right++) {

            arr[ans[right] - 'A']++;
            max = Math.max(max, arr[ans[right] - 'A']);

            while ((right - left + 1) - max > k) {
                arr[ans[left++] - 'A']--;
            }
        }

        return ans.length - left;
    }

    public static void main(String[] args) {

        L424_Longest_Repeating_Character_Replacement s = new L424_Longest_Repeating_Character_Replacement();
        long sysDate1 = System.currentTimeMillis();

        String input = "AABABBA";
        int k = 1;
        int res = s.characterReplacement(input, k);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}