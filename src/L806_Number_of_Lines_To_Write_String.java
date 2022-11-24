import java.util.Arrays;

public class L806_Number_of_Lines_To_Write_String {

    public int[] numberOfLines(int[] widths, String s) {

        // 返回体
        int[] res = new int[2];

        // 初始化
        int curLineWidth = 0;
        int count = 1;

        // 逐个计算
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            int width = widths[cur - 'a'];

            if (curLineWidth + width > 100) {
                curLineWidth = width;
                count++;
            } else {
                curLineWidth += width;
            }
        }

        // 构造返回体
        res[0] = count;
        res[1] = curLineWidth;
        return res;
    }

    public static void main(String[] args) {

        L806_Number_of_Lines_To_Write_String s = new L806_Number_of_Lines_To_Write_String();
        long sysDate1 = System.currentTimeMillis();

        int[] widths = {4, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10
                , 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        String ss = "bbbcccdddaaa";

        //        int[] widths = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
        //                10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        //        String ss = "abcdefghijklmnopqrstuvwxyz";

        int[] res = s.numberOfLines(widths, ss);
        System.out.println(Arrays.toString(res));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}