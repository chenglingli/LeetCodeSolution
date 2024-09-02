public class L3274_Check_if_Two_Chessboard_Squares_Have_the_Same_Color {

    /*
    coordinate1.length == coordinate2.length == 2
    'a' <= coordinate1[0], coordinate2[0] <= 'h'
    '1' <= coordinate1[1], coordinate2[1] <= '8'
     */
    public boolean checkTwoChessboards(String coordinate1, String coordinate2) {
        return (Math.abs(coordinate1.charAt(0) - coordinate2.charAt(0)) +
                Math.abs(coordinate1.charAt(1) - coordinate2.charAt(1)))
                % 2 == 0;
    }

    public static void main(String[] args) {

        L3274_Check_if_Two_Chessboard_Squares_Have_the_Same_Color s = new L3274_Check_if_Two_Chessboard_Squares_Have_the_Same_Color();
        long sysDate1 = System.currentTimeMillis();

        String coordinate1 = "a1";
        String coordinate2 = "c3";

        boolean res = s.checkTwoChessboards(coordinate1, coordinate2);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}