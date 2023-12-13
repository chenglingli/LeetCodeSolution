public class L2451_Odd_String_Difference {

    /*
    3 <= words.length <= 100
    n == words[i].length
    2 <= n <= 20
    words[i] consists of lowercase English letters.
     */
    public String oddString(String[] words) {

        // 初始化
        int n = words[0].length();
        int count = words.length;
        int[][] diff = new int[count][n - 1];

        // 计算diff
        int i = 0;
        for (String cur : words) {
            for (int j = 1; j < n; j++) {
                diff[i][j - 1] = cur.charAt(j) - cur.charAt(j - 1);
            }
            i++;
        }

        // 寻找 standard
        int stand = -1;
        // a a x x x
        if (equal(diff[0], diff[1])) {
            stand = 0;
        } else {
            // a b a a a
            if (equal(diff[0], diff[2])) {
                stand = 0;
            }
            // a b b b b
            else {
                stand = 1;
            }
        }

        // 寻找差异化
        for (int j = 1; j < count; j++) {
            if (!equal(diff[j], diff[stand])) {
                return words[j];
            }
        }

        // 兜底返回
        return words[0];
    }

    /**
     * 判断 数组是否相等
     */
    private boolean equal(int[] a, int[] b) {
        int i = 0;
        while (i < a.length) {
            if (a[i] != b[i]) {
                return false;
            }
            i++;
        }

        return true;
    }

    public String oddString2(String[] words) {

        int[][] arr = new int[2][words[0].length() + 2];
        for (int i = 1; i < words[0].length(); i++) {
            arr[0][i + 2] = words[0].charAt(i) - words[0].charAt(i - 1);
        }

        arr[0][0] = 1;
        for (int i = 1; i < words.length; i++) {
            arr[0][0]++;
            for (int j = 1; j < words[0].length(); j++) {
                if (arr[0][j + 2] != words[i].charAt(j) - words[i].charAt(j - 1)) {
                    arr[0][0]--;
                    arr[1][0]++;
                    arr[1][1] = i;
                    break;
                }
            }
            if ((arr[0][0] == 1 && arr[1][0] >= 2)
                    || (arr[0][0] >= 2 && arr[1][0] == 1)) {
                if (arr[0][0] > arr[1][0]) {
                    return words[arr[1][1]];
                }
                return words[arr[0][1]];
            }
        }

        return "";
    }

    public static void main(String[] args) {

        L2451_Odd_String_Difference s = new L2451_Odd_String_Difference();
        long sysDate1 = System.currentTimeMillis();

        String[] words = {"aaa", "bob", "ccc", "ddd"};
        String res = s.oddString(words);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}