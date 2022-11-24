public class L657_Robot_Return_to_Origin {

    public boolean judgeCircle(String moves) {
        int h = 0;
        int w = 0;
        for (int i = 0; i < moves.length(); i++) {

            //            if (moves.charAt(i) == 'U') {
            //                h++;
            //            }
            //            if (moves.charAt(i) == 'D') {
            //                h--;
            //            }
            //            if (moves.charAt(i) == 'R') {
            //                w++;
            //            }
            //            if (moves.charAt(i) == 'L') {
            //                w--;
            //            }

            switch (moves.charAt(i)) {
                case 'D':
                    h--;
                    break;
                case 'U':
                    h++;
                    break;
                case 'R':
                    w--;
                    break;
                case 'L':
                    w++;
                    break;
            }

        }

        return h == 0 && w == 0;
    }

    public static void main(String[] args) {

        L657_Robot_Return_to_Origin s = new L657_Robot_Return_to_Origin();
        long sysDate1 = System.currentTimeMillis();

        String moves = "UDLR";
        boolean res = s.judgeCircle(moves);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}