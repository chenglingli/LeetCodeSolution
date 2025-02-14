import java.util.ArrayList;
import java.util.List;

public class L1352_Product_of_the_Last_K_Numbers {

    /*
    Design an algorithm that accepts a stream of integers and
        retrieves the product of the last k integers of the stream.

    Implement the ProductOfNumbers class:

    ProductOfNumbers() Initializes the object with an empty stream.
    void add(int num) Appends the integer num to the stream.
    int getProduct(int k) Returns the product of the last k numbers in the current list.
        You can assume that always the current list has at least k numbers.
    The test cases are generated so that, at any time,
        the product of any contiguous sequence of numbers will fit into a single 32-bit integer without overflowing.



    Example:

    Input
    ["ProductOfNumbers","add","add","add","add","add","getProduct","getProduct","getProduct","add","getProduct"]
    [[],[3],[0],[2],[5],[4],[2],[3],[4],[8],[2]]

    Output
    [null,null,null,null,null,null,20,40,0,null,32]

    Explanation
    ProductOfNumbers productOfNumbers = new ProductOfNumbers();
    productOfNumbers.add(3);        // [3]
    productOfNumbers.add(0);        // [3,0]
    productOfNumbers.add(2);        // [3,0,2]
    productOfNumbers.add(5);        // [3,0,2,5]
    productOfNumbers.add(4);        // [3,0,2,5,4]
    productOfNumbers.getProduct(2); // return 20. The product of the last 2 numbers is 5 * 4 = 20
    productOfNumbers.getProduct(3); // return 40. The product of the last 3 numbers is 2 * 5 * 4 = 40
    productOfNumbers.getProduct(4); // return 0. The product of the last 4 numbers is 0 * 2 * 5 * 4 = 0
    productOfNumbers.add(8);        // [3,0,2,5,4,8]
    productOfNumbers.getProduct(2); // return 32. The product of the last 2 numbers is 4 * 8 = 32


    Constraints:

    0 <= num <= 100
    1 <= k <= 4 * 10^4
    At most 4 * 10^4 calls will be made to add and getProduct.
    The product of the stream at any point in time will fit in a 32-bit integer.
     */
    static class ProductOfNumbers {

        int[] res;
        int cur;
        int idx;

        public ProductOfNumbers() {
            res = new int[40001];
            cur = 0;
        }

        public void add(int num) {

            if (num == 0) {
                cur = 0;
                res[idx] = 1;
                idx++;
            }
            else if (cur == 0) {
                res[idx] = num;
                idx++;
                cur++;
            }
            else {
                res[idx] = res[idx - 1] * num;
                idx++;
                cur++;
            }
        }

        public int getProduct(int k) {
            if (cur < k)
                return 0;
            if (idx - k == 0)
                return res[idx - 1];

            return res[idx - 1] / res[idx - k - 1];

        }
    }

    class ProductOfNumbers2 {

        List<Integer> list;
        int idx;
        int lastZero;

        public ProductOfNumbers2() {
            this.list = new ArrayList<>();
            this.idx = 0;
            this.list.add(1);
            this.lastZero = 0;
        }

        public void add(int num) {
            idx++;
            if(num != 0) {
                list.add(list.get(list.size() - 1) * num);
            } else {
                lastZero = idx;
                list.add(1);
            }
        }

        public int getProduct(int k) {
            if(lastZero <= idx - k) {
                return list.get(list.size() - 1) / list.get(idx - k);
            } else return 0; // x x 0 [3 4 5]
        }
    }

    public static void main(String[] args) {

        ProductOfNumbers s = new ProductOfNumbers();
        long sysDate1 = System.currentTimeMillis();

        int res = 0;

        s.add(3);
        res = s.getProduct(1);
        System.out.println(res);
        s.add(0);
        res = s.getProduct(2);
        System.out.println(res);
        s.add(2);
        res = s.getProduct(1);
        System.out.println(res);
        s.add(5);
        s.add(4);
        res = s.getProduct(2);
        System.out.println(res);
        res = s.getProduct(3);
        System.out.println(res);
        res = s.getProduct(4);
        System.out.println(res);
        s.add(8);
        res = s.getProduct(2);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}