public class L011_Container_With_Most_Water {

    // 两个柱子向里逼近
    public int maxArea2(int[] height) {

        int max = Integer.MIN_VALUE;
        int l = 0;
        int h = height.length - 1;
        while (l < h) {
            if (height[l] > height[h]) {
                max = Math.max(max, (h - l) * height[h]);
                h--;
            } else {
                max = Math.max(max, (h - l) * height[l]);
                l++;
            }
        }
        return max;
    }

    // 以i为结尾柱子的思维模式，DP算法，有性能提升空间
    public int maxArea(int[] height) {
        int res = 0;

        for (int i = 1; i < height.length; i++) {
            int curArea = 0;

            int tempMax = -1;
            for (int j = 0; j < i; j++) {
                if (height[j] <= height[i]) {
                    curArea = (i - j) * height[j];
                } else {
                    curArea = (i - j) * height[i];
                    j = i;
                }

                if (curArea > tempMax) {
                    tempMax = curArea;
                }
                // System.out.println("i: " + i + " j: " + j + " tempMax: " + tempMax);
            }

            if (tempMax > res) {
                res = tempMax;
            }
            // System.out.println(i + " " + res);
        }

        return res;
    }

    public static void main(String[] args) {

        L011_Container_With_Most_Water s = new L011_Container_With_Most_Water();

        long sysDate1 = System.currentTimeMillis();

        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        int res = s.maxArea(height);

        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}