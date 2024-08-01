public class L3200_Maximum_Height_of_a_Triangle {

    /*

    You are given two integers red and blue
        representing the count of red and blue colored balls.

    You have to arrange these balls to form a triangle such that the 1st row will have 1 ball,
    the 2nd row will have 2 balls, the 3rd row will have 3 balls, and so on.

    All the balls in a particular row should be the same color,
    and adjacent rows should have different colors.

    Return the maximum height of the triangle that can be achieved.

    1 <= red, blue <= 100

     */

    /*
    i不断累加，计算目前为止奇数行和偶数行个数
     */
    public int maxHeightOfTriangle(int red, int blue) {

        int i = 1;

        int sum1 = 0;
        int sum2 = 0;

        while (true) {
            if (i % 2 == 0) {
                sum1 = (i / 2) * (i + 2) / 2;
                sum2 = ((i + 1) / 2) * (i - 1 + 1) / 2;
            } else {
                sum1 = ((i + 1) / 2) * (i + 1) / 2;
                sum2 = ((i - 1) / 2) * (i - 1 + 2) / 2;
            }

            if (!(sum1 <= red && sum2 <= blue || sum1 <= blue && sum2 <= red)) {
                break;
            }

            i++;
        }

        return i - 1;
    }


    /*
    轮流减去1,2,3,4,5...直到不能减为止
     */
    public int maxHeightOfTriangle2(int red, int blue) {
        return Math.max(towerHeight(red, blue, 1), towerHeight(blue, red, 1));
    }

    private int towerHeight(int firstDot, int secondDot, int index) {

        if ((firstDot - index) < 0) {
            return (index - 1);
        } else {
            firstDot -= index;
        }

        index++;
        return towerHeight(secondDot, firstDot, index);
    }


    public static void main(String[] args) {

        L3200_Maximum_Height_of_a_Triangle s = new L3200_Maximum_Height_of_a_Triangle();
        long sysDate1 = System.currentTimeMillis();

        int red = 2;
        int blue = 4;
        int res = s.maxHeightOfTriangle(red, blue);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}