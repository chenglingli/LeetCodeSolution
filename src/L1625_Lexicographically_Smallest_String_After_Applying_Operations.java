import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Set;

public class L1625_Lexicographically_Smallest_String_After_Applying_Operations {


    /*

    You are given a string s of even length consisting of digits from 0 to 9, and two integers a and b.

    You can apply either of the following two operations any number of times and in any order on s:

    Add a to all odd indices of s (0-indexed). Digits post 9 are cycled back to 0. For example, if s = "3456" and a = 5, s becomes "3951".
    Rotate s to the right by b positions. For example, if s = "3456" and b = 1, s becomes "6345".
    Return the lexicographically smallest string you can obtain by applying the above operations any number of times on s.

    A string a is lexicographically smaller than a string b (of the same length) if in the first position where a and b differ,
    string a has a letter that appears earlier in the alphabet than the corresponding letter in b. For example,
    "0158" is lexicographically smaller than "0190" because the first position they differ is at the third letter, and '5' comes before '9'.



    Example 1:

    Input: s = "5525", a = 9, b = 2
    Output: "2050"

    Explanation: We can apply the following operations:
    Start:  "5525"
    Rotate: "2555"
    Add:    "2454"
    Add:    "2353"
    Rotate: "5323"
    Add:    "5222"
    Add:    "5121"
    Rotate: "2151"
    Add:    "2050"
    There is no way to obtain a string that is lexicographically smaller than "2050".

    Example 2:
    Input: s = "74", a = 5, b = 1
    Output: "24"

    Explanation: We can apply the following operations:
    Start:  "74"
    Rotate: "47"
    ​​Add:    "42"
    ​​Rotate: "24"​​
    There is no way to obtain a string that is lexicographically smaller than "24".

    Example 3:

    Input: s = "0011", a = 4, b = 2
    Output: "0011"
    Explanation: There are no sequence of operations that will give us a lexicographically smaller string than "0011".


    Constraints:
    2 <= s.length <= 100
    s.length is even.
    s consists of digits from 0 to 9 only.
    1 <= a <= 9
    1 <= b <= s.length - 1

     */
    public String findLexSmallestString(String s, int a, int b) {
        /*
        题意：
        对于一个由纯数字组成的字符串，且是偶数位
        可以做两个操作，已达到数字上最小值
        操作1，对奇数位做加a操作，如果超过9，则循环到0
        操作2，对整个字符串做右移b位

        分析：
        假设s长度为l，根据l和b的关系，可以知道哪些位置可以被调整
        对于特定的某一位，无数次加a后，可以知道最小值是多少

        问题：
        怎么判断当前值是可能的最小值呢?

        解法：
        两个操作都会循环，能到达的字符串很少，全部搜出来取字典序最小即可。
        加法一次作用在所有奇数位上（模 10），同一串最多走出 10 种；右旋 b 位，转若干次回到原点。
        b 为偶数时，奇偶位置不会对调，偶数位数字改不了。
        b 为奇数时，转一次奇偶对调，原来的偶数位也能被加到。
        状态数最多大约 n * 10 * 10，用队列 + set 去重即可。

         */

        Set<String> visited = new HashSet<>();
        ArrayDeque<String> queue = new ArrayDeque<>();
        visited.add(s);
        queue.add(s);
        String min = s;

        while (!queue.isEmpty()) {

            // 取出队列中的第一个字符串
            String cur = queue.poll();
            // 如果当前字符串的字典序小于最小值，则更新最小值
            if (cur.compareTo(min) < 0) {
                min = cur;
            }

            // 对奇数位做加a操作
            String added = addOdd(cur, a);
            // 如果这个字符串没有被访问过，则加入队列
            if (visited.add(added)) {
                queue.add(added);
            }

            // 对整个字符串做右移b位
            String rotated = rotateRight(cur, b);
            // 如果这个字符串没有被访问过，则加入队列
            if (visited.add(rotated)) {
                queue.add(rotated);
            }
        }

        return min;
    }

    private String addOdd(String s, int a) {
        char[] arr = s.toCharArray();
        for (int i = 1; i < arr.length; i += 2) {
            arr[i] = (char) ('0' + (arr[i] - '0' + a) % 10);
        }
        return new String(arr);
    }

    private String rotateRight(String s, int b) {
        return s.substring(s.length() - b) + s.substring(0, s.length() - b);
    }


    public String findLexSmallestString2(String S, int a, int b) {
        char[] s = S.toCharArray();
        int n = s.length;
        int step = gcd(b, n);
        int g = gcd(a, 10);
        String ans = S;

        // 对每个位置进行操作
        for (int i = 0; i < n; i += step) {

            // 对整个字符串做右移b位
            char[] t = rotate(s, i, n);

            // 对奇数位做加a操作
            optimizeDigits(t, 1, g);
            
            // 如果step是奇数，则对偶数位做加a操作
            if (step % 2 == 1) {
                optimizeDigits(t, 0, g);
            }

            // 生成新的字符串   
            String candidate = new String(t);
            // 如果新的字符串的字典序小于最小值，则更新最小值
            if (candidate.compareTo(ans) < 0) {
                ans = candidate;
            }
        }

        return ans;
    }

    // 对整个字符串做右移b位
    private char[] rotate(char[] s, int start, int n) {
        char[] rotated = new char[n];
        System.arraycopy(s, start, rotated, 0, n - start);
        System.arraycopy(s, 0, rotated, n - start, start);
        return rotated;
    }

    // 对奇数位做加a操作
    private void optimizeDigits(char[] t, int start, int g) {
        // 获取第一个数字
        int firstDigit = t[start] - '0';
        // 获取最小值
        int minValue = firstDigit % g;
        // 计算增量
        int inc = (minValue - firstDigit + 10) % 10;
        
        // 对奇数位做加a操作
        for (int j = start; j < t.length; j += 2) {
            t[j] = (char) ('0' + (t[j] - '0' + inc) % 10);
        }
    }

    // 计算最大公约数
    private int gcd(int a, int b) {
        while (a != 0) {
            int temp = a;
            a = b % a;
            b = temp;
        }
        return b;
    }



    public static void main(String[] args) {

        L1625_Lexicographically_Smallest_String_After_Applying_Operations s = new L1625_Lexicographically_Smallest_String_After_Applying_Operations();
        long sysDate1 = System.currentTimeMillis();

        String ss = "5525";
        int a = 9;
        int b = 2;

        String res = s.findLexSmallestString(ss, a, b);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}