public class L1081_Smallest_Subsequence_of_Distinct_Characters {

    public String smallestSubsequence(String s) {
        int[] frequency = new int[26];
        boolean[] seen = new boolean[26];
        char[] ans = new char[26];
        int size = 0;

        for (char c : s.toCharArray()) {
            frequency[c - 'a']++;
        }

        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            if (seen[idx]) {
                frequency[idx]--;
                continue;
            }

            // 如果栈不为空，且栈顶元素大于当前元素，且栈顶元素在后面还会出现
            while (size != 0
                    && frequency[ans[size - 1] - 'a'] > 0
                    && ans[size - 1] > c) {
                size--;
                seen[ans[size] - 'a'] = false;
            }

            frequency[idx]--;
            ans[size] = c;
            size++;
            seen[c - 'a'] = true;
        }

        return new String(ans, 0, size);
    }

    public static void main(String[] args) {

        L1081_Smallest_Subsequence_of_Distinct_Characters s = new L1081_Smallest_Subsequence_of_Distinct_Characters();

        long sysDate1 = System.currentTimeMillis();

        String ss = "cbacdcbc";
        String res = s.smallestSubsequence(ss);

        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}