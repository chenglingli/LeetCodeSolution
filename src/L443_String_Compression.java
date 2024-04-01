public class L443_String_Compression {

    /*
    1 <= chars.length <= 2000
    chars[i] is a lowercase English letter,
        uppercase English letter, digit, or symbol.
     */
    public int compress(char[] chars) {

        int n = chars.length;
        int right = 0;
        int left = 0;

        while (right < n) {

            // 寻找连续的字符
            char cur = chars[right];
            int runIndex = right;
            while (runIndex < n && chars[runIndex] == cur) {
                runIndex++;
            }

            // 计算连续的个数
            int count = runIndex - right;

            // left 累加字符
            chars[left] = cur;
            left++;

            // left 累加字符数字
            if (count > 1) {
                String countStr = String.valueOf(count);
                for (char c : countStr.toCharArray()) {
                    chars[left] = c;
                    left++;
                }
            }

            // 更新right
            right = runIndex;
        }

        // 返回长度
        return left;
    }


    public static void main(String[] args) {

        L443_String_Compression s = new L443_String_Compression();

        long sysDate1 = System.currentTimeMillis();
        //        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        char[] chars = {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
        int res = s.compress(chars);
        System.out.println(res);
        for (int i = 0; i < res; i++) {
            System.out.print(chars[i]);
        }

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}