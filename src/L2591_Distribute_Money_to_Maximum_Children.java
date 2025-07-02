import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class L2591_Distribute_Money_to_Maximum_Children {

    /*
    You are given an integer money denoting the amount of money (in dollars)
    that you have and another integer children denoting the number of children that you must distribute the money to.

    You have to distribute the money according to the following rules:

    All money must be distributed.
    Everyone must receive at least 1 dollar.
    Nobody receives 4 dollars.
    Return the maximum number of children who may receive exactly 8 dollars if you distribute the money according to the aforementioned rules.
    If there is no way to distribute the money, return -1.



    Example 1:
    Input: money = 20, children = 3
    Output: 1
    Explanation:
    The maximum number of children with 8 dollars will be 1. One of the ways to distribute the money is:
    - 8 dollars to the first child.
    - 9 dollars to the second child.
    - 3 dollars to the third child.
    It can be proven that no distribution exists such that number of children getting 8 dollars is greater than 1.

    Example 2:
    Input: money = 16, children = 2
    Output: 2
    Explanation: Each child can be given 8 dollars.


    Constraints:
    1 <= money <= 200
    2 <= children <= 30
     */
    public int distMoney(int money, int children) {

        // 每人1美元都达不到
        if (money < children)
            return -1;

        // 每人至少1美元
        money -= children;

        // 不断尝试给人8美元，直到没钱为止
        int res = 0;
        while (money >= 7 && children > 0) {
            money -= 7;
            res++;
            children--;
        }

        // 每个孩子都分了8美元，钱可能还多
        if (children == 0) {
            if (money == 0) {
                return res;
            } else {
                res -= 1;
                return res;
            }
        }

        // 省下钱不足给下一个孩子分8美元了
        if (money < 7) {

            if (money == 3) {
                if (children == 1) {
                    res -= 1;
                    return res;
                } else {
                    return res;
                }
            } else {
                return res;
            }
        }

        return res;
    }

    public int distMoney2(int money, int children) {

        // 每人1美元都达不到
        if (money < children)
            return -1;

        // 先给每个人1美元
        money -= children;

        // 看多少人可以分8美元
        int ans = money / 7;

        // 每人1美元后，剩下钱不足7美元，则无法再给任何人8美元
        if (ans == 0)
            return 0;

        /*
        看可以给多少人8美元，几种情况：
        1，可以给n-2或更少的人8美元（ans < n-1）
            剩下钱不论多少，都可以分摊好，不让某个人得到4美元，所以答案就是ans

        2，可以给n-1个人8美元(ans = n-1)
            要看下剩下的钱，
                如果是4美元，则需要某个小朋友拿4美元，则ans-1，实际上是n-2
                否则，就是ans，即n-1

        3，可以给n个人8美元(ans == n)
           如果钱刚好分完，money = n * 8，则答案为n，也是ans
           如果钱还多，则答案为n - 1

        4，可以给>n个人8美元(ans > n)
           因为钱多，所以答案是n-1
         */

        if (ans < children - 1)
            return ans;

        if (ans == children - 1) {
            if (money % 7 == 3)
                return ans - 1;
            else
                return ans;
        }

        if (ans == children) {
            if (money % 7 == 0)
                return ans;
            else
                return children - 1;
        }

        if (ans > children)
            return children - 1;

        return -1;
    }

    public int distMoney3(int money, int children) {

        // 每人1美元都达不到
        if (money < children)
            return -1;

        // 先给每个人1美元
        money -= children;

        // 看多少人可以分8美元
        int ans = money / 7;

        // 每人1美元后，剩下钱不足7美元，则无法再给任何人8美元
        if (ans == 0)
            return 0;

        // 剩下的钱可以给每个人8美元后，还多出来很多钱（>8），则只能给n-1个小朋友8美元
        if (ans > children)
            return children - 1;

        // 可以给n-1个小朋友8美元后，还剩下的钱为3，则ans需要-1
        if (ans == children - 1 && money % 7 == 3) {
            ans--;
            return ans;
        }

        // 可以给n个小朋友8美元后，还剩下钱，则ans需要-1
        if (ans == children && money % 7 > 0) {
            return children - 1;
        }

        return ans;
    }


    public static void main(String[] args) {

        L2591_Distribute_Money_to_Maximum_Children s = new L2591_Distribute_Money_to_Maximum_Children();
        long sysDate1 = System.currentTimeMillis();

        int money = 20;
        int children = 3;
        int ans = s.distMoney(money, children);
        System.out.println(ans);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}