
public class L076_Minimum_Window_Substring {

    public String minWindow(String s, String t) {

        // t塞入字典统计
        int[] cnt = new int[128];
        for (char c : t.toCharArray()) {
            cnt[c]++;
        }
        int total = t.length();

        // 初始化变量
        int m = s.length();
        int from = 0;
        int min = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;
        while (i < m) {

            // i位置字符加入，总count-1
            if (cnt[s.charAt(i)] > 0) {
                total--;
            }
            cnt[s.charAt(i)]--;

            // 更新最短长度
            while (total == 0) {
                if (i - j + 1 < min) {
                    min = i - j + 1;
                    from = j;
                }

                // j位置字符释放出来
                cnt[s.charAt(j)]++;
                if (cnt[s.charAt(j)] > 0) {
                    total++;
                }
                j++;
            }

            i++;
        }

        // 返回结果
        if (min == Integer.MAX_VALUE) {
            return "";
        } else {
            return s.substring(from, from + min);
        }
    }


    public static void main(String[] args) {

        L076_Minimum_Window_Substring s = new L076_Minimum_Window_Substring();

        long sysDate1 = System.currentTimeMillis();
        String ss = "ADOBECODEBANC";
        String tt = "ABC";
        String res = s.minWindow(ss, tt);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}