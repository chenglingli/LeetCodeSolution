public class L041_First_Missing_Positive {


    /*
    采用交换元素的方式，将数组下标与数组元素大小对应起来。
    假设数组的大小为n，我们遍历整个数组，
        如果当前元素i在1-n之间那么就将当前元素和数组第i-1个元素交换。
        如果当前元素是负数或者大于n那么就不处理。
    这样遍历完所有的元素之后，原始数组当中出现在1-n之间的元素都被放在了对应的0~n-1的位置里。

    再次遍历数组，找到第一个不满足v[i]==i+1的位置，那么i+1就是最小的未出现的正整数。
     */
    public int firstMissingPositive(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                continue;
            }
            if (nums[i] > nums.length) {
                continue;
            }

            // swap
            int cur = nums[i];
            int temp = nums[cur - 1];

            nums[cur - 1] = cur;

            while (temp > 0 && temp <= nums.length && cur != temp) {
                cur = temp;
                temp = nums[cur - 1];
                nums[cur - 1] = cur;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return nums.length + 1;
    }


    public int firstMissingPositive2(int[] nums) {
        int minNum = 1;
        while (true) {
            boolean changed = false;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == minNum) {
                    minNum++;
                    changed = true;
                }
            }
            if (!changed) {
                break;
            }
        }
        return minNum;
    }

    public static void main(String[] args) {

        L041_First_Missing_Positive s = new L041_First_Missing_Positive();

        long sysDate1 = System.currentTimeMillis();

        int[] input = {3, 4, -1, 1};
        int res = s.firstMissingPositive2(input);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}