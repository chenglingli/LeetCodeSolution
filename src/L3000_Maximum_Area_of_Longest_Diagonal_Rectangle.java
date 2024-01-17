public class L3000_Maximum_Area_of_Longest_Diagonal_Rectangle {

    /*
    1 <= dimensions.length <= 100
    dimensions[i].length == 2
    1 <= dimensions[i][0], dimensions[i][1] <= 100
     */
    public int areaOfMaxDiagonal(int[][] dimensions) {

        int maxDiagonal = 0;
        int maxArea = 0;

        for (int[] dimension : dimensions) {
            int tempDiagonal = dimension[0] * dimension[0] + dimension[1] * dimension[1];
            if (tempDiagonal > maxDiagonal) {
                maxDiagonal = tempDiagonal;
                maxArea = dimension[0] * dimension[1];
            } else if (tempDiagonal == maxDiagonal) {
                if (dimension[0] * dimension[1] > maxArea) {
                    maxArea = dimension[0] * dimension[1];
                }
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {

        L3000_Maximum_Area_of_Longest_Diagonal_Rectangle s = new L3000_Maximum_Area_of_Longest_Diagonal_Rectangle();
        long sysDate1 = System.currentTimeMillis();

        int[][] dimensions = {{9, 3}, {8, 6}};
        int res = s.areaOfMaxDiagonal(dimensions);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}