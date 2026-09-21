public class L1061_Lexicographically_Smallest_Equivalent_String {

    /*

    You are given two strings of the same length s1 and s2 and a string baseStr.

    We say s1[i] and s2[i] are equivalent characters.

    For example, if s1 = "abc" and s2 = "cde", then we have 'a' == 'c', 'b' == 'd', and 'c' == 'e'.
    Equivalent characters follow the usual rules of any equivalence relation:

    Reflexivity: 'a' == 'a'.
    Symmetry: 'a' == 'b' implies 'b' == 'a'.
    Transitivity: 'a' == 'b' and 'b' == 'c' implies 'a' == 'c'.

    For example, given the equivalency information from s1 = "abc" and s2 = "cde",
    "acd" and "aab" are equivalent strings of baseStr = "eed",
    and "aab" is the lexicographically smallest equivalent string of baseStr.

    Return the lexicographically smallest equivalent string of baseStr by using the equivalency information from s1 and s2.



    Example 1:
    Input: s1 = "parker", s2 = "morris", baseStr = "parser"
    Output: "makkek"
    Explanation: Based on the equivalency information in s1 and s2, we can group their characters as [m,p], [a,o], [k,r,s], [e,i].
    The characters in each group are equivalent and sorted in lexicographical order.
    So the answer is "makkek".

    Example 2:
    Input: s1 = "hello", s2 = "world", baseStr = "hold"
    Output: "hdld"
    Explanation: Based on the equivalency information in s1 and s2, we can group their characters as [h,w], [d,e,o], [l,r].
    So only the second letter 'o' in baseStr is changed to 'd', the answer is "hdld".

    Example 3:
    Input: s1 = "leetcode", s2 = "programs", baseStr = "sourcecode"
    Output: "aauaaaaada"
    Explanation: We group the equivalent characters in s1 and s2 as [a,o,e,r,s,c], [l,p], [g,t] and [d,m],
    thus all letters in baseStr except 'u' and 'd' are transformed to 'a', the answer is "aauaaaaada".


    Constraints:

    1 <= s1.length, s2.length, baseStr <= 1000
    s1.length == s2.length
    s1, s2, and baseStr consist of lowercase English letters.

     */
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        /*

        题目：
        s1[i] 与 s2[i] 等价，且等价关系满足自反、对称、传递。
        把 baseStr 中每个字符替换成其等价类里字典序最小的字符。

        解法：并查集
        26 个小写字母是节点，s1[i]-s2[i] 是边，连通分量就是一个等价类。
        union 时始终把较大的根接到较小的根上，这样根就是该类里最小的字母。
        最后把 baseStr 每个字符替换成 find 到的根。

        时间复杂度: O((n + m) * α(26)) ≈ O(n + m)，n = s1.length，m = baseStr.length
        空间复杂度: O(1)，只需要长度为 26 的 parent 数组
         */

        // 初始化 parent 数组
        int[] parent = new int[26];
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }

        // 合并等价类
        for (int i = 0; i < s1.length(); i++) {
            union(parent, s1.charAt(i) - 'a', s2.charAt(i) - 'a');
        }

        // 替换 baseStr 中的字符
        StringBuilder sb = new StringBuilder();
        for (char c : baseStr.toCharArray()) {
            sb.append((char) (find(parent, c - 'a') + 'a'));
        }

        // 返回结果
        return sb.toString();
    }

    // 找到 x 的根
    private int find(int[] parent, int x) {
        if (parent[x] == x) {
            return x;
        }

        // 返回 x 的根
        return find(parent, parent[x]);
    }

    /*
    在查询多的时候，应该更快
     */
    private int find2(int[] parent, int x) {
        if (parent[x] != x) {
            // 把 x 的根直接接到 x 的根上，路径压缩
            parent[x] = find(parent, parent[x]);
        }

        return parent[x];
    }

    // 合并 a 和 b 的等价类
    private void union(int[] parent, int a, int b) {
        // 找到 a 和 b 的根
        int pa = find(parent, a);
        int pb = find(parent, b);

        // 如果 a 和 b 已经在同一个等价类中，直接返回
        if (pa == pb) {
            return;
        }

        // 否则，把大根接到小根，根始终是字典序最小的字母
        if (pa < pb) {
            parent[pb] = pa;
        } else {
            parent[pa] = pb;
        }
    }

    public static void main(String[] args) {

        L1061_Lexicographically_Smallest_Equivalent_String s = new L1061_Lexicographically_Smallest_Equivalent_String();

        long sysDate1 = System.currentTimeMillis();

//        String s1 = "parker";
//        String s2 = "morris";
//        String baseStr = "parser";

        String s1 = "leetcode";
        String s2 = "programs";
        String baseStr = "sourcecode";

        System.out.println(s.smallestEquivalentString(s1, s2, baseStr));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}