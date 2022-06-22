public class L042_Trapping_Rain_Water {


    // 遍历两遍数组，找到每一个位置所对应的leftMost 和 rightMost
    // rain[i] = min(leftMost[i], rightMost[i]) - height[i]

    public int trap(int[] height) {

        int size = height.length;
        int res = 0;

        int[] leftMost = new int[size];
        int[] rightMost = new int[size];

        for (int i = 1; i < size; i++) {
            leftMost[i] = Integer.max(leftMost[i - 1], height[i - 1]);
        }

        for (int i = size - 2; i >= 0; i--) {
            rightMost[i] = Integer.max(rightMost[i + 1], height[i + 1]);
            int top = Integer.min(rightMost[i], leftMost[i]);
            if (top > height[i]) {
                res += top - height[i];
            }
        }

        return res;
    }

    /*

    双指针法，两个指针向中间移动，leftMost 和 rightMost
    指针小的那一边先挪动计算，为了解决中间有高值情况

     */
    public int trap2(int[] height) {

        int n = height.length;
        int res = 0;

        int leftMost = 0;
        int rightMost = 0;
        int left = 1;
        int right = n - 2;

        while (left <= right) {

            leftMost = Integer.max(leftMost, height[left - 1]);
            rightMost = Integer.max(rightMost, height[right + 1]);

            if (leftMost < rightMost) {
                res += leftMost > height[left] ? leftMost - height[left] : 0;
                left ++;
            } else {
                res += rightMost > height[right] ? rightMost - height[right] : 0;
                right--;
            }
        }

        return res;
    }

    public static void main(String[] args) {

        L042_Trapping_Rain_Water s = new L042_Trapping_Rain_Water();

        long sysDate1 = System.currentTimeMillis();

        int[] input = {4,2,0,3,2,5};
        int res = s.trap2(input);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}