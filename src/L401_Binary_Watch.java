import java.util.ArrayList;
import java.util.List;

public class L401_Binary_Watch {

    /*
    A binary watch has 4 LEDs on the top to represent the hours (0-11),
    and 6 LEDs on the bottom to represent the minutes (0-59). Each LED represents a zero or one,
    with the least significant bit on the right.


    For example, the below binary watch reads "4:51".


    Given an integer turnedOn which represents the number of LEDs that are currently on (ignoring the PM),
    return all possible times the watch could represent. You may return the answer in any order.

    The hour must not contain a leading zero.

    For example, "01:00" is not valid. It should be "1:00".
    The minute must consist of two digits and may contain a leading zero.

    For example, "10:2" is not valid. It should be "10:02".


    Example 1:

    Input: turnedOn = 1
    Output: ["0:01","0:02","0:04","0:08","0:16","0:32","1:00","2:00","4:00","8:00"]
    Example 2:

    Input: turnedOn = 9
    Output: []


    Constraints:
    0 <= turnedOn <= 10

    */

    public List<String> readBinaryWatch(int turnedOn) {

        List<String> res = new ArrayList<>();

        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                if (countBits(h) + countBits(m) == turnedOn) {
                    res.add(String.format("%d:%02d", h, m));
                }
            }
        }

        return res;
    }

    private int countBits(int n) {
        int count = 0;
        while (n != 0) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }

    public List<String> readBinaryWatch2(int turnedOn) {
        // 创建一个StringBuilder对象用于构建时间字符串
        StringBuilder sb = new StringBuilder();

        // 创建一个ArrayList对象用于存储结果
        List<String> result = new ArrayList<String>();

        // 遍历小时数，从0到11
        for (int hour = 0; hour < 12; hour++) {
            // 初始化分钟数为0
            int min = 0;
            // 计算小时数的二进制中1的个数
            int hCount = Integer.bitCount(hour);

            // 如果小时数的二进制中1的个数等于turnedOn，则构建时间字符串并添加到结果列表中
            if (Integer.bitCount(hour) == turnedOn) {
                sb.setLength(0); // 清空StringBuilder
                sb.append(hour).append(":"); // 添加小时数，并跟上冒号
                sb.append("0").append(min); // 添加分钟数，如果分钟数为0，则显式写出0
                result.add(sb.toString()); // 将构建的时间字符串添加到结果列表中
                continue; // 跳过当前循环的剩余部分，继续下一次循环
            }

            // 遍历分钟数，从0到59
            for (min = 0; min < 60; min++) {
                // 如果小时数的二进制中1的个数加上分钟数的二进制中1的个数等于turnedOn
                if (hCount + Integer.bitCount(min) == turnedOn) {
                    sb.setLength(0); // 清空StringBuilder
                    sb.append(hour).append(":"); // 添加小时数，并跟上冒号
                    // 如果分钟数小于10，则在分钟数前添加0，以确保时间格式为HH:MM
                    if (min < 10) sb.append("0");
                    sb.append(min); // 添加分钟数
                    result.add(sb.toString()); // 将构建的时间字符串添加到结果列表中
                }
            }
        }

        // 返回结果列表
        return result;
    }


    public static void main(String[] args) {

        L401_Binary_Watch s = new L401_Binary_Watch();

        long sysDate1 = System.currentTimeMillis();

        int k = 2;
        List<String> res = s.readBinaryWatch(k);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}