import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class L131_Palindrome_Partitioning {

    public List<List<String>> partition(String s) {

        List<List<String>> rt = new ArrayList<List<String>>();

        if ("".equals(s)) {
            return rt;
        }

        if (s.length() == 1) {
            rt.add(Arrays.asList(s));
            return rt;
        }

        for (int i = 0; i < s.length(); i++) {

            String x = s.substring(0, i + 1);
            List<List<String>> sub = new ArrayList<List<String>>();

            if (isPal(x)) {
                sub = partition(s.substring(i + 1));

                if (sub.isEmpty()) {
                    rt.add(Arrays.asList(x));
                } else {
                    for (List<String> l : sub) {
                        List<String> _l = new ArrayList<String>();
                        _l.add(x);
                        _l.addAll(l);
                        rt.add(_l);
                    }
                }
            }
        }

        return rt;
    }

    static boolean isPal(String s) {

        int st = 0, ed = s.length() - 1;
        while (st < ed) {
            if (s.charAt(st++) != s.charAt(ed--)) {
                return false;
            }
        }
        return true;
    }


    public List<List<String>> partition2(String s) {
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        isPalindrome[0][0] = true;
        for (int i = 1; i < s.length(); i++) {
            expand(s, i - 1, i, isPalindrome);
            expand(s, i, i, isPalindrome);
        }
        List<List<String>> palindromes = new ArrayList<>();
        partition(isPalindrome, s, 0, new LinkedList<>(), palindromes);
        return palindromes;
    }

    private void expand(String s, int i, int j, boolean[][] isPalindrome) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            isPalindrome[i][j] = true;
            i--;
            j++;
        }
    }

    private void partition(
            boolean[][] isPalindrome,
            String s, int index,
            LinkedList<String> palindrome,
            List<List<String>> palindromes) {
        if (index == s.length()) {
            palindromes.add(new ArrayList<>(palindrome));
        } else {
            for (int i = index; i < s.length(); i++) {
                if (isPalindrome[index][i]) {
                    palindrome.addLast(s.substring(index, i + 1));
                    partition(isPalindrome, s, i + 1, palindrome, palindromes);
                    palindrome.removeLast();
                }
            }
        }
    }

    public static void main(String[] args) {

        L131_Palindrome_Partitioning s = new L131_Palindrome_Partitioning();

        long sysDate1 = System.currentTimeMillis();
        List<List<String>> res = s.partition("aabbc");

        for (List<String> l : res) {
            System.out.println(l);
        }

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}