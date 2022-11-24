public class L836_Rectangle_Overlap {

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {

        // 点在腹中 情况
        if (isInRectangle(rec1[0], rec1[1], rec2) || isInRectangle(rec2[0], rec2[1], rec1)) {
            return true;
        }

        if (isInRectangle(rec1[2], rec1[1], rec2) || isInRectangle(rec2[2], rec2[1], rec1)) {
            return true;
        }

        if (isInRectangle(rec1[2], rec1[3], rec2) || isInRectangle(rec2[2], rec2[3], rec1)) {
            return true;
        }

        if (isInRectangle(rec1[0], rec1[3], rec2) || isInRectangle(rec2[0], rec2[3], rec1)) {
            return true;
        }

        // 十字 情况
        if (shiZi(rec1, rec2) || shiZi(rec2, rec1)) {
            return true;
        }

        return false;
    }

    private boolean isInRectangle(int x, int y, int[] rec) {
        return x > rec[0] && x < rec[2] && y > rec[1] && y < rec[3];
    }

    private boolean shiZi(int[] rec1, int[] rec2) {
        return rec1[1] >= rec2[1]
                && rec1[1] <= rec2[3]
                && rec1[3] >= rec2[1]
                && rec1[3] <= rec2[3]

                && rec2[0] >= rec1[0]
                && rec2[0] <= rec1[2]
                && rec2[2] >= rec1[0]
                && rec2[2] <= rec1[2];
    }

    public static void main(String[] args) {

        L836_Rectangle_Overlap s = new L836_Rectangle_Overlap();
        long sysDate1 = System.currentTimeMillis();

        //        int[] rec2 = {7,8,13,15};
        //        int[] rec1 = {10,8,12,20};

        int[] rec1 = {1, 13, 16, 20};
        int[] rec2 = {2, 12, 11, 18};

        boolean res = s.isRectangleOverlap(rec1, rec2);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}