import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class L3606_Coupon_Code_Validator {

    /*

    You are given three arrays of length n that describe the properties of n coupons:
        code, businessLine, and isActive.

    The ith coupon has:

    code[i]: a string representing the coupon identifier.
    businessLine[i]: a string denoting the business category of the coupon.
    isActive[i]: a boolean indicating whether the coupon is currently active.


    A coupon is considered valid if all of the following conditions hold:
    code[i] is non-empty and consists only of alphanumeric characters (a-z, A-Z, 0-9) and underscores (_).
    businessLine[i] is one of the following four categories: "electronics", "grocery", "pharmacy", "restaurant".
    isActive[i] is true.
    Return an array of the codes of all valid coupons,

    sorted first by their businessLine in the order: "electronics", "grocery", "pharmacy", "restaurant",
    and then by code in lexicographical (ascending) order within each category.

    Example 1:

    Input: code = ["SAVE20","","PHARMA5","SAVE@20"],
    businessLine = ["restaurant","grocery","pharmacy","restaurant"], isActive = [true,true,true,true]

    Output: ["PHARMA5","SAVE20"]

    Explanation:

    First coupon is valid.
    Second coupon has empty code (invalid).
    Third coupon is valid.
    Fourth coupon has special character @ (invalid).

    Example 2:

    Input: code = ["GROCERY15","ELECTRONICS_50","DISCOUNT10"],
    businessLine = ["grocery","electronics","invalid"], isActive = [false,true,true]

    Output: ["ELECTRONICS_50"]

    Explanation:

    First coupon is inactive (invalid).
    Second coupon is valid.
    Third coupon has invalid business line (invalid).


    Constraints:

    n == code.length == businessLine.length == isActive.length
    1 <= n <= 100
    0 <= code[i].length, businessLine[i].length <= 100
    code[i] and businessLine[i] consist of printable ASCII characters.
    isActive[i] is either true or false.
     */
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {

        List<coupon> couponList = new ArrayList<>();

        for (int i = 0; i < code.length; i++) {
            if (!code[i].isEmpty()
                    && isAlphanumeric(code[i])
                    && isValidBusinessLine(businessLine[i])
                    && isActive[i]) {
                coupon coupon = new coupon(code[i], businessLine[i]);
                couponList.add(coupon);
            }
        }

        couponList.sort((c1, c2) -> {
            int blComp = c1.getBusinessLine().compareTo(c2.getBusinessLine());
            if (blComp != 0) {
                return blComp;
            } else {
                return c1.getCode().compareTo(c2.getCode());
            }
        });

        List<String> res = new ArrayList<>();
        for (coupon c : couponList) {
            res.add(c.getCode());
        }
        return res;
    }

    private boolean isAlphanumeric(String code) {
        return code.matches("[a-zA-Z0-9_]+");
    }

    private boolean isValidBusinessLine(String businessLine) {
        return "electronics".equals(businessLine)
                || "grocery".equals(businessLine)
                || "pharmacy".equals(businessLine)
                || "restaurant".equals(businessLine);
    }

    public List<String> validateCoupons2(String[] code, String[] businessLine, boolean[] isActive) {
        List<String> electronics = new ArrayList<>();
        List<String> grocery = new ArrayList<>();
        List<String> pharmacy = new ArrayList<>();
        List<String> restaurant = new ArrayList<>();

        for (int i = 0; i < code.length; i++) {
            if (!isActive[i] || code[i].isEmpty()) continue;

            boolean validCode = true;
            for (char c : code[i].toCharArray()) {
                if (!Character.isLetterOrDigit(c) && c != '_') {
                    validCode = false;
                    break;
                }
            }

            if (validCode) {
                if (businessLine[i].equals("electronics")) {
                    electronics.add(code[i]);
                }
                else if (businessLine[i].equals("grocery")){
                    grocery.add(code[i]);
                }
                else if (businessLine[i].equals("pharmacy")){
                    pharmacy.add(code[i]);
                }
                else if (businessLine[i].equals("restaurant")){
                    restaurant.add(code[i]);
                }
            }
        }

        Collections.sort(electronics);
        Collections.sort(grocery);
        Collections.sort(pharmacy);
        Collections.sort(restaurant);

        List<String> result = new ArrayList<>();
        result.addAll(electronics);
        result.addAll(grocery);
        result.addAll(pharmacy);
        result.addAll(restaurant);

        return result;
    }

    public static void main(String[] args) {

        L3606_Coupon_Code_Validator s = new L3606_Coupon_Code_Validator();
        long sysDate1 = System.currentTimeMillis();

        String[] code = {"GROCERY15", "ELECTRONICS_50", "DISCOUNT10"};
        String[] businessLine = {"grocery", "electronics", "invalid"};
        boolean[] isActive = {false, true, true};

        List<String> res = s.validateCoupons(code, businessLine, isActive);
        System.out.println(Collections.unmodifiableList(res));

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}

class coupon {
    String code;
    String businessLine;

    coupon(String c, String b) {
        code = c;
        businessLine = b;
    }

    String getCode() {
        return code;
    }

    String getBusinessLine() {
        return businessLine;
    }
}