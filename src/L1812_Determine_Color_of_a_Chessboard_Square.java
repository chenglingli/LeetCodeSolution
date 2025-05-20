public class L1812_Determine_Color_of_a_Chessboard_Square {

    /*

    You are given coordinates, a string that represents the coordinates of a square of the chessboard.
    Below is a chessboard for your reference.


    Return true if the square is white, and false if the square is black.

    The coordinate will always represent a valid chessboard square. The coordinate will always have the letter first, and the number second.



    Example 1:

    Input: coordinates = "a1"
    Output: false
    Explanation: From the chessboard above, the square with coordinates "a1" is black, so return false.

    Example 2:
    Input: coordinates = "h3"
    Output: true
    Explanation: From the chessboard above, the square with coordinates "h3" is white, so return true.

    Example 3:
    Input: coordinates = "c7"
    Output: false


    Constraints:

    coordinates.length == 2
    'a' <= coordinates[0] <= 'h'
    '1' <= coordinates[1] <= '8'

     */
    public boolean squareIsWhite(String coordinates) {
        char c = coordinates.charAt(0);
        int num = coordinates.charAt(1) - '0';
        return (c + num + 1) % 2 == 0;
    }

    public static void main(String[] args) {

        L1812_Determine_Color_of_a_Chessboard_Square s = new L1812_Determine_Color_of_a_Chessboard_Square();
        long sysDate1 = System.currentTimeMillis();

        String coordinates = "h3";
        boolean res = s.squareIsWhite(coordinates);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}