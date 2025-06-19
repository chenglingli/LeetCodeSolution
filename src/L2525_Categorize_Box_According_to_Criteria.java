public class L2525_Categorize_Box_According_to_Criteria {

    /*
     Given four integers length, width, height, and mass,
     representing the dimensions and mass of a box,
     respectively, return a string representing the category of the box.

    The box is "Bulky" if:
    Any of the dimensions of the box is greater or equal to 10^4.
    Or, the volume of the box is greater or equal to 10^9.
    If the mass of the box is greater or equal to 100, it is "Heavy".

    If the box is both "Bulky" and "Heavy", then its category is "Both".

    If the box is neither "Bulky" nor "Heavy", then its category is "Neither".

    If the box is "Bulky" but not "Heavy", then its category is "Bulky".

    If the box is "Heavy" but not "Bulky", then its category is "Heavy".

    Note that the volume of the box is the product of its length, width and height.



    Example 1:

    Input: length = 1000, width = 35, height = 700, mass = 300
    Output: "Heavy"
    Explanation:
    None of the dimensions of the box is greater or equal to 104.
    Its volume = 24500000 <= 10^9. So it cannot be categorized as "Bulky".
    However mass >= 100, so the box is "Heavy".
    Since the box is not "Bulky" but "Heavy", we return "Heavy".

    Example 2:

    Input: length = 200, width = 50, height = 800, mass = 50
    Output: "Neither"
    Explanation:
    None of the dimensions of the box is greater or equal to 104.
    Its volume = 8 * 106 <= 109. So it cannot be categorized as "Bulky".
    Its mass is also less than 100, so it cannot be categorized as "Heavy" either.
    Since its neither of the two above categories, we return "Neither".


    Constraints:

    1 <= length, width, height <= 10^5
    1 <= mass <= 10^3

     */
    public String categorizeBox(int length, int width, int height, int mass) {

        double volume = length * 1.0 * width * height;

        double one = Math.pow(10, 4);
        double two = Math.pow(10, 9);
        boolean isBulky = length >= one || width >= one || height >= one || volume >= two;
        boolean isHeavy = mass >= 100;

        if (isBulky && isHeavy) {
            return "Both";
        }
        if (isBulky) {
            return "Bulky";
        }
        if (isHeavy) {
            return "Heavy";
        }
        return "Neither";
    }

    public static void main(String[] args) {

        L2525_Categorize_Box_According_to_Criteria s = new L2525_Categorize_Box_According_to_Criteria();
        long sysDate1 = System.currentTimeMillis();

        int length = 2909;
        int width = 3968;
        int height = 3272;
        int mass = 727;
        String res = s.categorizeBox(length,  width,  height,  mass);
        System.out.println(res);


        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}