import java.util.Arrays;

public class L2739_Total_Distance_Traveled {

    /*

    A truck has two fuel tanks. You are given two integers,
    mainTank representing the fuel present in the main tank in liters and additionalTank representing the fuel present in the additional tank in liters.

    The truck has a mileage of 10 km per liter. Whenever 5 liters of fuel get used up in the main tank,
    if the additional tank has at least 1 liters of fuel, 1 liters of fuel will be transferred from the additional tank to the main tank.

    Return the maximum distance which can be traveled.

    Note: Injection from the additional tank is not continuous. It happens suddenly and immediately for every 5 liters consumed.



    Example 1:

    Input: mainTank = 5, additionalTank = 10
    Output: 60
    Explanation:
    After spending 5 litre of fuel, fuel remaining is (5 - 5 + 1) = 1 litre and distance traveled is 50km.
    After spending another 1 litre of fuel, no fuel gets injected in the main tank and the main tank becomes empty.
    Total distance traveled is 60km.
    Example 2:

    Input: mainTank = 1, additionalTank = 2
    Output: 10
    Explanation:
    After spending 1 litre of fuel, the main tank becomes empty.
    Total distance traveled is 10km.



    Constraints:

    1 <= mainTank, additionalTank <= 100

     */
    public int distanceTraveled(int mainTank, int additionalTank) {
        int dis = 0;
        int temp = 0;

        while (mainTank > 0) {
            dis += 10;
            mainTank--;
            temp++;
            if (temp == 5 && additionalTank > 0) {
                mainTank++;
                additionalTank--;
                temp = 0;
            }
        }

        return dis;
    }

    /*
    数学方法
    (mainTank + min((mainTank - 1) / 4, additionalTank)) * 10
    解释：
    mainTank - 1 表示总共消耗了多少次油，每次消耗5升，总共消耗了多少次油就表示总共加了多少次油。
    (mainTank - 1) / 4 表示总共加了多少次油，因为每次消耗5升油就加一次油。
    min((mainTank - 1) / 4, additionalTank) 表示总共加了多少次油，但是不能超过副油箱的油量。
    (mainTank + min((mainTank - 1) / 4, additionalTank)) * 10 表示总共行驶了多少公里。

    譬如mainTank = 9，如果直接9/5，就是1
    但实际是：
    1. 先消耗5升油，加一次油，剩余5升
    2. 再消耗5升油，再加一次油，剩余1升
    3. 再消耗1升油，总共加了2次油


     */
    public int distanceTraveled2(int mainTank, int additionalTank) {
        return (mainTank + Math.min((mainTank - 1) / 4, additionalTank)) * 10;
    }

    public static void main(String[] args) {

        L2739_Total_Distance_Traveled s = new L2739_Total_Distance_Traveled();
        long sysDate1 = System.currentTimeMillis();


        int mainTank = 5;
        int additionalTank = 10;
        int res = s.distanceTraveled(mainTank, additionalTank);
        System.out.println(res);

        long sysDate2 = System.currentTimeMillis();
        System.out.println("\ntime ");
        System.out.print(sysDate2 - sysDate1);
    }
}