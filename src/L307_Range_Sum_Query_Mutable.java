public class L307_Range_Sum_Query_Mutable {

    /*
        1 <= nums.length <= 3 * 10^4
        -100 <= nums[i] <= 100
        0 <= index < nums.length
        -100 <= val <= 100
        0 <= left <= right < nums.length
        At most 3 * 10^4 calls will be made to update and sumRange.
     */
    public static void main(String[] args) {

        long sysDate1 = System.currentTimeMillis();

        NumArray2 numArray = new NumArray2(new int[]{1, 3, 5});

        int res = numArray.sumRange(0, 2);
        System.out.println(res);

        numArray.update(1, 2);

        res = numArray.sumRange(0, 2);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}

class NumArray {

    int[] numArray;
    // cumulateSum[3] = nums[0] + nums[1] + nums[2]
    // cumulateSum[0] = 0
    // cumulateSum[1] = nums[0]
    int[] cumulateSum;

    public NumArray(int[] nums) {

        int n = nums.length;
        numArray = new int[n];
        cumulateSum = new int[n + 1];

        for (int i = 0; i < n; i++) {
            numArray[i] = nums[i];
            cumulateSum[i + 1] = cumulateSum[i] + numArray[i];
        }
    }

    public void update(int index, int val) {

        int diff = val - numArray[index];
        numArray[index] = val;
        for (int i = index + 1; i < cumulateSum.length; i++) {
            cumulateSum[i] += diff;
        }
    }

    // 1 ~ 3
    // cumulateSum[4] - cumulateSum[1]
    // [0 ~ 3] - [0] = [1 ~ 3]
    public int sumRange(int left, int right) {
        return cumulateSum[right + 1] - cumulateSum[left];
    }
}

/*
使用 树状数组（Binary Indexed Tree）

numArray 保存原始数组
BIT 保存树状数组

BIT[1] = numArray[1]
BIT[2] = numArray[1] + numArray[2]
BIT[3] = numArray[3]
BIT[4] = numArray[1] + numArray[2] + numArray[3] + numArray[4]
BIT[5] = numArray[5]
BIT[6] = numArray[5] + numArray[6]
BIT[7] = numArray[7]
BIT[8] = numArray[1] + numArray[2] + numArray[3] + numArray[4] +
         numArray[5] + numArray[6] + numArray[7] + numArray[8]


len 数组长度

lowBit 操作就是为了获取当前变量 x xx 二进制中最后一个 1 的位置
lowBit =  (i & -i)


 */
class NumArray2 {

    int[] numArray;
    int[] BIT;
    int len;

    // 构造函数
    public NumArray2(int[] nums) {

        this.numArray = nums;
        len = nums.length;

        BIT = new int[len + 1];
        for (int i = 0; i < len; i++)
            init(i, nums[i]);
    }

    // 初始化
    public void init(int i, int val) {

        // 因为numArray从0开始，BIT从1开始
        i++;

        while (i <= len) {
            BIT[i] += val;
            i = i + lowBit(i);
        }
    }

    // 更新第i位值
    void update(int i, int val) {

        int diff = val - numArray[i];
        numArray[i] = val;

        init(i, diff);
    }

    // 获取前i位的和
    public int getSum(int i) {

        int sum = 0;
        // 因为numArray从0开始，BIT从1开始
        i++;

        while (i > 0) {
            sum += BIT[i];
            i = i - lowBit(i);
        }

        return sum;
    }

    // 获取区间和
    public int sumRange(int i, int j) {
        return getSum(j) - getSum(i - 1);
    }

    // 获取当前变量 x 二进制中最后一个 1 的位置
    public int lowBit(int x) {
        return x & (-x);
    }
}