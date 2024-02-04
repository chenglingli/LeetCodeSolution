import java.util.Stack;

public class L084_Largest_Rectangle_in_Histogram {

    /*
    1 <= heights.length <= 10^5
    0 <= heights[i] <= 10^4

         2, 1, 5, 6, 2, 3

    顺次遍历每位元素，当前元素为x，坐标为i
    如果 x 比之前元素大，压栈
    如果 x 比之前元素小，则出栈 y，开始计算面积
        栈中不断往前找，如果遍历元素比x大，为a，则面积 = a * ( (i-1) - (z+1) + 1)
        譬如 1, 5, 6, 2
        到2的时候，栈中有6, 5, 1
        2比6小，出栈6，
        i == 3
        a == 6
        z == 2

        面积 = a * ( (i-1) - (z+1) + 1) = 6 * ( (3-1) - 2 + 1) = 6

   处理栈中剩余元素，里面上都是不增序列。

     */
    public int largestRectangleArea(int[] heights) {

        if (heights == null || heights.length == 0)
            return 0;

        Stack<Integer> stack = new Stack<>();
        int res = 0;
        int i = 0;

        while (i < heights.length) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                int index = stack.pop();
                int temp = stack.isEmpty() ? i * heights[index]
                        : ((i - 1) - (stack.peek() + 1) + 1) * heights[index];
                res = Math.max(res, temp);
            }

            stack.push(i);
            i++;
        }

        int count = 1;
        while (!stack.isEmpty()) {

            int index = stack.pop();
            if (!stack.isEmpty() && heights[index] == heights[stack.peek()]) {
                count++;
                continue;
            }

            int temp = count * heights[index];
            res = Math.max(res, temp);

            temp = stack.isEmpty() ? i * heights[index]
                    : (i - stack.peek() - 1) * heights[index];
            res = Math.max(res, temp);
        }

        return res;
    }

    /*
    维护两个数组，left和right
    left[i]表示i左边，从i向左，第一个比heights[i]小的元素的下标
    right[i]表示i右边，从i向右，第一个比heights[i]小的元素的下标

    遍历heights，计算面积
    面积 = heights[i] * (right[i] - left[i] - 1)

     */
    public int largestRectangleArea3(int[] heights) {

        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int maxArea = 0;

        // Filling left array
        for (int i = 0; i < n; i++) {
            int j = i - 1;
            while (j >= 0 && heights[j] >= heights[i]) {
                j = left[j];
            }
            left[i] = j;
        }

        // Filling right array
        for (int i = n - 1; i >= 0; i--) {
            int j = i + 1;
            while (j < n && heights[j] >= heights[i]) {
                j = right[j];
            }
            right[i] = j;
        }

        for (int i = 0; i < n; i++) {
            int width = right[i] - left[i] - 1;
            int area = heights[i] * width;
            maxArea = Math.max(area, maxArea);
        }

        return maxArea;
    }


    public static void main(String[] args) {

        L084_Largest_Rectangle_in_Histogram s = new L084_Largest_Rectangle_in_Histogram();

        long sysDate1 = System.currentTimeMillis();

        int[] heights = {2, 1, 5, 6, 2, 3};
        //        int[] heights = {2, 4};
        // int[] heights = {1, 1};
        int res = s.largestRectangleArea3(heights);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}