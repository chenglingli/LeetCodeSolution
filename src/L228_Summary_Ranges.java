import java.util.ArrayList;
import java.util.List;

public class L228_Summary_Ranges {

    public List<String> summaryRanges(int[] nums) {

        List<String> res = new ArrayList<>();

        if (nums == null || nums.length <= 0) {
            return res;
        }

        if (nums.length == 1) {
            res.add(String.valueOf(nums[0]));
            return res;
        }

        int start = nums[0];

        for (int i = 1; i < nums.length; i++) {

            // 加入结果集
            if (nums[i] - nums[i - 1] != 1) {
                if (start == nums[i - 1]) {
                    res.add(String.valueOf(start));
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append(start);
                    sb.append("->");
                    sb.append(nums[i - 1]);
                    res.add(sb.toString());
                }
                start = nums[i];
            }

            // 最后一位单独处理
            if (i == nums.length - 1) {
                if (start == nums[i]) {
                    res.add(String.valueOf(start));
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append(start);
                    sb.append("->");
                    sb.append(nums[i]);
                    res.add(sb.toString());
                }
            }

        }

        return res;
    }

    public static void main(String[] args) {
        L228_Summary_Ranges s = new L228_Summary_Ranges();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {0, 1, 2, 4, 5, 7};
        System.out.println(s.summaryRanges(nums));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}