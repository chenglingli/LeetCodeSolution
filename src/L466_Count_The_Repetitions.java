public class L466_Count_The_Repetitions {
    
    /*

                        0 1    2 3 0      1    2 3 0      1    2 3 0
    S1 --------------> abacb | abacb | abacb | abacb | abacb | abacb

    repeatCount ----->    0  |   1   |   1   |   2   |   2   |   3

    Increment of
    repeatCount     ->    0  |   1   |   0   |   1   |   0   |   1

    nextIndex ------->    2  |   1   |   2   |   1   |   2   |   1
                                         ^
                                         |
                                         repetitive pattern found here (we've met 2 before)!
                                         The pattern repeated 3 times


        pattern 前面出现s2的次数：
        repeatCount[start];

        pattern部分s2出现的次数：
        可以看到nextIndex中出现了[1,2]这样的pattern，只需要知道pattern出现了多少次。
        start = 1, k = 3, n1 = 6
        // pre | a-b,a-b …… a-b| post
        // 总长度是n1
        // a-b的长度是 interval = k - start = 2
        // a-b个数是 repeat =  (n1-start) / interval = 5 / 2 = 2
        // a-b中pattern个数 pattenCount = repeatCount[k] - repeatCount[start] = 2 - 1 = 1
        // 所以总的重复个数 = repeat * pattenCount = 2 * 1 = 2

        pattern结束到S1结尾部分s2出现的次数：
        假设上面图中s1重复的字段从下标1～n1，
        可以看到nextIndex = [1,2]这个pattern是从start=1开始的，
        第一次pattern结束是下标k=3，那么就可以知道pattern结束后到S1结尾的重复次数是(n1-start) % (k-start),
        即结尾处nextIndex=[1]的部分，这个部分是和下标2部分相同的，
        所以只需要知道下标2处repeatCount的值，也就是这段中s2出现的次数。
        // 尾部下标 = start + (n1-start) % interval  = 1 +（6 - 1） % 2 = 2
        // 尾部重复次数 = repeatCount[尾部下标] - repeatCount[start] = 2 - 1 = 1

     */
    public int getMaxRepetitions3(String s1, int n1, String s2, int n2) {

        int[] next = new int[s2.length() + 1];
        int[] repeatCount = new int[s2.length() + 1];
        int j = 0, cnt = 0;

        for (int k = 1; k <= n1; k++) {

            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    j++;
                    if (j == s2.length()) {
                        j = 0;
                        cnt++;
                    }
                }
            }

            // 计算出现了k次s1中有cnt个s2，count[k] = cnt
            repeatCount[k] = cnt;
            // next[k]表示s1中出现了k次s2时，s2的下一个字符位置
            next[k] = j;

            // 如果之前出现过next[k]，说明找到了循环节
            for (int start = 0; start < k; start++) {
                //
                if (next[start] == j) {

                    // 分3部分, start之前重复次数，有重复pattern的部分pattern重复多少次，pattern后的结尾部分

                    // 第一部分，start之前重复次数
                    int preRepeat = repeatCount[start];

                    // 第二部分，有重复pattern的部分，pattern重复多少次
                    // pre | a-b,a-b …… a-b| post
                    // 总长度是n1
                    // a-b的长度是 interval = k - start
                    // a-b个数是 repeat =  (n1-start) / interval
                    // a-b中pattern个数 pattenCount = repeatCount[k] - repeatCount[start]
                    // 所以总的重复个数 = repeat * pattenCount

                    int interval = k - start;  //重复区域的长度
                    // start之前不是pattern，想看pattern重复多少次要把前面去掉
                    int repeat = (n1 - start) / interval;
                    // pattern数 * 每个pattern里重复的次数
                    int patternRepeat = repeat * (repeatCount[k] - repeatCount[start]);

                    // 第三部分，pattern后的结尾部分
                    // pre | a-b,a-b …… a-b | post
                    // 尾部长度 end = start + (n1 - start) % interval
                    int end = start + (n1 - start) % interval;
                    int postRepeat = repeatCount[end] - repeatCount[start];

                    // s2出现n次，那么s2重复n2次后会出现 n/n2次
                    return (preRepeat + patternRepeat + postRepeat) / n2;
                }
            }
        }

        // 没有循环节
        return repeatCount[n1] / n2;
    }

    /*
    最简单写法 一句话，计算 n1次重复的s1中有多少个s2，假设有count2次
    答案 = count2 / n2

    i和j分别指向s1和s2的当前字符，count1和count2分别表示s1和s2的重复次数。
    然后遍历s1，如果s1[i] == s2[j]，则j++，如果j到达s2的末尾，说明s2已经匹配完了，那么j重置为0，count2自增1。
    然后i自增1，如果i到达s1的末尾，说明s1已经匹配完了，那么i重置为0，count1自增1。

     */
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {

        char[] array1 = s1.toCharArray(), array2 = s2.toCharArray();
        int count1 = 0, count2 = 0, i = 0, j = 0;

        while (count1 < n1) {
            if (array1[i] == array2[j]) {
                j++;
                if (j == array2.length) {
                    j = 0;
                    count2++;
                }
            }
            i++;
            if (i == array1.length) {
                i = 0;
                count1++;
            }
        }

        return count2 / n2;
    }

    public static void main(String[] args) {

        L466_Count_The_Repetitions s = new L466_Count_The_Repetitions();

        long sysDate1 = System.currentTimeMillis();

//        String s1 = "acb", s2 = "ab";
//        int n1 = 4, n2 = 2;

        String s1 = "abacb", s2 = "bcaa";
        int n1 = 6, n2 = 1;
        int res = s.getMaxRepetitions3(s1, n1, s2, n2);
        System.out.println(res);


        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}