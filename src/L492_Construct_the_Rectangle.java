import java.util.Arrays;

public class L492_Construct_the_Rectangle {


    /*

    A web developer needs to know how to design a web page's size.
    So, given a specific rectangular web page’s area,
    your job by now is to design a rectangular web page,
    whose length L and width W satisfy the following requirements:

    The area of the rectangular web page you designed must equal to the given target area.
    The width W should not be larger than the length L, which means L >= W.
    The difference between length L and width W should be as small as possible.
    Return an array [L, W] where L and W are the length and width of the web page you designed in sequence.



    Example 1:

    Input: area = 4
    Output: [2,2]
    Explanation: The target area is 4,
        and all the possible ways to construct it are [1,4], [2,2], [4,1].
    But according to requirement 2, [1,4] is illegal;
    according to requirement 3,  [4,1] is not optimal compared to [2,2].
    So the length L is 2, and the width W is 2.

    Example 2:

    Input: area = 37
    Output: [37,1]
    Example 3:

    Input: area = 122122
    Output: [427,286]

     */
    public int[] constructRectangle(int area) {
        int[] res = new int[2];

        int x = (int)Math.sqrt(area);
        while(x >= 1){
            if(area % x == 0){
                res[0] = area / x;
                res[1] = x;
                break;
            }
            x--;
        }

        return res;
    }

    public static void main(String[] args) {

        L492_Construct_the_Rectangle s = new L492_Construct_the_Rectangle();
        long sysDate1 = System.currentTimeMillis();
        int area = 122122;
        int[] res = s.constructRectangle(area);
        System.out.println(Arrays.toString(res));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}