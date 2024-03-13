public class L1598_Crawler_Log_Folder {

    /*
    1 <= logs.length <= 10^3
    2 <= logs[i].length <= 10
    logs[i] contains lowercase English letters, digits, '.', and '/'.
    logs[i] follows the format described in the statement.
    Folder names consist of lowercase English letters and digits.
     */
    public int minOperations(String[] logs) {

        int count = 0;

        for (String cur : logs) {
            if (cur.equals("../")) {
                if (count > 0) {
                    count--;
                }
            } else if (!cur.equals("./")) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        L1598_Crawler_Log_Folder s =
                new L1598_Crawler_Log_Folder();
        long sysDate1 = System.currentTimeMillis();

        String[] logs = {"d1/", "d2/", "../", "d21/", "./"};
        int res = s.minOperations(logs);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("time ");
        System.out.print(sysDate2 - sysDate1);
    }
}