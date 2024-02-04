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
            init(s, i - 1, i, isPalindrome);
            init(s, i, i, isPalindrome);
        }

        List<List<String>> res = new ArrayList<>();
        backtrackPartition(isPalindrome, s, 0, new LinkedList<>(), res);
        return res;
    }

    private void init(String s, int i, int j, boolean[][] isPalindrome) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            isPalindrome[i][j] = true;
            i--;
            j++;
        }
    }

    private void backtrackPartition(
            boolean[][] isPalindrome,
            String s,
            int index,
            LinkedList<String> tmp,
            List<List<String>> res) {

        if (index == s.length()) {
            res.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            if (isPalindrome[index][i]) {
                tmp.addLast(s.substring(index, i + 1));
                backtrackPartition(isPalindrome, s, i + 1, tmp, res);
                tmp.removeLast();
            }
        }
    }


    public static void main(String[] args) {

        L131_Palindrome_Partitioning s = new L131_Palindrome_Partitioning();

        long sysDate1 = System.currentTimeMillis();
        List<List<String>> res = s.partition2("aabbc");

        for (List<String> l : res) {
            System.out.println(l);
        }

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}