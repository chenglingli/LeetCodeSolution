public class L214_Shortest_Palindrome {

    /*
    1. 本身是回文，则啥也不用加

    2. 部分是回文，分3种情况
        1.  [i j] [l m] [...] s2
        2.  s1 [i j] [l m] [...] s2
        3.  s1 [i j] [l m] [...]

    所以，我们从前往后找，找到以第一个字符开始的最长回文串，然后将剩下的部分翻转加到前面即可

    执行方式是，从后往前看，看是否满足回文，如果满足，那么就找到了以第一个字符开始的最长回文串

    */
    public String shortestPalindrome(String s) {

        int n = s.length();

        // 寻找以第一个字符开始的最长回文串
        int j = n - 1;
        while (j >= 0) {
            if (isPalindrome(s, 0, j)) {
                break;
            }
            j--;
        }

        // 组装非首回文串的部分（翻转）
        StringBuilder sb = new StringBuilder();
        for (int i = n - 1; i > j; i--) {
            sb.append(s.charAt(i));
        }

        // 组装剩下的部分
        sb.append(s);


        // 返回结果
        return sb.toString();
    }

    /*
    判断是否是回文
     */
    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }


    public String shortestPalindrome2(String s) {
        char[] arr = s.toCharArray();

        StringBuilder sb = new StringBuilder();
        helper(arr, arr.length, sb);
        return sb.toString();
    }

    /*
    递归的方式

    My thought is:
    1. if s is palindrome, after the loop, j will be j == s.length(),
    then, we just need to return this palindrome string.

    2. if s overall is not palindrome,
        first, j will definitely be smaller than s.length(),
        this is very import to ensure the recursion will terminate at the base case -
        palindrome found or empty string found,
        we will definitely cut the string “s” into two parts.
        if s has some precedine substring to be palindrome, like “abbacdefg”,
        j will definitely end with somewhere after the “sub” palindrome - “abba”.
       Thus, it is still safe for us to cut into two parts.

    Thus, this method works.

    如果本身是一个回文串，则i遍历后 == len
    如果本身不是一个回文串，但存在以首字母为回文的子串，譬如
    abba cdefg
    则，i会停在 cdefg 的某处，譬如 d
    那么我们可以先append efg（反序），然后继续处理 abbacd

     */
    private void helper(char[] arr, int n, StringBuilder sb) {

        int i = 0;

        // 找到以第一个字符开始的最长回文串
        for (int j = n - 1; j >= 0; j--) {
            if (arr[j] == arr[i]) {
                i++;
            }
        }

        if (i == n) {
            sb.append(arr, 0, n);
            return;
        }
        // 非首回文串的部分
        for (int j = n - 1; j >= i; j--) {
            sb.append(arr[j]);
        }

        // 递归, 找到以第一个字符开始的最长回文串
        helper(arr, i, sb);

        // 剩下的部分
        sb.append(arr, i, n - i);
    }


    /*
    递归的方式

     */
    public String shortestPalindrome3(String s) {
        int i = 0;
        int n = s.length();
        for (int j = n - 1; j >= 0; j--) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
            }
        }
        if (i == n) {
            return s;
        }

        StringBuilder rev = new StringBuilder();

        rev.append(s.substring(i, n));
        rev.reverse();
        rev.append(shortestPalindrome3(s.substring(0, i)));
        rev.append(s.substring(i, n));

        return rev.toString();
    }


    public static void main(String[] args) {

        L214_Shortest_Palindrome s = new L214_Shortest_Palindrome();
        long sysDate1 = System.currentTimeMillis();

//        String input = "abcbaefefff";
//        String input = "aacecaaa";
//        String input = "abbacdefg";
        String input = "adcba";

        String res = s.shortestPalindrome2(input);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}