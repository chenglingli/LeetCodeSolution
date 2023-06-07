public class L1725_Number_Of_Rectangles_That_Can_Form_The_Square {


    /*
    1 <= rectangles.length <= 1000
    rectangles[i].length == 2
    1 <= li, wi <= 109
    li != wi
     */
    public int countGoodRectangles(int[][] rectangles) {

        int maxLen = 0;
        int count = 0;
        for (int[] rectangle : rectangles) {
            int curLen = Math.min(rectangle[0], rectangle[1]);
            if (curLen > maxLen) {
                maxLen = curLen;
                count = 1;
            } else if (curLen == maxLen) {
                count++;
            }
        }

        return count;
    }

    public int countGoodRectangles2(int[][] rectangles) {

        int result[] = new int[rectangles.length];

        int count = 0;
        int maxLen = 0;

        for (int i = 0; i < rectangles.length; i++) {
            result[i] = Math.min(rectangles[i][0], rectangles[i][1]);
        }

        for (int num : result)
            if (num > maxLen) maxLen = num;

        for (int num : result)
            if (num == maxLen) count++;

        return count;
    }

    public static void main(String[] args) {

        L1725_Number_Of_Rectangles_That_Can_Form_The_Square s = new L1725_Number_Of_Rectangles_That_Can_Form_The_Square();
        long sysDate1 = System.currentTimeMillis();

        int[][] rectangles = {{5, 8}, {3, 9}, {5, 12}, {16, 5}};
        int res = s.countGoodRectangles(rectangles);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}