public class L223_Rectangle_Area {

    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {

        int left = Math.max(ax1, bx1);
        int right = Math.min(ax2, bx2);
        int top = Math.min(ay2, by2);
        int bottom = Math.max(ay1, by1);


        int total = (ax2 - ax1) * (ay2 - ay1) + (bx2 - bx1) * (by2 - by1);
        int overlap = 0;
        if (top > bottom && right > left) {
            overlap = (top - bottom) * (right - left);
        }

        return total - overlap;
    }

    public static void main(String[] args) {

        L223_Rectangle_Area s = new L223_Rectangle_Area();
        long sysDate1 = System.currentTimeMillis();

        int ax1 = -3, ay1 = 0, ax2 = 3, ay2 = 4, bx1 = 0, by1 = -1, bx2 = 9, by2 = 2;
        int res = s.computeArea(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}