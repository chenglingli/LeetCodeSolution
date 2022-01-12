/**
 * 使用string build，性能会好很多，相比较string xx = xx + yy；
 * <p>
 * 实际方法很简单，就是简单模拟
 */

public class L038_Count_and_Say {

    public String countAndSay(int n) {

        String sayStr = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();

            int curCount = 1;
            char curNum = sayStr.charAt(0);

            for (int j = 1; j < sayStr.length(); j++) {
                if (sayStr.charAt(j) == curNum) {
                    curCount++;
                } else {
                    sb.append(Integer.toString(curCount));
                    sb.append(curNum);
                    curNum = sayStr.charAt(j);
                    curCount = 1;
                }
            }
            if (curCount > 0) {
                sb.append(Integer.toString(curCount));
                sb.append(curNum);
            }
            sayStr = sb.toString();
        }

        return sayStr;
    }

    public static void main(String[] args) {

        L038_Count_and_Say s = new L038_Count_and_Say();

        int val = 7;

        long sysDate1 = System.currentTimeMillis();

        String res = s.countAndSay(val);
        System.out.print("val:");
        System.out.print(val);
        System.out.print(" res: ");
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}