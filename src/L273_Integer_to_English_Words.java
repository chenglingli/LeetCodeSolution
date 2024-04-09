public class L273_Integer_to_English_Words {

    /*
        三位一组，分别处理
     */
    public String numberToWords(int num) {

        // 处理0
        if (num == 0) {
            return "Zero";
        }

        String[] unit = {"", "Thousand", "Million", "Billion"};
        String res = "";
        int i = 0;

        while (num > 0) {
            if (num % 1000 != 0) {
                String temp = helper(num % 1000);
                res = temp + unit[i] + " " + res;
            }
            num /= 1000;
            i++;
        }

        return res;
    }

    /*
        处理三位的转化
     */
    private String helper(int num) {

        String[] unit = {"Thousand", "Hundred"};

        String[] ten = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty",
                "Sixty", "Seventy", "Eighty", "Ninety"};
        String[] one = {"", "One", "Two", "Three", "Four", "Five",
                "Six", "Seven", "Eight", "Nine"};
        String[] tenOne = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen",
                "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

        StringBuilder res = new StringBuilder();

        int a = num / 100;
        int b = num % 100;
        int c = num % 10;

        // 处理 千 位置
        if (a > 0) {
            res.append(one[a]).append(" ").append(unit[1]).append(" ");
        }

        // 处理20以上的数字，闭区间
        if (b >= 20) {
            res.append(ten[b / 10]).append(" ");
            if (c > 0) {
                res.append(one[c]).append(" ");
            }
        }
        // 处理 10 - 19，闭区间
        else if (b >= 10) {
            res.append(tenOne[b - 10]).append(" ");
        }
        // 处理 0 - 9，闭区间
        else if (b > 0) {
            res.append(one[b]).append(" ");
        }

        // 返回结果
        return res.toString().trim();
    }


    public String numberToWords2(int num) {
        return num == 0 ? "Zero" : helper2(num);
    }

    private String helper2(int num) {

        String[] belowTwenty = {
                "", "One", "Two", "Three", "Four",
                "Five", "Six", "Seven", "Eight", "Nine",
                "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen",
                "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

        String[] tens = {
                "", "", "Twenty", "Thirty", "Forty",
                "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

        StringBuilder s = new StringBuilder();

        if (num < 20) {
            s.append(belowTwenty[num]);
        } else if (num < 100) {
            s.append(tens[num / 10]).append(" ").append(belowTwenty[num % 10]);
        } else if (num < 1000) {
            s.append(helper2(num / 100)).append(" Hundred ").append(helper2(num % 100));
        } else if (num < 1000000) {
            s.append(helper2(num / 1000)).append(" Thousand ").append(helper2(num % 1000));
        } else if (num < 1000000000) {
            s.append(helper2(num / 1000000)).append(" Million ").append(helper2(num % 1000000));
        } else {
            s.append(helper2(num / 1000000000)).append(" Billion ").append(helper2(num % 1000000000));
        }

        return s.toString().trim();
    }


    public static void main(String[] args) {

        L273_Integer_to_English_Words s = new L273_Integer_to_English_Words();
        long sysDate1 = System.currentTimeMillis();

        int num = 1234567;
        String res = s.numberToWords(num);
        System.out.print(res);
        System.out.print("END");

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}