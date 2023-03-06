public class L1668_Maximum_Repeating_Substring {

    public int maxRepeating(String sequence, String word) {

        // 初步定位
        int i = sequence.indexOf(word);
        if (i == -1) {
            return 0;
        }
        i = i + word.length();

        // 数据初始化
        int wl = word.length();
        int sl = sequence.length();
        int ans = -1;

        // 循环检索
        while (i <= sl) {

            // 寻找当前重复count值
            int count = 1;
            while (i + wl <= sl && (sequence.substring(i, i + wl)).equals(word)) {
                i += wl;
                count++;
            }
            ans = Math.max(ans, count);

            // 重新准备检索
            i = i - wl + 1;

            // 重新定位（和初步定位逻辑一致）
            i = sequence.indexOf(word, i);
            if (i == -1) {
                break;
            }
            i += word.length();
        }

        // 返回结果
        return ans;
    }

    public static void main(String[] args) {

        L1668_Maximum_Repeating_Substring s = new L1668_Maximum_Repeating_Substring();
        long sysDate1 = System.currentTimeMillis();

        //        String sequence = "aaabaaaabaaabaaaabaaaabaaaabaaaaba";
        //        String word = "aaaba";

        String sequence = "a";
        String word = "a";

        //        String sequence = "baba";
        //        String word = "b";

        int res = s.maxRepeating(sequence, word);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}