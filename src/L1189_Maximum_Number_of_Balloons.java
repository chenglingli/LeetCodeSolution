public class L1189_Maximum_Number_of_Balloons {


    public int maxNumberOfBalloons(String text) {
        // balloon
        /*
        a - 1
        b - 1
        l - 2
        o - 2
        n - 1
         */

        char[] textArray = text.toCharArray();
        int[] count = new int[26];
        for (char c : textArray) {
            count[c - 'a']++;
        }

        int ans = count[0];
        ans = Math.min(count['b' - 'a'], ans);
        ans = Math.min(count['l' - 'a'] / 2, ans);
        ans = Math.min(count['o' - 'a'] / 2, ans);
        ans = Math.min(count['n' - 'a'], ans);

        return ans;
    }

    public static void main(String[] args) {

        L1189_Maximum_Number_of_Balloons s = new L1189_Maximum_Number_of_Balloons();
        long sysDate1 = System.currentTimeMillis();

        String text = "loonbalxballpoon";
        int res = s.maxNumberOfBalloons(text);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}