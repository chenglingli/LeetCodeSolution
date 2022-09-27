import java.util.Arrays;

public class L628_Maximum_Product_of_Three_Numbers {


    /*
        3 <= nums.length <= 104
        -1000 <= nums[i] <= 1000
     */



    // 一般正负分析法
    public int maximumProduct(int[] nums) {

        Arrays.sort(nums);
        int len = nums.length;

        // 全负数 或者 全正数 或者 只有三个值
        if (nums[0] >= 0 || nums[len - 1] <= 0 || len == 3) {
            return nums[len - 1] * nums[len - 2] * nums[len - 3];
        }

        // 计算正值位数、负值位数、0的位数
        int negCount = 0;
        int zeroCount = 0;
        int posCount = 0;
        for (int i =0 ; i < len ; i++) {
            if (nums[i] < 0) {
                negCount ++;
            }
            if (nums[i] == 0) {
                zeroCount ++;
            }
            if (nums[i] > 0) {
                break;
            }
        }
        posCount = len - negCount - zeroCount;


        // -- 下面不用考虑全正值和全负值情况
        // 即，一定是：正值 + 负值 + 可能0


        // 非0值不够
        if (posCount + negCount <= 2) {
            return 0;
        }

        // 非0值足够
        else {
            // 负值数 >= 2，结果一定正值：（绝对值）最大的两个负数+最大的整数 或 最大的三个正数
            if (negCount >= 2) {
                if (posCount >= 3) {
                    return Math.max(nums[len - 1] * nums[0] * nums[1],
                            nums[len - 1] * nums[len - 2] * nums[len - 3]);
                }
                else {
                    return nums[len - 1] * nums[0] * nums[1];
                }
            }

            // 负值数 < 2，结果一定正值：（绝对值）最大的两个负数+最大的整数
            else {
                if (posCount >= 3) {
                    return nums[len - 1] * nums[len - 2] * nums[len - 3];
                }
                else {
                    if (zeroCount >= 0) {
                        return 0;
                    }
                    else {
                        return nums[0] * nums[1] * nums[2];
                    }
                }
            }
        }

    }


    // 简化代码写法，最大的三个值 或者 最小两个值*最大值
    public int maximumProduct3(int[] nums) {

        Arrays.sort(nums);
        int len = nums.length;

        return Math.max(nums[len - 1] * nums[0] * nums[1],
                nums[len - 1] * nums[len - 2] * nums[len - 3]);
    }

    // 高效代码运行写法，最大的三个值 或者 最小两个值*最大值
    public int maximumProduct2(int[] nums) {

        if (nums.length == 3) {
            return nums[0] * nums[1] * nums[2];
        }

        int[] max = new int[] { Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE };
        int[] min = new int[] { Integer.MAX_VALUE, Integer.MAX_VALUE };

        for (int idx = 0; idx < nums.length; idx++) {

            if (nums[idx] < min[1]) {
                if (nums[idx] < min[0]) {
                    min[1] = min[0];
                    min[0] = nums[idx];
                } else {
                    min[1] = nums[idx];
                }
            }

            if (nums[idx] > max[0]) {
                if (nums[idx] > max[2]) {
                    max[0] = max[1];
                    max[1] = max[2];
                    max[2] = nums[idx];
                } else if (nums[idx] > max[1]) {
                    max[0] = max[1];
                    max[1] = nums[idx];
                } else {
                    max[0] = nums[idx];
                }
            }

        }

        return Math.max(
                max[2] * max[1] * max[0],
                max[2] * min[0] * min[1]);
    }

    public static void main(String[] args) {

        L628_Maximum_Product_of_Three_Numbers s = new L628_Maximum_Product_of_Three_Numbers();
        long sysDate1 = System.currentTimeMillis();

        int[] nums = {-1, -2, 0, 0};
        int [] nums2 = {-710,-107,-851,657,-14,-859,278,-182,-749,718,-640,127,-930,-462,694,969,143,309,904,-651,160,451,-159,-316,844,-60,611,-169,-73,721,-902,338,-20,-890,-819,-644,107,404,150,-219,459,-324,-385,-118,-307,993,202,-147,62,-94,-976,-329,689,870,532,-686,371,-850,-186,87,878,989,-822,-350,-948,-412,161,-88,-509,836,-207,-60,771,516,-287,-366,-512,509,904,-459,683,-563,-766,-837,-333,93,893,303,908,532,-206,990,280,826,-13,115,-732,525,-939,-787};
        int res = s.maximumProduct(nums2);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}